package com.sboo.demowebmvc;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

    @GetMapping("/events")
    @ResponseBody
    public Event getEvent(@ModelAttribute Event event, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            bindingResult.getAllErrors().forEach(objectError ->
                    System.out.println(objectError.toString())
            );
        }
        return event;
    }

    @PostMapping("/events/name/{name}")
    @ResponseBody
    public Event postEvent(@ModelAttribute Event event) {
        return event;
    }
}
