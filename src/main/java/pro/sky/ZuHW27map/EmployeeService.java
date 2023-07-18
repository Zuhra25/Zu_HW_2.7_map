package pro.sky.ZuHW27map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

public interface EmployeeService {
    public Employee addEmployee(String firstName, String lastName);
    public Employee removeEmployee(String firstName, String lastName);
    public Employee findEmployee(String firstName, String lastName);
    public Collection<Employee> printAll();

}
