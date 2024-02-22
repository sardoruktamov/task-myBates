package uz.javadev.taskmybates.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.javadev.taskmybates.mapper.UserMapper;
import uz.javadev.taskmybates.model.User;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/all-users")
    public List<User> getAllUsers(){
        return userMapper.getAllUser();
    }

}
