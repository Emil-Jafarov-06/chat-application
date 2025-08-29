package com.emil.chatapplication.model.dto;

import com.emil.chatapplication.enums.ChatType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatDTO {

    private Long id;
    private String name;
    private String description;
    private ChatType type;
    private List<ChatMessageDTO> messages = new ArrayList<>();

}
