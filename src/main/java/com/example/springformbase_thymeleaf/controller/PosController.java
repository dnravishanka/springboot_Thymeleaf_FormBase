package com.example.springformbase_thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pos")
public class PosController {
    @GetMapping("/home")
    public String posView() {
        return "other/pos";
    }
}
