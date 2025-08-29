package com.emil.chatapplication.model.request;

import com.emil.chatapplication.enums.ContactAdjustmentEnum;
import lombok.Getter;

@Getter
public class ContactAdjustmentRequest {

    private String phoneNumber;
    private ContactAdjustmentEnum adjustment;

}
