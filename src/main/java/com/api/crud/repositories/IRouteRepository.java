package com.api.crud.repositories;

import com.api.crud.models.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@Repository
@RepositoryRestResource(path = "routes", collectionResourceRel = "routes")
public interface IRouteRepository extends JpaRepository <Route, Long> {
}
