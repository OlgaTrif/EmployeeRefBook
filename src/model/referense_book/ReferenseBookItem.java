package model.referense_book;

import java.io.Serializable;

public interface ReferenseBookItem<T> extends Serializable, Comparable<T>{
    Integer getEmployeeId();
    Integer getExperience();
    String getName();
    String getPhoneNumber();
    void setId(Integer id);
    Integer getId();
}
