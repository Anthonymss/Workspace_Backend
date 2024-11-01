package com.coworking.spaces_service.presentation.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class EquipmentDto {
    private Long id;
    private String name;
    private String description;
    private Integer quantity;
    private BigDecimal equipmentRate;
}