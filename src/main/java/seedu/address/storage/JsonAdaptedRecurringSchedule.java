package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.RecurringSchedule;

/**
 * Jackson-friendly version of {@link RecurringSchedule}.
 */
class JsonAdaptedRecurringSchedule {

    private final String recurringSchedule;

    /**
     * Constructs a {@code JsonAdaptedRecurringSchedule} with the given {@code recurringSchedule}.
     */
    @JsonCreator
    public JsonAdaptedRecurringSchedule(String recurringSchedule) {
        this.recurringSchedule = recurringSchedule;
    }

    /**
     * Converts a given {@code RecurringSchedule} into this class for Jackson use.
     */
    public JsonAdaptedRecurringSchedule(RecurringSchedule source) {
        recurringSchedule = source.schedule;
    }

    @JsonValue
    public String getRecurringSchedule() {
        return recurringSchedule;
    }

    /**
     * Converts this Jackson-friendly adapted tag object into the model's {@code Tag} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted tag.
     */
    public RecurringSchedule toModelType() throws IllegalValueException {
        if (!RecurringSchedule.isValidSchedule(recurringSchedule)) {
            throw new IllegalValueException(RecurringSchedule.MESSAGE_CONSTRAINTS);
        }
        return new RecurringSchedule(recurringSchedule);
    }
}
