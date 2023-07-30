package com.unical.solarVision.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.unical.solarVision.mapper.UserMapper;
import com.unical.solarVision.model.AuthToken;
import com.unical.solarVision.model.User;
import com.unical.solarVision.repository.UserRepository;
import com.unical.solarVision.security.JwtProvider;
import com.unical.solarVision.service.AuthenticationService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthToken login(String email, String password) {
        User user = userRepository.findByEmail(email).orElse(null);
        if (user == null || !this.passwordEncoder.matches(password, user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Bad credentials");
        }
        ObjectNode userNode = new ObjectMapper().convertValue(user, ObjectNode.class);
        userNode.remove("password");
        Map<String, Object> claimMap = new HashMap<>(0);
        claimMap.put("user", userNode);

        AuthToken token = new AuthToken();
        token.setType("bearer");
        token.setToken(JwtProvider.createJwt(email, claimMap));
        token.setExpires_in(DateTime.now().plusDays(1).toDate());
        token.setUserId(user.getId().toString());
        return token;
    }
}