package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.person.Email;
import seedu.address.model.person.Goals;
import seedu.address.model.person.Location;
import seedu.address.model.person.MedicalHistory;
import seedu.address.model.person.Name;
import seedu.address.model.person.OneTimeSchedule;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.RecurringSchedule;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Person objects.
 */
public class PersonBuilder {

    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_PHONE = "88888888";
    public static final String DEFAULT_EMAIL = "amy@gmail.com";
    public static final String DEFAULT_GOALS = "Bee the best Amy strongwoman";
    public static final String DEFAULT_LOCATION = "123, Jurong West Ave 6, #08-111";
    public static final String DEFAULT_MEDICAL_HISTORY = "Twisted right ankle";

    private Name name;
    private Phone phone;
    private Set<RecurringSchedule> recurringSchedules;
    private Email email;
    private Goals goals;
    private MedicalHistory medicalHistory;
    private Location location;
    private Set<OneTimeSchedule> oneTimeSchedules;
    private Set<Tag> tags;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public PersonBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        recurringSchedules = new HashSet<>();
        email = new Email(DEFAULT_EMAIL);
        goals = new Goals(DEFAULT_GOALS);
        medicalHistory = new MedicalHistory(DEFAULT_MEDICAL_HISTORY);
        location = new Location(DEFAULT_LOCATION);
        oneTimeSchedules = new HashSet<>();
        tags = new HashSet<>();
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public PersonBuilder(Person personToCopy) {
        name = personToCopy.getName();
        phone = personToCopy.getPhone();
        recurringSchedules = new HashSet<>(personToCopy.getRecurringSchedules());
        email = personToCopy.getEmail();
        goals = personToCopy.getGoals();
        medicalHistory = personToCopy.getMedicalHistory();
        location = personToCopy.getLocation();
        oneTimeSchedules = new HashSet<>(personToCopy.getOneTimeSchedules());
        tags = new HashSet<>(personToCopy.getTags());
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public PersonBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Person} that we are building.
     */
    public PersonBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Parses the {@code goals} of the {@code Person} that we are building.
     */
    public PersonBuilder withGoals(String goals) {
        this.goals = new Goals(goals);
        return this;
    }

    /**
     * Sets the {@code MedicalHistory} of the {@code Person} that we are building.
     */
    public PersonBuilder withMedicalHistory(String medicalHistory) {
        this.medicalHistory = new MedicalHistory(medicalHistory);
        return this;
    }

    /**
     * Sets the {@code Location} of the {@code Person} that we are building.
     */
    public PersonBuilder withLocation(String address) {
        this.location = new Location(address);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Person} that we are building.
     */
    public PersonBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Parses the {@code recurringSchedules} into a {@code Set<RecurringSchedule>} and set it to the {@code Person}
     * that we are building.
     */
    public PersonBuilder withRecurringSchedules(String ... recurringSchedules) {
        this.recurringSchedules = SampleDataUtil.getRecurringScheduleSet(recurringSchedules);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Person} that we are building.
     */
    public PersonBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Parses the {@code oneTimeSchedules} into a {@code Set<OneTimeSchedule>} and set it to the
     * {@code Person} that we are building.
     */
    public PersonBuilder withOneTimeSchedules(String ... oneTimeSchedules) {
        this.oneTimeSchedules = SampleDataUtil.getOneTimeScheduleSet(oneTimeSchedules);
        return this;
    }

    /**
     * Builds a person object.
     */
    public Person build() {
        return new Person(name, phone, recurringSchedules, email, goals, medicalHistory, location, oneTimeSchedules,
                tags);
    }

}
