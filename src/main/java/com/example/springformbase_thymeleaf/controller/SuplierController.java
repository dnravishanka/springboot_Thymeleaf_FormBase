package com.example.springformbase_thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/supliers")
public class SuplierController {
    @GetMapping("/home")
    public String suplierHome() {
        return "other/supliers";
    }

}
