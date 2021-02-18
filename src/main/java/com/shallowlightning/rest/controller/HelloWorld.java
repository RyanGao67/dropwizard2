package com.shallowlightning.rest.controller;

import com.codahale.metrics.annotation.Timed;
import com.shallowlightning.rest.dao.Sayling;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import io.swagger.annotations.Api;

@Api(tags={"hello"})
@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorld {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public HelloWorld(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Sayling sayHello(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.orElse(defaultName));
        return new Sayling(counter.incrementAndGet(), value);
    }
}
