package za.co.issuetracker.frontend.issue;

import org.junit.Assert;
import org.junit.Test;
import za.co.issuetracker.frontend.issue.IssueManagedBean;
import za.co.issuetracker.frontend.issue.IssueWrapper;

import java.util.List;

/**
 * The test case for IssueManagedBean
 *
 * @author Jaco Koekemoer
 * Date: 2023-01-26
 */
public class IssueWrapperManagedBeanTest
{

    @Test
    public void testGetIssueList()
    {
        IssueManagedBean issueManagedBean = new IssueManagedBean();
        List<IssueWrapper> issueWrapperList = issueManagedBean.getIssueList();
        Assert.assertNotNull(issueWrapperList);
        Assert.assertTrue(issueWrapperList.size() > 0);
        for (IssueWrapper issueWrapper : issueWrapperList)
        {
            System.out.println(issueWrapper.toString());
        }
    }

    @Test
    public void testAddIssue()
    {
        IssueManagedBean issueManagedBean = new IssueManagedBean();
        List<IssueWrapper> issueWrapperList = issueManagedBean.getIssueList();
        int sizeBeforeAdd = issueWrapperList.size();
        IssueWrapper issueWrapper = new IssueWrapper(sizeBeforeAdd + 1, "Wrong color", "The color of the menu is incorrect");
        issueManagedBean.addIssue(issueWrapper);
        List<IssueWrapper> issueWrapperListAfterAdd = issueManagedBean.getIssueList();
        int sizeAfterAdd = issueWrapperListAfterAdd.size();
        Assert.assertTrue(sizeAfterAdd == sizeBeforeAdd + 1); //TODO This fails
    }

    @Test
    public void testRemoveIssue()
    {
        IssueManagedBean issueManagedBean = new IssueManagedBean();
        List<IssueWrapper> issueWrapperListBeforeRemove = issueManagedBean.getIssueList();
        int sizeBeforeRemove = issueWrapperListBeforeRemove.size();
        int maxId = issueManagedBean.getMaxId();
        IssueWrapper issueWrapperToRemove = issueWrapperListBeforeRemove.get(1);
        issueManagedBean.deleteIssue(issueWrapperToRemove);
        issueManagedBean.getIssueList();
        List<IssueWrapper> issueWrapperListAfterRemove = issueManagedBean.getIssueList();
        int sizeAfterRemove = issueWrapperListAfterRemove.size();
        Assert.assertTrue(sizeAfterRemove == sizeBeforeRemove - 1);
    }

}
