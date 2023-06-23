package com.api.crud.repositories;

import com.api.crud.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "roles", collectionResourceRel = "roles")
public interface IRoleRepository  extends JpaRepository<Role, Long> {
}
