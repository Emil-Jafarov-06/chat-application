package com.emil.chatapplication.mapper;

import com.emil.chatapplication.model.dto.UserDTO;
import com.emil.chatapplication.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO mapIntoDto(User user);

}
