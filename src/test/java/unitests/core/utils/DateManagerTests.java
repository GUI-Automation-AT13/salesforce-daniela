package unitests.core.utils;

import core.utils.DateManager;
import org.openqa.selenium.InvalidArgumentException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import static org.testng.Assert.assertEquals;

public class DateManagerTests {
    DateManager dates;
    DateFormat parser;
    String dateFormat = "MM/dd/yyyy HH:mm:ss";

    @BeforeTest
    public void initialize() {
        dates = new DateManager();
        parser = new SimpleDateFormat(dateFormat);
    }

    @Test
    public void testGetTodayDate() throws ParseException {
        String value = "TODAY";
        Date dateResult = dates.getDate(value);
        Calendar calendar = Calendar.getInstance();
        Date date = parser.parse(new SimpleDateFormat(dateFormat).format(calendar.getTime()));
        assertEquals(dateResult, date, "The expected date is incorrect");
    }

    @Test
    public void testGetYesterdayDate() throws ParseException {
        String value = "YESTERDAY";
        Calendar calendar = Calendar.getInstance();
        Date dateResult = dates.getDate(value);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date date = parser.parse(new SimpleDateFormat(dateFormat).format(calendar.getTime()));
        assertEquals(dateResult, date, "The expected date is incorrect");
    }

    @Test
    public void testGetTomorrowDate() throws ParseException {
        String value = "TOMORROW";
        Calendar calendar = Calendar.getInstance();
        Date dateResult = dates.getDate(value);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date date = parser.parse(new SimpleDateFormat(dateFormat).format(calendar.getTime()));
        assertEquals(dateResult, date, "The expected date is incorrect");
    }

    @Test
    public void testGetTwoDaysAgoDate() throws ParseException {
        String value = "2 days ago";
        Calendar calendar = Calendar.getInstance();
        Date dateResult = dates.getDate(value);
        calendar.add(Calendar.DAY_OF_MONTH, -2);
        Date date = parser.parse(new SimpleDateFormat(dateFormat).format(calendar.getTime()));
        assertEquals(dateResult, date, "The expected day date is incorrect");
    }

    @Test
    public void testGetTwoHundredSecondsAgoDate() throws ParseException {
        String value = "200 seconds ago";
        Calendar calendar = Calendar.getInstance();
        Date dateResult = dates.getDate(value);
        calendar.add(Calendar.SECOND, -200);
        Date date = parser.parse(new SimpleDateFormat(dateFormat).format(calendar.getTime()));
        assertEquals(dateResult, date, "The expected day date is incorrect");
    }

    @Test
    public void testGetTenMonthsAgoDate() throws ParseException {
        String value = "10 months ago";
        Calendar calendar = Calendar.getInstance();
        Date dateResult = dates.getDate(value);
        calendar.add(Calendar.MONTH, -10);
        Date date = parser.parse(new SimpleDateFormat(dateFormat).format(calendar.getTime()));
        assertEquals(dateResult, date, "The expected day date is incorrect");
    }

    @Test
    public void testGetTwentyHoursFromNowDate() throws ParseException {
        String value = "20 hours from now";
        Calendar calendar = Calendar.getInstance();
        Date dateResult = dates.getDate(value);
        calendar.add(Calendar.HOUR, 20);
        Date date = parser.parse(new SimpleDateFormat(dateFormat).format(calendar.getTime()));
        assertEquals(dateResult, date, "The expected hour date is incorrect");
    }

    @Test
    public void testGetOneMinuteFromNowDate() throws ParseException {
        String value = "1 minutes from now";
        Calendar calendar = Calendar.getInstance();
        Date dateResult = dates.getDate(value);
        calendar.add(Calendar.MINUTE, 1);
        Date date = parser.parse(new SimpleDateFormat(dateFormat).format(calendar.getTime()));
        assertEquals(dateResult, date, "The expected hour date is incorrect");
    }
    @Test
    public void testGetFiveWeeksFromNowDate() throws ParseException {
        String value = "5 weeks from now";
        Calendar calendar = Calendar.getInstance();
        Date dateResult = dates.getDate(value);
        calendar.add(Calendar.WEEK_OF_YEAR, 5);
        Date date = parser.parse(new SimpleDateFormat(dateFormat).format(calendar.getTime()));
        assertEquals(dateResult, date, "The expected hour date is incorrect");
    }

    @Test
    public void testGetOneYearFromNowDate() throws ParseException {
        String value = "1 year from now";
        Calendar calendar = Calendar.getInstance();
        Date dateResult = dates.getDate(value);
        calendar.add(Calendar.YEAR, 1);
        Date date = parser.parse(new SimpleDateFormat(dateFormat).format(calendar.getTime()));
        assertEquals(dateResult, date, "The expected hour date is incorrect");
    }

    @Test
    public void testSimpleStringDate() throws ParseException {
        DateManager dates = new DateManager();
        DateFormat parser = new SimpleDateFormat("MM/dd/yyyy");
        String value = "01/20/2021";
        Date dateResult = dates.getDate(value);
        Date date = parser.parse(value);
        assertEquals(dateResult, date, "The simple date is incorrect");
    }

    @Test(expectedExceptions = {InvalidArgumentException.class})
    public void testGetPassedDateWithInvalidTimeUnit() {
        String value = "2 min ago";
        dates.getDate(value);
    }

    @Test(expectedExceptions = {NullPointerException.class})
    public void testGetDateWithNullValue() {
        String value = null;
        dates.getDate(value);
    }

    @Test(expectedExceptions = {InvalidArgumentException.class})
    public void testGetDateWithEmptyValue() {
        String value = "";
        dates.getDate(value);
    }

    @Test(expectedExceptions = {InvalidArgumentException.class})
    public void testGetDateWithInvalidTimeFormat() {
        String value = "MM/dd/yyyy";
        dates.getDate(value);
    }

    @Test(expectedExceptions = {InvalidArgumentException.class})
    public void testGetTodayDateWithInvalidValue() {
        String value = "TDY";
        dates.getDate(value);
    }

    @Test(expectedExceptions = {NumberFormatException.class, InvalidArgumentException.class})
    public void testGetFutureDateWithInvalidValue() {
        String value = "from now";
        dates.getDate(value);
    }

    @Test(expectedExceptions = {NumberFormatException.class, InvalidArgumentException.class})
    public void testGetFutureDateWithOnlyWordsValue() {
        String value = "one day from now";
        dates.getDate(value);
    }

    @Test(expectedExceptions = {NumberFormatException.class, InvalidArgumentException.class})
    public void testGetPassedDateWithInvalidValue() {
        String value = "ago";
        dates.getDate(value);
    }

    @Test(expectedExceptions = {NumberFormatException.class, InvalidArgumentException.class})
    public void testGetPassedDateWithOnlyWordsValue() {
        String value = "ten days ago";
        dates.getDate(value);
    }

}