package com.coworking.reservation_service.service.impl;

import com.coworking.reservation_service.persistence.entity.Reservation;
import com.coworking.reservation_service.service.CostCalculator;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;

@Service
public class HourlyCostCalculator implements CostCalculator {
    @Override
    public BigDecimal calculate(BigDecimal pricePerHour, Reservation reservation) {
        long totalHours = Duration.between(reservation.getStartDate(), reservation.getEndDate()).toHours();
        return pricePerHour.multiply(BigDecimal.valueOf(totalHours));
    }
}