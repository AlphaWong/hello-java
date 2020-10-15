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
        months.put(2, isLeapYear(dateString.year) ? 29 : 28);
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
        return dateString.day <= ((Integer) months.get(dateString.month)).intValue();
    }

    public static boolean validDate(DateString dateString) throws Error {
        // 0 < N <= 12
        if (1 > dateString.month || dateString.month > 12) {
            throw new Error(String.format("invalid month: %s", dateString.month));
        }
        if (!isValidDayOfMonth(dateString)) {
            throw new Error(String.format("invalid day of month: %s", dateString.day));
        }
        return true;
    }

    public static DateString getAMonthLater(final DateString a) {
        DateString aMonthLater = new DateString();
        aMonthLater.year = a.year;
        if (a.month == 1 && a.day == 28) {
            if (isLeapYear(a.year)) {
                aMonthLater.month = 2;
                aMonthLater.day = 29;
            } else {
                aMonthLater.month = 3;
                aMonthLater.day = 1;
            }
        } else if (a.month == 1 && (a.day == 29 || a.day == 30 || a.day == 31)) {
            aMonthLater.month = 3;
            aMonthLater.day = 1;
        } else if (a.month == 3 && a.day == 31) {
            aMonthLater.month = 5;
            aMonthLater.day = 1;
        } else if (a.month == 5 && a.day == 31) {
            aMonthLater.month = 7;
            aMonthLater.day = 1;
        } else if (a.month == 7 && a.day == 31) {
            aMonthLater.month = 9;
            aMonthLater.day = 1;
        } else if (a.month == 8 && a.day == 31) {
            aMonthLater.month = 10;
            aMonthLater.day = 1;
        } else if (a.month == 10 && a.day == 31) {
            aMonthLater.month = 12;
            aMonthLater.day = 1;
        } else if (a.month == 12 && a.day == 31) {
            aMonthLater.year = a.year + 1;
            aMonthLater.month = 2;
            aMonthLater.day = 1;
        } else {
            aMonthLater.month = a.month + 1;
            if (aMonthLater.month == 13) {
                aMonthLater.month = 1;
                aMonthLater.year = a.year + 1;
            }
            aMonthLater.day = a.day + 1;
        }
        return aMonthLater;
    }

    public static boolean isLaterOrEqualThan(final DateString aMonthLater, final DateString b) {
        // aMonthLater 19991010
        if (b.year == aMonthLater.year) {
            if (b.month == aMonthLater.month) {
                if (b.day >= aMonthLater.day) {
                    // b 19991011
                    // b 19991010
                    return true;
                } else {
                    // b 19991001
                    return false;
                }
            } else if (b.month > aMonthLater.month) {
                // b 19991110
                return true;
            } else {
                // b 19990910
                return false;
            }
        } else if (b.year > aMonthLater.year) {
            // b 20000910
            return true;
        } else if (aMonthLater.year > b.year) {
            // b 19980910
            return false;
        }
        return false;
    }

    public static boolean moreThanAMonthApart(final DateString a, final DateString b) {
        validDate(a);
        validDate(b);
        if (isLaterOrEqualThan(a, b)) {
            DateString aMonthLater = getAMonthLater(a);
            return isLaterOrEqualThan(aMonthLater, b);
        }
        DateString aMonthLater = getAMonthLater(b);
        return isLaterOrEqualThan(aMonthLater, a);
    }

    public static boolean moreThanAMonthApartBuildIn(final DateString a, final DateString b) throws Error {
        validDate(a);
        validDate(b);

        GregorianCalendar calendarA = new GregorianCalendar(a.year, a.month, a.day);
        GregorianCalendar calendarB = new GregorianCalendar(b.year, b.month, b.day);
        if (calendarA.compareTo(calendarB) == -1) {
            calendarB.add(GregorianCalendar.MONTH, -1);
            // After deduce a month, if calendarA still ahead.
            // it still more than a month
            if (calendarA.compareTo(calendarB) == -1) {
                return true;
            }
        } else {
            calendarA.add(GregorianCalendar.MONTH, -1);
            if (calendarB.compareTo(calendarA) == -1) {
                return true;
            }
        }
        return false;
    }
}