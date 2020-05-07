package com.biscuit.microservice.services.v2;

import com.biscuit.microservice.web.model.v2.ChocolateDtoV2;
import org.springframework.stereotype.Service;

@Service
public interface ChocolateServiceV2 {
    ChocolateDtoV2 getChocolateById(Long id);

    ChocolateDtoV2 saveNewChocolate(ChocolateDtoV2 chocolateDtoV2);

    void updateChocolate(Long chocolateId, ChocolateDtoV2 chocolateDtoV2);

    void deleteChocolate(Long chocolateId);
}
