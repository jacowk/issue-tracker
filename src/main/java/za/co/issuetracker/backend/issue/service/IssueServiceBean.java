package za.co.issuetracker.backend.issue.service;

import za.co.issuetracker.backend.issue.domain.Issue;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * A stateless session bean for Issues
 *
 * @author Jaco Koekemoer
 * Date: 2023-02-17
 */
@Stateless
@Remote(IssueService.class)
public class IssueServiceBean implements IssueService
{

    @PersistenceContext(unitName = "myPersistenceUnit")
    private EntityManager entityManager;

    @Override
    public void addIssue(Issue issue)
    {
        entityManager.persist(issue);
    }

}
