package com.project.url_short;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class UiController {

    @Autowired
    private UrlService urlService;

    @GetMapping("/home")
    public String homePage() {
        return "index";
    }

    @PostMapping("/shorten")
    public String shortenUrl(@RequestParam("longUrl") String longUrl, Model model, HttpServletRequest request) {
        String shortCode = urlService.createUrl(longUrl);

        String baseUrl = request.getScheme() + "://" + request.getServerName() 
                        + (request.getServerPort() != 80 && request.getServerPort() != 443 ? ":" + request.getServerPort() : "")
                        + request.getContextPath();

        String fullShortUrl = baseUrl + "/" + shortCode;

        model.addAttribute("shortUrl", fullShortUrl);
        return "result";
    }    
}
