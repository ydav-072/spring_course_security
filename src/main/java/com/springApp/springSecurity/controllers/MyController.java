package com.springApp.springSecurity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/")
    public String getInfoForAllEmps() {
        return "view-for-all-employees";
    }

    @GetMapping("/hr-info")
    public String getInfoOnlyForHR() {
        return "view-for-hr";
    }

    @GetMapping("/manager-info")
    public String getInfoOnlyForManagers() {
        return "view-for-managers";
    }
}
