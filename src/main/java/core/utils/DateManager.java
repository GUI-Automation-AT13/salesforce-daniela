package core.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.openqa.selenium.InvalidArgumentException;

/**
 * Converts to date a given string with some date.
 */
public class DateManager {

    private Calendar today;

    /**
     * Adds the format to the date.
     *
     * @param calendarDate obtained calendar date.
     * @return a date.
     */
    public Date addFormatDate(Calendar calendarDate) {
        DateFormat parser = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date;
        try {
            date = parser.parse(new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(calendarDate.getTime()));
        } catch (ParseException e) {
            throw new RuntimeException("It was not possible to format the date", e);
        }
        return date;
    }

    /**
     * Gets the date of a given string.
     *
     * @param stringDate a string date.
     * @return a date.
     */
    public Date getDate(String stringDate) {
        if (stringDate == null) {
            throw new NullPointerException("Invalid Argument: Unsupported String Format.");
        } else if (stringDate.equals("")) {
            throw new InvalidArgumentException("Invalid Argument: Unsupported String Format.");
        }
        Date newDate;
        if (stringDate.matches("TODAY|TOMORROW|YESTERDAY")) {
            newDate = oneDateGroup(stringDate);
            return newDate;
        }
        if (stringDate.contains("ago")) {
            newDate = passedDateGroup(stringDate);
            return newDate;
        }
        if (stringDate.contains("from now")) {
            newDate = futureDateGroup(stringDate);
            return newDate;
        }
        if (stringDate.contains("/")) {
            newDate = simpleDateGroup(stringDate);
            return newDate;
        }
        throw new InvalidArgumentException("Invalid Argument: Unsupported String Format.");
    }

    /**
     * Finds the date for one word date.
     *
     * @param date a string with the date to find.
     * @return a date.
     */
    private Date oneDateGroup(String date) {
        today = Calendar.getInstance();
        if (date.equals("TODAY")) {
            return addFormatDate(today);
        }
        if (date.equals("TOMORROW")) {
            today.add(Calendar.DAY_OF_MONTH, 1);
            return addFormatDate(today);
        }
        if (date.equals("YESTERDAY")) {
            today.add(Calendar.DAY_OF_MONTH, -1);
            return addFormatDate(today);
        }
        throw new InvalidArgumentException("Invalid Argument: Unsupported String Format.");
    }

    /**
     * Finds the date for a passed date.
     *
     * @param date a string with the date to find.
     * @return a date.
     */
    private Date passedDateGroup(String date) {
        int number;
        String[] result = date.trim().split(" ");
        if (result.length == 3) {
            try {
                number = (Integer.parseInt(result[0]));
            } catch (IllegalArgumentException e) {
                throw new NumberFormatException();
            }
            String timeUnit = result[1];
            return separateUnits(timeUnit, -number);
        }
        throw new InvalidArgumentException("Invalid Argument: Unsupported String Format.");
    }

    /**
     * Finds the date for a future date.
     *
     * @param date a string with the date to find.
     * @return a date.
     */
    private Date futureDateGroup(String date) {
        int number;
        String[] result = date.trim().split(" ");
        if (result.length == 4) {
            try {
                number = (Integer.parseInt(result[0]));
            } catch (IllegalArgumentException e) {
                throw new NumberFormatException();
            }
            String timeUnit = result[1];
            return separateUnits(timeUnit, number);
        }
        throw new InvalidArgumentException("Invalid Argument: Unsupported String Format.");
    }

    /**
     * Separates the time units.
     *
     * @param timeUnit the unit to change.
     * @param number   the amount to change.
     * @return a date.
     */
    private Date separateUnits(String timeUnit, int number) {
        today = Calendar.getInstance();
        if (timeUnit.matches("second|seconds")) {
            today.add(Calendar.SECOND, number);
            return addFormatDate(today);
        }
        if (timeUnit.matches("minute|minutes")) {
            today.add(Calendar.MINUTE, number);
            return addFormatDate(today);
        }
        if (timeUnit.matches("hour|hours")) {
            today.add(Calendar.HOUR, number);
            return addFormatDate(today);
        }
        if (timeUnit.matches("day|days")) {
            today.add(Calendar.DAY_OF_YEAR, number);
            return addFormatDate(today);
        }
        if (timeUnit.matches("week|weeks")) {
            today.add(Calendar.WEEK_OF_MONTH, number);
            return addFormatDate(today);
        }
        if (timeUnit.matches("month|months")) {
            today.add(Calendar.MONTH, number);
            return addFormatDate(today);
        }
        if (timeUnit.matches("year|years")) {
            today.add(Calendar.YEAR, number);
            return addFormatDate(today);
        }
        throw new InvalidArgumentException("Invalid Argument: Unsupported String Format.");
    }

    /**
     * Finds the date of a string date.
     *
     * @param dateString a string with the date to find.
     * @return a date.
     */
    private Date simpleDateGroup(String dateString) {
        DateFormat parser = new SimpleDateFormat("MM/dd/yyyy");
        Date date;
        try {
            date = parser.parse(dateString);
        } catch (ParseException e) {
            throw new InvalidArgumentException("It was not possible to format the date", e);
        }
        return date;
    }

    /**
     * Gets today date.
     *
     * @return a String with the date.
     */
    public String getTodayDate() {
        Date actualDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyyHH:mm");
        return dateFormat.format(actualDate);
    }
}


