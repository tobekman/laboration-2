package com.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InMemoryRepositoryTest {

    @Test
    void employeesReturned() {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("1", 1000));
        employees.add(new Employee("2", 2000));
        employees.add(new Employee("3", 4000));
        InMemoryRepository imr = new InMemoryRepository(employees);

        List<Employee> actualList = imr.findAll();

        assertThat(actualList).hasSameElementsAs(employees);
    }

    @Test
    void emptyListReturned() {

        InMemoryRepository imr = new InMemoryRepository();

        List<Employee> actualList = imr.findAll();

        assertThat(actualList).isEmpty();

    }

    @Test
    void employeeIsSaved() {

        Employee e = new Employee("1", 100);
        InMemoryRepository imr = new InMemoryRepository();

        imr.save(e);
        List<Employee> employees = imr.findAll();

        assertThat(employees).contains(e);

    }

}
