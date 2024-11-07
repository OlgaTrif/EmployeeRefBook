package view.commands;

import view.ConsoleUI;

public class EndProgrammCommand extends Command{
    public EndProgrammCommand(ConsoleUI consoleUI) {
        super("Завершить", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().endProgram();
    }
}
