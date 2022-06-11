package pro.sky.skyproemployee;

import org.springframework.stereotype.Service;
import pro.sky.skyproemployee.exception.EmployeeAlreadyAddedException;
import pro.sky.skyproemployee.exception.EmployeeNotFoundException;
import pro.sky.skyproemployee.exception.EmployeeStorageIsFullException;

import java.util.*;

@Service
public class EmployeeService {
    private static final int LIMIT = 10;
    private final List<Employee> employees = new ArrayList<>();

//     {
//    employees.set(0, new Employee("Иванова", "Ирина"));
//    employees.set(1, new Employee("Харитонов", "Петр"));
//    employees.set(2, new Employee("Шевцова", "Анна"));
//    employees.set(3, new Employee("Дудник", "Даниил"));
//    employees.set(4, new Employee("Стадник", "Анна"));
//    employees.set(5, new Employee("Щербаченко", "Наталья"));
//    employees.set(6, new Employee("Ткачук", "Павел"));
//    employees.set(7, new Employee("Шамшура", "Анна"));
//    employees.set(8, new Employee("Холодова", "Анастасия"));
//    employees.set(9, new Employee("Толстой", "Лев"));
//     }

    public Employee addEmployee(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < LIMIT) {
            employees.add(employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }


    public Employee deleteEmployee(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
        return employee;
    }
    public Employee findEmployee(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();

        }
        return employee;
    }


    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }
}
