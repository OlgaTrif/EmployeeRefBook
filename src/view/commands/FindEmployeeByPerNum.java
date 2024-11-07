package view.commands;

import view.ConsoleUI;

public class FindEmployeeByPerNum extends Command{
    public FindEmployeeByPerNum(ConsoleUI consoleUI) {
        super("Найти сотрудника по табельному номеру", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().findEmployeeByEmployeeId();
    }
}
