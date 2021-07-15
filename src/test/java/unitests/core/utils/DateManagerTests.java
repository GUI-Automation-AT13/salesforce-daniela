package unitests.core.utils;

import core.utils.DateManager;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.testng.Assert.assertEquals;

public class DateManagerTests {
    @Test
    public void testGetTodayDate() throws ParseException {
        DateManager dates = new DateManager();
        DateFormat parser = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String value = "TODAY";
        Date dateResult = dates.getDate(value);
        Calendar calendar = Calendar.getInstance();
        Date date = parser.parse(new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(calendar.getTime()));
        System.out.println(dateResult);
        System.out.println(date);
        assertEquals(dateResult, date, "The expected date is incorrect");
    }

    @Test
    public void testGetYesterdayDate() throws ParseException {
        DateManager dates = new DateManager();
        DateFormat parser = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String value = "YESTERDAY";
        Calendar calendar = Calendar.getInstance();
        Date dateResult = dates.getDate(value);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date date = parser.parse(new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(calendar.getTime()));
        System.out.println(dateResult);
        System.out.println(date);
        assertEquals(dateResult, date, "The expected date is incorrect");
    }

    @Test
    public void testGetTomorrowDate() throws ParseException {
        DateManager dates = new DateManager();
        DateFormat parser = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String value = "TOMORROW";
        Calendar calendar = Calendar.getInstance();
        Date dateResult = dates.getDate(value);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date date = parser.parse(new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(calendar.getTime()));
        System.out.println(dateResult);
        System.out.println(date);
        assertEquals(dateResult, date, "The expected date is incorrect");
    }

    @Test
    public void testGetTwoDAysAgoDate() throws ParseException {
        DateManager dates = new DateManager();
        DateFormat parser = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String value = "2 days ago";
        Calendar calendar = Calendar.getInstance();
        Date dateResult = dates.getDate(value);
        calendar.add(Calendar.DAY_OF_MONTH, -2);
        Date date = parser.parse(new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(calendar.getTime()));
        System.out.println(dateResult);
        System.out.println(date);
        assertEquals(dateResult, date, "The expected day date is incorrect");
    }

    @Test
    public void testGetTwentyHoursFromNowDate() throws ParseException {
        DateManager dates = new DateManager();
        DateFormat parser = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String value = "20 hours from now";
        Calendar calendar = Calendar.getInstance();
        Date dateResult = dates.getDate(value);
        calendar.add(Calendar.HOUR, 20);
        Date date = parser.parse(new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(calendar.getTime()));
        System.out.println(dateResult);
        System.out.println(date);
        assertEquals(dateResult, date, "The expected hour date is incorrect");
    }

    @Test
    public void testSimpleStringDate() throws ParseException {
        DateManager dates = new DateManager();
        DateFormat parser = new SimpleDateFormat("MM/dd/yyyy");
        String value = "12/20/2021";
        Date dateResult = dates.getDate(value);
        Date date = parser.parse(value);
        System.out.println(dateResult);
        System.out.println(date);
        assertEquals(dateResult, date, "The simple date is incorrect");
    }
}
