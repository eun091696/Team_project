package com.teamproject.mvc20221004teamproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MypageController {

    @GetMapping("/mypage/index")
    public String index() {
        return ("mypage/index");
    }
}
