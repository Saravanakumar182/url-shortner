package com.project.url_short;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String shortUrl;

    @Column(columnDefinition = "TEXT")
    private String longUrl;
    private LocalDateTime timestamp;
    private Long clicks=0L;
}
