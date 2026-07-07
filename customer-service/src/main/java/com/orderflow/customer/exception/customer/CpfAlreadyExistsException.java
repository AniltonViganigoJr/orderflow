package com.orderflow.customer.exception.customer;

public class CpfAlreadyExistsException extends RuntimeException {

    public CpfAlreadyExistsException() {
        super("Já existe um cliente cadastrado com este CPF.");
    }

    public CpfAlreadyExistsException(String msg) {
        super(msg);
    }
}
