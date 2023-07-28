package com.maslov.springinaction.utils;

import com.maslov.springinaction.models.Ingredient;
import com.maslov.springinaction.repos.IngredientRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientByIdConverter implements Converter<Long, Ingredient> {

    private final IngredientRepository repo;

    public IngredientByIdConverter(IngredientRepository repo) {
        this.repo = repo;
    }

    @Override
    public Ingredient convert(Long id) {
        return repo.findById(id).orElse(null);
    }

}