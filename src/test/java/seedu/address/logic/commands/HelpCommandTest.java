package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.HelpCommand.GENERIC_HELP_MESSAGE;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;

public class HelpCommandTest {
    private Model model = new ModelManager();
    private Model expectedModel = new ModelManager();

    @Test
    public void execute_help_success() {
        CommandResult expectedCommandResult = new CommandResult(GENERIC_HELP_MESSAGE);
        assertCommandSuccess(new HelpCommand(""), model, expectedCommandResult, expectedModel);
    }

    @Test
    public void execute_helpAdd_success() {
        CommandResult expectedCommandResult = new CommandResult(AddCommand.MESSAGE_USAGE);
        assertCommandSuccess(
                new HelpCommand("add"), model, expectedCommandResult, expectedModel);
    }

    @Test
    public void execute_helpClear_success() {
        CommandResult expectedCommandResult = new CommandResult(ClearCommand.MESSAGE_USAGE);
        assertCommandSuccess(
                new HelpCommand("clear"), model, expectedCommandResult, expectedModel);
    }

    @Test
    public void execute_helpDelete_success() {
        CommandResult expectedCommandResult = new CommandResult(DeleteCommand.MESSAGE_USAGE);
        assertCommandSuccess(
                new HelpCommand("delete"), model, expectedCommandResult, expectedModel);
    }

    @Test
    public void execute_helpEdit_success() {
        CommandResult expectedCommandResult = new CommandResult(EditCommand.MESSAGE_USAGE);
        assertCommandSuccess(
                new HelpCommand("edit"), model, expectedCommandResult, expectedModel);
    }

    @Test
    public void execute_helpExit_success() {
        CommandResult expectedCommandResult = new CommandResult(ExitCommand.MESSAGE_USAGE);
        assertCommandSuccess(
                new HelpCommand("exit"), model, expectedCommandResult, expectedModel);
    }

    @Test
    public void execute_helpFind_success() {
        CommandResult expectedCommandResult = new CommandResult(FindCommand.MESSAGE_USAGE);
        assertCommandSuccess(
                new HelpCommand("find"), model, expectedCommandResult, expectedModel);
    }

    @Test
    public void execute_helpList_success() {
        CommandResult expectedCommandResult = new CommandResult(ListCommand.MESSAGE_USAGE);
        assertCommandSuccess(
                new HelpCommand("list"), model, expectedCommandResult, expectedModel);
    }

    @Test
    public void execute_helpUnrecognisedString_success() {
        CommandResult expectedCommandResult = new CommandResult(GENERIC_HELP_MESSAGE);
        assertCommandSuccess(
                new HelpCommand("aasdgae"), model, expectedCommandResult, expectedModel);
    }

    @Test
    public void equals() {
        HelpCommand helpAddCommand = new HelpCommand("add");
        HelpCommand helpEditCommand = new HelpCommand("edit");

        // same object -> returns true
        assertTrue(helpAddCommand.equals(helpAddCommand));

        // same values -> returns true
        HelpCommand helpAddCommandCopy = new HelpCommand("add");
        assertTrue(helpAddCommand.equals(helpAddCommandCopy));

        // different types -> returns false
        assertFalse(helpAddCommand.equals(1));

        // null -> returns false
        assertFalse(helpAddCommand.equals(null));

        // different commandRequested -> returns false
        assertFalse(helpAddCommand.equals(helpEditCommand));
    }

    @Test
    public void toStringMethod() {
        String command = "delete";
        HelpCommand helpCommand = new HelpCommand(command);
        String expected = HelpCommand.class.getCanonicalName() + "{commandRequested=" + command + "}";
        assertEquals(expected, helpCommand.toString());
    }
}
