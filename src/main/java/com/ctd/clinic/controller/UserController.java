package com.ctd.clinic.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UserController {

    @GetMapping("/index.html")
    public ResponseEntity<?> home() {
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
