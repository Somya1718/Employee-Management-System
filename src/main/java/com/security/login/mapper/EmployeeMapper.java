package com.security.login.mapper;


import com.security.login.dto.EmployeeDto;
import com.security.login.entity.Employee;


public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPassword(), // Add this line
                employee.getYrsOfExp(),
                employee.getDesignation(),
                employee.getPhoneNumber()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getPassword(), // Add this line
                employeeDto.getYrsOfExp(),
                employeeDto.getDesignation(),
                employeeDto.getPhoneNumber()
        );
    }
}
