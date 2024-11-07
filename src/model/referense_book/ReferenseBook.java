package model.referense_book;

import model.employee.iterator.EmployeeIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ReferenseBook<E extends ReferenseBookItem<E>> implements Serializable, Iterable<E>{
    private int employeeId;
    private List<E> emploeesList;

    public ReferenseBook(){
        this.employeeId = -1;
        this.setEmploeesList(new ArrayList<>());
    }

    public void setEmploeesList(List<E> membersList) {
        this.emploeesList = membersList;
    }

    public List<E> getEmploeesList() {
        return emploeesList;
    }

    @Override
    public Iterator<E> iterator() {
        return new EmployeeIterator<>(emploeesList);
    }

    public void addEmployee(E employee) {
        if (employee != null && !getEmploeesList().contains(employee)) {
            getEmploeesList().add(employee);
            //увеличиваем id и сохраняем
            setMemberId(getEmployeeId() + 1);
            //устанавливаем члену семьи его id
            employee.setId(getEmployeeId());
        }
    }

    private Integer getEmployeeId() {
        return employeeId;
    }

    private void setMemberId(int i) {
        employeeId = i;
    }

    private List<E> findEmployeesByExperience(Integer targetExperience) {
        return emploeesList.stream().filter(emp -> Objects.equals(emp.getExperience(), targetExperience)).toList();
    }

    private String findPhoneNumberByName(String targetName) {
        return emploeesList.stream().filter(emp -> emp.getName().equals(targetName)).toList().getFirst().getPhoneNumber();
    }

    private E findEmployeeByEmployeeId(Integer targetId) {
        return emploeesList.stream().filter(emp -> Objects.equals(emp.getEmployeeId(), targetId)).toList().getFirst();
    }

    public E getEmployeeById(Integer id){
        return emploeesList.stream().filter(m -> Objects.equals(m.getEmployeeId(), id)).toList().getFirst();
    }
}
