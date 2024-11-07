package model.referense_book;

import java.io.Serializable;

public interface ReferenseBookItem<T> extends Serializable, Comparable<T>{
    Integer getEmployeeId();
    Integer getExperience();
    void setId(Integer employeeId);
    String getName();
    String getPhoneNumber();
}
