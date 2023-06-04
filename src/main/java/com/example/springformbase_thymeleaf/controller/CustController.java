package com.example.springformbase_thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustController {
    @GetMapping("admin/customer")
    public String adminCustomerPage() {
        return "admin/customer";
    }

    @GetMapping("manage/customer")
    public String manageCustomerPage() {
        return "management/customer";
    }

    @GetMapping("user/customer")
    public String employCustomerPage() {
        return "user/customer";
    }
}
