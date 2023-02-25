package za.co.issuetracker.backend.util;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import za.co.issuetracker.backend.exception.IssueTrackerException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A util class for managing date/time related methods.
 *
 * @author Jaco Koekemoer
 * Date: 2023-02-25
 */
public class DateUtil
{

    private static Logger LOG = Logger.getLogger(DateUtil.class.getName());
    public static String DATE_TIME_MILL_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
    public static String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static String DATE_FORMAT = "yyyy-MM-dd";
    public static String TIME_FORMAT = "HH:mm:ss";

    /**
     * Convert a string to a date format
     * Example: 2017-11-15 15:30:14.332
     *
     * @param date String
     * @param format String
     * @return
     */
    public static Date convertStringToDate(String date, String format)
    {
        try
        {
            return new SimpleDateFormat(format).parse(date);
        }
        catch (ParseException e)
        {
            String message = String.format("Unable to parse date %s with format %s", date, format);
            LOG.error(message);
        }
        return null;
    }

    /**
     * Convert a date to a string format
     * Example: "2017-11-15 15:30:14.332"
     *
     * @param date Date
     * @param format String
     * @return
     */
    public static String convertDateToString(Date date, String format)
    {
        try
        {
            return new SimpleDateFormat(format).format(date);
        }
        catch (Exception e)
        {
            String message = String.format("Unable to format date object with format %s", format);
            LOG.error(message);
        }
        return IssueTrackerConstant.EMPTY_STRING.getValue();
    }

}
