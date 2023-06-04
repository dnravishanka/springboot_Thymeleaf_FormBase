package com.example.springformbase_thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employ")
public class EmployController {
    @GetMapping("/admin/employ")
    public String adminEmploy() {
        return "admin/employ";
    }
    @GetMapping("/manage/employ")
    public String manageEmploy() {
        return "management/employ";
    }
}
