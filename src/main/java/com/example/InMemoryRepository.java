package com.example;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRepository implements EmployeeRepository{

    private List<Employee> employees = new ArrayList<>();

    public InMemoryRepository(){}

    public InMemoryRepository(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public List<Employee> findAll() {

        return employees;

    }

    @Override
    public Employee save(Employee e) {

        employees.add(e);

        return null;
    }
}
