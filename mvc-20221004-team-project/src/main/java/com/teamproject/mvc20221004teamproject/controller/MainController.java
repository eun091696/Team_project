package com.teamproject.mvc20221004teamproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/main/index")
    public String index() {
        return ("main/index");
    }
}
