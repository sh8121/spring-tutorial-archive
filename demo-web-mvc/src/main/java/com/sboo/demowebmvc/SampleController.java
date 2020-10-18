package com.sboo.demowebmvc;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class SampleController {

    @PostMapping("/events")
    @ResponseBody
    public Event getEvent(@RequestParam Map paramMap) {
        //Map or MultiValueMap
        Event event = new Event();
        event.setName((String)paramMap.get("name"));
        event.setLimit(Integer.parseInt((String)paramMap.get("limit")));
        return event;
    }
}
