package com.unical.solarVision.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.unical.solarVision.dto.UserDTO;
import com.unical.solarVision.dto.UserRegistrationDTO;
import com.unical.solarVision.mapper.UserMapper;
import com.unical.solarVision.model.User;
import com.unical.solarVision.repository.UserRepository;
import com.unical.solarVision.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public List<UserDTO> findAll() {
		List<User> list = repository.findAll();
		List<UserDTO> out = new ArrayList<>();
		for (User user : list) {
			out.add(UserMapper.INSTANCE.toUserDTO(user));

		}
		return out;
	}

	@Override
	public UserDTO findByEmail(String email) {
		return UserMapper.INSTANCE.toUserDTO(repository.findByEmail(email).orElse(null));
	}

	@Override
	public UserDTO findById(Long id) {
		return UserMapper.INSTANCE.toUserDTO(repository.findById(id).orElse(null));
	}

	@Override
	public boolean existsById(Long id) {
		return repository.existsById(id);
	}

	@Override
	public void delete(Long id) {
		User userToDelete = repository.findById(id).orElse(null);
		if (userToDelete != null)
			repository.delete(userToDelete);
	}

	@Override
	public UserDTO create(UserRegistrationDTO dto) {

		User userToCreate = UserMapper.INSTANCE.toUserEntity(dto);
		
		userToCreate.setPassword(passwordEncoder.encode(userToCreate.getPassword()));
		userToCreate = repository.save(userToCreate);

		return UserMapper.INSTANCE.toUserDTO(userToCreate);

	}

	@Override
	public UserDTO modify(Long id, UserDTO dto) {
		User oldUser = repository.findById(id).orElse(null);
		oldUser.setEmail(dto.getEmail());
		oldUser.setSurname(dto.getSurname());
		oldUser.setName(dto.getName());
		return UserMapper.INSTANCE.toUserDTO(repository.save(oldUser));
	}
}