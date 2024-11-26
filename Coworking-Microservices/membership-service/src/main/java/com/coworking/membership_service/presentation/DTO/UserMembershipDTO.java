package com.coworking.membership_service.presentation.DTO;

import com.coworking.membership_service.util.MembershipStatus;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record UserMembershipDTO(
        Long userId,
        Long membershipId,
        LocalDate startDate,
        MembershipStatus status,
        String paymentMethod
) {
}
