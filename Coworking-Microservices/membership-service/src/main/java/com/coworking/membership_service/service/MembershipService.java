package com.coworking.membership_service.service;

import com.coworking.membership_service.presentation.DTO.MembershipDTO;

import java.util.List;

public interface MembershipService {

    List<MembershipDTO> getAllMemberships();
}
