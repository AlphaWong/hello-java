import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateString {
    public int day;
    public int month;
    public int year;

    public static boolean moreThanAMonthApart(final DateString a, final DateString b) {
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