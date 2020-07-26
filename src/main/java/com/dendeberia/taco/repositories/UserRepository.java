package com.dendeberia.taco.repositories;

import com.dendeberia.taco.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
