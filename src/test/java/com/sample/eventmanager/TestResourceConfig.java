/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.eventmanager;

import com.sample.eventmanager.resource.LoginResource;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author Shindo
 */
public class TestResourceConfig extends ResourceConfig {
    
    public static class TestBinder extends AbstractBinder {
        @Override
        protected void configure() {
            
        }
    }

    public TestResourceConfig() {
        register(new TestBinder()).register(LoginResource.class);
    }
    
}
