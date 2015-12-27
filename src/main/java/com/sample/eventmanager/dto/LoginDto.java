/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.eventmanager.dto;

import java.util.Set;

/**
 *
 * @author Shindo
 */
public class LoginDto {
    
    String userId;
    
    String name;
    
    String employeeNumber;
    
    Set<String> permissions;

    public LoginDto() {
    }

    public LoginDto(String userId, String name, String employeeNumber, Set<String> permissions) {
        this.userId = userId;
        this.name = name;
        this.employeeNumber = employeeNumber;
        this.permissions = permissions;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Set<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }
    
    
    
}
