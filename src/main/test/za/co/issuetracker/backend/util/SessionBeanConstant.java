package za.co.issuetracker.backend.util;

/**
 * An enum containing session bean names
 *
 * @author Jaco Koekemoer
 * Date: 2023-02-24
 */
public enum SessionBeanConstant
{

    USER_SERVICE_BEAN("UserServiceBean!za.co.issuetracker.backend.user.service.UserService");

    private String value;

    SessionBeanConstant(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

}
