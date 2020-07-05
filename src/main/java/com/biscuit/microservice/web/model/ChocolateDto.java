package com.biscuit.microservice.web.model;

import io.micrometer.core.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChocolateDto {

    @NotNull
    private Long id;

    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @Positive
    private float capacity;
    @Positive
    private int quantityInBox;
    @Positive
    private float boxWeight;
    @Positive
    private int boxesOnPlatformQuantity;
    @NotBlank
    private String expirationDate;
}
