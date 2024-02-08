package com.ijse.IJSEFinalpasan_pathiranage.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ijse.IJSEFinalpasan_pathiranage.entity.User;




@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    
    Optional<User> findByUserName(String userName);

    Boolean existsByUserName(String userName);

    Boolean existsByEmail(String email);
}
