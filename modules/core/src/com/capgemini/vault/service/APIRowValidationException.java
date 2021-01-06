package com.capgemini.vault.service;

public class APIRowValidationException extends Exception{

    public APIRowValidationException(String message) {
        super(message);
        System.out.println("In API row validation exception");
    }
    public APIRowValidationException() {

    }
}
