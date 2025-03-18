package seedu.address.model.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class DayOfWeekTest {
    @Test
    void testGetAbbreviation() {
        assertEquals("Mon", DayOfWeek.MONDAY.getAbbreviation());
        assertEquals("Tue", DayOfWeek.TUESDAY.getAbbreviation());
        assertEquals("Wed", DayOfWeek.WEDNESDAY.getAbbreviation());
        assertEquals("Thu", DayOfWeek.THURSDAY.getAbbreviation());
        assertEquals("Fri", DayOfWeek.FRIDAY.getAbbreviation());
        assertEquals("Sat", DayOfWeek.SATURDAY.getAbbreviation());
        assertEquals("Sun", DayOfWeek.SUNDAY.getAbbreviation());
    }

    @Test
    void testFromString_validFullName() {
        assertEquals(DayOfWeek.MONDAY, DayOfWeek.fromString("Monday"));
        assertEquals(DayOfWeek.TUESDAY, DayOfWeek.fromString("Tuesday"));
        assertEquals(DayOfWeek.WEDNESDAY, DayOfWeek.fromString("Wednesday"));
        assertEquals(DayOfWeek.THURSDAY, DayOfWeek.fromString("Thursday"));
        assertEquals(DayOfWeek.FRIDAY, DayOfWeek.fromString("Friday"));
        assertEquals(DayOfWeek.SATURDAY, DayOfWeek.fromString("Saturday"));
        assertEquals(DayOfWeek.SUNDAY, DayOfWeek.fromString("Sunday"));
    }

    @Test
    void testFromString_validAbbreviations() {
        assertEquals(DayOfWeek.MONDAY, DayOfWeek.fromString("Mon"));
        assertEquals(DayOfWeek.TUESDAY, DayOfWeek.fromString("Tue"));
        assertEquals(DayOfWeek.WEDNESDAY, DayOfWeek.fromString("Wed"));
        assertEquals(DayOfWeek.THURSDAY, DayOfWeek.fromString("Thu"));
        assertEquals(DayOfWeek.FRIDAY, DayOfWeek.fromString("Fri"));
        assertEquals(DayOfWeek.SATURDAY, DayOfWeek.fromString("Sat"));
        assertEquals(DayOfWeek.SUNDAY, DayOfWeek.fromString("Sun"));
    }

    @Test
    void testFromString_caseInsensitive() {
        assertEquals(DayOfWeek.MONDAY, DayOfWeek.fromString("monday"));
        assertEquals(DayOfWeek.TUESDAY, DayOfWeek.fromString("tueSDAY"));
        assertEquals(DayOfWeek.WEDNESDAY, DayOfWeek.fromString("WeD"));
        assertEquals(DayOfWeek.THURSDAY, DayOfWeek.fromString("thu"));
        assertEquals(DayOfWeek.FRIDAY, DayOfWeek.fromString("fRI"));
    }

    @Test
    void testFromString_invalidValues() {
        assertThrows(IllegalArgumentException.class, () -> DayOfWeek.fromString("Notaday"));
        assertThrows(IllegalArgumentException.class, () -> DayOfWeek.fromString("Mond"));
        assertThrows(IllegalArgumentException.class, () -> DayOfWeek.fromString("Mo"));
        assertThrows(IllegalArgumentException.class, () -> DayOfWeek.fromString(""));
        assertThrows(IllegalArgumentException.class, () -> DayOfWeek.fromString("123"));
    }

    @Test
    void testIsDayOfWeek_validInputs() {
        assertTrue(DayOfWeek.isDayOfWeek("Monday"));
        assertTrue(DayOfWeek.isDayOfWeek("mon"));
        assertTrue(DayOfWeek.isDayOfWeek("TUESDAY"));
        assertTrue(DayOfWeek.isDayOfWeek("wed"));
        assertTrue(DayOfWeek.isDayOfWeek("Thu"));
        assertTrue(DayOfWeek.isDayOfWeek("fri"));
        assertTrue(DayOfWeek.isDayOfWeek("saturday"));
        assertTrue(DayOfWeek.isDayOfWeek("Sun"));
    }

    @Test
    void testIsDayOfWeek_invalidInputs() {
        assertFalse(DayOfWeek.isDayOfWeek("Mo"));
        assertFalse(DayOfWeek.isDayOfWeek("Mond"));
        assertFalse(DayOfWeek.isDayOfWeek("Notaday"));
        assertFalse(DayOfWeek.isDayOfWeek("123"));
        assertFalse(DayOfWeek.isDayOfWeek(""));
        assertFalse(DayOfWeek.isDayOfWeek("mon1"));
    }

    @Test
    void testGenerateDayOfWeekRegex() {
        String regex = "(?i)(" + DayOfWeek.generateDayOfWeekRegex() + ")";
        assertTrue("Monday".matches(regex));
        assertTrue("Tue".matches(regex));
        assertTrue("WEDNESDAY".matches(regex));
        assertTrue("fri".matches(regex));
        assertFalse("Funday".matches(regex));
        assertFalse("Monx".matches(regex));
    }

    @Test
    void testToString() {
        assertEquals("Monday", DayOfWeek.MONDAY.toString());
        assertEquals("Tuesday", DayOfWeek.TUESDAY.toString());
        assertEquals("Wednesday", DayOfWeek.WEDNESDAY.toString());
        assertEquals("Thursday", DayOfWeek.THURSDAY.toString());
        assertEquals("Friday", DayOfWeek.FRIDAY.toString());
        assertEquals("Saturday", DayOfWeek.SATURDAY.toString());
        assertEquals("Sunday", DayOfWeek.SUNDAY.toString());
    }
}
