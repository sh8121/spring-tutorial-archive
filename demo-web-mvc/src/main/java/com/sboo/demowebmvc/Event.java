package com.sboo.demowebmvc;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Event {

    interface ValidateLimit {}
    interface ValidateName {}

    @NotNull
    private Integer id;

    @NotNull(groups = ValidateName.class)
    private String name;

    @NotNull(groups = ValidateLimit.class)
    @Min(value = 0, groups = ValidateLimit.class)
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
