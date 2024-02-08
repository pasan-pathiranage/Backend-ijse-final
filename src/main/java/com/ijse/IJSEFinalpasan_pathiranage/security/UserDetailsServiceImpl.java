package com.ijse.IJSEFinalpasan_pathiranage.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ijse.IJSEFinalpasan_pathiranage.entity.User;
import com.ijse.IJSEFinalpasan_pathiranage.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        User user = userRepository.findByUserName(username).orElse(null);

        if(user == null){
            throw new UsernameNotFoundException("User not found with the given username");
        }

        return org.springframework.security.core.userdetails.User.builder()
            .username(user.getUserName())
            .password(user.getPassword())
            .build();
    }
    
}
