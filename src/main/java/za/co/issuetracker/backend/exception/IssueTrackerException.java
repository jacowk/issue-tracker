package za.co.issuetracker.backend.exception;

/**
 * An general exception for Issue Tracker
 *
 * @author Jaco Koekemoer
 * Date: 2023-02-25
 */
public class IssueTrackerException extends Throwable
{

    public IssueTrackerException(Exception exception)
    {
        super(exception);
    }

    public IssueTrackerException(String exceptionMessage)
    {
        super(exceptionMessage);
    }

}
