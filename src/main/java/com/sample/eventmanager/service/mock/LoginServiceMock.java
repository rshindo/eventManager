/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.eventmanager.service.mock;

import com.sample.eventmanager.dto.LoginDto;
import com.sample.eventmanager.service.LoginService;
import java.util.HashSet;
import java.util.Set;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Ryo Shindo
 */
@Dependent
public class LoginServiceMock implements LoginService {

   
    @Override
    public boolean authorize(final String userId, final String password) {
        boolean isUser001 = userId.equals("user001");
        return isUser001;
    }

    @Override
    public LoginDto getUserInfo(String userId) {
        LoginDto dto = new LoginDto();
        dto.setUserId(userId);
        dto.setName("Shindo");
        dto.setEmployeeNumber("128");
        Set<String> permissions = new HashSet<>();
        permissions.add("event_r");
        permissions.add("event_c");
        permissions.add("event_u");
        permissions.add("event_d");
        dto.setPermissions(permissions);
        return dto;
    }
    
}
