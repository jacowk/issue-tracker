package za.co.issuetracker.backend.user.domain;

import za.co.issuetracker.backend.domain.AbstractValueObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * A class representing a user in the system. This user will be used for logins and auditing purposes.
 *
 * @author Jaco Koekemoer
 * Date: 2023-02-11
 */
@Entity
@Table(name = "user")
//public class User implements Serializable
public class User extends AbstractValueObject
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "firstname", nullable = false)
    private String firstname;
    @Column(name = "surname", nullable = false)
    private String surname;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;

    private boolean active;

    /**
     * Default constructor
     */
    public User()
    {

    }

    /**
     * Constructor for firstname and surname
     *
     * @param firstname
     * @param surname
     */
    public User(String firstname, String surname)
    {
        this.firstname = firstname;
        this.surname = surname;
    }

    /**
     * Constructor for firstname, surname, username, password, active
     *
     * @param firstname
     * @param surname
     * @param username
     * @param password
     * @param active
     */
    public User(Long id, String firstname, String surname, String username, String password,
                boolean active)
    {
        this.firstname = firstname;
        this.surname = surname;
        this.username = username;
        this.password = password;
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

    @Override
    public String toString()
    {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
