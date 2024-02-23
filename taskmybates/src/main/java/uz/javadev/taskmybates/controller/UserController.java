package uz.javadev.taskmybates.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.javadev.taskmybates.model.Users;
import uz.javadev.taskmybates.service.UsersService;

import java.util.List;

import static uz.javadev.taskmybates.constanta.SwaggerConstants.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UsersService usersService;

    @Operation(description = "Yangi User yaratish",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "User yaratish uchun Post request",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = {
                                    @ExampleObject(value = CREATE_USER_EXAMPLE)
                            }
                    )
            )
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OOK!",content = @Content(mediaType = MediaType.ALL_VALUE,
                    examples = {
                            @ExampleObject(value = CREATE_USER_RESPONSE_SUCCESS_EXAMPLE),
                            @ExampleObject(value = CREATE_USER_RESPONSE_INTERNAL_ERROR_EXAMPLE)
                    },schema = @Schema(implementation = Users.class, subTypes = {Users.class})
            )),
            @ApiResponse(responseCode = "200", description = "Malumotni saqlashda xatolik!",content = @Content(mediaType = MediaType.ALL_VALUE,
                    examples = {
                            @ExampleObject(value = CREATE_USER_RESPONSE_INTERNAL_ERROR_EXAMPLE)
                    }))
        }
    )
    @PostMapping()
    public ResponseEntity<String>  addUser(@RequestBody Users users){
        usersService.addUser(users);
        return ResponseEntity.ok("Muvoffaqiyatli Saqlandi!");
    }

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
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable(value = "id") Integer id){
        usersService.deleteUser(id);
        return "Muvoffaqiyatli o'chirildi!";
    }
}
