/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sample.eventmanager.service.impl;

import com.sample.eventmanager.dto.LoginDto;
import com.sample.eventmanager.service.LoginService;
import javax.enterprise.context.Dependent;

/**
 * 
 * @author Ryo Shindo
 */
@Dependent
public class LoginServiceImpl implements LoginService{

    @Override
    public boolean authorize(String userId, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LoginDto getUserInfo(String userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
