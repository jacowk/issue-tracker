package za.co.issuetracker.frontend.util;

/**
 * A constants file containing miscellaneous constant values for the Issue Tracker user interface.
 *
 * @author Jaco Koekemoer
 * Date: 2023-02-26
 */
public enum IssueTrackerUIConstants
{

    SUCCESS_NAVIGATION("success");

    private String value;

    IssueTrackerUIConstants(String value)
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
