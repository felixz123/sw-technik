package com.project.zulassungssystem;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

/**
 * Spring Data JPA automatically generates the repository implementation.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByLastName(String lastName);

    User findById(long id);
    Optional <User> findByEmail(String email);
}