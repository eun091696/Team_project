package com.teamproject.mvc20221004teamproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {

    @GetMapping("/order/cart")
    public String cart() {
        return ("order/cart");
    }
}
