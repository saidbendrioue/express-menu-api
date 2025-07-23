package com.bendrioue.expressmenu.exception;

import java.util.UUID;

public class FastFoodNotFoundException extends RuntimeException {
    public FastFoodNotFoundException(UUID id) {
        super("FastFood not found with id: " + id);
    }
}