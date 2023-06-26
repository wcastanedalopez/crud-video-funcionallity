package com.api.crud.repository;

import com.api.crud.models.ERole;
import com.api.crud.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RepositoryRestResource(path = "roles", collectionResourceRel = "roles")
public interface IRoleRepository  extends JpaRepository<Role, Long> {
    Optional<Role> findRoleByName(ERole name);
}
