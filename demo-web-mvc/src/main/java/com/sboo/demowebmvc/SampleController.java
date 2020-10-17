package com.sboo.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class SampleController {
    @RequestMapping("/{name}")
    @ResponseBody
    public String hello(@PathVariable String name) {
        return "hello " + name;
    }
}
