package za.co.issuetracker.backend.user;

import za.co.issuetracker.backend.user.domain.User;
import za.co.issuetracker.frontend.user.UserWrapper;
import za.co.issuetracker.frontend.util.IssueTrackerUIUtil;

/**
 * A util class for users
 *
 * @author Jaco Koekemoer
 * Date: 2023-02-26
 */
public class UserUtil
{

    /**
     * Convert a userWrapper to a user object
     *
     * @param userWrapper UserWrapper
     * @return User
     */
    public static User convertUserWrapperToUser(UserWrapper userWrapper)
    {
        User user = new User();
        user.setId(userWrapper.getId());
        user.setFirstname(userWrapper.getFirstname());
        user.setSurname(userWrapper.getSurname());
        user.setUsername(userWrapper.getUsername());
        user.setPassword(userWrapper.getPassword());
        user.setActive(userWrapper.isActive());
        return user;
    }

    /**
     * Convert a user to a userWrapper object
     *
     * @param user User
     * @return UserWrapper
     */
    public static UserWrapper convertUserToUserWrapper(User user)
    {
        UserWrapper userWrapper = new UserWrapper();
        userWrapper.setId(user.getId());
        userWrapper.setFirstname(user.getFirstname());
        userWrapper.setSurname(user.getSurname());
        userWrapper.setUsername(user.getUsername());
        userWrapper.setPassword(user.getPassword());
        userWrapper.setActive(user.isActive());
        userWrapper.setActiveString(IssueTrackerUIUtil.convertBooleanToString(user.isActive()));
        return userWrapper;
    }

}
