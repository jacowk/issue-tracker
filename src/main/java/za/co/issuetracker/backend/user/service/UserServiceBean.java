package za.co.issuetracker.backend.user.service;

import za.co.issuetracker.backend.user.domain.User;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * A stateless session bean for managing Users
 *
 * @author Jaco Koekemoer
 * Date: 2023-02-17
 */
@Stateless
@Remote(UserService.class)
public class UserServiceBean implements UserService
{

    @PersistenceContext(unitName = "myPersistenceUnit")
    private EntityManager entityManager;

    @Override
    public User findUserById(long id)
    {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> findAllUsers()
    {
        String queryString = "SELECT u FROM User u";
        Query query = entityManager.createQuery(queryString);
        List<User> users = query.getResultList();
        return users;
    }

    @Override
    public List<User> findUsersByFirstNameAndSurname(String firstname, String surname)
    {
        String queryString = "SELECT u FROM User u WHERE u.firstname = :firstname AND u.surname = :surname";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("firstname", firstname);
        query.setParameter("surname", surname);
        List<User> users = query.getResultList();
        return users;
    }

    @Override
    public void addUser(User user)
    {
        System.out.println(String.format("Adding user %s %s", user.getFirstname(), user.getSurname()));
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user)
    {
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(User user)
    {
        entityManager.remove(user);
    }

}
