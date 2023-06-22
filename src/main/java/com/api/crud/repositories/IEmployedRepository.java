package com.api.crud.repositories;

import com.api.crud.models.Employed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "employees", collectionResourceRel = "employees")
public interface IEmployedRepository extends JpaRepository<Employed, Integer> {
}
