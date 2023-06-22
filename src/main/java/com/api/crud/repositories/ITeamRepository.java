package com.api.crud.repositories;

import com.api.crud.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "teams", collectionResourceRel = "teams")
public interface ITeamRepository extends JpaRepository<Team, Long> {
}
