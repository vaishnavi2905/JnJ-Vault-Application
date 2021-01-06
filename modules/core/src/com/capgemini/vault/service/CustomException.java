package com.capgemini.vault.service;

import com.capgemini.vault.entity.ErrorSummary;
import com.capgemini.vault.entity.UploadSummary;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(com.capgemini.vault.service.SheetNotFoundException.class)
    public void handleSheetNotFoundExceptions(SheetNotFoundException ex) {
        System.out.println("Inside custom exception");
        ErrorSummary error = new ErrorSummary(1,2,"abc",ex.getMessage());
        System.out.println("Error object" + error);
    }

    @ExceptionHandler(APIRowValidationException.class)
    public void handleAPIRowValidationExceptions(APIRowValidationException ex) {
        System.out.println("Inside custom exception");
        ErrorSummary error = new ErrorSummary(1,2,"abc",ex.getMessage());
        System.out.println("Error object" + error);
    }

    @ExceptionHandler(Exception.class)
    public void handleAllExceptions(Exception ex) {
        System.out.println("Inside custom exception");
        ErrorSummary error = new ErrorSummary(1,2,"abc",ex.getMessage());
        System.out.println("Error object" + error);
    }
}
