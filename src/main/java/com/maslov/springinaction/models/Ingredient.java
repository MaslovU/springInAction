package com.maslov.springinaction.models;

import com.maslov.springinaction.enums.Type;
import lombok.Data;

@Data
public class Ingredient {

    private final String id;
    private final String name;
    private final Type type;
}
