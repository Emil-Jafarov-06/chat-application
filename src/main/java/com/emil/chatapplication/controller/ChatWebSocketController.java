package com.emil.chatapplication.controller;

import com.emil.chatapplication.model.entity.ChatMessage;
import com.emil.chatapplication.enums.MessageType;
import com.emil.chatapplication.service.OnlineUserTracker;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Set;

@Controller
@RequiredArgsConstructor
public class ChatWebSocketController {

    private final SimpMessageSendingOperations messagingTemplate;
    private final OnlineUserTracker onlineUserTracker;

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage message){
        return message;
    }

    @MessageMapping("/chat.addUser")
    public void addUser(@Payload ChatMessage message,
                        SimpMessageHeaderAccessor headerAccessor){
        onlineUserTracker.addUser(message.getSender());
        Objects.requireNonNull(headerAccessor.getSessionAttributes()).put("username", message.getSender());

        messagingTemplate.convertAndSend("/topic/public",
                ChatMessage.builder()
                .type(MessageType.JOIN)
                .sender(message.getSender())
                .content(message.getSender() + " joined the chat")
                .build());
    }

    @GetMapping("/users/online")
    @ResponseBody
    public Set<String> getOnlineUsers(){
        return onlineUserTracker.getOnlineUsers();
    }

}
