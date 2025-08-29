package com.emil.chatapplication.repository;

import com.emil.chatapplication.model.entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<ChatMessage, Long> {
}
