/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sample.eventmanager;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;

/**
 * 
 * @author ryo_shindo
 */
@SessionScoped
public class UserSession implements Serializable {

    @Context
    HttpSession session;
    
    private String name;
    
    private String userId;
    
    private boolean isLogged;
    
    public void start() {
        this.isLogged = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    
}
