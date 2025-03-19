package seedu.address.model.util;

import static java.util.Objects.requireNonNull;

/**
 * Represents the days of the week.
 */
public enum DayOfWeek {
    MONDAY("Mon"),
    TUESDAY("Tue"),
    WEDNESDAY("Wed"),
    THURSDAY("Thu"),
    FRIDAY("Fri"),
    SATURDAY("Sat"),
    SUNDAY("Sun");

    public static final String DAY_OF_WEEK_REGEX = generateDayOfWeekRegex();

    private final String abbreviation;
    /**
     * Constructs a {@code DayOfWeek} with the given abbreviation.
     *
     * @param abbreviation The short form of the day (e.g., "Mon" for Monday).
     */
    DayOfWeek(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    /**
     * Gets the abbreviated name of the day.
     *
     * @return The abbreviation of the day (e.g., "Mon", "Tue").
     */
    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * Converts a string to a {@code DayOfWeek} enum.
     * The input string is case-insensitive.
     *
     * @param day The name or abbreviation of the day (e.g., "Monday", "mon", "Mon").
     * @return The corresponding {@code DayOfWeek} enum.
     * @throws IllegalArgumentException if the input does not match any day.
     */
    public static DayOfWeek fromString(String day) {
        String normalizedDay = day.trim().toLowerCase();
        for (DayOfWeek dayOfWeek : values()) {
            if (dayOfWeek.name().equalsIgnoreCase(normalizedDay)
                    || dayOfWeek.getAbbreviation().equalsIgnoreCase(normalizedDay)) {
                return dayOfWeek;
            }
        }
        throw new IllegalArgumentException("Invalid day: " + day);
    }

    /**
     * Checks if the given string is a day of the week.
     * @param day The input string.
     * @return True if string is a day of the week, False otherwise.
     */
    public static boolean isDayOfWeek(String day) {
        requireNonNull(day);
        return day.matches("(?i)(" + DAY_OF_WEEK_REGEX + ")");
    }
    /**
     * Generates a regex pattern that matches all day names and abbreviations from the DayOfWeek enum.
     * Example output: "Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday|Mon|Tue|Wed|Thu|Fri|Sat|Sun"
     *
     * @return A regex pattern string matching all valid day names.
     */
    private static String generateDayOfWeekRegex() {
        StringBuilder regex = new StringBuilder();
        for (DayOfWeek day : DayOfWeek.values()) {
            if (regex.length() > 0) {
                regex.append("|");
            }
            regex.append(day.name()); // Full name (e.g., "Monday")
            regex.append("|").append(day.getAbbreviation()); // Short name (e.g., "Mon")
        }
        return regex.toString();
    }

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
