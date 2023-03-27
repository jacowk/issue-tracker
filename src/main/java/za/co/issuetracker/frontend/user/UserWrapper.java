package za.co.issuetracker.frontend.user;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

/**
 * A wrapper class used to represent user data for the frontend
 *
 * @author Jaco Koekemoer
 * Date: 2023-02-25
 */
@ManagedBean(name = "userWrapper")
@RequestScoped
public class UserWrapper implements Serializable
{

    private Long id;
    private String firstname;
    private String surname;
    private String username;
    private String password;
    private boolean active;
    private String activeString;

    /**
     * Default constructor
     */
    public UserWrapper()
    {

    }

    /**
     *
     * @param id int
     * @param firstname String
     * @param surname String
     */
    public UserWrapper(Long id, String firstname, String surname, boolean active)
    {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.active = active;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    public String getActiveString()
    {
        return activeString;
    }

    public void setActiveString(String activeString)
    {
        this.activeString = activeString;
    }
}
