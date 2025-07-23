package com.bendrioue.expressmenu.exception;

import java.util.UUID;

public class MenuNotFoundException extends RuntimeException {
    public MenuNotFoundException(UUID id) {
        super("Menu not found with id: " + id);
    }
}