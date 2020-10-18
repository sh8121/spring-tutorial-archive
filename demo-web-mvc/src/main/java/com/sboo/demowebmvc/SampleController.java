package com.sboo.demowebmvc;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class SampleController {

    @GetMapping("/events")
    @ResponseBody
    public String events() {
        return "event";
    }

    @GetMapping("/events/{id}")
    @ResponseBody
    public String getAnEvent(@PathVariable int id) {
        return "event";
    }

    @DeleteMapping("/events/{id}")
    @ResponseBody
    public String removeAnEvent(@PathVariable int id) {
        return "event";
    }

    @GetHelloMapping
    @ResponseBody
    public String hello() {
        return "hello";
    }
}
