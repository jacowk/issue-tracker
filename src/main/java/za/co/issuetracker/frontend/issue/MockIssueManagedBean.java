package za.co.issuetracker.frontend.issue;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * The main backing bean for managing Issues which contains the mock operations.
 *
 * @author Jaco Koekemoer
 * Date: 2023-01-29
 */
@ManagedBean(name = "mockIssueManagedBean")
@SessionScoped
public class MockIssueManagedBean implements Serializable
{

    private final Logger LOG = Logger.getLogger(this.getClass().getName());
    private static List<IssueWrapper> issueWrapperList = new ArrayList<>();
    private static int maxId = 1;

    static
    {
        issueWrapperList.clear();
        issueWrapperList.add(new IssueWrapper(maxId++, "Page Navigation Broken", "When clicking on the link, it breaks."));
        issueWrapperList.add(new IssueWrapper(maxId++, "Font too Big", "The font of the heading is too big."));
        issueWrapperList.add(new IssueWrapper(maxId++, "Button not responsive", "The Cancel button does not do anything."));
        issueWrapperList.add(new IssueWrapper(maxId++, "Button missing", "There is no OK button on the second screen."));
        issueWrapperList.add(new IssueWrapper(maxId++, "Incorrect calculation", "The result of the formula is incorrect."));
    }

    /**
     * Get the list of issues
     *
     * @return
     */
    public List<IssueWrapper> getIssueList()
    {
        return issueWrapperList;
    }

    /* Add a issueWrapper */
    public String addIssue(IssueWrapper issueWrapper)
    {
        String message = String.format("Adding issueWrapper: %s", issueWrapper.toString());
        issueWrapper.setId(maxId++);
        LOG.info(message);
        issueWrapperList.add(issueWrapper);
        return "success";
    }

    /* Cancel a issue */
    public String cancelIssue()
    {
        return "cancel";
    }

    /**
     * Delete a issueWrapper
     *
     * @param issueWrapper
     * @return
     */
    public String deleteIssue(IssueWrapper issueWrapper)
    {
        List<IssueWrapper> newIssueListWrapper = new ArrayList<>();
        for (IssueWrapper currentIssueWrapper : getIssueList())
        {
            if (currentIssueWrapper.getId() != issueWrapper.getId())
            {
                newIssueListWrapper.add(currentIssueWrapper);
            }
        }
        this.issueWrapperList = newIssueListWrapper;
        return "success";
    }

    /**
     * Edit a issueWrapper
     *
     * @param issueWrapper
     * @return
     */
    public String editIssue(IssueWrapper issueWrapper)
    {
        IssueWrapper issueWrapperToEdit = new IssueWrapper();
        issueWrapperToEdit.setId(issueWrapper.getId());
        issueWrapperToEdit.setHeading(issueWrapper.getHeading());
        issueWrapperToEdit.setDescription(issueWrapper.getDescription());
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        /* Put the issueWrapper to edit on the session map, which is the accessed in edit-issueWrapper.xhtml */
        sessionMap.put("editIssue", issueWrapperToEdit);
        return "success";
    }

    /**
     * Update a issueWrapper
     *
     * @param issueWrapper
     * @return
     */
    public String updateIssue(IssueWrapper issueWrapper)
    {
        List<IssueWrapper> newIssueListWrapper = new ArrayList<>();
        for (IssueWrapper currentIssueWrapper : getIssueList())
        {
            if (currentIssueWrapper.getId() != issueWrapper.getId())
            {
                newIssueListWrapper.add(currentIssueWrapper);
            }
            else
            {
                newIssueListWrapper.add(issueWrapper);
            }
        }
        this.issueWrapperList = newIssueListWrapper;
        return "success";
    }

    /**
     * Refresh the issue data
     *
     * @return
     */
    public String refreshIssueData()
    {
        issueWrapperList.clear();
        maxId = 1;
        issueWrapperList.add(new IssueWrapper(maxId++, "Page Navigation Broken", "When clicking on the link, it breaks."));
        issueWrapperList.add(new IssueWrapper(maxId++, "Font too Big", "The font of the heading is too big."));
        issueWrapperList.add(new IssueWrapper(maxId++, "Button not responsive", "The Cancel button does not do anything."));
        issueWrapperList.add(new IssueWrapper(maxId++, "Button missing", "There is no OK button on the second screen."));
        issueWrapperList.add(new IssueWrapper(maxId++, "Incorrect calculation", "The result of the formula is incorrect."));
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
