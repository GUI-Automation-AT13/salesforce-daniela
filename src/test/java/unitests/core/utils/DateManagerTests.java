package unitests.core.utils;

import core.utils.DateManager;
import org.openqa.selenium.InvalidArgumentException;
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
        assertEquals(dateResult, date, "The expected hour date is incorrect");
    }

    @Test
    public void testSimpleStringDate() throws ParseException {
        DateManager dates = new DateManager();
        DateFormat parser = new SimpleDateFormat("MM/dd/yyyy");
        String value = "12/20/2021";
        Date dateResult = dates.getDate(value);
        Date date = parser.parse(value);
        assertEquals(dateResult, date, "The simple date is incorrect");
    }

    @Test(expectedExceptions = {InvalidArgumentException.class})
    public void testGetPassedDateWithInvalidTimeUnit() {
        DateManager dates = new DateManager();
        String value = "2 min ago";
        dates.getDate(value);
    }

    @Test(expectedExceptions = {NullPointerException.class})
    public void testGetDateWithNullValue() {
        DateManager dates = new DateManager();
        String value = null;
        dates.getDate(value);
    }

    @Test(expectedExceptions = {InvalidArgumentException.class})
    public void testGetDateWithEmptyValue() {
        DateManager dates = new DateManager();
        String value = "";
        dates.getDate(value);
    }

    @Test(expectedExceptions = {InvalidArgumentException.class})
    public void testGetDateWithInvalidTimeFormat() {
        DateManager dates = new DateManager();
        String value = "MM/dd/yyyy";
        dates.getDate(value);
    }

    @Test(expectedExceptions = {InvalidArgumentException.class})
    public void testGetTodayDateWithInvalidValue() {
        DateManager dates = new DateManager();
        String value = "TDY";
        dates.getDate(value);
    }

    @Test(expectedExceptions = {NumberFormatException.class, InvalidArgumentException.class})
    public void testGetFutureDateWithInvalidValue() {
        DateManager dates = new DateManager();
        String value = "from now";
        dates.getDate(value);
    }

    @Test(expectedExceptions = {NumberFormatException.class, InvalidArgumentException.class})
    public void testGetPassedDateWithInvalidValue() {
        DateManager dates = new DateManager();
        String value = "ago";
        dates.getDate(value);
    }
}