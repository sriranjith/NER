package com.sri.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sri.rest.controller.EmployeeRESTController;
import com.sri.rest.controller.NERRestController;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class App extends Application<Configuration> {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }

    @Override
    public void run(Configuration c, Environment e) throws Exception {
        LOGGER.info("Registering REST resources");
        e.jersey().register(new EmployeeRESTController(e.getValidator()));
        e.jersey().register(new NERRestController());
    }

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}
