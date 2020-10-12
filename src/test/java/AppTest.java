import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class AppTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testMoreThanAMonthApartWithInvalidMonth() {
        exceptionRule.expectMessage("invalid month: -1");
        DateString a = new DateString();
        a.year = 2000;
        a.month = -1;
        a.day = 1;
        DateString b = new DateString();
        b.year = 2001;
        b.month = 1;
        b.day = 1;
        DateString.moreThanAMonthApart(a, b);
    }

    @Test
    public void testMoreThanAMonthApartWithInvalidDayOfMonth() {
        exceptionRule.expectMessage("invalid day of month: 30");
        DateString a = new DateString();
        a.year = 2000;
        a.month = 2;
        a.day = 30;
        DateString b = new DateString();
        b.year = 2001;
        b.month = 1;
        b.day = 1;
        DateString.moreThanAMonthApart(a, b);
    }

    @Test
    public void testMoreThanAMonthApartWithInvalidNegativeDayOfMonth() {
        exceptionRule.expectMessage("invalid day of month: -1");
        DateString a = new DateString();
        a.year = 2000;
        a.month = 2;
        a.day = -1;
        DateString b = new DateString();
        b.year = 2001;
        b.month = 1;
        b.day = 1;
        DateString.moreThanAMonthApart(a, b);
    }

    @Test
    public void testMoreThanAMonthApartWithDifferenceYear() {
        DateString a = new DateString();
        a.year = 1989;
        a.month = 6;
        a.day = 4;
        DateString b = new DateString();
        b.year = 2019;
        b.month = 7;
        b.day = 21;
        assertTrue(DateString.moreThanAMonthApart(a, b));
    }

    @Test
    public void testMoreThanAMonthApartWithDifferenceBCYear() {
        DateString a = new DateString();
        a.year = -1;
        a.month = 1;
        a.day = 1;
        DateString b = new DateString();
        b.year = 2001;
        b.month = 1;
        b.day = 1;
        assertTrue(DateString.moreThanAMonthApart(a, b));
    }

    @Test
    public void testMoreThanAMonthApartBetweenFebAndMar() {
        DateString a = new DateString();
        a.year = 2000;
        a.month = 2;
        a.day = 24;
        DateString b = new DateString();
        b.year = 2000;
        b.month = 3;
        b.day = 1;
        assertFalse(DateString.moreThanAMonthApart(a, b));
    }

    @Test
    public void testMoreThanAMonthApartWithSameDate() {
        DateString a = new DateString();
        a.year = 2019;
        a.month = 8;
        a.day = 31;
        DateString b = new DateString();
        b.year = 2019;
        b.month = 8;
        b.day = 31;
        assertFalse(DateString.moreThanAMonthApart(a, b));
    }

    @Test
    public void testMoreThanAMonthApartWithAIsLatest() {
        DateString a = new DateString();
        a.year = 2019;
        a.month = 10;
        a.day = 1;
        DateString b = new DateString();
        b.year = 2018;
        b.month = 10;
        b.day = 1;
        assertTrue(DateString.moreThanAMonthApart(a, b));
    }

    @Test
    public void testMoreThanAMonthApartWithAIsLatestButLessThanAMonthGap() {
        DateString a = new DateString();
        a.year = 2001;
        a.month = 2;
        a.day = 1;
        DateString b = new DateString();
        b.year = 2001;
        b.month = 1;
        b.day = 19;
        assertFalse(DateString.moreThanAMonthApart(a, b));
    }
}