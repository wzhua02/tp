package seedu.address.logic.commands;

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
}
