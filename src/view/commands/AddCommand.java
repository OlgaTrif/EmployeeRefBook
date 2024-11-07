package view.commands;

import view.ConsoleUI;

public class AddCommand extends Command{
    public AddCommand(ConsoleUI consoleUI) {
        super("Добавить нового сотрудника", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().addEmployee();
    }
}
