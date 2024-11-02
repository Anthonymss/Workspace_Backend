package com.coworking.reservation_service.service;

import com.coworking.reservation_service.presentation.dto.ReservationDto;
import java.util.List;

public interface ReservationService {
    String saveReservation(ReservationDto reservationDto);
    ReservationDto getReservationById(Long id);
}
/*
    private Long id;
    private Long spaceId;
    private Long userId;
    private String startDate;
    private String endDate;
    private boolean status;
    private BigDecimal totalCost;
 */