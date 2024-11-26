package com.coworking.membership_service.presentation.DTO;

public record InvoiceRequest(
        Long reservationId,
        Long userId,
        Double totalCost,
        String paymentMethod
) {

}
