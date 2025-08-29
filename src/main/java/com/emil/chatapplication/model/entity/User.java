package com.emil.chatapplication.model.entity;

import com.emil.chatapplication.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users", schema = "chatApp")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String aboutMe;
    @Column(unique = true)
    @Pattern(regexp = "^\\+?[0-9]{10,13}$", message = "Invalid phone number")
    private String phoneNumber;
    private String password;
    private UserRole role;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChatMessage> messages = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_chats",
            schema = "chatApp",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "chat_id"))
    private List<Chat> chats = new ArrayList<>();


    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "user_contacts",
            schema = "chatApp",
            joinColumns = @JoinColumn(name = "user_id")
    )
    private Set<String> contactPhoneNumbers = new HashSet<>();










}
