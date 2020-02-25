package com.nsu.bd.aircraft.dao.utils;

import com.nsu.bd.aircraft.model.staff.Employee;

public class EmployeeFieldsExtractor {
    private static final int NULL_ID = 0;
    private static final String NULL_STRING_VALUE = "";

    public static int getId(Employee employee) {
        return employee == null ? NULL_ID : employee.getId();
    }

    public static String getName(Employee employee) {
        return employee == null ? NULL_STRING_VALUE : employee.getName();
    }

    public static String getSurname(Employee employee) {
        return employee == null ? NULL_STRING_VALUE : employee.getSurname();
    }
}
