package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.Messages.MESSAGE_PERSONS_LISTED_OVERVIEW;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.BENSON;
import static seedu.address.testutil.TypicalPersons.CARL;
import static seedu.address.testutil.TypicalPersons.DANIEL;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.ScheduleContainsKeywordPredicate;

/**
 * Contains integration tests (interaction with the Model) for {@code ScheduleCommand}.
 */
public class ScheduleCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    private Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void equals() {
        ScheduleContainsKeywordPredicate firstPredicate =
                new ScheduleContainsKeywordPredicate("first");
        ScheduleContainsKeywordPredicate secondPredicate =
                new ScheduleContainsKeywordPredicate("second");

        ScheduleCommand findFirstCommand = new ScheduleCommand(firstPredicate);
        ScheduleCommand findSecondCommand = new ScheduleCommand(secondPredicate);

        // same object -> returns true
        assertTrue(findFirstCommand.equals(findFirstCommand));

        // same values -> returns true
        ScheduleCommand findFirstCommandCopy = new ScheduleCommand(firstPredicate);
        assertTrue(findFirstCommand.equals(findFirstCommandCopy));

        // different types -> returns false
        assertFalse(findFirstCommand.equals(1));

        // null -> returns false
        assertFalse(findFirstCommand.equals(null));

        // different person -> returns false
        assertFalse(findFirstCommand.equals(findSecondCommand));
    }

    @Test
    public void execute_dayKeyword_multiplePersonsFound() {
        String expectedMessage = String.format(MESSAGE_PERSONS_LISTED_OVERVIEW, 3);
        ScheduleContainsKeywordPredicate predicate = preparePredicate("Monday");
        ScheduleCommand command = new ScheduleCommand(predicate);
        expectedModel.updateFilteredPersonList(predicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Arrays.asList(ALICE, BENSON, CARL), model.getFilteredPersonList());
    }

    @Test
    public void execute_dayTruncatedKeyword_multiplePersonsFound() {
        String expectedMessage = String.format(MESSAGE_PERSONS_LISTED_OVERVIEW, 3);
        ScheduleContainsKeywordPredicate predicate = preparePredicate("mon");
        ScheduleCommand command = new ScheduleCommand(predicate);
        expectedModel.updateFilteredPersonList(predicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Arrays.asList(ALICE, BENSON, CARL), model.getFilteredPersonList());
    }

    @Test
    public void execute_dateKeyword_multiplePersonsFound() {
        String expectedMessage = String.format(MESSAGE_PERSONS_LISTED_OVERVIEW, 2);
        ScheduleContainsKeywordPredicate predicate = preparePredicate("2/2");
        ScheduleCommand command = new ScheduleCommand(predicate);
        expectedModel.updateFilteredPersonList(predicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Arrays.asList(BENSON, DANIEL), model.getFilteredPersonList());
    }

    @Test
    public void toStringMethod() {
        ScheduleContainsKeywordPredicate predicate = new ScheduleContainsKeywordPredicate("keyword");
        ScheduleCommand scheduleCommand = new ScheduleCommand(predicate);
        String expected = ScheduleCommand.class.getCanonicalName() + "{predicate=" + predicate + "}";
        assertEquals(expected, scheduleCommand.toString());
    }

    /**
     * Parses {@code userInput} into a {@code ScheduleContainsKeywordPredicate}.
     */
    private ScheduleContainsKeywordPredicate preparePredicate(String userInput) {
        return new ScheduleContainsKeywordPredicate(userInput);
    }
}
