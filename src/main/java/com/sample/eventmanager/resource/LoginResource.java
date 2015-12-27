/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.eventmanager.resource;

import com.sample.eventmanager.UserSession;
import com.sample.eventmanager.dto.LoginDto;
import com.sample.eventmanager.form.LoginForm;
import com.sample.eventmanager.service.LoginService;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.core.Context;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import org.glassfish.hk2.api.HK2Loader;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.api.ServiceLocatorFactory;
import org.glassfish.hk2.utilities.HK2LoaderImpl;

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
    
    @Inject
    UserSession session;
    
    @Inject
    ServiceLocator locator;
    
    
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
            return Response.ok(Response.Status.UNAUTHORIZED)
                    .entity(loginForm)
                    .build();
        }
        
        request.getSession().invalidate();
        
        String jSessionId = request.getSession().getId();
        
        session = getUserSessionBean();
        
        loginForm.setMessage(Arrays.asList("ok"));
        
        request.getSession().setAttribute("userId", loginForm.getUserId());
        LoginDto dto = loginService.getUserInfo(loginForm.getUserId());
//        session.setUserId(dto.getUserId());
//        session.setName(dto.getName());
        request.getSession().setAttribute("name", dto.getName());
        
        
        return Response.ok(loginForm, MediaType.APPLICATION_JSON)
                .cookie(new NewCookie("JSESSIONID",jSessionId))
                .build();
    }
    
    @GET
    @Path("session")
    @Produces(MediaType.APPLICATION_JSON)
    public UserSession getSession() {
        session.setUserId((String) request.getSession().getAttribute("userId"));
        session.setName((String) request.getSession().getAttribute("name"));
        return session;
    } 
    
    private UserSession getUserSessionBean() {
        return locator.getService(UserSession.class);
    }

}
