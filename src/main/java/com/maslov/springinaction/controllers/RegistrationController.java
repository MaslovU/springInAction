package com.maslov.springinaction.controllers;

import com.maslov.springinaction.models.RegistrationForm;
import com.maslov.springinaction.repos.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final UserRepo userRepo;
    private final PasswordEncoder encoder;

    public RegistrationController(UserRepo userRepo, PasswordEncoder encoder) {
        this.userRepo = userRepo;
        this.encoder = encoder;
    }

    @GetMapping
    public String registerForm() {
        return "registration";
    }

    @PostMapping
    public String processRegistration(RegistrationForm form) {
        var res = form.toUser(encoder);

        userRepo.save(form.toUser(encoder));
        return "redirect:/login";
    }
}
