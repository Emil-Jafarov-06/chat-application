package com.emil.chatapplication.entity;

import com.emil.chatapplication.enums.MessageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {

    public String content;
    public String sender;
    public MessageType type;

}
