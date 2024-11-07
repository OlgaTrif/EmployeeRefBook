package view.commands;

import view.ConsoleUI;

public class FindByExpCommand extends Command{
    public FindByExpCommand(ConsoleUI consoleUI) {
        super("Найти сотрудников по стажу", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().findEmployeesByExperience();
    }
}
