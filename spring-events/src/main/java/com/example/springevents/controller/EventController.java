package com.example.springevents.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EventController {
    @RequestMapping("/test")
    @ResponseBody
    public String handle () {
        return "test response from /test";
    }
}
