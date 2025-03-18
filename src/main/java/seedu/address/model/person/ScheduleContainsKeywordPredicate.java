package seedu.address.model.person;

import static seedu.address.model.person.OneTimeSchedule.formatDate;
import static seedu.address.model.person.RecurringSchedule.formatDay;

import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;
import seedu.address.commons.util.ToStringBuilder;

/**
 * Tests that a {@code Person}'s {@code Name} matches any of the keywords given.
 */
public class ScheduleContainsKeywordPredicate implements Predicate<Person> {
    private final String keyword;

    /**
     * Constructs a {@code ScheduleContainsKeywordPredicate} with the specified keyword.
     * If the keyword is an abbreviated form of a weekday (e.g., "mon", "tue"),
     * it is automatically expanded to the full day name (e.g., "monday", "tuesday").
     * Otherwise, the keyword remains unchanged.
     *
     * @param keyword The keyword to match against a person's schedules.
     */
    public ScheduleContainsKeywordPredicate(String keyword) {
        if (isDay(keyword)) {
            this.keyword = formatDay(keyword);
        } else {
            this.keyword = formatDate(keyword);
        }
    }
    private boolean isDay(String input) {
        String lowerDay = input.toLowerCase();
        return switch (lowerDay) {
        case "mon", "monday", "tue", "tuesday", "wed", "wednesday",
             "thu", "thursday", "fri", "friday", "sat", "saturday",
             "sun", "sunday" -> true;
        default -> false;
        };
    }

    public String getKeyword() {
        return keyword;
    }

    @Override
    public boolean test(Person person) {
        boolean oneTimeScheduleMatches = person.getOneTimeSchedules().stream()
                .anyMatch(schedule -> StringUtil.containsWordIgnoreCase(schedule.getDate(), keyword));
        boolean recurringScheduleMatches = person.getRecurringSchedules().stream()
                .anyMatch(schedule -> StringUtil.containsWordIgnoreCase(schedule.getDay(), keyword));
        return oneTimeScheduleMatches || recurringScheduleMatches;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof ScheduleContainsKeywordPredicate)) {
            return false;
        }

        ScheduleContainsKeywordPredicate otherScheduleContainsKeywordPredicate =
                (ScheduleContainsKeywordPredicate) other;
        return keyword.equals(otherScheduleContainsKeywordPredicate.keyword);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("keyword", keyword).toString();
    }
}
