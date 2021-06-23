package com.github.inchh.study.service;

import com.github.inchh.study.base.Employee;
import org.junit.jupiter.api.Test;

class NameListServiceTest {


    @Test
    void getAllEmployeesTest() {
        NameListService nl = new NameListService();
        Employee[] allEmployees = nl.getAllEmployees();
        for (var elem :
                allEmployees) {
            System.out.println(elem);
        }
    }

    @Test
    void getEmployeeTest() {
        NameListService nl = new NameListService();
        try {
            Employee employee = nl.getEmployee(2);
            System.out.println(employee);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }
}