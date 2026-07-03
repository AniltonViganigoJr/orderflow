package com.orderflow.customer.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.orderflow.customer.entity.Customer;
import com.orderflow.customer.repository.CustomerRepository;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository repository;

    @Test
    void shouldSaveCustomer() {

        Customer customer = Customer.builder()
                .name("Anilton")
                .email("anilton@email.com")
                .cpf("12345678900")
                .createdAt(LocalDateTime.now())
                .build();

        Customer saved = repository.save(customer);

        assertNotNull(saved.getId());
    }
}