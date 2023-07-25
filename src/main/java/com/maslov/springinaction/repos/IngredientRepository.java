package com.maslov.springinaction.repos;

import com.maslov.springinaction.models.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
