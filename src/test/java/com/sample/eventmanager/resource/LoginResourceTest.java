/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.eventmanager.resource;

import com.sample.eventmanager.UserSession;
import com.sample.eventmanager.service.LoginService;
import com.sample.eventmanager.service.mock.LoginServiceMock;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.test.DeploymentContext;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.ServletDeploymentContext;
import org.glassfish.jersey.test.grizzly.GrizzlyWebTestContainerFactory;
import org.glassfish.jersey.test.spi.TestContainerException;
import org.glassfish.jersey.test.spi.TestContainerFactory;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Shindo
 */
public class LoginResourceTest extends JerseyTest {
    
    
    public static class TestBinder extends AbstractBinder {
        @Override
        protected void configure() {
            bind(LoginServiceMock.class).to(LoginService.class);
            bind(UserSession.class).to(UserSession.class);
        }
    }

    @Override
    protected Application configure() {
        return new ResourceConfig().register(new TestBinder())
                .register(LoginResource.class);
    }

    @Override
    protected TestContainerFactory getTestContainerFactory() throws TestContainerException {
        return new GrizzlyWebTestContainerFactory();
    }

    @Override
    protected DeploymentContext configureDeployment() {
        ResourceConfig config = new ResourceConfig(LoginResource.class);
        config.register(UserSession.class);
        config.register(new TestBinder());
        return ServletDeploymentContext.forServlet(new ServletContainer(config)).build();
    }
    
    @Test
    public void testLogin() {
        System.out.println("login");
        String expected = "ok";
        Form form = new Form();
        form.param("userId", "user001");
        form.param("password", "password");
        String actual = target("login")
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .post(Entity.form(form), String.class);
        assertTrue(actual.contains(expected));
    }
    
    @Test
    public void testSession() {
        UserSession session = target("login")
                .path("session")
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get(UserSession.class);
        System.out.println(String.format(
                "user_id=%s, name=%s", 
                session.getUserId(), session.getName()));
    }
    
}
