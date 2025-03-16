package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.util.regex.Pattern;

/**
 * Represents a RecurringSchedule in the address book.
 * Guarantees: immutable; name is valid as declared in {@link #isValidSchedule(String)}
 */
public class RecurringSchedule {

    public static final String MESSAGE_CONSTRAINTS = "Recurring schedules should be in the following format:"
            + " [day HHmm HHmm].";
    public static final String MESSAGE_TIME_CONSTRAINTS = "End time (second time) must be later than start time"
            + " (first time).";
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
    public final String startTime;
    public final String endTime;

    /**
     * Constructs a {@code RecurringSchedule}.
     *
     * @param schedule A valid recurring schedule.
     */
    public RecurringSchedule(String schedule) {
        requireNonNull(schedule);
        checkArgument(isValidSchedule(schedule), MESSAGE_CONSTRAINTS);

        String[] parts = schedule.split("\\s+");
        String day = parts[0];
        String startTime = parts[1];
        String endTime = parts[2];

        String formattedDay = formatDay(day);
        this.day = formattedDay;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Returns true if a given string is a valid recurring schedule.
     */
    public static boolean isValidSchedule(String test) {
        return pattern.matcher(test).matches();
    }

    /**
     * Returns true if the end time is later than the start time in the given schedule.
     *
     * @param test A valid recurring schedule.
     * @return true if the end time is later than the start time, false otherwise.
     */
    public static boolean isValidTime(String test) {
        String[] parts = test.split("\\s+");
        String startTime = parts[1];
        String endTime = parts[2];

        int startHour = Integer.parseInt(startTime.substring(0, 2));
        int startMinute = Integer.parseInt(startTime.substring(2));
        int startTotal = startHour * 60 + startMinute;
        int endHour = Integer.parseInt(endTime.substring(0, 2));
        int endMinute = Integer.parseInt(endTime.substring(2));
        int endTotal = endHour * 60 + endMinute;

        return endTotal > startTotal;
    }

    /**
     * Formats the given day to its full form with the first letter capitalized.
     *
     * @param day The day input string.
     * @return The formatted day string.
     */
    private static String formatDay(String day) {
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
