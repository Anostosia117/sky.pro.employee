package pro.sky.skyproemployee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyproemployee.Employee;
import pro.sky.skyproemployee.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    private final DepartmentService departmentService;


@GetMapping("/min-salary")
    public Employee findMinSalary (@RequestParam("departmentId") int department) {
return departmentService.findMinSalary(department);
    }
    @GetMapping("/max-salary")
    public Employee findMaxSalary (@RequestParam("departmentId") int department) {
        return departmentService.findMaxSalary(department);

    }

    @GetMapping(value = "/all", params = "departmentId")
    public List<Employee> findEmployeesFromDepartment (@RequestParam("departmentId") int department) {
        return departmentService.findEmployeesFromDepartment(department);

    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> findEmployees() {
        return departmentService.findEmployees();

    }

}





















