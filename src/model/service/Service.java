package model.service;

import model.employee.Employee;
import model.reader.ReferenceBookReadable;
import model.reader.ReferenceBookReader;
import model.referense_book.ReferenseBook;
import model.writer.ReferenceBookWriteable;
import model.writer.ReferenceBookWriter;

public class Service {
    ReferenseBook<Employee> employeesList;
    private static final String filePath = "src/employees.txt";

    public Service() {
        try {
            ReferenseBook<Employee> employees = load();
            setEmployeesList(employees);
        } catch (Exception e) {
            employeesList = new ReferenseBook<>();
        }
    }

    private void save(ReferenseBook<Employee> employees){
        ReferenceBookWriteable writer = new ReferenceBookWriter();
        writer.write(employees, filePath);
    }

    private ReferenseBook<Employee> load(){
        ReferenceBookReadable reader = new ReferenceBookReader();
        try {
            return (ReferenseBook<Employee>) reader.read(filePath);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void setEmployeesList(ReferenseBook<Employee> employees) {
        employeesList = employees;
        save(employeesList);
    }

    public String addEmployee(Integer id, String phoneNumber, String name, Integer exp) {
        Employee employee = new Employee(id, phoneNumber, name, exp);
        try{
            employeesList.addEmployee(employee);
            save(employeesList);
            return "Сотрудник успешно добавлен";
        } catch(Exception e) {
            return "Ошибка добавления: " + e.getMessage();
        }
    }

    public String findEmployeesByExperience(Integer experiece) {

    }
}
