package za.co.issuetracker.backend.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * A test class for DateUtil
 *
 * @author Jaco Koekemoer
 * Date: 2023-02-25
 */
public class DateUtilTest
{

    @Test
    public void testConvertStringToDate()
    {
        String date = "2017-11-15 15:30:14.332";
        String format = DateUtil.DATE_TIME_MILL_FORMAT;
        Date result = DateUtil.convertStringToDate(date, format);
        Assert.assertNotNull(result);
    }

    @Test
    public void testConvertDateToString()
    {
        String dateString = "2017-11-15 15:30:14.332";
        String format = DateUtil.DATE_TIME_MILL_FORMAT;
        Date date = DateUtil.convertStringToDate(dateString, format);
        String result = DateUtil.convertDateToString(date, format);
        Assert.assertNotNull(result);
        Assert.assertTrue(dateString.equals(result));
    }

}
