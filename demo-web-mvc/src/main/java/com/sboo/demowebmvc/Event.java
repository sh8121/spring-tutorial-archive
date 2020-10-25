package com.sboo.demowebmvc;

import javax.validation.constraints.NotNull;

public class Event {
    @NotNull
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private Integer limit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
