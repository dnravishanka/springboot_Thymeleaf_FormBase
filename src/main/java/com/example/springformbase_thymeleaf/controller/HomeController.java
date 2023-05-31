package com.example.springformbase_thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping("home")
    public String homepage() {
        return "index";
    }

    @GetMapping("admi")
    public String adminpage() {
        return "admin/index";
    }
    @GetMapping("manage")
    public String mangementPage() {
        return "management/index";
    } @GetMapping("use")
    public String userpage() {
        return "user/index";
    }
}
