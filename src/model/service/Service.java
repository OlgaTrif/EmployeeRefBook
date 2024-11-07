package model.service;

import model.employee.Employee;
import model.reader.ReferenceBookReadable;
import model.reader.ReferenceBookReader;
import model.referense_book.ReferenseBook;
import model.writer.ReferenceBookWriteable;
import model.writer.ReferenceBookWriter;

import java.util.ArrayList;
import java.util.List;

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

    public String getEmployeesListInfo() {
        StringBuilder members = new StringBuilder();
        for (Employee e : employeesList) {
            members.append(e.getMemberInfo());
            members.append("\n");
        }
        return members.toString();
    }

    public void addEmployee(Integer id, String phoneNumber, String name, Integer exp) {
        Employee employee = new Employee(id, phoneNumber, name, exp);
        employeesList.addEmployee(employee);
        save(employeesList);
    }

    public String findEmployeesByExperience(Integer experiece) {
        List<Employee> found = new ArrayList<>();
        found.addAll(employeesList.findEmployeesByExperience(experiece));
        if (found.isEmpty()) {
            return "Нет сотрудников с подходящим стажем";
        }
        StringBuilder sb = new StringBuilder();
        for(Employee e : found){
            sb.append(e.getName());
            sb.append("\n");
        }
        return sb.toString();
    }

    public String findEmployeeByEmployeeId(Integer targetId) {
        String result = "";
        try {
            result = employeesList.findEmployeeByEmployeeId(targetId).getMemberInfo();
        } catch (Exception E) {
            result = "Сотрудник не найден";
        }
        return result;
    }

    public String findEmployeePhoneNumByEmployeeName(String name) {
        return employeesList.findPhoneNumberByName(name);
    }
}
