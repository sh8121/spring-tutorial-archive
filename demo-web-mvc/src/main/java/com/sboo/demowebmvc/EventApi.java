package com.sboo.demowebmvc;

import org.springframework.http.HttpEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/events")
public class EventApi {

    @PostMapping
    public Event createEvent(HttpEntity<Event> request) {
        System.out.println(request.getHeaders());
        return request.getBody();
    }
}
