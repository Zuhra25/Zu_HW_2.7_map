package pro.sky.ZuHW27map;


import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.ZuHW27map.exceptions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employees = new ArrayList<>();
    private int size = 4;

    public EmployeeServiceImpl() {
        employees.add(new Employee("Иван1", "Иванов1", 1000, 1));
        employees.add(new Employee("Иван2", "Иванов2", 2000, 1));
        employees.add(new Employee("Иван3", "Иванов3", 10000, 2));
        employees.add(new Employee("Иван4", "Иванов4", 20000, 2));
    }

    public Employee addEmployee(String firstName, String lastName, double salary, int department) {
        checkFullname(firstName, lastName);

        Employee employee = new Employee(firstName, lastName, salary, department);
        if (firstName == "" || lastName == "") {
            throw new IllegalArgumentException();
        }
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("этот сотрудник уже существует");
        }
        if (employees.size() > size) {
            throw new EmployeeStorageIsFullException("лимит сотрудников превышен");
        }
        employees.add(employee);
        return employee;
    }

    public Employee removeEmployee(String firstName, String lastName, double salary, int department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        checkFullname(firstName, lastName);

        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException("этот сотрудник отсутствует");
    }

    public Employee findEmployee(String firstName, String lastName, double salary, int department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        checkFullname(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException("этот сотрудник отсутствует");
    }

    public Collection<Employee> printAll() {
        return new ArrayList<>(employees);
    }

    public void checkFullname(String firstName, String lastName) {
        if (!StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName)) {
            throw new BadRequestException();
        }
    }
}