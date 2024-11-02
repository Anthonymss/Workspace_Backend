package com.coworking.reservation_service.presentation.controller;

import com.coworking.reservation_service.presentation.dto.ReservationDto;
import com.coworking.reservation_service.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping
    public ResponseEntity<String>saveResservation(@RequestBody ReservationDto reservationDto){
        System.out.println("::::: => "+reservationDto);
        return ResponseEntity.ok(reservationService.saveReservation(reservationDto));
    }
}
