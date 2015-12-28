/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sample.eventmanager.service.factory;

import com.sample.eventmanager.service.impl.LoginServiceImpl;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 * 
 * @author Ryo Shindo
 */
@RequestScoped
public class LoginServiceFactory {
    
    @Inject
    LoginServiceImpl loginServiceImpl;
    
    

}
