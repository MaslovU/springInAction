package com.maslov.springinaction.controllers;

import com.maslov.springinaction.models.TacoOrder;
import com.maslov.springinaction.models.UserTaco;
import com.maslov.springinaction.repos.UserRepo;
import com.maslov.springinaction.services.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.security.Principal;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(
            @Valid TacoOrder tacoOrder,
            Errors errors,
            SessionStatus sessionStatus,
            @AuthenticationPrincipal UserTaco user) {
        if (errors.hasErrors()) {
            return "orderForm";
        }

        tacoOrder.setUser(user);

        service.saveOrder(tacoOrder);
        sessionStatus.setComplete();

        return "redirect:/";
    }
}
