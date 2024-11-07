package presenter;

import model.service.Service;
import view.ReferenceBookView;

public class ReferenceBookPresenter {
    private final ReferenceBookView view;
    private final Service service;

    public ReferenceBookPresenter(ReferenceBookView view) {
        this.view = view;
        service = new Service();
    }

    public String addEmployee(Integer id, String phoneNumber, String name, Integer exp) {
        try{
            service.addEmployee(id, phoneNumber, name, exp);
            getEmployeeListInfo();
            return "Сотрудник успешно добавлен\n";
        } catch(Exception e) {
            return "Ошибка добавления: " + e.getMessage();
        }
    }

    public String findEmployeesByExperience(Integer experiece) {
        return service.findEmployeesByExperience(experiece);
    }

    public String findEmployeeByEmployeeId(Integer targetId) {
        return service.findEmployeeByEmployeeId(targetId);
    }

    public String findEmployeePhoneNumByEmployeeName(String name) {
        return service.findEmployeePhoneNumByEmployeeName(name);
    }

    public void getEmployeeListInfo() {
        view.printAnswer(service.getEmployeesListInfo());
    }
}
