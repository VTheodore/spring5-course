package com.vezenkov.restmvc.util;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ErrorHandlingUtil {

    public static List<String> getViolationsAsStringList(Errors errors) {
        List<String> allErrors = errors
                .getGlobalErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        allErrors.addAll(
                errors
                .getFieldErrors()
                .stream()
                .map(err -> err.getField() + " = " + err.getRejectedValue() + ": " + err.getDefaultMessage())
                .collect(Collectors.toList())
        );

        return allErrors;
    }
}
