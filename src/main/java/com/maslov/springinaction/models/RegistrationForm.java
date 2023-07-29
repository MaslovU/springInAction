package com.maslov.springinaction.models;

import com.maslov.springinaction.enums.Role;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {

    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String role;

    public UserTaco toUser(PasswordEncoder passwordEncoder) {
        return new UserTaco(username, passwordEncoder.encode(password), fullname, street, city, state, zip, phone, Role.USER);
    }
}
