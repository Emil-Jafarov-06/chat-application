package com.emil.chatapplication.security;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String phoneNumber;
    private String username;
    private String password;

}
