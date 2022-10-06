package com.teamproject.mvc20221004teamproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

    @GetMapping("/account/login")
    public String login() {
        return ("account/login");
    }
}
