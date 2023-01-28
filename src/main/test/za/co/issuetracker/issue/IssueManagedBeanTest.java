package za.co.issuetracker.issue;

import org.junit.Assert;
import org.junit.Test;
import za.co.issuetracker.issue.domain.Issue;

import java.util.List;

/**
 * The test case for IssueManagedBean
 *
 * @author Jaco Koekemoer
 * Date: 2023-01-26
 */
public class IssueManagedBeanTest
{

    @Test
    public void testGetIssueList()
    {
        IssueManagedBean issueManagedBean = new IssueManagedBean();
        List<Issue> issueList = issueManagedBean.getIssueList();
        Assert.assertNotNull(issueList);
        Assert.assertTrue(issueList.size() > 0);
        for (Issue issue : issueList)
        {
            System.out.println(issue.toString());
        }
    }

    @Test
    public void testAddIssue()
    {
        IssueManagedBean issueManagedBean = new IssueManagedBean();
        List<Issue> issueList = issueManagedBean.getIssueList();
        int sizeBeforeAdd = issueList.size();
        Issue issue = new Issue(sizeBeforeAdd + 1, "Wrong color", "The color of the menu is incorrect");
        issueManagedBean.addIssue(issue);
        List<Issue> issueListAfterAdd = issueManagedBean.getIssueList();
        int sizeAfterAdd = issueListAfterAdd.size();
        Assert.assertTrue(sizeAfterAdd == sizeBeforeAdd + 1); //TODO This fails
    }

    @Test
    public void testRemoveIssue()
    {
        IssueManagedBean issueManagedBean = new IssueManagedBean();
        List<Issue> issueListBeforeRemove = issueManagedBean.getIssueList();
        int sizeBeforeRemove = issueListBeforeRemove.size();
        int maxId = IssueManagedBean.getMaxId();
        Issue issueToRemove = issueListBeforeRemove.get(1);
        issueManagedBean.deleteIssue(issueToRemove);
        issueManagedBean.getIssueList();
        List<Issue> issueListAfterRemove = issueManagedBean.getIssueList();
        int sizeAfterRemove = issueListAfterRemove.size();
        Assert.assertTrue(sizeAfterRemove == sizeBeforeRemove - 1);
    }

}
