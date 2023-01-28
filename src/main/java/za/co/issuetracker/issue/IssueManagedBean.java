package za.co.issuetracker.issue;

import za.co.issuetracker.issue.domain.Issue;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * The main backing bean for managing Issues.
 *
 * @author Jaco Koekemoer
 * Date: 2023-01-26
 */
@ManagedBean(name = "issueManagedBean")
@SessionScoped
public class IssueManagedBean implements Serializable
{

    private final Logger LOG = Logger.getLogger(this.getClass().getName());
    private static List<Issue> issueList = new ArrayList<>();
    private static int maxId = 1;

    static
    {
        issueList.clear();
        issueList.add(new Issue(maxId++, "Page Navigation Broken", "When clicking on the link, it breaks."));
        issueList.add(new Issue(maxId++, "Font too Big", "The font of the heading is too big."));
        issueList.add(new Issue(maxId++, "Button not responsive", "The Cancel button does not do anything."));
        issueList.add(new Issue(maxId++, "Button missing", "There is no OK button on the second screen."));
        issueList.add(new Issue(maxId++, "Incorrect calculation", "The result of the formula is incorrect."));
    }

    /**
     * Get the list of issues
     *
     * @return
     */
    public List<Issue> getIssueList()
    {
        return issueList;
    }

    /* Add a issue */
    public String addIssue(Issue issue)
    {
        String message = String.format("Adding issue: %s", issue.toString());
        issue.setId(maxId++);
        LOG.info(message);
        issueList.add(issue);
        return "success";
    }

    /* Cancel a issue */
    public String cancelIssue()
    {
        return "cancel";
    }

    /**
     * Delete a issue
     *
     * @param issue
     * @return
     */
    public String deleteIssue(Issue issue)
    {
        List<Issue> newIssueList = new ArrayList<>();
        for (Issue currentIssue : getIssueList())
        {
            if (currentIssue.getId() != issue.getId())
            {
                newIssueList.add(currentIssue);
            }
        }
        this.issueList = newIssueList;
        return "success";
    }

    /**
     * Edit a issue
     *
     * @param issue
     * @return
     */
    public String editIssue(Issue issue)
    {
        Issue issueToEdit = new Issue();
        issueToEdit.setId(issue.getId());
        issueToEdit.setHeading(issue.getHeading());
        issueToEdit.setDescription(issue.getDescription());
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        /* Put the issue to edit on the session map, which is the accessed in edit-issue.xhtml */
        sessionMap.put("editIssue", issueToEdit);
        return "success";
    }

    /**
     * Update a issue
     *
     * @param issue
     * @return
     */
    public String updateIssue(Issue issue)
    {
        List<Issue> newIssueList = new ArrayList<>();
        for (Issue currentIssue : getIssueList())
        {
            if (currentIssue.getId() != issue.getId())
            {
                newIssueList.add(currentIssue);
            }
            else
            {
                newIssueList.add(issue);
            }
        }
        this.issueList = newIssueList;
        return "success";
    }

    /**
     * Refresh the issue data
     *
     * @return
     */
    public String refreshIssueData()
    {
        issueList.clear();
        maxId = 1;
        issueList.add(new Issue(maxId++, "Page Navigation Broken", "When clicking on the link, it breaks."));
        issueList.add(new Issue(maxId++, "Font too Big", "The font of the heading is too big."));
        issueList.add(new Issue(maxId++, "Button not responsive", "The Cancel button does not do anything."));
        issueList.add(new Issue(maxId++, "Button missing", "There is no OK button on the second screen."));
        issueList.add(new Issue(maxId++, "Incorrect calculation", "The result of the formula is incorrect."));
        return "success";
    }

    /**
     * Get the maximum ID for the issues
     *
     * @return
     */
    public static int getMaxId()
    {
        return maxId;
    }
}
