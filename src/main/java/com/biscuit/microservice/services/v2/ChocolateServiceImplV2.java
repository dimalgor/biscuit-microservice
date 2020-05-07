package com.biscuit.microservice.services.v2;

import com.biscuit.microservice.web.model.v2.ChocolateDtoV2;
import com.biscuit.microservice.web.model.v2.ChocolateStyleEnum;
import org.springframework.stereotype.Service;

@Service
public class ChocolateServiceImplV2 implements ChocolateServiceV2 {
    @Override
    public ChocolateDtoV2 getChocolateById(Long id) {
        return ChocolateDtoV2.builder()
                .id(id)
                .name("Old collection")
                .chocolateStyle(ChocolateStyleEnum.MILK)
                .description("Milk Chocolate with nuts")
                .capacity(0.2f)
                .quantityInBox(16)
                .boxWeight(3.2f)
                .boxesOnPlatformQuantity(84)
                .expirationDate("7 months")
                .build();
    }

    @Override
    public ChocolateDtoV2 saveNewChocolate(ChocolateDtoV2 chocolateDtoV2) {
        return ChocolateDtoV2.builder().id(5L).build();
    }

    @Override
    public void updateChocolate(Long chocolateId, ChocolateDtoV2 chocolateDtoV2) {
        // todo implement updating chocolate here
    }

    @Override
    public void deleteChocolate(Long chocolateId) {
        // todo implement delete logic
    }
}
