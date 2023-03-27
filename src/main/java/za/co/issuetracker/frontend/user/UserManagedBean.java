package za.co.issuetracker.frontend.user;

import za.co.issuetracker.backend.user.UserUtil;
import za.co.issuetracker.backend.user.domain.User;
import za.co.issuetracker.backend.user.service.UserService;
import za.co.issuetracker.frontend.util.IssueTrackerUIConstants;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * The main backing bean for managing Users.
 *
 * @author Jaco Koekemoer
 * Date: 2023-01-26
 */
@ManagedBean(name = "userManagedBean")
@SessionScoped
public class UserManagedBean implements Serializable
{

    private final Logger LOG = Logger.getLogger(this.getClass().getName());
    @EJB
    private UserService userService;
    private List<UserWrapper> userWrapperList = new ArrayList<>();

    public UserManagedBean()
    {

    }

    @PostConstruct
    public void init() {

    }

    /**
     * Get the list of users. This is called from manage-users.xhtml, to populate the datatable
     * containing all the users.
     *
     * @return List<UserWrapper>
     */
    public List<UserWrapper> getUserList()
    {
        /* Retrieve the users from the database via the session bean */
        List<User> userList = userService.findAllUsers();

        /* Convert the users to  */
        userWrapperList.clear();
        for (User user: userList)
        {
            userWrapperList.add(UserUtil.convertUserToUserWrapper(user));
        }
        return userWrapperList;
    }

    /**
     * This method is called when the user clicks on the Add button in add-user.xhtml.
     *
     * @param userWrapper UserWrapper
     * @return String
     */
    public String addUser(UserWrapper userWrapper)
    {
        String message = String.format("Adding a user: %s", userWrapper.toString());
        LOG.info(message);
        User user = UserUtil.convertUserWrapperToUser(userWrapper);
        userService.addUser(user);
        return IssueTrackerUIConstants.SUCCESS_NAVIGATION.getValue();
    }

    /**
     * This method is called when the user clicks on the Cancel button in add-user.xhtml.
     *
     * @return String
     */
    public String cancelAddUser()
    {
        String message = String.format("Cancel adding a user");
        LOG.info(message);
        return IssueTrackerUIConstants.SUCCESS_NAVIGATION.getValue();
    }

    /**
     * A method to deactivate a user if it is active. This method is called from manage-users.xhtml
     * when the user clicks on the Deactivate link for particular user.
     *
     * @param userWrapper
     */
    public String deactivateUser(UserWrapper userWrapper)
    {
        //TODO the User object should be updated by calling the UserServiceBean's updateUser() method.
        //The activate field should be set to false first.
        return IssueTrackerUIConstants.SUCCESS_NAVIGATION.getValue();
    }

    /**
     * Edit a selected users. This is called from the Edit link to edit a user in the datatable in
     * manage-users.xhtml method
     *
     * @param userWrapper
     */
    public String editUser(UserWrapper userWrapper)
    {
        //TODO
//        IssueWrapper issueWrapperToEdit = new IssueWrapper();
//        issueWrapperToEdit.setId(issueWrapper.getId());
//        issueWrapperToEdit.setHeading(issueWrapper.getHeading());
//        issueWrapperToEdit.setDescription(issueWrapper.getDescription());
//        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//        /* Put the issueWrapper to edit on the session map, which is the accessed in edit-issueWrapper.xhtml */
//        sessionMap.put("editIssue", issueWrapperToEdit);
        return IssueTrackerUIConstants.SUCCESS_NAVIGATION.getValue();
    }

}
