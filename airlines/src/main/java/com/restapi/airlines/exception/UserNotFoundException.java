package com.restapi.airlines.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() { super("User ID not Found"); }
    public UserNotFoundException(String message) { super(message); }
}
