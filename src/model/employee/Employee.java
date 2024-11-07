package model.employee;

import model.referense_book.ReferenseBookItem;

import java.io.Serializable;

public class Employee implements Serializable, ReferenseBookItem<Employee> {
    private Integer employeelId;
    private String phoneNumber;
    private String name;
    private Integer experience;

    public Employee(Integer employeeId, String phoneNumber, String name, Integer experience) {
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

    public String getMemberInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("табельный номер: ");
        sb.append(getEmployeeId());
        sb.append("; имя: ");
        sb.append(getName());
        sb.append("; номер телефона: ");
        sb.append(getPhoneNumber());
        sb.append("; стаж: ");
        sb.append(getExperience());
        return sb.toString();
    }
}
