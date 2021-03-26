package com.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class EmployeeManagerTest {

    @Test
    void allEmployeesPaid() {

        EmployeeManager employeeManager = new EmployeeManager(new TestEmployeeRepository(), new TestBankService());

        int expectedPaid = 3;
        int actualPaid = employeeManager.payEmployees();

        assertThat(actualPaid).isEqualTo(expectedPaid);
    }

    @Test
    void bankServiceThrowsException() {

        BankService bankService = mock(BankService.class);
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
        EmployeeManager employeeManager = new EmployeeManager(employeeRepository, bankService);

        doThrow(RuntimeException.class).when(bankService).pay(anyString(), anyDouble());
        int actualResult = employeeManager.payEmployees();

        assertThat(actualResult).isZero();
    }

}