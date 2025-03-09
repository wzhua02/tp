package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class OneTimeDateTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new OneTimeDate(null));
    }

    @Test
    public void constructor_invalidName_throwsIllegalArgumentException() {
        String invalidOneTimeDate = "";
        assertThrows(IllegalArgumentException.class, () -> new OneTimeDate(invalidOneTimeDate));
    }

    @Test
    public void isValidOneTimeDate() {
        // null one time date
        assertThrows(NullPointerException.class, () -> OneTimeDate.isValidOneTimeDate(null));

        // invalid one time date
        assertFalse(OneTimeDate.isValidOneTimeDate("")); // empty string
        assertFalse(OneTimeDate.isValidOneTimeDate(" ")); // spaces only
        assertFalse(OneTimeDate.isValidOneTimeDate("^")); // only non-alphanumeric characters
        assertFalse(OneTimeDate.isValidOneTimeDate("peter*")); // contains non-alphanumeric characters
        assertFalse(OneTimeDate.isValidOneTimeDate("2/2 1000 12")); // wrong time
        assertFalse(OneTimeDate.isValidOneTimeDate("3/2 1000 1290")); // wrong date
        assertFalse(OneTimeDate.isValidOneTimeDate("34/10 1000 1200")); // wrong date
        assertFalse(OneTimeDate.isValidOneTimeDate("3/13 1000 1200")); // wrong date

        // valid one time date
        assertTrue(OneTimeDate.isValidOneTimeDate("2/2 1000 1200")); // d/m HHmm HHmm
        assertTrue(OneTimeDate.isValidOneTimeDate("02/2 1000 1200")); // dd/m HHmm HHmm
        assertTrue(OneTimeDate.isValidOneTimeDate("2/02 1000 1200")); // d/mm HHmm HHmm
        assertTrue(OneTimeDate.isValidOneTimeDate("02/02 1000 1200")); // dd/mm HHmm HHmm
        assertTrue(OneTimeDate.isValidOneTimeDate("2/2/25 1000 1200")); // d/m/yy HHmm HHmm
        assertTrue(OneTimeDate.isValidOneTimeDate("02/02/25 1000 1200")); // dd/mm/yy HHmm HHmm
    }

    @Test
    public void equals() {
        OneTimeDate oneTimeDate = new OneTimeDate("2/2 1000 1200");

        // same values -> returns true
        assertTrue(oneTimeDate.equals(new OneTimeDate("2/2 1000 1200")));

        // same object -> returns true
        assertTrue(oneTimeDate.equals(oneTimeDate));

        // null -> returns false
        assertFalse(oneTimeDate.equals(null));

        // different types -> returns false
        assertFalse(oneTimeDate.equals(5.0f));

        // different values -> returns false
        assertFalse(oneTimeDate.equals(new OneTimeDate("30/2 1000 1200")));
    }
}
