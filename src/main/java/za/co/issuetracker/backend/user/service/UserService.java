package za.co.issuetracker.backend.user.service;

import za.co.issuetracker.backend.user.domain.User;

import javax.ejb.Remote;
import java.io.Serializable;
import java.util.List;

/**
 * A remove interface for managing Users
 *
 * @author Jaco Koekemoer
 * Date: 2023-02-17
 */
@Remote
public interface UserService extends Serializable
{

    public User findUserById(long id);

    public List<User> findAllUsers();

    public List<User> findUsersByFirstNameAndSurname(String firstname, String surname);

    /**
     * A contract for adding a user
     *
     * @param user User
     */
    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUser(User user);

}
