package za.co.issuetracker.issue.domain;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

/**
 * A domain object representing an issue
 *
 * @author Jaco Koekemoer
 * Date: 2023-01-26
 */
@ManagedBean(name = "issue")
@RequestScoped
public class Issue implements Serializable
{

    public int id;
    public String heading;
    public String description;
    public String result;

    public Issue()
    {
    }

    public Issue(int id, String heading, String description)
    {
        this.id = id;
        this.heading = heading;
        this.description = description;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getHeading()
    {
        return heading;
    }

    public void setHeading(String heading)
    {
        this.heading = heading;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getResult()
    {
        return result;
    }

    public void setResult(String result)
    {
        this.result = result;
    }

    @Override
    public String toString()
    {
        return "Issue{" +
                "id=" + id +
                ", heading='" + heading + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
