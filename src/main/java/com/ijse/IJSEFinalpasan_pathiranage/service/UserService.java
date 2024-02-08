package com.ijse.IJSEFinalpasan_pathiranage.service;

import java.util.List;

import com.ijse.IJSEFinalpasan_pathiranage.dto.UserPwdDto;
import com.ijse.IJSEFinalpasan_pathiranage.entity.User;



public interface UserService {
    List<User> getAllUsers();
    User creatUser(User user);
    User getUserById(Long id);
    User changeUserPassword(Long id, UserPwdDto userPwdDto);
}
