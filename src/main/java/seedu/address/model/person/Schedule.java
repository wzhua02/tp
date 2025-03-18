package seedu.address.model.person;

/**
 * Represents a generic schedule with a start time and end time.
 * This is the base class for {@link OneTimeSchedule} and {@link RecurringSchedule}.
 */
public abstract class Schedule {
    public static final String MESSAGE_TIME_CONSTRAINTS = "End time (second time) must be later than start time"
            + " (first time).";
    protected final String startTime;
    protected final String endTime;

    /**
     * Constructs a {@code Schedule}.
     *
     * @param startTime The starting time of the schedule.
     * @param endTime   The ending time of the schedule.
     */
    public Schedule(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Returns the start time of the schedule.
     *
     * @return Start time as a String.
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * Returns the end time of the schedule.
     *
     * @return End time as a String.
     */
    public String getEndTime() {
        return endTime;
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
     * Returns the string representation of the schedule.
     */
    @Override
    public abstract String toString();
}
