package com.maslov.springinaction.controllers;

import com.maslov.springinaction.models.Taco;
import com.maslov.springinaction.models.TacoOrder;
import com.maslov.springinaction.repos.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    private OrderRepository repo;

    public OrderController(OrderRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/current")
    public String orderForm(Model model) {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(
            @Valid TacoOrder tacoOrder,
            Errors errors,
            SessionStatus sessionStatus,
            Model model) {
        if (errors.hasErrors()) {
            return "orderForm";
        }
        log.info("Order submitted: {}", tacoOrder);
        repo.save(tacoOrder);
        sessionStatus.setComplete();

        return "redirect:/";
    }
}
