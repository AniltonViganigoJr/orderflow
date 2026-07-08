package com.orderflow.customer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.orderflow.customer.domain.Customer;
import com.orderflow.customer.dto.request.CustomerRequest;
import com.orderflow.customer.dto.response.CustomerResponse;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Customer toEntity(CustomerRequest request);

    CustomerResponse toResponse(Customer customer);
}