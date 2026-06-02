package com.example.user_service.controller;

import com.example.user_service.entity.User;
import com.example.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping
    public User adduser(@RequestBody User user)
    {
        return userService.adduser(user);
    }
    @GetMapping("/{id}")
    public User getuser(@PathVariable Long id)
    {
        return userService.getuserbyid(id);
    }
    @GetMapping
    public List<User> getallusers()
    {
        return userService.getallusers();
    }
    @PutMapping("/{id}")
    public User updateuser(@PathVariable Long id,@RequestBody User user)
    {
        return userService.updateuser(id,user);
    }
    @DeleteMapping("/{id}")
    public void deleteuser(@PathVariable Long id)
    {
        userService.deleteuser(id);
    }


}
