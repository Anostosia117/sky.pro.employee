package pro.sky.skyproemployee;

import org.springframework.stereotype.Service;
import pro.sky.skyproemployee.exception.EmployeeAlreadyAddedException;
import pro.sky.skyproemployee.exception.EmployeeNotFoundException;
import pro.sky.skyproemployee.exception.EmployeeStorageIsFullException;

import java.util.*;

@Service
public class EmployeeService {
    private static final int LIMIT = 10;
    private final Map<String, Employee> employees = new HashMap<>();

    private String getKey(Employee employee){
        return employee.getFirstName() + " " + employee.getLastName();
    }
    public Employee addEmployee(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        String key = getKey(employee);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < LIMIT) {
            return employees.put(key, employee);
        }
        throw new EmployeeStorageIsFullException();
    }
    public Employee deleteEmployee(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        String key = getKey(employee);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
                return employees.remove(key);
    }

    public Employee findEmployee(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        if (!employees.containsKey(getKey(employee))) {
            throw new EmployeeNotFoundException();

        }
        return employee;
    }

    public List<Employee> getEmployees() {

        return new ArrayList<>(employees.values());
    }
}
