package uz.javadev.taskmybates.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.javadev.taskmybates.model.Users;
import uz.javadev.taskmybates.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    private UserRepository userRepository;

    public List<Users> getAllUsers(){
        return userRepository.findAll();
    }

    public Users getUserById(long id){
        return userRepository.findById(id).orElseThrow(null);
    }

    public void addUser(Users user){
        userRepository.insert(user);
    }

    public void updateUser(Users users){

        userRepository.update(users);
    }

    public void deleteUser(long id){
        userRepository.deleteById(id);
    };







}
