package com.emil.chatapplication.model.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class AccountUpdateRequest {

    @NotBlank
    private String username;
    private String aboutMe;
    @Size(min = 6, max = 100)
    private String password;

}
