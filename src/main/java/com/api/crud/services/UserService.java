package com.api.crud.services;


import com.api.crud.dto.UserDto;
import com.api.crud.entities.User;

import java.util.List;

public interface UserService {
    User save(UserDto user);
    List<User> findAll();
    User findOne(String username);
}