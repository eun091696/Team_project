package com.teamproject.mvc20221004teamproject.controller;

import com.teamproject.mvc20221004teamproject.dto.LoginReqDto;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {

    @GetMapping("/account/login")
    public String login(Model model, @RequestParam @Nullable String username) {
        model.addAttribute("username", username == null ? "" : username);
        return ("account/login");
    }

    @GetMapping("/account/register")
    public String register() {
        return ("account/register");
    }

    @GetMapping("/account/join")
  public String join() {
        return ("account/join");
  }
}
