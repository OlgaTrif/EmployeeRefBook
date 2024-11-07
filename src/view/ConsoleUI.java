package view;

import presenter.ReferenceBookPresenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleUI implements EmployeeView{
    private final Scanner scanner;
    private final ReferenceBookPresenter presenter;
    private boolean work;
    private final MainMenu mainMenu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new ReferenceBookPresenter(this);
        work = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void start() {
        while (work) {
            System.out.println("Добро пожаловать!\n");
            System.out.println(mainMenu.menu());
            String choiceStr = scanner.nextLine();
            if (choiceStr.isEmpty()) {
                System.out.println("Ошибка: Введена пустая команда");
                break;
            }
            if (choiceStr.length() > 1) {
                System.out.println("Ошибка: Введен недопустимый символ");
                break;
            }
            int choice = Integer.parseInt(choiceStr);
            if (mainMenu.size() < choice) {
                System.out.println("Ошибка: Проверьте номер команды");
                break;
            }
            mainMenu.execute(choice);
        }
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer + "\n");
    }

    public void addEmployee() {
        System.out.println("Введите имя нового сотрудника\n");
        String name = scanner.nextLine();
        System.out.println("Введите табельный номер\n");
        String targetId = scanner.nextLine();
        System.out.println("Введите номер телефона сотрудника\n");
        String phoneNumber = scanner.nextLine();
        System.out.println("Введите стаж сотрудника\n");
        String experience = scanner.nextLine();
        printAnswer(presenter.addEmployee(Integer.parseInt(targetId),
                phoneNumber,
                name,
                Integer.parseInt(experience)));
    }

    public void findEmployeesByExperience() {
        System.out.println("Введите стаж\n");
        String experience = scanner.nextLine();
        printAnswer(presenter.findEmployeesByExperience(experience));
    }

    public void findEmployeeByEmployeeId() {
    }

    public void findEmployeePhoneNumByEmployeeName() {
    }

    public void endProgram() {
        work = false;
        System.out.println("До новых встреч!");
    }
}
