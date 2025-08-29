package com.emil.chatapplication.repository;

import com.emil.chatapplication.model.entity.Chat;
import com.emil.chatapplication.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);

    User findUserByPhoneNumber(String phoneNumber);

    @Query("select u.chats from User u where u.id = :id")
    List<Chat> findChatsByUserId(Long id);

    List<User> findUsersByPhoneNumberLikeIgnoreCaseAndUsernameLikeIgnoreCase(String phoneNumber, String username);

    List<User> findUsersByPhoneNumberLikeIgnoreCase(String phoneNumber);

    List<User> findUsersByUsernameLikeIgnoreCase(String username);

    List<User> findAllByPhoneNumberIn(Collection<String> phoneNumbers);
}
