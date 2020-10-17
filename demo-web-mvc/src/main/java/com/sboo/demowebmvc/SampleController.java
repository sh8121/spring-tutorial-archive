package com.sboo.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
public class SampleController {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }
}
