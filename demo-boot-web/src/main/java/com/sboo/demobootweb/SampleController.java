package com.sboo.demobootweb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    // preHandle 1
    // preHandle 2
    // 요청 처리
    // postHandler 2
    // postHandler 1
    // 뷰 랜더링
    // afterCompletion 2
    // afterCompletion 1

    @GetMapping("/hello")
    public String hello(@RequestParam("id") Person person) {
        return "hello, " + person.getName();
    }

    @GetMapping("/sample")
    public String sample() {
        return "hello";
    }

    @GetMapping("/h1")
    public String h1() {
        return "h1";
    }
}
