package com.bendrioue.expressmenu.exception;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(UUID id) {
        super("User not found with id: " + id);
    }
}
