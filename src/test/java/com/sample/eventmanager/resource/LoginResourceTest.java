/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.eventmanager.resource;

import com.sample.eventmanager.UserSession;
import com.sample.eventmanager.dto.LoginDto;
import com.sample.eventmanager.service.LoginService;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import org.glassfish.hk2.api.Factory;
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
import org.mockito.Mockito;

/**
 *
 * @author Shindo
 */
public class LoginResourceTest extends JerseyTest {
    
    public static class MockLoginServiceFactory implements Factory<LoginService> {

        @Override
        public LoginService provide() {
            LoginService loginServiceMock = Mockito.mock(LoginService.class);
            Mockito.when(loginServiceMock.authorize(Mockito.anyString(), Mockito.anyString())).thenReturn(true);
            LoginDto dto = new LoginDto();
            dto.setUserId("user001");
            dto.setName("Shindo");
            dto.setEmployeeNumber("128");
            Set<String> permissions = new HashSet<>();
            permissions.add("event_r");
            dto.setPermissions(permissions);
            Mockito.when(loginServiceMock.getUserInfo("user001")).thenReturn(dto);
            return loginServiceMock;
        }

        @Override
        public void dispose(LoginService instance) {
        }
        
    }
    
    public static class TestBinder extends AbstractBinder {
        @Override
        protected void configure() {
            bindFactory(new MockLoginServiceFactory()).to(LoginService.class);
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
