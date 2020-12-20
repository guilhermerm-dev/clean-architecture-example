package com.clean.arch.example.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @Value("${api.info}")
    private String API_INFO;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getApiVersion() {
        return API_INFO;
    }
}
