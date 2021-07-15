package core.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
            throw new RuntimeException("The value is not valid");
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
        Date newDate = null;
        if (stringDate.matches("TODAY|TOMORROW|YESTERDAY")) {
            newDate = oneDateGroup(stringDate);
        }
        if (stringDate.contains("ago")) {
            newDate = passedDateGroup(stringDate);
        }
        if (stringDate.contains("from now")) {
            newDate = futureDateGroup(stringDate);
        }
        if (stringDate.contains("/")) {
            newDate = simpleDateGroup(stringDate);
        }
        return newDate;
    }

    /**
     * Finds the date for one word date.
     *
     * @param date a string with the date to find.
     * @return a date.
     */
    public Date oneDateGroup(String date) {
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

        return null;
    }

    /**
     * Finds the date for a passed date.
     *
     * @param date a string with the date to find.
     * @return a date.
     */
    public Date passedDateGroup(String date) {
        int number;
        String word;
        String[] result = date.trim().split(" ");
        number = (Integer.parseInt(result[0]));
        word = result[1];
        return separateUnits(word, -number);
    }

    /**
     * Finds the date for a future date.
     *
     * @param date a string with the date to find.
     * @return a date.
     */
    public Date futureDateGroup(String date) {
        int number;
        String word;
        String[] result = date.trim().split(" ");
        number = (Integer.parseInt(result[0]));
        word = result[1];
        return separateUnits(word, number);
    }

    /**
     * Separates the time units.
     *
     * @param word the unit to change.
     * @param number the amount to change.
     * @return a date.
     */
    public Date separateUnits(String word, int number) {
        today = Calendar.getInstance();
        if (word.matches("second|seconds")) {
            today.add(Calendar.SECOND, number);
            return addFormatDate(today);
        }
        if (word.matches("minute|minutes")) {
            today.add(Calendar.MINUTE, number);
            return addFormatDate(today);
        }
        if (word.matches("hour|hours")) {
            today.add(Calendar.HOUR, number);
            return addFormatDate(today);
        }
        if (word.matches("day|days")) {
            today.add(Calendar.DAY_OF_YEAR, number);
            return addFormatDate(today);
        }
        if (word.matches("week|weeks")) {
            today.add(Calendar.WEEK_OF_MONTH, number);
            return addFormatDate(today);
        }
        if (word.matches("month|months")) {
            today.add(Calendar.MONTH, number);
            return addFormatDate(today);
        }
        if (word.matches("year|years")) {
            today.add(Calendar.YEAR, number);
            return addFormatDate(today);
        }
        return null;
    }

    /**
     * Finds the date of a string date.
     *
     * @param dateString a string with the date to find.
     * @return a date.
     */
    public Date simpleDateGroup(String dateString) {
        DateFormat parser = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        try {
            date = parser.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}


