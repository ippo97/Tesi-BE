package com.unical.solarVision.mapper;

import com.unical.solarVision.dto.UserDTO;
import com.unical.solarVision.dto.UserRegistrationDTO;
import com.unical.solarVision.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
	public static UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	UserDTO toUserDTO(User user);

	List<UserDTO> toUserDTOList(List<User> list);

	User toUserEntity(UserDTO dto);

	User toUserEntity(UserRegistrationDTO dto);
}