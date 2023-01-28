package za.co.issuetracker.navigation;

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
        return "success";
    }

    /**
     * List all the issues
     *
     * @return
     */
    public String manageIssues()
    {
        return "success";
    }

    /**
     * Add an issue
     *
     * @return
     */
    public String addIssue()
    {
        return "success";
    }

}
