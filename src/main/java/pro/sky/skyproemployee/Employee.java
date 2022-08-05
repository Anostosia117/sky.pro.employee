package pro.sky.skyproemployee;

import org.apache.commons.lang3.StringUtils;

import java.util.Locale;
import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.*;

public class Employee {


    private final String lastName;
    private final String firstName;
    private final int department;
    private final float salary;

    public Employee(String lastName,
                    String firstName,
                    int department,
                    float salary) {
        this.lastName = capitalize(lastName.toLowerCase());
        this.firstName = capitalize(firstName.toLowerCase());
        this.department = department;
        this.salary = salary;
    }
    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public int getDepartment() {
        return department;
    }

    public float getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee employee = (Employee) o;
        return department == employee.department && Float.compare(employee.salary, salary) == 0 && Objects.equals(lastName, employee.lastName) && Objects.equals(firstName, employee.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, department, salary);
    }

    @Override
    public String toString() {
        return String.format("Фамилия Имя: %s %s, Отдел: %d, Зарплата: %.2f", lastName, firstName, department, salary);
    }
}

