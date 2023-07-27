package com.unical.solarVision.service;

import com.unical.solarVision.dto.UserDTO;
import com.unical.solarVision.dto.UserRegistrationDTO;

import java.util.List;

public interface UserService {
	List<UserDTO> findAll();

	UserDTO findByEmail(String email);

	UserDTO findById(Long id);

	boolean existsById(Long id);

	void delete(Long id);

	UserDTO create(UserRegistrationDTO dto);

	UserDTO modify(Long id, UserDTO dto);
}