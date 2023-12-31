package com.unical.solarVision.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserRegistrationDTO {

    private String name;

    private String surname;

    private String email;

    private String password;

    private boolean isEmailNotification;
}