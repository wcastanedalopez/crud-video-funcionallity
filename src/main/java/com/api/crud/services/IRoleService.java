package com.api.crud.services;

import com.api.crud.entities.Role;

public interface IRoleService {
    Role findByName(String name);
}