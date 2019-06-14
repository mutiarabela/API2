package com.restapi.airlines.exception;

public class AirlineNotFoundException extends RuntimeException {
    public AirlineNotFoundException() { super("User ID not Found"); }
    public AirlineNotFoundException(String message) { super(message); }
}
