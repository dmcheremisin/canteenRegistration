package com.syngenta.canteen.registration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AngularForwardController {

    @GetMapping(value = {
            "/login",
            "/week", "/week/*",
            "/day", "/day/*"
    })
    public String frontend() {
        return "forward:/";
    }
}
