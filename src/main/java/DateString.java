import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateString {
    public int day;
    public int month;
    public int year;

    public static boolean moreThanAMonthApart(final DateString a, final DateString b) {
        GregorianCalendar calendarA = new GregorianCalendar(a.year, a.month, a.day);
        GregorianCalendar calendarB = new GregorianCalendar(b.year, b.month, b.day);
        calendarB.add(Calendar.MONTH, -1);

        // After deduce a month, if it still behind.
        // it still more than a month
        if (calendarA.compareTo(calendarB) == -1) {
            return true;
        }
        return false;
    }
}