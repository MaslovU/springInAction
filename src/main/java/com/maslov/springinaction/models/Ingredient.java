package com.maslov.springinaction.models;

import com.maslov.springinaction.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Ingredient {

    @Id
    private Long id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Type type;

}
