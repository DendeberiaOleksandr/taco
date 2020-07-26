package com.dendeberia.taco.repositories;

import com.dendeberia.taco.entities.Taco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface TacoRepository extends CrudRepository<Taco, Long> {

}
