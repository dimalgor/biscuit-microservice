package com.biscuit.microservice.services;

import com.biscuit.microservice.web.model.CustomerDto;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomer(Long customerId) {
        return CustomerDto.builder()
                .id(customerId)
                .name("Dmitriy Gorban").build();
    }
}
