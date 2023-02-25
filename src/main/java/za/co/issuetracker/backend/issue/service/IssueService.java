package za.co.issuetracker.backend.issue.service;

import za.co.issuetracker.backend.issue.domain.Issue;

import javax.ejb.Remote;
import java.io.Serializable;

/**
 * A remove interface for managing Issues
 *
 * @author Jaco Koekemoer
 * Date: 2023-02-17
 */
@Remote
public interface IssueService extends Serializable
{

    /**
     * A contract for adding an issue
     *
     * @param issue Issue
     */
    public void addIssue(Issue issue);

}
