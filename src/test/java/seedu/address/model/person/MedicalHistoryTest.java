package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class MedicalHistoryTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new MedicalHistory(null));
    }

    @Test
    public void constructor_invalidMedicalHistory_throwsIllegalArgumentException() {
        String invalidMedicalHistory = "é©";
        assertThrows(IllegalArgumentException.class, () -> new MedicalHistory(invalidMedicalHistory));
    }

    @Test
    public void isValidMedicalHistory() {
        //null medical history
        assertThrows(NullPointerException.class, () -> MedicalHistory.isValidMedicalHistory(null));

        // invalid medical histories
        assertFalse(MedicalHistory.isValidMedicalHistory(" "));// blank space
        assertFalse(MedicalHistory.isValidMedicalHistory("é©"));// non-ASCII character

        // valid medical histories
        assertTrue(MedicalHistory.isValidMedicalHistory("Lower Back Injury"));
        assertTrue(MedicalHistory.isValidMedicalHistory("Fractured 4 fingers on right hand, "
                + "Subluxations and ligament damage of vetebrae")); // Long medical history
    }

    @Test
    public void equals() {
        MedicalHistory medicalHistory = new MedicalHistory("Valid Medical History");

        // same values -> returns true
        assertTrue(medicalHistory.equals(new MedicalHistory("Valid Medical History")));

        // same object -> returns true
        assertTrue(medicalHistory.equals(medicalHistory));

        // null -> returns false
        assertFalse(medicalHistory.equals(null));

        // different types -> returns false
        assertFalse(medicalHistory.equals(5.0f));

        // different values -> returns false
        assertFalse(medicalHistory.equals(new MedicalHistory("Other Valid Medical History")));
    }
}
