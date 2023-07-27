package com.unical.solarVision.controller;

import com.unical.solarVision.dto.AuthenticationDTO;
import com.unical.solarVision.model.AuthToken;
import com.unical.solarVision.service.impl.AuthenticationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class AuthenticationController {

    @Autowired
    private AuthenticationServiceImpl authenticationService;

    @PostMapping
    public AuthToken login(@RequestBody AuthenticationDTO authDto) {
        return this.authenticationService.login(authDto.getEmail(), authDto.getPassword());
    }
}
