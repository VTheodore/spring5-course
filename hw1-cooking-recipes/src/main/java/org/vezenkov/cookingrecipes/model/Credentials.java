package org.vezenkov.cookingrecipes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Credentials {
    @NotNull
    @Length(min = 3, max = 15)
    private String username;

    @NotNull
    @Length(min = 8)
    private String password;
}
