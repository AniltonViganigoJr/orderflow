package com.orderflow.customer.service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orderflow.customer.domain.Customer;
import com.orderflow.customer.dto.request.CustomerRequest;
import com.orderflow.customer.dto.response.CustomerResponse;
import com.orderflow.customer.exception.customer.CpfAlreadyExistsException;
import com.orderflow.customer.exception.customer.CustomerNotFoundException;
import com.orderflow.customer.exception.customer.EmailAlreadyExistsException;
import com.orderflow.customer.mapper.CustomerMapper;
import com.orderflow.customer.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Transactional
    public CustomerResponse create(CustomerRequest request) {

        validateCustomerUniqueness(request);

        Customer customer = customerMapper.toEntity(request);

        Customer savedCustomer = customerRepository.save(customer);

        return customerMapper.toResponse(savedCustomer);
    }

    @Transactional(readOnly = true)
    public CustomerResponse findById(UUID id) {
        return customerMapper.toResponse(findCustomerById(id));
    }

    @Transactional(readOnly = true)
    public List<CustomerResponse> findAll() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toResponse)
                .toList();
    }

    @Transactional
    public CustomerResponse update(UUID id, CustomerRequest request) {
        Customer customer = findCustomerById(id);

        if (!Objects.equals(customer.getEmail(), request.email())) {
            validateEmailUniqueness(request.email());
        }

        if (!Objects.equals(customer.getCpf(), request.cpf())) {
            validateCpfUniqueness(request.cpf());
        }

        customer.update(
                request.name(),
                request.email(),
                request.cpf());

        Customer updatedCustomer = customerRepository.save(customer);

        return customerMapper.toResponse(updatedCustomer);
    }

    @Transactional
    public void delete(UUID id) {
        customerRepository.delete(findCustomerById(id));
    }

    private Customer findCustomerById(UUID id) {
        return customerRepository.findById(id)
                .orElseThrow(CustomerNotFoundException::new);

    }

    private void validateEmailUniqueness(String email) {
        if (customerRepository.existsByEmail(email)) {
            throw new EmailAlreadyExistsException();
        }
    }

    private void validateCpfUniqueness(String cpf) {
        if (customerRepository.existsByCpf(cpf)) {
            throw new CpfAlreadyExistsException();
        }
    }

    private void validateCustomerUniqueness(CustomerRequest request) {
        validateEmailUniqueness(request.email());
        validateCpfUniqueness(request.cpf());
    }
}
