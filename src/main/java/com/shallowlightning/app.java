package com.shallowlightning;

import com.shallowlightning.rest.controller.EmployeeRESTController;
import com.shallowlightning.rest.controller.HelloWorld;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class app extends Application<HelloWorldConfiguration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(app.class);
    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> b){}
    @Override
    public void run(HelloWorldConfiguration c, Environment e) throws Exception{
        LOGGER.info("Registering REST resources");
        e.jersey().register(new EmployeeRESTController(e.getValidator()));
        e.jersey().register(new HelloWorld(c.getTemplate(),c.getDefaultName()));
    }
    public static void main(String[] args) throws Exception{
        new app().run(args);
    }





    @Override
    public String getName() {
        return "hello-world";
    }

}
