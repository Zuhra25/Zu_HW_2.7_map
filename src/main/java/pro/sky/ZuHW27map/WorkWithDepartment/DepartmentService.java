package pro.sky.ZuHW27map.WorkWithDepartment;

import pro.sky.ZuHW27map.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    public Employee maxSalary(int dep);
    public Employee minSalary(int dep);
    public List<Employee> allEmployeeInDep(int dep);
    public Map<Integer, List<Employee>> allEmployee ();
}
