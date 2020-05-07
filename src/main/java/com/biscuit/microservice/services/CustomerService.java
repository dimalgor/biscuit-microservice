package com.biscuit.microservice.services;

import com.biscuit.microservice.web.model.CustomerDto;

public interface CustomerService {
    CustomerDto getCustomer(Long customerId);

    CustomerDto saveNewCustomer(CustomerDto customerDto);

    void updateCustomer(Long customerId, CustomerDto customerDto);

    void deleteCustomer(Long customerId);
}
