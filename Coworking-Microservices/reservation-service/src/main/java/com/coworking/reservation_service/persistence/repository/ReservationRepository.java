package com.coworking.reservation_service.persistence.repository;

import com.coworking.reservation_service.persistence.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
