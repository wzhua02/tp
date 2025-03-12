package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Represents a RecurringSchedule in the address book.
 * Guarantees: immutable; name is valid as declared in {@link #isValidSchedule(String)}
 */
public class RecurringSchedule {

    public static final String MESSAGE_CONSTRAINTS = "Recurring schedules should be in the following format:"
            + " [day HHmm HHmm].";
    /*
     * A valid schedule format:
     * - Must start with a valid day of the week (full or abbreviated).
     * - Followed by two sets of four-digit times (HHmm format, 00:00 to 23:59).
     */
    public static final String VALIDATION_REGEX =
            "^(?i)(Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday|"
                    + "Mon|Tue|Wed|Thu|Fri|Sat|Sun)\\s"
                    + "(?:[01]\\d|2[0-3])[0-5]\\d\\s" // First HHmm (0000 - 2359)
                    + "(?:[01]\\d|2[0-3])[0-5]\\d$"; // Second HHmm (0000 - 2359)

    private static final Pattern pattern = Pattern.compile(VALIDATION_REGEX, Pattern.CASE_INSENSITIVE);

    public final String schedule;

    /**
     * Constructs a {@code RecurringSchedule}.
     *
     * @param schedule A valid recurring schedule.
     */
    public RecurringSchedule(String schedule) {
        requireNonNull(schedule);
        checkArgument(isValidSchedule(schedule), MESSAGE_CONSTRAINTS);
        this.schedule = schedule;
    }

    /**
     * Returns true if a given string is a valid recurring schedule.
     */
    public static boolean isValidSchedule(String test) {
        return pattern.matcher(test).matches();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof RecurringSchedule)) {
            return false;
        }

        RecurringSchedule otherRecurringSchedule = (RecurringSchedule) other;
        return Objects.equals(schedule, otherRecurringSchedule.schedule);
    }

    @Override
    public int hashCode() {
        return schedule.hashCode();
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return '[' + schedule + ']';
    }

}
