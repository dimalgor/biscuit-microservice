package com.biscuit.microservice.services;

import com.biscuit.microservice.web.model.ChocolateDto;
import org.springframework.stereotype.Service;

@Service
public class ChocolateServiceImpl implements ChocolateService {
    @Override
    public ChocolateDto getChocolateById(Long id) {
        return ChocolateDto.builder()
                .id(id)
                .name("Old collection")
                .description("Milk Chocolate with nuts")
                .capacity(0.2f)
                .quantityInBox(16)
                .boxWeight(3.2f)
                .boxesOnPlatformQuantity(84)
                .expirationDate("7 months")
                .build();
    }

    @Override
    public ChocolateDto saveNewChocolate(ChocolateDto chocolateDto) {
        return chocolateDto.builder().id(5L).build();
    }

    @Override
    public void updateChocolate(Long chocolateID, ChocolateDto chocolateDto) {
        // todo implement updating chocolate here
    }

    @Override
    public void deleteChocolate(Long chocolateId) {
        // todo implement delete logic
    }
}
