package seedu.address.model.person;

/**
 * Represents a generic schedule with a start time and end time.
 * This is the base class for {@link OneTimeSchedule} and {@link RecurringSchedule}.
 */
public abstract class Schedule {
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
     * Returns the string representation of the schedule.
     */
    @Override
    public abstract String toString();
}
