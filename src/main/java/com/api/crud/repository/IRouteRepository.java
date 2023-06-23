package com.api.crud.repository;

import com.api.crud.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@Repository
@RepositoryRestResource(path = "routes", collectionResourceRel = "routes")
public interface IRouteRepository extends JpaRepository <Route, Long> {
}
