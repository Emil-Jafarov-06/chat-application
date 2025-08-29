package com.emil.chatapplication.repository;

import com.emil.chatapplication.model.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {

}
