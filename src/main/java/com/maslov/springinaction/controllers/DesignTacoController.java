package com.maslov.springinaction.controllers;

import com.maslov.springinaction.enums.Type;
import com.maslov.springinaction.models.Ingredient;
import com.maslov.springinaction.models.Taco;
import com.maslov.springinaction.models.TacoOrder;
import com.maslov.springinaction.repos.IngredientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    private final IngredientRepository repo;

    @Autowired
    public DesignTacoController(IngredientRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @PostMapping
    public String processTaco(@ModelAttribute("design") @Valid Taco taco, Errors errors, Model model) {

        if (errors.hasErrors()) {
            List<Ingredient> ingredients = (List<Ingredient>) repo.findAll();

            Type[] types = Type.values();
            for (Type x : types) {
                model.addAttribute(x.toString().toLowerCase(),
                        ingredients.stream().filter(p -> p.getType().equals(x)).collect(Collectors.toList()));
            }
            return "design";
        }
        log.info("Processing desing: " + taco);

        return "redirect:/orders/current";
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        repo.findAll().forEach(i -> ingredients.add(i));

        Type[] types = Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
    }
}
