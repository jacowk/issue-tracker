package za.co.issuetracker.backend.issue.domain;

import za.co.issuetracker.backend.domain.AbstractValueObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * A value object that represents an issue, meaning a bug or a story that should be tracked.
 *
 * @author Jaco Koekemoer
 * Date: 2023-02-10
 */
@Entity
@Table(name = "issue")
public class Issue extends AbstractValueObject
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    private String heading;
    private String description;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
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

}