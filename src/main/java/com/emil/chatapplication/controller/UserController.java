package com.emil.chatapplication.controller;

import com.emil.chatapplication.model.dto.ChatDTO;
import com.emil.chatapplication.model.dto.UserDTO;
import com.emil.chatapplication.model.request.AccountUpdateRequest;
import com.emil.chatapplication.model.request.ContactAdjustmentRequest;
import com.emil.chatapplication.model.response.InfoResponse;
import com.emil.chatapplication.security.SecurityUser;
import com.emil.chatapplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    public ResponseEntity<InfoResponse<UserDTO>> getUserInfo(@AuthenticationPrincipal SecurityUser principal){
        UserDTO userDTO = userService.getUserById(principal.getUser().getId());
        return ResponseEntity.status(HttpStatus.OK).body(
                InfoResponse.<UserDTO>builder()
                        .success(true)
                        .message("User info retrieved successfully")
                        .data(userDTO)
                        .build());
    }

    @GetMapping("/me/chats")
    public ResponseEntity<InfoResponse<List<ChatDTO>>> getUserChats(@AuthenticationPrincipal SecurityUser principal){
        List<ChatDTO> userChats = userService.getUserChats(principal.getUser().getId());
        return ResponseEntity.status(HttpStatus.OK).body(
                InfoResponse.<List<ChatDTO>>builder()
                        .success(true)
                        .message("User chats retrieved successfully")
                        .data(userChats)
                        .build());
    }

    @GetMapping("/me/contacts")
    public ResponseEntity<InfoResponse<List<UserDTO>>> getContacts(@AuthenticationPrincipal SecurityUser principal){
        List<UserDTO> userContacts = userService.getUserContacts(principal.getUser().getId());
        return ResponseEntity.status(HttpStatus.OK).body(
                InfoResponse.<List<UserDTO>>builder()
                        .success(true)
                        .message("User contacts retrieved successfully")
                        .data(userContacts)
                        .build());
    }

    @PostMapping("/me/contacts")
    public ResponseEntity<InfoResponse<List<UserDTO>>> changeContactList(@AuthenticationPrincipal SecurityUser principal, @RequestBody ContactAdjustmentRequest request){
        List<UserDTO> userContacts = userService.adjustUserContacts(principal.getUser().getId(), request);
        return ResponseEntity.status(HttpStatus.OK).body(
                InfoResponse.<List<UserDTO>>builder()
                        .success(true)
                        .message("User contacts using this app retrieved successfully")
                        .data(userContacts)
                        .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InfoResponse<UserDTO>> getUserById(@PathVariable Long id){
        UserDTO userDTO = userService.getUserById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(
                InfoResponse.<UserDTO>builder()
                        .success(true)
                        .message("User info retrieved successfully")
                        .data(userDTO)
                        .build());
    }

    @GetMapping("/search")
    public ResponseEntity<InfoResponse<List<UserDTO>>> searchUsers(@RequestParam(required = false) String name, @RequestParam(required = false) String phoneNumber){
        List<UserDTO> users = userService.searchUsers(name, phoneNumber);
        return ResponseEntity.status(HttpStatus.FOUND).body(
                InfoResponse.<List<UserDTO>>builder()
                        .success(true)
                        .message("Users retrieved successfully")
                        .data(users)
                        .build()
        );
    }

    @PutMapping("/me")
    public ResponseEntity<InfoResponse<UserDTO>> updateMyAccount(@AuthenticationPrincipal SecurityUser principal, @RequestBody AccountUpdateRequest request){
        UserDTO user = userService.updateUser(principal.getUser().getId(), request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                InfoResponse.<UserDTO>builder()
                        .success(true)
                        .message("User account updated successfully")
                        .data(user)
                        .build());
    }

}
