package com.teamproject.mvc20221004teamproject.controller;

import com.teamproject.mvc20221004teamproject.dto.LoginReqDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

    @GetMapping("/account/login")
    public String login() {
        return ("account/login");
    }
}
