package com.emil.chatapplication.model.request;

import java.util.ArrayList;
import java.util.List;

public class GroupChatCreateRequest {

    List<String> userPhoneNumbers = new ArrayList<>();
    String name;
    String description;

}
