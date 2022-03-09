package com.jakala.mappers;

import org.mapstruct.Mapper;
import com.jakala.dtos.UserDto;
import com.jakala.entities.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUser(UserEntity users);
}
