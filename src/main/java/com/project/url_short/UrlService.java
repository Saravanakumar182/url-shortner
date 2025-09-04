package com.project.url_short;

import java.security.SecureRandom;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlService {

    @Autowired
    private UrlRepo urlRepo;

    private final String KEY = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final int BASE = 7;
    private final SecureRandom random = new SecureRandom();

    public String createUrl (String url){
        Url shortUrl = new Url();
        shortUrl.setLongUrl(url);
        shortUrl.setShortUrl(Base62converter(url));
        shortUrl.setTimestamp(LocalDateTime.now());
        urlRepo.save(shortUrl);
        return shortUrl.getShortUrl();
    }

    public String getUrl (String shortUrl){
        Url url = urlRepo.findByShortUrl(shortUrl);
        if (url != null) {
            url.setClicks(url.getClicks()+1);
            urlRepo.save(url);
            return url.getLongUrl();
        } else {
            return null;
        }
    }

    private String Base62converter(String url){
        StringBuilder sb = new StringBuilder(BASE);
        for (int i = 0; i < BASE; i++) {
            sb.append(KEY.charAt(random.nextInt(KEY.length())));
        }
        return sb.toString();
    }
}