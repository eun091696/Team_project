package com.teamproject.mvc20221004teamproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GoodsController {

    @GetMapping("/goods/goods_list")
    public String goods_list() {
        return ("goods/goods_list");
    }

    @GetMapping("/goods/goods_view")
    public String goods_view() {
        return ("goods/goods_view");
    }
}
