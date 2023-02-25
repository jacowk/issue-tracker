package za.co.issuetracker.backend.user.service;

import org.junit.Assert;
import org.junit.Test;
import za.co.issuetracker.backend.AbstractTest;
import za.co.issuetracker.backend.util.SessionBeanConstant;
import za.co.issuetracker.backend.user.domain.User;

import java.util.Date;
import java.util.List;

/**
 * A test class for UserServiceBean
 *
 * @author Jaco Koekemoer
 * Date: 2023-02-17
 */
public class UserServiceBeanTest extends AbstractTest
{

    @Test
    public void testAddUser()
    {
        /* Prepare parameters */
        String firstname = "Jaco";
        String surname = "Koekemoer";
        String username = "jacok";
        String password = "password";

        /* Setup user */
        User user = new User();
        user.setFirstname(firstname);
        user.setSurname(surname);
        user.setUsername(username);
        user.setPassword(password);
        user.setCreateUser(user);
        user.setCreateDate(new Date());

        /* Run the test */
        UserService userService = lookupUserService(SessionBeanConstant.USER_SERVICE_BEAN.getValue());
        userService.addUser(user);
    }

    @Test
    public void testAddMultipleUsers()
    {
        /* Prepare parameters */
        String[][] names = {
                { "Calvin", "Wood" },
                { "Gary", "Charles" },
                { "Brian", "Hinze" },
                { "Jesse", "Hollis" }
        };

        UserService userService = lookupUserService(SessionBeanConstant.USER_SERVICE_BEAN.getValue());
        for (String[] fullNames: names)
        {
            String firstname = fullNames[0];
            String surname = fullNames[1];

            /* Setup user */
            User user = new User();
            user.setFirstname(firstname);
            user.setSurname(surname);

            /* Run the test */
            userService.addUser(user);
        }
    }

    @Test
    public void testFindUserById()
    {
        /* Prepare parameters */
        long id = 1;

        /* Run the test */
        UserService userService = lookupUserService(SessionBeanConstant.USER_SERVICE_BEAN.getValue());
        User user = userService.findUserById(id);

        /* Assert result */
        Assert.assertNotNull(user);
        System.out.println(user.toString());
    }

    @Test
    public void testUpdateUser()
    {
        /* Prepare parameters */
        long id = 1;
        String newFirstName = "David";

        /* Find the user */
        UserService userService = lookupUserService(SessionBeanConstant.USER_SERVICE_BEAN.getValue());
        User user = userService.findUserById(id);

        /* Change the user */
        user.setFirstname(newFirstName);

        /* Run the test */
        userService.updateUser(user);

        /* Find the user */
        User updatedUser = userService.findUserById(id);

        /* Assert results */
        Assert.assertTrue(updatedUser.getFirstname().equals(newFirstName));
    }

    @Test
    public void testFindAllUsers()
    {
        /* Run the test */
        UserService userService = lookupUserService(SessionBeanConstant.USER_SERVICE_BEAN.getValue());
        List<User> userList = userService.findAllUsers();

        /* Assert result */
        Assert.assertNotNull(userList);
        for (User user: userList)
        {
            System.out.println(user.toString());
        }
    }

    @Test
    public void testFindUsersByFirstNameAndSurname()
    {
        /* Prepare parameters */
        String firstname = "Gary";
        String surname = "Charles";

        /* Run the test */
        UserService userService = lookupUserService(SessionBeanConstant.USER_SERVICE_BEAN.getValue());
        List<User> userList = userService.findUsersByFirstNameAndSurname(firstname, surname);

        /* Assert result */
        Assert.assertNotNull(userList);
        for (User user: userList)
        {
            System.out.println(user.toString());
        }
    }

}
