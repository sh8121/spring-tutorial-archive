package com.sboo.demowebmvc;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SampleController {
//    @GetMapping(value = "/hello", headers = HttpHeaders.FROM)
//    @GetMapping(value = "/hello", headers = "!" + HttpHeaders.FROM)
//    @GetMapping(value = "/hello", headers = HttpHeaders.FROM + "=" + "111")
//    @GetMapping(value = "/hello", params = "name")
    @GetMapping(value = "/hello", params = "name=spring")
    @ResponseBody
    public String hello() {
        return "hello";
    }
}
