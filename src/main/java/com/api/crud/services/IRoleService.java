package com.api.crud.services;

import com.api.crud.models.ERole;
import com.api.crud.models.Role;

public interface IRoleService {
    Role findByName(ERole name);
}