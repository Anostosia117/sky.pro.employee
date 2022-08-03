package pro.sky.skyproemployee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyproemployee.Employee;
import pro.sky.skyproemployee.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam("lastName") String lastName,
                        @RequestParam("firstName") String firstName,
                        @RequestParam("departmentID") int department,
                        @RequestParam("salary") float salary) {
        return employeeService.addEmployee(lastName, firstName, department, salary);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam("lastName") String lastName,
                           @RequestParam("firstName") String firstName) {
        return employeeService.deleteEmployee(lastName, firstName);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam("lastName") String lastName,
                         @RequestParam("firstName") String firstName) {
        return employeeService.findEmployee(lastName, firstName);
    }
    @GetMapping("/")
    public List<Employee> getAll() {

        return employeeService.getEmployees();
    }
}
