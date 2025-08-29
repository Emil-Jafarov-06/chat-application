package com.emil.chatapplication.service;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@Getter
public class OnlineUserTracker {

    Set<String> onlineUsers = new HashSet<>();

    public void addUser(String username){
        onlineUsers.add(username);
    }

    public void removeUser(String username){
        onlineUsers.remove(username);
    }

    public int getOnlineUsersCount(){
        return onlineUsers.size();
    }
}
