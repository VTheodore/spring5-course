package com.vezenkov.restmvc.model;

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
    @Length(min = 3, max = 32)
    private String username;

    @NotNull
    @Length(min = 3, max = 32)
    private String password;
}
