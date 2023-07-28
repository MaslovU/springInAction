package com.maslov.springinaction.services;

import com.maslov.springinaction.models.Ingredient;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IngredientService {
    List<Ingredient> getAllIngredients();
}
