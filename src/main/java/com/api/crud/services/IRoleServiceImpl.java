package com.api.crud.services;

import com.api.crud.models.ERole;
import com.api.crud.models.Role;
import com.api.crud.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "roleService")
public class IRoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public Role findByName(ERole name) {
        return roleRepository.findRoleByName(name).orElse(null);
    }
}