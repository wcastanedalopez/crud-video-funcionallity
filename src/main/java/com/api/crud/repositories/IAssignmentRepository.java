package com.api.crud.repositories;

import com.api.crud.entities.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "assignments", collectionResourceRel = "assignments")
public interface IAssignmentRepository  extends JpaRepository<Assignment, Long> {

}
