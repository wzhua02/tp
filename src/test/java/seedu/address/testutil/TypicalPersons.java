package seedu.address.testutil;

import java.util.ArrayList;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GOALS_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GOALS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_LOCATION_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_LOCATION_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_MEDICAL_HISTORY_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_MEDICAL_HISTORY_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ONETIMESCHEDULE_AMY;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.person.Person;

import static seedu.address.logic.commands.CommandTestUtil.*;

/**
 * A utility class containing a list of {@code Person} objects to be used in tests.
 */
public class TypicalPersons {

    public static final Person ALICE = new PersonBuilder().withName("Alice Pauline").withPhone("94351253")
            .withEmail("alice@example.com").withMedicalHistory("Twisted right ankle").withGoals("Get fitter")
            .withLocation("123, Jurong West Ave 6, #08-111")
            .withOneTimeSchedules("1/2 1000 1200", "2/3 1000 1200").withTags("friends").build();
    public static final Person BENSON = new PersonBuilder().withName("Benson Meier").withPhone("98765432")
            .withEmail("johnd@example.com").withGoals("Lose weight")
            .withLocation("311, Clementi Ave 2, #02-25")
            .withOneTimeSchedules("2/3 1200 1400").withTags("owesMoney", "friends").build();
    public static final Person CARL = new PersonBuilder().withName("Carl Kurz").withPhone("95352563")
            .withEmail("heinz@example.com").withGoals("Gain muscle mass").withMedicalHistory("Fractured right hand")
            .withLocation("wall street").build();
    public static final Person DANIEL = new PersonBuilder().withName("Daniel Meier").withPhone("87652533")
            .withEmail("cornelia@example.com").withGoals("Get stronger").withMedicalHistory("Dislocated left shoulder")
            .withLocation("10th street")
            .withOneTimeSchedules("2/2 1000 1200").withTags("friends").build();
    public static final Person ELLE = new PersonBuilder().withName("Elle Meyer").withPhone("94822241")
            .withEmail("werner@example.com").withGoals("Work on stamina").withMedicalHistory("High blood pressure")
            .withLocation("michegan ave").build();
    public static final Person FIONA = new PersonBuilder().withName("Fiona Kunz").withPhone("94824271")
            .withEmail("lydia@example.com").withGoals("Calisthenics improvement")
            .withLocation("little tokyo").withMedicalHistory("Twisted left ankle")
            .withOneTimeSchedules("10/03 1800 2000").build();
    public static final Person GEORGE = new PersonBuilder().withName("George Best").withPhone("94824421")
            .withEmail("anna@example.com").withGoals("Calisthenics improvement")
            .withMedicalHistory("Metal rod in right arm").withLocation("4th street").build();

    // Manually added
    public static final Person HOON = new PersonBuilder().withName("Hoon Meier").withPhone("84824241")
            .withGoals("Drink more water").withMedicalHistory("Pancreas surgery")
            .withEmail("stefan@example.com").withLocation("little india").build();
    public static final Person IDA = new PersonBuilder().withName("Ida Mueller").withPhone("84821311")
            .withGoals("Leg strength").withMedicalHistory("Left eye infection")
            .withEmail("hans@example.com").withLocation("chicago ave").build();

    // Manually added - Person's details found in {@code CommandTestUtil}
    public static final Person AMY = new PersonBuilder().withName(VALID_NAME_AMY).withPhone(VALID_PHONE_AMY)
            .withEmail(VALID_EMAIL_AMY).withGoals(VALID_GOALS_AMY).withMedicalHistory(VALID_MEDICAL_HISTORY_AMY)
            .withLocation(VALID_LOCATION_AMY)
            .withOneTimeSchedules(VALID_ONETIMESCHEDULE_AMY).withTags(VALID_TAG_FRIEND).build();
    public static final Person BOB = new PersonBuilder().withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
            .withGoals(VALID_GOALS_BOB).withMedicalHistory(VALID_MEDICAL_HISTORY_BOB)
            .withEmail(VALID_EMAIL_BOB).withLocation(VALID_LOCATION_BOB).withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND)
            .build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalPersons() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical persons.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Person person : getTypicalPersons()) {
            ab.addPerson(person);
        }
        return ab;
    }

    public static List<Person> getTypicalPersons() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
