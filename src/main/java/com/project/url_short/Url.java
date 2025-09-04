package com.project.url_short;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Url {

    @Id
    private Long id;
    private String shortUrl;
    private String longUrl;
    private LocalDateTime timestamp;
    private Long expiry;
    private Long clicks;
}
