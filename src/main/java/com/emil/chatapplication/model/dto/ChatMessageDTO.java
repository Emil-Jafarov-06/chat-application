package com.emil.chatapplication.model.dto;

import com.emil.chatapplication.enums.MessageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessageDTO {

    private Long id;
    private String content;
    private String sender;
    private MessageType type;
    private LocalDateTime dateTime;
    private Long chatId;
    private Long userId;

}
