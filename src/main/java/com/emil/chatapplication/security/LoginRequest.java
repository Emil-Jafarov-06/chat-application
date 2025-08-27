package com.emil.chatapplication.security;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    private String phoneNumber;
    private String password;

}