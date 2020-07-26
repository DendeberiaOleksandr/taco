package com.dendeberia.taco.repositories;

import com.dendeberia.taco.entities.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
