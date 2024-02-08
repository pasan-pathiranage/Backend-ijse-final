package com.ijse.IJSEFinalpasan_pathiranage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.IJSEFinalpasan_pathiranage.dto.LoginDto;
import com.ijse.IJSEFinalpasan_pathiranage.entity.User;
import com.ijse.IJSEFinalpasan_pathiranage.repository.UserRepository;
import com.ijse.IJSEFinalpasan_pathiranage.security.jwt.JwtUtils;
import com.ijse.IJSEFinalpasan_pathiranage.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("auth/register")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        
        if(userRepository.existsByUserName(user.getUserName())){
            return ResponseEntity.badRequest().body("Username is already in use");
        }

        if(userRepository.existsByEmail(user.getEmail())){
            return ResponseEntity.badRequest().body("Email is already in use");
        }

        User newUser = new User();
        newUser.setUserName(user.getUserName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));

        return ResponseEntity.ok(userService.creatUser(newUser));
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto){

        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginDto.getUserName(), loginDto.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateJwtToken(authentication);

        return ResponseEntity.ok(jwt);
    }
    
}
