package com.biscuit.microservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChocolateDto {
    private Long id;
    private String name;
    private String description;
    private float capacity;
    private int quantityInBox;
    private float boxWeight;
    private int boxesOnPlatformQuantity;
    private String expirationDate;
}
