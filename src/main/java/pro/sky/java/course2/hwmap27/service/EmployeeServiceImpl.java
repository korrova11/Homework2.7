package pro.sky.java.course2.hwmap27.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.hwmap27.Employee;
import pro.sky.java.course2.hwmap27.exception.EmployeeAlreadyAddedException;
import pro.sky.java.course2.hwmap27.exception.EmployeeNotFoundException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String,Employee> employeeMap;

    public EmployeeServiceImpl(Map<String, Employee> employeeMap) {
        this.employeeMap = employeeMap;
    }


    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        String s= firstName+lastName;
        if(employeeMap.containsKey(s)){
            throw new EmployeeAlreadyAddedException();
        }
        employeeMap.put(s,employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeMap.containsValue(employee)) {
            String s= firstName+lastName;
            employeeMap.remove(s);
            return employee;
        }
        throw new EmployeeNotFoundException();

    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        String s= firstName+lastName;
        if (employeeMap.containsKey(s)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Map<String, Employee> findAll() {

        return employeeMap;
    }

}
