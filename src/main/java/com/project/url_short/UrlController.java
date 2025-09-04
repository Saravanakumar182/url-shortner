package com.project.url_short;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class UrlController {

    @Autowired
    private UrlService urlService;

    @GetMapping("/")
    public String greetString() {
        return "Welcome to your url shortner!!!!";
    }

    @GetMapping("/{shortUrl}")
    public RedirectView redirectUrl(@PathVariable String shortUrl) {
        String longUrl = urlService.getUrl(shortUrl);
        if (longUrl != null) {
            return new RedirectView(longUrl);
        } else {
            return new RedirectView("/");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody String entity) {
        return ResponseEntity.ok(urlService.createUrl(entity));
    }
    
    
}
