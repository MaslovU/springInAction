package com.maslov.springinaction.services.impl;

import com.maslov.springinaction.models.Ingredient;
import com.maslov.springinaction.services.DataProvider;
import com.maslov.springinaction.services.IngredientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final DataProvider provider;

    public IngredientServiceImpl(DataProvider provider) {
        this.provider = provider;
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return provider.findAllIngredient();
    }
}
