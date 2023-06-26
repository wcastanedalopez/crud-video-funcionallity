package com.api.crud.repository;

import com.api.crud.models.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "registrations", collectionResourceRel = "registrations")
public interface IRegistrationRepository  extends JpaRepository<Registration, Long> {
}
