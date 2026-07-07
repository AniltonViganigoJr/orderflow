package com.orderflow.customer.exception.customer;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException() {
        super("Cliente não encontrado.");
    }

    public CustomerNotFoundException(String msg) {
        super(msg);
    }
}
