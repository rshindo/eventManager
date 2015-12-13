/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.eventmanager.resource;

import com.sample.eventmanager.form.LoginForm;
import java.awt.image.RescaleOp;
import java.util.Arrays;
import javax.enterprise.context.RequestScoped;
import javax.json.Json;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.ws.rs.BeanParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.server.JSONP;

/**
 * REST Web Service
 *
 * @author ryo_shindo
 */
@Path("login")
@RequestScoped
public class LoginResource {

    /**
     * 認証を行います。
     * @param loginForm
     * @param request
     * @return loginForm
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@BeanParam LoginForm loginForm,
            @Context HttpServletRequest request) {
        
        request.getSession().invalidate();
        
        String jSessionId = request.getSession().getId();
        
        loginForm.setMessage(Arrays.asList("ok"));
        
        return Response.ok(loginForm, MediaType.APPLICATION_JSON)
                .cookie(new NewCookie("JSESSIONID",jSessionId))
                .build();
    }

}
