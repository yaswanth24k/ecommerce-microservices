package com.example.user_service.service;

import com.example.user_service.entity.User;
import com.example.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public User adduser(User user)
    {
        return userRepository.save(user);
    }
    public User getuserbyid(Long id)
    {
        return userRepository.findById(id).orElse(null);
    }
    public List<User> getallusers()
    {
        return userRepository.findAll();
    }
    public User updateuser(Long id,User updateduser)
    {
        User user=getuserbyid(id);
        user.setName(updateduser.getName());
        user.setEmail(updateduser.getEmail());
        return userRepository.save(user);
    }
    public void deleteuser(Long id)
    {
        userRepository.deleteById(id);
    }



}
