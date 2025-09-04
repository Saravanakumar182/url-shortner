package com.project.url_short;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepo extends JpaRepository<Url,Long>{
    Url findByShortUrl(String shortUrl);
    Url findByLongUrl(String longUrl);
    void deleteByLongUrl(String longUrl);

}
