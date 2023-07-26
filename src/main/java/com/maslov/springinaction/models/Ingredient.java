package com.maslov.springinaction.models;

import com.maslov.springinaction.enums.Type;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PACKAGE, force = true)
public class Ingredient implements Persistable<String> {

    @Id
    private String id;

    private String name;
    private Type type;

    @Override
    public boolean isNew() {
        return true;
    }
}
