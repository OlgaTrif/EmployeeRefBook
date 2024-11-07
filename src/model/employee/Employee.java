package model.employee;

import model.referense_book.ReferenseBookItem;

import java.io.Serializable;

public class Employee implements Serializable, ReferenseBookItem<Employee> {
    private Integer employeelId;
    private String phoneNumber;
    private String name;
    private Integer experience;

    public Employee(int employeeId, String phoneNumber, String name, int experience) {
        this.employeelId = employeeId;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.experience = experience;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    @Override
    public Integer getEmployeeId() {
        return employeelId;
    }

    public Integer getExperience() {
        return experience;
    }

    @Override
    public void setId(Integer employeeId) {
        this.employeelId = employeeId;
    }

    @Override
    public int compareTo(Employee o) {
        return 0;
    }
}