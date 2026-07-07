package com.orderflow.customer.exception.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.orderflow.customer.exception.customer.CpfAlreadyExistsException;
import com.orderflow.customer.exception.customer.CustomerNotFoundException;
import com.orderflow.customer.exception.customer.EmailAlreadyExistsException;
import com.orderflow.customer.exception.response.ErrorResponse;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCustomerNotFound(
            CustomerNotFoundException ex,
            HttpServletRequest request) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                buildErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage(), request));
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleEmailAlreadyExists(
            EmailAlreadyExistsException ex,
            HttpServletRequest request) {

        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                buildErrorResponse(HttpStatus.CONFLICT, ex.getMessage(), request));
    }

    @ExceptionHandler(CpfAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleCpfAlreadyExists(
            CpfAlreadyExistsException ex,
            HttpServletRequest request) {

        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                buildErrorResponse(HttpStatus.CONFLICT, ex.getMessage(), request));
    }

    private ErrorResponse buildErrorResponse(HttpStatus status, String msg, HttpServletRequest request) {
        return new ErrorResponse(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                msg,
                request.getRequestURI());
    }
}
