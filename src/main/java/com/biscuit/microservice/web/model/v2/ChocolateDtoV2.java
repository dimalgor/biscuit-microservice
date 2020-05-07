package com.biscuit.microservice.web.model.v2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChocolateDtoV2 {
    private Long id;
    private String name;
    private ChocolateStyleEnum chocolateStyle;
    private String description;
    private float capacity;
    private int quantityInBox;
    private float boxWeight;
    private int boxesOnPlatformQuantity;
    private String expirationDate;
}
