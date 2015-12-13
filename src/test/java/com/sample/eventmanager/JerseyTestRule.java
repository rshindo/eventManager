/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.eventmanager;

import com.sample.eventmanager.resource.LoginResourceTest;
import java.io.IOException;
import java.net.URI;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Application;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.grizzly2.servlet.GrizzlyWebContainerFactory;
import org.glassfish.jersey.test.DeploymentContext;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.spi.TestContainer;
import org.glassfish.jersey.test.spi.TestContainerException;
import org.glassfish.jersey.test.spi.TestContainerFactory;
import org.junit.rules.ExternalResource;

/**
 *
 * @author Shindo
 */
public class JerseyTestRule extends ExternalResource {
    
    private final JerseyTest jerseyTest;

    public JerseyTestRule(final Application config) {
        this.jerseyTest = new JerseyTest() {
            @Override
            protected Application configure() {
                return config;
            }

            @Override
            protected TestContainerFactory getTestContainerFactory() throws TestContainerException {
                return new TestContainerFactory() {

                    @Override
                    public TestContainer create(URI baseUri, DeploymentContext deploymentContext) {
                        return createTestContainer(baseUri);
                    }

                    protected TestContainer createTestContainer(URI baseUri) {
                        return new TestContainer() {

                            private HttpServer server;

                            @Override
                            public ClientConfig getClientConfig() {
                                return null;
                            }

                            @Override
                            public URI getBaseUri() {
                                return baseUri;
                            }

                            @Override
                            public void start() {
                                try {
                                    this.server = GrizzlyWebContainerFactory.create(baseUri,
                                            Collections.singletonMap("jersey.config.server.provider.packages", "com.sample.eventmanager.resource"));
                                } catch (IOException ex) {
                                    Logger.getLogger(LoginResourceTest.class.getName()).log(Level.SEVERE, null, ex);
                                    throw new RuntimeException(ex);
                                }
                            }

                            @Override
                            public void stop() {
                                this.server.shutdownNow();
                            }
                        };
                    }
                };
            }
        };
    }

    @Override
    protected void before() throws Throwable {
        this.jerseyTest.setUp();
    }

    @Override
    protected void after() {
        try {
            this.jerseyTest.tearDown();
        } catch (Exception ex) {
            throw new RuntimeException("failed to tear down JerseyTest", ex);
        }
    }

    public JerseyTest getJerseyTest() {
        return jerseyTest;
    }
    
}
