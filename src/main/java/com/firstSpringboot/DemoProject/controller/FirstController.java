package com.firstSpringboot.DemoProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @GetMapping("api/divya")
    public String getName()
    {
        return "My first Spring boot Project";
    }


}
