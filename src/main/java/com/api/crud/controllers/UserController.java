package com.api.crud.controllers;

import com.api.crud.models.UserModel;
import com.api.crud.services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ArrayList<UserModel> getUsers(){
        return this.userService.getUsers();
    }

    @PostMapping
    public UserModel saveUsers( @RequestBody UserModel user){
        return this.userService.saveUser(user);
    }

    @GetMapping (path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable Long id) {
        return this.userService.getById(id);
    }

    @PostMapping(path = "/{id}")
    public UserModel updateUserById (@RequestBody UserModel user, Long id ) {
         return this.userService.updateById(user, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteUserById ( @PathVariable ("id") Long id) {
        boolean ok = this.userService.deleteById(id);

        if (ok ) {
            return "User with id" + id + "has delete";
        } else {
            return "Error, we have a problem for delete user with this id";
        }
    }





}
