package com.biscuit.microservice.services;

import com.biscuit.microservice.web.model.ChocolateDto;

public interface ChocolateService {
    ChocolateDto getChocolateById(Long id);
}
