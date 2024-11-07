package view.commands;

import view.ConsoleUI;

public class FindPhoneNumByNameCommand extends Command{
    public FindPhoneNumByNameCommand(ConsoleUI consoleUI) {
        super("Найти телефон сотрудника по имени", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().findEmployeePhoneNumByEmployeeName();
    }
}
