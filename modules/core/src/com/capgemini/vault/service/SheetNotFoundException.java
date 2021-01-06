package com.capgemini.vault.service;

import com.haulmont.cuba.core.global.SupportedByClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SupportedByClient
public class SheetNotFoundException extends Exception{

    public SheetNotFoundException(String message) {
        super(message);
        System.out.println("In sheet not found");
    }

    public SheetNotFoundException() {

    }
}
