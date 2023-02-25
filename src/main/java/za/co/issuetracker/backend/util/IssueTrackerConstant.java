package za.co.issuetracker.backend.util;

/**
 * A constants file containing miscellaneous constant values for Issue Tracker.
 *
 * @author Jaco Koekemoer
 * Date: 2023-02-25
 */
public enum IssueTrackerConstant
{

    EMPTY_STRING("");

    private String value;

    IssueTrackerConstant(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }
}
