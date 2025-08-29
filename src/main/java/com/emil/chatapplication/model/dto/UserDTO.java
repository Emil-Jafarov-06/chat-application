package com.emil.chatapplication.model.dto;

import com.emil.chatapplication.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;
    private String username;
    private String aboutMe;
    private String phoneNumber;
    private String password;
    private UserRole role;

}
