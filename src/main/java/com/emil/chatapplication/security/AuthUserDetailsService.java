package com.emil.chatapplication.security;

import com.emil.chatapplication.entity.User;
import com.emil.chatapplication.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        User user = userRepository.findUserByPhoneNumber(phoneNumber);
        if(user == null){
            throw new EntityNotFoundException("User not found with phone number: " + phoneNumber);
        }
        return new SecurityUser(user);
    }
}

