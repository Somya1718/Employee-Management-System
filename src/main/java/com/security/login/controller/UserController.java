package com.security.login.controller;

import com.security.login.dto.EmployeeDto;
import com.security.login.entity.Employee;
import com.security.login.entity.Users;
import com.security.login.service.EmployeeService;
import com.security.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Employee employee) {
        try {
            // Create and save user for authentication
            Users user = new Users();
            user.setUsername(employee.getEmail());
            user.setPassword(employee.getPassword());
            Users registeredUser = userService.register(user);

            // Create and save employee details
            EmployeeDto employeeDto = convertToDto(employee);
            EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);

            return ResponseEntity.ok(savedEmployee);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

//@PostMapping("/login")
//public ResponseEntity<?> login(@RequestBody Users user) {
//    try {
//        String token = userService.verify(user);
//        return ResponseEntity.ok(token);
//    } catch (RuntimeException e) {
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//                .body(e.getMessage());
//    } catch (Exception e) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body("An unexpected error occurred");
//    }
//}
@PostMapping("/login")
public ResponseEntity<?> login(@RequestBody Users user) {
    try {
        String token = userService.verify(user);
        // Get employee details based on email/username
        Employee employee = employeeService.findByEmail(user.getUsername());

        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("designation", employee.getDesignation());  // Use designation instead of role

        return ResponseEntity.ok(response);
    } catch (RuntimeException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(e.getMessage());
    }
}

    // Helper method to convert Employee to EmployeeDto
    private EmployeeDto convertToDto(Employee employee) {
        EmployeeDto dto = new EmployeeDto();
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setEmail(employee.getEmail());
        dto.setPassword(employee.getPassword());
        dto.setYrsOfExp(employee.getYrsOfExp());
        dto.setDesignation(employee.getDesignation());
        dto.setPhoneNumber(employee.getPhoneNumber());
        return dto;
    }
}