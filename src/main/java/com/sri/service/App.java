package com.sri.service;

import com.sri.rest.controller.EmployeeRESTController;
import com.sri.rest.controller.NERRestController;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App extends Application<Configuration> {

    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }

    @Override
    public void run(Configuration c, Environment e) throws Exception {
        log.info("Registering REST resources");
        e.jersey().register(new EmployeeRESTController(e.getValidator()));
        e.jersey().register(new NERRestController());
    }

    public static void main(String[] args) throws Exception {
        new App().run(args);



    }
}
