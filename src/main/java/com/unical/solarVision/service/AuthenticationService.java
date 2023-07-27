package com.unical.solarVision.service;

import com.unical.solarVision.model.AuthToken;

public interface AuthenticationService {
	public AuthToken login(String email, String password);
}
