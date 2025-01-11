package com.inventory_management.inventory_management.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/home")
    public String getTestData() {
        return "Test Controller";
    }
}
