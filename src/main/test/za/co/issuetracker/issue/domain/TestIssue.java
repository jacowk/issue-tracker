package za.co.issuetracker.issue.domain;

import org.junit.Assert;
import org.junit.Test;

/**
 * A test class for Issue domain object
 *
 * @author Jaco Koekemoer
 * Date: 2023-01-28
 */
public class TestIssue
{

    @Test
    public void testIssue()
    {
        Issue issue = new Issue();
        Assert.assertNotNull(issue);
    }

}
