package com.letscode.usersapi.controller;

import com.letscode.usersapi.dto.UserDTO;
import com.letscode.usersapi.domain.UserEntity;
import com.letscode.usersapi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/users")
@RestController
public class UserController {

    private UserService userService;

    public UserController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<UserEntity> getUsers() {

        return this.userService.getUsers();

    }
    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {

        return this.userService.getUserById(id);

    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public UserEntity createUser (@RequestBody UserEntity user){

        return this.userService.createUser(user);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable Long id) {

        this.userService.deleteUserByID(id);

    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUserById(@RequestBody UserEntity user, @PathVariable Long id) {

        this.userService.updateUserById(user,id);

    }
}
