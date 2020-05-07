package com.biscuit.microservice.services;

import com.biscuit.microservice.web.model.ChocolateDto;

public interface ChocolateService {
    ChocolateDto getChocolateById(Long id);

    ChocolateDto saveNewChocolate(ChocolateDto chocolateDto);

    void updateChocolate(Long chocolateId, ChocolateDto chocolateDto);

    void deleteChocolate(Long chocolateId);
}
