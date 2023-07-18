package pro.sky.ZuHW27map;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping
    public Collection<Employee> printAll() {
        return employeeService.printAll();
    }
}