package pro.sky.ZuHW27map;


import org.springframework.stereotype.Service;
import pro.sky.ZuHW27map.exceptions.BadParamsException;
import pro.sky.ZuHW27map.exceptions.EmployeeAlreadyAddedException;
import pro.sky.ZuHW27map.exceptions.EmployeeNotFoundException;
import pro.sky.ZuHW27map.exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees;
    private int size = 2;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>(size) {
        };
    }

    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (firstName =="" || lastName == "") {
            throw new BadParamsException();

        }
        //if (employees.contains(employee)) {
            if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("этот сотрудник уже существует");
        }
        if (employees.size() > size) {
            throw new EmployeeStorageIsFullException("лимит сотрудников превышен");
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (employees.containsKey(employee.getFullName())) {
            employees.remove(employee.getFullName());
            return employee;
        }
        throw new EmployeeNotFoundException("этот сотрудник отсутствует");
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employee;
        }
        throw new EmployeeNotFoundException("этот сотрудник отсутствует");
    }

    public Collection<Employee> printAll() {
        return new ArrayList<>(employees.values());
    }
}
