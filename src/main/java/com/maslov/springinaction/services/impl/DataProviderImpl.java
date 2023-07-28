package com.maslov.springinaction.services.impl;

import com.maslov.springinaction.models.Ingredient;
import com.maslov.springinaction.models.TacoOrder;
import com.maslov.springinaction.repos.IngredientRepository;
import com.maslov.springinaction.repos.OrderRepository;
import com.maslov.springinaction.services.DataProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataProviderImpl implements DataProvider {

    private final OrderRepository orderRepository;
    private final IngredientRepository ingredientRepository;

    public DataProviderImpl(OrderRepository repository, IngredientRepository ingredientRepository) {
        this.orderRepository = repository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void saveTacoOrder(TacoOrder tacoOrder) {
        orderRepository.save(tacoOrder);
    }

    @Override
    public List<Ingredient> findAllIngredient() {
        return (List<Ingredient>) ingredientRepository.findAll();
    }
}
