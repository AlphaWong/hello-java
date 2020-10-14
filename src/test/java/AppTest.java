import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class AppTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testMoreThanAMonthApartBuildInWithInvalidMonth() {
        exceptionRule.expectMessage("invalid month: -1");
        DateString a = new DateString();
        a.year = 2000;
        a.month = -1;
        a.day = 1;
        DateString b = new DateString();
        b.year = 2001;
        b.month = 1;
        b.day = 1;
        DateString.moreThanAMonthApartBuildIn(a, b);
    }

    @Test
    public void testMoreThanAMonthApartBuildInWithInvalidDayOfMonth() {
        exceptionRule.expectMessage("invalid day of month: 35");
        DateString a = new DateString();
        a.year = 1989;
        a.month = 5;
        a.day = 35;
        DateString b = new DateString();
        b.year = 2001;
        b.month = 1;
        b.day = 1;
        DateString.moreThanAMonthApartBuildIn(a, b);
    }

    @Test
    public void testMoreThanAMonthApartBuildInWithInvalidNegativeDayOfMonth() {
        exceptionRule.expectMessage("invalid day of month: -1");
        DateString a = new DateString();
        a.year = 2000;
        a.month = 2;
        a.day = -1;
        DateString b = new DateString();
        b.year = 2001;
        b.month = 1;
        b.day = 1;
        DateString.moreThanAMonthApartBuildIn(a, b);
    }

    @Test
    public void testMoreThanAMonthApartBuildInWithDifferenceYear() {
        DateString a = new DateString();
        a.year = 1989;
        a.month = 6;
        a.day = 4;
        DateString b = new DateString();
        b.year = 2019;
        b.month = 7;
        b.day = 21;
        assertTrue(DateString.moreThanAMonthApartBuildIn(a, b));
    }

    @Test
    public void testMoreThanAMonthApartBuildInCrossFEB28() {
        DateString a = new DateString();
        a.year = 2000;
        a.month = 2;
        a.day = 28;
        DateString b = new DateString();
        b.year = 2000;
        b.month = 3;
        b.day = 29;
        assertTrue(DateString.moreThanAMonthApartBuildIn(a, b));
    }

    @Test
    public void testMoreThanAMonthApartBuildInWithCrossYear() {
        DateString a = new DateString();
        a.year = 2000;
        a.month = 11;
        a.day = 30;
        DateString b = new DateString();
        b.year = 2001;
        b.month = 1;
        b.day = 1;
        assertTrue(DateString.moreThanAMonthApartBuildIn(a, b));
    }

    @Test
    public void testMoreThanAMonthApartBuildInWithCross31And30Day() {
        DateString a = new DateString();
        a.year = 2000;
        a.month = 3;
        a.day = 31;
        DateString b = new DateString();
        b.year = 2000;
        b.month = 4;
        b.day = 30;
        assertFalse(DateString.moreThanAMonthApartBuildIn(a, b));
    }

    @Test
    public void testMoreThanAMonthApartBuildInWithDifferenceBCYear() {
        DateString a = new DateString();
        a.year = -1;
        a.month = 1;
        a.day = 1;
        DateString b = new DateString();
        b.year = 2001;
        b.month = 1;
        b.day = 1;
        assertTrue(DateString.moreThanAMonthApartBuildIn(a, b));
    }

    @Test
    public void testMoreThanAMonthApartBuildInBetweenFebAndMar() {
        DateString a = new DateString();
        a.year = 2000;
        a.month = 2;
        a.day = 24;
        DateString b = new DateString();
        b.year = 2000;
        b.month = 3;
        b.day = 1;
        assertFalse(DateString.moreThanAMonthApartBuildIn(a, b));
    }

    @Test
    public void testMoreThanAMonthApartBuildInWithSameDate() {
        DateString a = new DateString();
        a.year = 2019;
        a.month = 8;
        a.day = 31;
        DateString b = new DateString();
        b.year = 2019;
        b.month = 8;
        b.day = 31;
        assertFalse(DateString.moreThanAMonthApartBuildIn(a, b));
    }

    @Test
    public void testMoreThanAMonthApartBuildInWithAIsLatest() {
        DateString a = new DateString();
        a.year = 2019;
        a.month = 10;
        a.day = 1;
        DateString b = new DateString();
        b.year = 2018;
        b.month = 10;
        b.day = 1;
        assertTrue(DateString.moreThanAMonthApartBuildIn(a, b));
    }

    @Test
    public void testMoreThanAMonthApartBuildInWithAIsLatestButLessThanAMonthGap() {
        DateString a = new DateString();
        a.year = 2001;
        a.month = 2;
        a.day = 1;
        DateString b = new DateString();
        b.year = 2001;
        b.month = 1;
        b.day = 19;
        assertFalse(DateString.moreThanAMonthApartBuildIn(a, b));
    }

    @Test
    public void testGetAMonthLater() {
        // 19990101
        DateString a = new DateString();
        a.year = 1999;
        a.month = 1;
        a.day = 1;
        DateString b = DateString.getAMonthLater(a);
        // 19990202
        assertEquals(1999, b.year);
        assertEquals(2, b.month);
        assertEquals(2, b.day);
    }

    @Test
    public void testGetAMonthLaterFEB() {
        // 19990101
        DateString a = new DateString();
        a.year = 1999;
        a.month = 2;
        a.day = 1;
        DateString b = DateString.getAMonthLater(a);
        // 19990202
        assertEquals(1999, b.year);
        assertEquals(3, b.month);
        assertEquals(2, b.day);
    }

    @Test
    public void testGetAMonthLaterCrossYear() {
        // 19991201
        DateString a = new DateString();
        a.year = 1999;
        a.month = 12;
        a.day = 1;
        DateString b = DateString.getAMonthLater(a);
        // 20000102
        assertEquals(2000, b.year);
        assertEquals(1, b.month);
        assertEquals(2, b.day);
    }

    @Test
    public void testGetAMonthLaterFromMAYToJUN() {
        // 19991201
        DateString a = new DateString();
        a.year = 1999;
        a.month = 5;
        a.day = 30;
        DateString b = DateString.getAMonthLater(a);
        // 20000102
        assertEquals(1999, b.year);
        assertEquals(6, b.month);
        assertEquals(31, b.day);
    }

    @Test
    public void testGetAMonthLaterFromJAN2FEBInLeapYear() {
        // 19991201
        DateString a = new DateString();
        a.year = 2000;
        a.month = 1;
        a.day = 28;
        DateString b = DateString.getAMonthLater(a);
        // 20000102
        assertEquals(2000, b.year);
        assertEquals(2, b.month);
        assertEquals(29, b.day);
    }

    @Test
    public void testGetAMonthLaterFromJAN2FEBInNonLeapYear() {
        // 19991201
        DateString a = new DateString();
        a.year = 1999;
        a.month = 1;
        a.day = 28;
        DateString b = DateString.getAMonthLater(a);
        // 20000102
        assertEquals(1999, b.year);
        assertEquals(3, b.month);
        assertEquals(1, b.day);
    }

    @Test
    public void testIsLaterOrEqualThanInEqualDate() {
        // 19991001
        DateString a = new DateString();
        a.year = 1999;
        a.month = 1;
        a.day = 28;
        // 19991001
        DateString b = new DateString();
        b.year = 1999;
        b.month = 1;
        b.day = 28;
        assertTrue(DateString.isLaterOrEqualThan(a, b));
    }

    @Test
    public void testIsLaterOrEqualThanInSameMonthOneDayAfterDate() {
        // 19991001
        DateString a = new DateString();
        a.year = 1999;
        a.month = 1;
        a.day = 28;
        // 19991001
        DateString b = new DateString();
        b.year = 1999;
        b.month = 1;
        b.day = 29;
        assertTrue(DateString.isLaterOrEqualThan(a, b));
    }

    @Test
    public void testIsLaterOrEqualThanInSameMonthOneDayBeforeDate() {
        // 19991001
        DateString a = new DateString();
        a.year = 1999;
        a.month = 1;
        a.day = 28;
        // 19991001
        DateString b = new DateString();
        b.year = 1999;
        b.month = 1;
        b.day = 27;
        assertFalse(DateString.isLaterOrEqualThan(a, b));
    }

    @Test
    public void testIsLaterOrEqualThanCrossYear() {
        // 19991001
        DateString a = new DateString();
        a.year = 1999;
        a.month = 1;
        a.day = 28;
        // 19991001
        DateString b = new DateString();
        b.year = 2000;
        b.month = 1;
        b.day = 27;
        assertTrue(DateString.isLaterOrEqualThan(a, b));
    }

    @Test
    public void testIsLaterOrEqualThanOneMonthBeforeDate() {
        // 19991001
        DateString a = new DateString();
        a.year = 1999;
        a.month = 2;
        a.day = 28;
        // 19991001
        DateString b = new DateString();
        b.year = 1999;
        b.month = 1;
        b.day = 27;
        assertFalse(DateString.isLaterOrEqualThan(a, b));
    }

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
        exceptionRule.expectMessage("invalid day of month: 35");
        DateString a = new DateString();
        a.year = 1989;
        a.month = 5;
        a.day = 35;
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
    public void testMoreThanAMonthApartCrossFEB28() {
        DateString a = new DateString();
        a.year = 2000;
        a.month = 2;
        a.day = 28;
        DateString b = new DateString();
        b.year = 2000;
        b.month = 3;
        b.day = 29;
        assertTrue(DateString.moreThanAMonthApart(a, b));
    }

    @Test
    public void testMoreThanAMonthApartWithCrossYear() {
        DateString a = new DateString();
        a.year = 2000;
        a.month = 11;
        a.day = 30;
        DateString b = new DateString();
        b.year = 2001;
        b.month = 1;
        b.day = 1;
        assertTrue(DateString.moreThanAMonthApart(a, b));
    }

    @Test
    public void testMoreThanAMonthApartWithCross31And30Day() {
        DateString a = new DateString();
        a.year = 2000;
        a.month = 3;
        a.day = 31;
        DateString b = new DateString();
        b.year = 2000;
        b.month = 4;
        b.day = 30;
        assertFalse(DateString.moreThanAMonthApart(a, b));
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
    public void testMoreThanAMonthApartBetweenMayAndJul() {
        DateString a = new DateString();
        a.year = 2000;
        a.month = 5;
        a.day = 31;
        DateString b = new DateString();
        b.year = 2000;
        b.month = 7;
        b.day = 1;
        assertTrue(DateString.moreThanAMonthApart(a, b));
    }

    @Test
    public void testMoreThanAMonthApartBetweenJulAndAug() {
        DateString a = new DateString();
        a.year = 2000;
        a.month = 7;
        a.day = 31;
        DateString b = new DateString();
        b.year = 2000;
        b.month = 9;
        b.day = 1;
        assertTrue(DateString.moreThanAMonthApart(a, b));
    }

    @Test
    public void testMoreThanAMonthApartBetweenAugAndSep() {
        DateString a = new DateString();
        a.year = 2000;
        a.month = 8;
        a.day = 31;
        DateString b = new DateString();
        b.year = 2000;
        b.month = 10;
        b.day = 1;
        assertTrue(DateString.moreThanAMonthApart(a, b));
    }

    @Test
    public void testMoreThanAMonthApartBetweenOctAndNov() {
        DateString a = new DateString();
        a.year = 2000;
        a.month = 10;
        a.day = 31;
        DateString b = new DateString();
        b.year = 2000;
        b.month = 12;
        b.day = 1;
        assertTrue(DateString.moreThanAMonthApart(a, b));
    }

    @Test
    public void testMoreThanAMonthApartBetweenDecAndJanCrossYear() {
        DateString a = new DateString();
        a.year = 2000;
        a.month = 12;
        a.day = 31;
        DateString b = new DateString();
        b.year = 2001;
        b.month = 2;
        b.day = 1;
        assertTrue(DateString.moreThanAMonthApart(a, b));
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