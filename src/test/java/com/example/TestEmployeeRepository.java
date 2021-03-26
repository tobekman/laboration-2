package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestEmployeeRepository implements EmployeeRepository{

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(Arrays.asList(
                new Employee("1", 1000.0),
                new Employee("2", 1500.0),
                new Employee("3", 2000.0)
        ));
    }

    @Override
    public Employee save(Employee e) {
        return null;
    }
}
