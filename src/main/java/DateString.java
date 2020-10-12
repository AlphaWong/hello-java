import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class DateString {
    public int day;
    public int month;
    public int year;

    public static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        }
        return true;
    }

    public static boolean isValidDayOfMonth(DateString dateString) {
        if (dateString.day <= 0) {
            return false;
        }
        HashMap months = new HashMap<Integer, Integer>();
        months.put(1, 31);
        months.put(3, 31);
        months.put(4, 30);
        months.put(5, 31);
        months.put(6, 30);
        months.put(7, 31);
        months.put(8, 31);
        months.put(9, 30);
        months.put(10, 31);
        months.put(11, 30);
        months.put(12, 31);
        if (isLeapYear(dateString.year)) {
            months.put(2, 29);
        }
        months.put(2, 28);
        return dateString.day <= ((Integer) months.get(dateString.month)).intValue();
    }

    public static boolean validDate(DateString dateString) throws Error {
        if (dateString.month <= 0) {
            throw new Error(String.format("invalid month: %s", dateString.month));
        }
        if (!isValidDayOfMonth(dateString)) {
            throw new Error(String.format("invalid day of month: %s", dateString.day));
        }
        return true;
    }

    public static boolean moreThanAMonthApart(final DateString a, final DateString b) throws Error {
        validDate(a);
        validDate(b);

        GregorianCalendar calendarA = new GregorianCalendar(a.year, a.month, a.day);
        GregorianCalendar calendarB = new GregorianCalendar(b.year, b.month, b.day);
        if (calendarA.compareTo(calendarB) == -1) {
            calendarB.add(Calendar.MONTH, -1);
            // After deduce a month, if calendarA still ahead.
            // it still more than a month
            if (calendarA.compareTo(calendarB) == -1) {
                return true;
            }
        } else {
            calendarA.add(Calendar.MONTH, -1);
            if (calendarB.compareTo(calendarA) == -1) {
                return true;
            }
        }
        return false;
    }
}