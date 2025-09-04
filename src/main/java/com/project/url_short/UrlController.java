package com.project.url_short;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class UrlController {

    @GetMapping("/")
    public String greetString() {
        return "Welcome to your url shortner!!!!";
    }

    
}
