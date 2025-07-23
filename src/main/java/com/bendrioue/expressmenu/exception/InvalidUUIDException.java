package com.bendrioue.expressmenu.exception;

public class InvalidUUIDException extends RuntimeException {
    public InvalidUUIDException(String invalidUUID) {
        super("Invalid UUID format: " + invalidUUID);
    }
}