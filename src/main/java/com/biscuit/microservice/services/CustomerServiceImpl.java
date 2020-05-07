package com.biscuit.microservice.services;

import com.biscuit.microservice.web.model.CustomerDto;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomer(Long customerId) {
        return CustomerDto.builder()
                .id(customerId)
                .name("Dmitriy Gorban").build();
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        return CustomerDto.builder()
                .id(customerDto.getId())
                .name(customerDto.getName()).build();
    }

    @Override
    public void updateCustomer(Long customerId, CustomerDto customerDto) {
        log.debug("Updating Customer with id: " + customerId);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        log.debug("Deleting Customer with Id: " + customerId);
    }
}
