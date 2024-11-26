package com.coworking.membership_service.presentation.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public record InvoiceResponse(
        Long id,
        Long userId,
        Long membershipId,
        String invoiceNumber,
        LocalDate fecha,
        BigDecimal subtotal,
        BigDecimal taxAmount,
        BigDecimal totalCost,
        String paymentMethod
) {
}
