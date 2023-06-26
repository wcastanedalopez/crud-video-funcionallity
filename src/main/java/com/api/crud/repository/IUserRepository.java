package com.api.crud.repository;

import com.api.crud.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RepositoryRestResource(path = "users", collectionResourceRel = "users")
public interface IUserRepository extends JpaRepository<User, Long> {
    Optional <User> findByUsername(String username);

    Boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}