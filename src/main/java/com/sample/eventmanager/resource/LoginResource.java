/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.eventmanager.resource;

import com.sample.eventmanager.dto.LoginDto;
import com.sample.eventmanager.form.LoginForm;
import com.sample.eventmanager.service.LoginService;
import java.util.Arrays;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.BeanParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author ryo_shindo
 */
@Path("login")
@RequestScoped
public class LoginResource {
    
    @Inject
    LoginService loginService;
    
    @Context
    HttpServletRequest request;
    
    /**
     * 認証を行います。
     * @param loginForm
     * @return loginForm
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@BeanParam LoginForm loginForm) {
        
        if(!loginService.authorize(loginForm.getUserId(), loginForm.getPassword())) {
            loginForm.setMessage(Arrays.asList("ng"));
            return Response.ok(loginForm)
                    .status(Response.Status.UNAUTHORIZED)
                    .build();
        }
        
        request.getSession().invalidate();
        
        String jSessionId = request.getSession().getId();
        
        loginForm.setMessage(Arrays.asList("ok"));
        
        request.getSession().setAttribute("userId", loginForm.getUserId());
        LoginDto dto = loginService.getUserInfo(loginForm.getUserId());
        request.getSession().setAttribute("name", dto.getName());
        request.getSession().setAttribute("permissions", dto.getPermissions());
        
        return Response.ok(loginForm, MediaType.APPLICATION_JSON)
                .cookie(new NewCookie("JSESSIONID",jSessionId))
                .build();
    }
    

}
