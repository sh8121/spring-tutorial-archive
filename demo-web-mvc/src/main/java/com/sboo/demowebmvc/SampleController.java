package com.sboo.demowebmvc;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class SampleController {

    @GetMapping("/events/form")
    public String eventsForm(Model model) {
        Event newEvent = new Event();
        newEvent.setLimit(50);
        model.addAttribute("event", newEvent);
        return "/events/form";
    }

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
