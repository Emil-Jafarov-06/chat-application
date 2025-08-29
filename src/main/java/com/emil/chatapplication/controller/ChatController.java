package com.emil.chatapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chats")
public class ChatController {
/*
    @PostMapping("/chats")
    @ResponseBody
    public ChatMessage createChat(@RequestBody ChatCreateRequest request){
        return ChatMessage.builder()
                .type(MessageType.CHAT)
                .sender(request.getSender())
                .content(request.getContent())
                .build();
    }
     */

}
