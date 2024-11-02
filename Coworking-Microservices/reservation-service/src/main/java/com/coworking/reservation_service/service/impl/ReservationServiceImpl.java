package com.coworking.reservation_service.service.impl;

import com.coworking.reservation_service.persistence.entity.Reservation;
import com.coworking.reservation_service.persistence.repository.ReservationRepository;
import com.coworking.reservation_service.presentation.dto.ReservationDto;
import com.coworking.reservation_service.service.ReservationService;
import com.coworking.reservation_service.service.feignclient.SpacesFeignClient;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final SpacesFeignClient spacesFeignClient;
    private final ReservationRepository  reservationRepository;

    @Override
    public String saveReservation(ReservationDto reservationDto) {
        System.out.println("antes de convertir");
        Reservation reservation = convert(reservationDto);
        System.out.println("antes de feign: " + reservation);
        BigDecimal priceHour= spacesFeignClient.getpriceHour(reservationDto.getSpaceId()).getBody();
        System.out.println("precio: despues " + priceHour);
        Long TotalHour=calculateHoursBetweenDates(reservationDto.getStartDate(), reservationDto.getEndDate());
        reservation.setTotalCost(priceHour.multiply(new BigDecimal(TotalHour)));
        System.out.println("Total cost: " + reservation.getTotalCost());
        System.out.println("TotalHOur: " + TotalHour);
        reservationRepository.save(reservation);
        System.out.println("Se guardo..");
        return "Reservation saved successfully";
    }

    @Override
    public ReservationDto getReservationById(Long id) {
        return null;
    }
    private Reservation convert(ReservationDto  reservationDto){
        return Reservation.builder()
                .spaceId(reservationDto.getSpaceId())
                .userId(reservationDto.getUserId())
                .startDate(reservationDto.getStartDate())
                .endDate(reservationDto.getEndDate())
                .comments(reservationDto.getComments())
                .status(true)
                .build();
    }
    public  Long calculateHoursBetweenDates(Date fechaInicio, Date fechaFin) {
        long diferenciaMillis = fechaFin.getTime() - fechaInicio.getTime();
        return diferenciaMillis / (1000 * 60 * 60);
    }
}