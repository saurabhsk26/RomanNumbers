package com.saurabh.projects.romannumbercreator.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class SampleController {
    @GetMapping("/check")
    public String check(){
        return "sample API working";
    }
}
