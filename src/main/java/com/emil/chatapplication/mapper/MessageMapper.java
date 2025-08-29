package com.emil.chatapplication.mapper;

import com.emil.chatapplication.model.dto.ChatMessageDTO;
import com.emil.chatapplication.model.entity.ChatMessage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {UserMapper.class, ChatMapper.class}, componentModel = "spring", imports = {ChatMessage.class})
public interface MessageMapper {

    @Mapping(target = "chatId", source = "chat.id")
    @Mapping(target = "userId", source = "user.id")
    ChatMessageDTO mapIntoDto(ChatMessage message);

}
