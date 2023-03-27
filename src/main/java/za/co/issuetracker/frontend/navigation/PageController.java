package za.co.issuetracker.frontend.navigation;

import za.co.issuetracker.frontend.util.IssueTrackerUIConstants;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean(name = "pageController")
@SessionScoped
public class PageController implements Serializable
{

    /**
     * Go back home
     *
     * @return
     */
    public String index()
    {
        return IssueTrackerUIConstants.SUCCESS_NAVIGATION.getValue();
    }

    /**
     * List all the users
     *
     * @return
     */
    public String manageUsers()
    {
        return IssueTrackerUIConstants.SUCCESS_NAVIGATION.getValue();
    }

    /**
     * Add a user
     *
     * @return
     */
    public String addUser()
    {
        return IssueTrackerUIConstants.SUCCESS_NAVIGATION.getValue();
    }

    /**
     * List all the issues
     *
     * @return
     */
    public String manageIssues()
    {
        return IssueTrackerUIConstants.SUCCESS_NAVIGATION.getValue();
    }

    /**
     * Add an issue
     *
     * @return
     */
    public String addIssue()
    {
        return IssueTrackerUIConstants.SUCCESS_NAVIGATION.getValue();
    }

}
