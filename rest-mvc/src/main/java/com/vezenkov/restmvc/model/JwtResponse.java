package com.vezenkov.restmvc.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class JwtResponse {
    private final User user;

    private final String token;
}
