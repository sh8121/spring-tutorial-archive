package com.sboo.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("visitTime2")
public class SampleController {

    @GetMapping("/events/form")
    public String eventsForm(Model model) {
        Event newEvent = new Event();
        newEvent.setLimit(50);
        model.addAttribute("event", newEvent);
        return "/events/form";
    }

    @GetMapping("/events/time")
    public String saveTime(Model model) {
        model.addAttribute("visitTime2", LocalDateTime.now());
        return "redirect:/events/list";
    }

    @PostMapping("/events")
    public String createEvent(@Validated @ModelAttribute Event event, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "/events/form";
        }
        return "redirect:/events/list";
        //PRG Pattern
    }

    @GetMapping("/events/list")
    public String getEvents(SessionStatus sessionStatus, Model model, @SessionAttribute LocalDateTime visitTime, @SessionAttribute LocalDateTime visitTime2) {
        Event event = new Event();
        event.setName("spring");
        event.setLimit(10);

        List<Event> eventList = new ArrayList<>();
        eventList.add(event);

        model.addAttribute(eventList);

        sessionStatus.setComplete();
        System.out.println(visitTime);
        System.out.println(visitTime2);

        return "/events/list";
    }
}
