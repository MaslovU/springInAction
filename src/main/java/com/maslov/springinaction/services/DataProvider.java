package com.maslov.springinaction.services;

import com.maslov.springinaction.models.Ingredient;
import com.maslov.springinaction.models.TacoOrder;

import java.util.List;

public interface DataProvider {
    void saveTacoOrder(TacoOrder tacoOrder);
    List<Ingredient> findAllIngredient();
}
