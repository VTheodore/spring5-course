package org.vezenkov.cookingrecipes.util;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.Errors;

import java.util.List;
import java.util.stream.Collectors;

public class ErrorHandlingUtil {
    public static List<String> getViolationsAsStringList(Errors errors) {
        List<String> violations = errors
                .getGlobalErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        violations.addAll(errors
                .getFieldErrors()
                .stream()
                .map(err -> err.getField() + " = " + err.getRejectedValue() + ": " + err.getDefaultMessage())
                .collect(Collectors.toList())
        );

        return violations;
    }
}
