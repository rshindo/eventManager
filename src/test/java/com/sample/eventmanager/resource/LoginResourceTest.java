/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.eventmanager.resource;

import com.sample.eventmanager.JerseyTestRule;
import com.sample.eventmanager.TestResourceConfig;
import java.io.IOException;
import java.net.URI;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.grizzly2.servlet.GrizzlyWebContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.DeploymentContext;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.grizzly.GrizzlyWebTestContainerFactory;
import org.glassfish.jersey.test.spi.TestContainer;
import org.glassfish.jersey.test.spi.TestContainerException;
import org.glassfish.jersey.test.spi.TestContainerFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;

/**
 *
 * @author Shindo
 */
public class LoginResourceTest {
    
    @Rule
    public JerseyTestRule rule = new JerseyTestRule(new TestResourceConfig());
    
    @Test
    public void testLogin() {
        System.out.println("login");
        String expected = "ok";
//        LoginForm loginForm = new LoginForm(null, "userId", "password");
//        MultivaluedHashMap param = new MultivaluedHashMap();
//        param.add("userId", "userId");
//        param.add("password", "password");
        Form form = new Form();
        form.param("userId", "userId");
        form.param("password", "password");
        String actual = rule.getJerseyTest()
                .target("login")
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .post(Entity.form(form), String.class);
        assertTrue(actual.contains(expected));
    }
    
}
