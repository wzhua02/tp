package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.util.regex.Pattern;

/**
 * Represents a RecurringSchedule in the address book.
 * Guarantees: immutable; name is valid as declared in {@link #isValidRecurringSchedule(String)}
 */
public class RecurringSchedule extends Schedule {

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

    public final String day;

    /**
     * Constructs a {@code RecurringSchedule}.
     *
     * @param schedule A valid recurring schedule string.
     */
    public RecurringSchedule(String schedule) {
        super(validateThenExtractStartTime(schedule), extractEndTime(schedule));
        this.day = extractDay(schedule);
    }
    private static String validateThenExtractStartTime(String schedule) {
        requireNonNull(schedule);
        checkArgument(isValidRecurringSchedule(schedule), MESSAGE_CONSTRAINTS);
        return extractStartTime(schedule);
    }

    private static String extractDay(String schedule) {
        return formatDay(schedule.split(" ")[0]);
    }

    private static String extractStartTime(String schedule) {
        return schedule.split(" ")[1];
    }

    private static String extractEndTime(String schedule) {
        return schedule.split(" ")[2];
    }

    public String getDay() {
        return day;
    }

    /**
     * Returns true if a given string is a valid recurring schedule.
     */
    public static boolean isValidRecurringSchedule(String test) {
        return pattern.matcher(test).matches();
    }
    /**
     * Formats the given day to its full form with the first letter capitalized.
     *
     * @param day The day input string.
     * @return The formatted day string.
     */
    public static String formatDay(String day) {
        String lowerDay = day.toLowerCase();
        switch (lowerDay) {
        case "mon":
        case "monday":
            return "Monday";
        case "tue":
        case "tuesday":
            return "Tuesday";
        case "wed":
        case "wednesday":
            return "Wednesday";
        case "thu":
        case "thursday":
            return "Thursday";
        case "fri":
        case "friday":
            return "Friday";
        case "sat":
        case "saturday":
            return "Saturday";
        case "sun":
        case "sunday":
            return "Sunday";
        default:
            throw new IllegalArgumentException("Invalid day: " + day);
        }
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
        Boolean isDayEquals = day.equals(otherRecurringSchedule.day);
        Boolean isStartTimeEquals = startTime.equals(otherRecurringSchedule.startTime);
        Boolean isEndTimeEquals = endTime.equals(otherRecurringSchedule.endTime);
        return isDayEquals && isStartTimeEquals && isEndTimeEquals;
    }

    @Override
    public int hashCode() {
        String toHash = day + " " + startTime + " " + endTime;
        return toHash.hashCode();
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return '[' + day + " " + startTime + " " + endTime + ']';
    }

}
