package pro.sky.skyproemployee.service;

import org.springframework.stereotype.Service;
import pro.sky.skyproemployee.Employee;
import pro.sky.skyproemployee.exception.EmployeeAlreadyAddedException;
import pro.sky.skyproemployee.exception.EmployeeNotFoundException;
import pro.sky.skyproemployee.exception.EmployeeStorageIsFullException;

import java.util.*;

@Service
public class EmployeeService {
    private static final int LIMIT = 10;
    private final Map<String, Employee> employees = new HashMap<>();

    private String getKey(String lastName, String firstName) {
        return lastName + " " + firstName;
    }

    public Employee addEmployee(String lastName,
                                String firstName,
                                int department,
                                float salary) {
        Employee employee = new Employee(lastName, firstName, department, salary);
        String key = getKey(lastName, firstName);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < LIMIT) {
            return employees.put(key, employee);
        }
        throw new EmployeeStorageIsFullException();
    }

    public Employee deleteEmployee(String lastName, String firstName) {
        String key = getKey(lastName, firstName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        Employee employee = employees.get(key);
        employees.remove(key);
        return  employee;
    }

    public Employee findEmployee(String lastName, String firstName) {
        String key = getKey(lastName, firstName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();

        }
        return employees.get(key);
    }
    public List<Employee> getEmployees() {

        return new ArrayList<>(employees.values());
    }

}
