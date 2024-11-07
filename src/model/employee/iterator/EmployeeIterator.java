package model.employee.iterator;

import java.util.Iterator;
import java.util.List;

public class EmployeeIterator<T> implements Iterator<T> {
    private int emplId;
    private List<T> emloyeesList;

    public EmployeeIterator(List<T> membersList) {
        this.emloyeesList = membersList;
    }

        @Override
        public boolean hasNext() {
        return getEmloyeesList().size() > emplId;
    }

        @Override
        public T next() {
        return getEmloyeesList().get(emplId++);
    }

        private List<T> getEmloyeesList() {
        return emloyeesList;
    }
}
