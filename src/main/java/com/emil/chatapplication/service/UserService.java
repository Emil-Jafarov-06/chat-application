package com.emil.chatapplication.service;

import com.emil.chatapplication.enums.ChatType;
import com.emil.chatapplication.enums.ContactAdjustmentEnum;
import com.emil.chatapplication.mapper.ChatMapper;
import com.emil.chatapplication.mapper.UserMapper;
import com.emil.chatapplication.model.dto.ChatDTO;
import com.emil.chatapplication.model.dto.UserDTO;
import com.emil.chatapplication.model.entity.Chat;
import com.emil.chatapplication.model.entity.User;
import com.emil.chatapplication.model.request.AccountUpdateRequest;
import com.emil.chatapplication.model.request.ContactAdjustmentRequest;
import com.emil.chatapplication.repository.ChatRepository;
import com.emil.chatapplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final ChatRepository chatRepository;
    private final ChatMapper chatMapper;

    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return userMapper.mapIntoDto(user);
    }

    public List<ChatDTO> getUserChats(Long id) {
        return userRepository.findChatsByUserId(id)
                .stream()
                .map(chatMapper::mapIntoDto)
                .toList();
    }

    public List<UserDTO> getUserContacts(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        Set<String> contactPhoneNumbers = user.getContactPhoneNumbers();
        List<User> appUsers = userRepository.findAllByPhoneNumberIn(contactPhoneNumbers);
        return appUsers.stream()
                .map(userMapper::mapIntoDto)
                .toList();
    }

    public UserDTO updateUser(Long id, AccountUpdateRequest request) {
        User user = userRepository.findById(id).orElseThrow();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setAboutMe(request.getAboutMe());
        return userMapper.mapIntoDto(userRepository.save(user));
    }

    public List<UserDTO> searchUsers(String name, String phoneNumber) {
        return null;
    }

    public List<UserDTO> adjustUserContacts(Long id, ContactAdjustmentRequest request) {
        User user = userRepository.findById(id).orElseThrow();
        var contactPhoneNumbers = user.getContactPhoneNumbers();
        if (request.getAdjustment() == ContactAdjustmentEnum.ADD && contactPhoneNumbers.contains(request.getPhoneNumber())){
            throw new RuntimeException("Contact already exists for this user.");
        }
        if (request.getAdjustment() == ContactAdjustmentEnum.REMOVE && !contactPhoneNumbers.contains(request.getPhoneNumber())) {
            throw new RuntimeException("Contact does not exist for this user.");
        }
        if (request.getAdjustment() == ContactAdjustmentEnum.ADD) {
            contactPhoneNumbers.add(request.getPhoneNumber());
        } else if (request.getAdjustment() == ContactAdjustmentEnum.REMOVE) {
            contactPhoneNumbers.remove(request.getPhoneNumber());
        } else {
            throw new RuntimeException("Invalid adjustment type.");
        }

        user.setContactPhoneNumbers(contactPhoneNumbers);
        userRepository.save(user);

        List<User> appUsers = userRepository.findAllByPhoneNumberIn(contactPhoneNumbers);
        return appUsers.stream()
                .map(userMapper::mapIntoDto)
                .toList();
    }
}
