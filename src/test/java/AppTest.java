import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class AppTest {
    @Test
    public void testMoreThanAMonthApartWithDifferenceYear() {
        DateString a = new DateString();
        a.year = 2000;
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
        a.year = 2000;
        a.month = 1;
        a.day = 1;
        DateString b = new DateString();
        b.year = 2000;
        b.month = 1;
        b.day = 1;
        assertFalse(DateString.moreThanAMonthApart(a, b));
    }

    @Test
    public void testMoreThanAMonthApartWithAIsLatest() {
        DateString a = new DateString();
        a.year = 2001;
        a.month = 1;
        a.day = 1;
        DateString b = new DateString();
        b.year = 2000;
        b.month = 1;
        b.day = 1;
        assertTrue(DateString.moreThanAMonthApart(a, b));
    }

    @Test
    public void testMoreThanAMonthApartWithAIsLatestButLessThanAMonthGap() {
        DateString a = new DateString();
        a.year = 2001;
        a.month = 1;
        a.day = 1;
        DateString b = new DateString();
        b.year = 2001;
        b.month = 1;
        b.day = 2;
        assertFalse(DateString.moreThanAMonthApart(a, b));
    }
}