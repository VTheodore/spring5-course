package org.vezenkov.cookingrecipes.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class JwtResponse {
    private final User user;

    private final String token;
}