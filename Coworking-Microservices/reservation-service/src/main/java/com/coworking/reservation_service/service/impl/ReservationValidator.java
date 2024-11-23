package com.coworking.reservation_service.service.impl;

import com.coworking.reservation_service.exception.ReservationConflictException;
import com.coworking.reservation_service.persistence.entity.Reservation;
import com.coworking.reservation_service.persistence.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationValidator {
    private final ReservationRepository reservationRepository;

    public void validateConflict(Reservation reservation) {
        boolean conflict = reservationRepository.existsBySpaceIdAndTimeRange(
                reservation.getSpaceId(),
                reservation.getStartDate(),
                reservation.getEndDate()
        );
        if (conflict) {
            throw new ReservationConflictException("El espacio ya está reservado en el horario seleccionado.");
        }
    }
}