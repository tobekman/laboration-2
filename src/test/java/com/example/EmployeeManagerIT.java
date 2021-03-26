package com.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class EmployeeManagerIT {

    @Test
    void payEmployees() {

        List<Employee> employees = new ArrayList<>(Arrays.asList(
                new Employee("1", 1000.0),
                new Employee("2", 1500.0),
                new Employee("3", 2000.0),
                new Employee("4", 2000.0)));
        InMemoryRepository imr = new InMemoryRepository(employees);
        EmployeeManager employeeManager = new EmployeeManager(imr, new TestBankService());

        int expectedPaid = 4;
        int actualPaid = employeeManager.payEmployees();

        assertThat(actualPaid).isEqualTo(expectedPaid);

    }


}
