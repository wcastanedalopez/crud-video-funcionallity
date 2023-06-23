package com.api.crud.repository;

import com.api.crud.entities.Employed;
import com.api.crud.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "employees", collectionResourceRel = "employees")
public interface IEmployedRepository extends JpaRepository<Employed, Integer> {
}
