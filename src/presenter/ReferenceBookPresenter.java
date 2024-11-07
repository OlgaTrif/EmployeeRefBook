package presenter;

import model.service.Service;
import view.EmployeeView;

public class ReferenceBookPresenter {
    private final EmployeeView view;
    private final Service service;

    public ReferenceBookPresenter(EmployeeView view) {
        this.view = view;
        service = new Service();
    }

    public String addEmployee(Integer id, String phoneNumber, String name, Integer exp) {
        return service.addEmployee(id, phoneNumber, name, exp);
    }

    public String findEmployeesByExperience(Integer experiece) {
        return service.findEmployeesByExperience(experiece);
    }
}
