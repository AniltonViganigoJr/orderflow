package com.orderflow.customer.exception.customer;

public class EmailAlreadyExistsException extends RuntimeException {

    public EmailAlreadyExistsException() {
        super("Já existe um cliente cadastrado com esse e-mail.");
    }

    public EmailAlreadyExistsException(String msg) {
        super(msg);
    }

}
