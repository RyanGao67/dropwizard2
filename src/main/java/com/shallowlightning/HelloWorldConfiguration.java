package com.shallowlightning;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class HelloWorldConfiguration extends Configuration {
    @NotEmpty
    private String template;
    @JsonProperty    public String getTemplate() {return template;}
    @JsonProperty    public void setTemplate(String template) {this.template = template;}

    @NotEmpty
    private String defaultName = "Stranger";
    @JsonProperty    public String getDefaultName() {return defaultName;}
    @JsonProperty    public void setDefaultName(String name) {this.defaultName = name;}
    @JsonProperty("swagger")
    public SwaggerBundleConfiguration swaggerBundleConfiguration;
}