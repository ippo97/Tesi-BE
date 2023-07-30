package com.unical.solarVision.model;

import com.unical.solarVision.dto.UserDTO;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class AuthToken {
    private String token;

    private String type;

    private Date expires_in;

    private String userId;
}
