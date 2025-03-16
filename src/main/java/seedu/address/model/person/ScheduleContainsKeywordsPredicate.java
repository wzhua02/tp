package seedu.address.model.person;

import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;
import seedu.address.commons.util.ToStringBuilder;

/**
 * Tests that a {@code Person}'s {@code Name} matches any of the keywords given.
 */
public class ScheduleContainsKeywordsPredicate implements Predicate<Person> {
    private final String keyword;

    public ScheduleContainsKeywordsPredicate(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public boolean test(Person person) {
        boolean oneTimeScheduleMatches = person.getOneTimeSchedules().stream()
                .anyMatch(schedule -> StringUtil.containsWordIgnoreCase(schedule.date, keyword));
        boolean recurringScheduleMatches = person.getRecurringSchedules().stream()
                .anyMatch(schedule -> StringUtil.containsWordIgnoreCase(schedule.day, keyword));
        return oneTimeScheduleMatches || recurringScheduleMatches;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof ScheduleContainsKeywordsPredicate)) {
            return false;
        }

        ScheduleContainsKeywordsPredicate otherScheduleContainsKeywordsPredicate =
                (ScheduleContainsKeywordsPredicate) other;
        return keyword.equals(otherScheduleContainsKeywordsPredicate.keyword);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("keyword", keyword).toString();
    }
}
