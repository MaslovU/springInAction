package com.maslov.springinaction.utils;

import com.maslov.springinaction.models.Ingredient;
import com.maslov.springinaction.repos.IngredientRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private final IngredientRepository repo;

    public IngredientByIdConverter(IngredientRepository repo) {
        this.repo = repo;
    }

    @Override
    public Ingredient convert(String id) {
        return repo.findById(id).orElse(null);
    }
}