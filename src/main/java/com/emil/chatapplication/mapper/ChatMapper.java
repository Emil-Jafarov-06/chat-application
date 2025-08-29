package com.emil.chatapplication.mapper;

import com.emil.chatapplication.model.dto.ChatDTO;
import com.emil.chatapplication.model.entity.Chat;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {MessageMapper.class})
public interface ChatMapper {

    ChatDTO mapIntoDto(Chat chat);

}
