package com.security.login.dto;

public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password; // Add this field
    private int yrsOfExp;
    private String designation;
    private String phoneNumber;

    // Default constructor
    public EmployeeDto() {
    }

    // Constructor with fields
    public EmployeeDto(Long id, String firstName, String lastName, String email, String password, int yrsOfExp, String designation, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password; // Add this line
        this.yrsOfExp = yrsOfExp;
        this.designation = designation;
        this.phoneNumber = phoneNumber;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getYrsOfExp() {
        return yrsOfExp;
    }

    public void setYrsOfExp(int yrsOfExp) {
        this.yrsOfExp = yrsOfExp;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}