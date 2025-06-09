package com.manoj.employeeservice.service;


import com.manoj.employeeservice.dto.APIResponseDto;
import com.manoj.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);
}
