package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class RecurringScheduleTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new RecurringSchedule(null));
    }

    @Test
    public void constructor_invalidSchedule_throwsIllegalArgumentException() {
        String invalidSchedule = "invalid schedule";
        assertThrows(IllegalArgumentException.class, () -> new RecurringSchedule(invalidSchedule));
    }

    @Test
    public void isValidSchedule_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> RecurringSchedule.isValidSchedule(null));
    }

    @Test
    public void isValidSchedule_validSchedules_returnsTrue() {
        // Valid schedule examples:
        assertTrue(RecurringSchedule.isValidSchedule("Monday 0900 1700"));
        assertTrue(RecurringSchedule.isValidSchedule("Mon 0000 2359"));
        assertTrue(RecurringSchedule.isValidSchedule("Tuesday 1230 1330"));
        // Test case-insensitivity
        assertTrue(RecurringSchedule.isValidSchedule("fri 0800 1200"));
    }

    @Test
    public void isValidSchedule_invalidSchedules_returnsFalse() {
        // Invalid schedule examples:
        assertFalse(RecurringSchedule.isValidSchedule("")); // empty string
        assertFalse(RecurringSchedule.isValidSchedule("Monday")); // missing times
        assertFalse(RecurringSchedule.isValidSchedule("Monday 0900")); // missing second time
        assertFalse(RecurringSchedule.isValidSchedule("Monday09001700")); // no spaces between parts
        assertFalse(RecurringSchedule.isValidSchedule("Funday 0900 1700")); // invalid day
        assertFalse(RecurringSchedule.isValidSchedule("Monday 900 1700")); // time not in four-digit format
        assertFalse(RecurringSchedule.isValidSchedule("Monday 2400 0100")); // invalid time: 2400 is not allowed
    }

    @Test
    public void equals() {
        RecurringSchedule schedule = new RecurringSchedule("Monday 0900 1700");
        // Same values -> returns true
        assertTrue(schedule.equals(new RecurringSchedule("Monday 0900 1700")));
        // Same object -> returns true
        assertTrue(schedule.equals(schedule));
        // Null -> returns false
        assertFalse(schedule.equals(null));
        // Different types -> returns false
        assertFalse(schedule.equals("Monday 0900 1700"));
        // Different schedule -> returns false
        assertFalse(schedule.equals(new RecurringSchedule("Tuesday 0900 1700")));
    }

    @Test
    public void hashCode_sameForEqualSchedules() {
        RecurringSchedule schedule1 = new RecurringSchedule("Monday 0900 1700");
        RecurringSchedule schedule2 = new RecurringSchedule("Monday 0900 1700");
        assertTrue(schedule1.hashCode() == schedule2.hashCode());
    }

    @Test
    public void toString_returnsCorrectFormat() {
        RecurringSchedule schedule = new RecurringSchedule("Monday 0900 1700");
        String expected = "[Monday 0900 1700]";
        assertTrue(schedule.toString().equals(expected));
    }

    @Test
    public void isValidTime_validTimes_returnsTrue() {
        // Valid schedule where end time is after start time.
        assertTrue(RecurringSchedule.isValidTime("Monday 0900 1700"));
    }

    @Test
    public void isValidTime_invalidTimes_returnsFalse() {
        // Although the format is valid, the end time is not after the start time.
        assertFalse(RecurringSchedule.isValidTime("Monday 1400 1200"));
    }

    @Test
    public void constructor_abbreviatedDayFormatsToFullDay() {
        // Provide an abbreviated day and check that it is formatted to its full, capitalized form.
        RecurringSchedule schedule = new RecurringSchedule("fri 0800 1200");
        assertEquals("[Friday 0800 1200]", schedule.toString());
    }

    @Test
    public void constructor_edgeCaseTimes_returnsCorrectFormat() {
        // Test the edge valid times: one minute past midnight and near midnight.
        RecurringSchedule schedule1 = new RecurringSchedule("Monday 0000 0001");
        assertEquals("[Monday 0000 0001]", schedule1.toString());

        RecurringSchedule schedule2 = new RecurringSchedule("Monday 2358 2359");
        assertEquals("[Monday 2358 2359]", schedule2.toString());
    }

    @Test
    public void isValidTime_null_throwsNullPointerException() {
        // The method should throw a NullPointerException when provided with null.
        assertThrows(NullPointerException.class, () -> RecurringSchedule.isValidTime(null));
    }

}
