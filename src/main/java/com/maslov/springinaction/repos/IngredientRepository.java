package com.maslov.springinaction.repos;

import com.maslov.springinaction.models.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

}
