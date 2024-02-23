package uz.javadev.taskmybates.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.javadev.taskmybates.model.Users;
import uz.javadev.taskmybates.service.UsersService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/all-users")
    public List<Users> getAllUsers(){
        return usersService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public Users getUserById(@PathVariable(value = "id") long id){
        return usersService.getUserById(id);
    }

    @PutMapping()
    public String updateUserById(@RequestBody Users users){
        usersService.updateUser(users);
        return "Muvoffaqiyatli O'zgartirildi!";
    }

    @PostMapping()
    public ResponseEntity<String>  addUser(@RequestBody Users users){
        usersService.addUser(users);
        return ResponseEntity.ok("Muvoffaqiyatli Saqlandi!");
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable(value = "id") Integer id){
        usersService.deleteUser(id);
        return "Muvoffaqiyatli o'chirildi!";
    }
}
