package com.sust.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by SunnyGrocery on 2019/10/5 19:31
 */
@Controller
public class GreetingController {
    @GetMapping("/greeting")
    public String hello(@RequestParam(name = "name", required = false, defaultValue = "SunnyGrocery") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}
