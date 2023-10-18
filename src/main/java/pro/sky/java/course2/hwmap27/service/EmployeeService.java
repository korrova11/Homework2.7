package pro.sky.java.course2.hwmap27.service;

import pro.sky.java.course2.hwmap27.Employee;

import java.util.Collection;
import java.util.Map;

public interface EmployeeService {
    Employee add(String firstName,String lastName);
    Employee remove(String firstName,String lastName);
    Employee find(String firstName, String lastName);

    Map<String, Employee> findAll() ;
}

