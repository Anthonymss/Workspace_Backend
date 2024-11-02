package com.coworking.reservation_service.presentation.dto;

import lombok.*;
import java.math.BigDecimal;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {
    private Long id;
    private Long spaceId;
    private Long userId;
    private Date startDate;
    private Date endDate;
    private boolean status;
    private BigDecimal totalCost;
    private String comments;

}