package com.lpu.LibraryManagmentAPI.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lpu.LibraryManagmentAPI.Entity.UserEntity;
import com.lpu.LibraryManagmentAPI.Resopsitory.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //  CREATE - Create new user
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    //  READ - Get all users
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    //  READ - Get user by ID
    public UserEntity getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    //  UPDATE - Update user details
    public UserEntity updateUser(Long id, UserEntity updatedUser) {
        UserEntity existing = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        existing.setName(updatedUser.getName());
        existing.setUsername(updatedUser.getUsername());

        if (updatedUser.getProfile() != null) {
            existing.setProfile(updatedUser.getProfile());
        }

        return userRepository.save(existing);
    }

    //  DELETE - Delete user by ID
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }
}