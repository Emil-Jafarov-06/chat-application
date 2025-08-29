package com.emil.chatapplication.model.entity;

import com.emil.chatapplication.enums.ChatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "chats", schema = "chatApp")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chat {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private ChatType type;

    @OneToMany(mappedBy = "chat", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChatMessage> messages = new ArrayList<>();

    @ManyToMany(mappedBy = "chats", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<User> users = new ArrayList<>();

}
