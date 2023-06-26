package com.api.crud.services;


import com.api.crud.dto.UserDto;
import com.api.crud.models.User;

import java.util.List;

public interface UserService {
    User save(UserDto user);
    List<User> findAll();
    User findOne(String username);

    Boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}