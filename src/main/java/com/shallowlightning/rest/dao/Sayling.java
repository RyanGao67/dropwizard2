package com.shallowlightning.rest.dao;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sayling {
    private long id;

    private String content;

    public Sayling() {
        // Jackson deserialization
    }

    public Sayling(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}