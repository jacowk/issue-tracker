package za.co.issuetracker.backend.domain;

import za.co.issuetracker.backend.user.domain.User;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * A value object represents any domain object in this application that can be persisted to the database.
 *
 * @author Jaco Koekemoer
 * Date: 2023-02-10
 */
@MappedSuperclass
public class AbstractValueObject implements Serializable
{

    private boolean active;
    @ManyToOne
    @JoinColumn(name = "create_user_id")
    private User createUser;
    @Column(name = "create_user_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @ManyToOne
    @JoinColumn(name = "modify_user_id")
    private User modifyUser;
    @Column(name = "modify_user_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyDate;

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    public User getCreateUser()
    {
        return createUser;
    }

    public void setCreateUser(User createUser)
    {
        this.createUser = createUser;
    }

    public Date getCreateDate()
    {
        return createDate;
    }

    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }

    public User getModifyUser()
    {
        return modifyUser;
    }

    public void setModifyUser(User modifyUser)
    {
        this.modifyUser = modifyUser;
    }

    public Date getModifyDate()
    {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate)
    {
        this.modifyDate = modifyDate;
    }
}
