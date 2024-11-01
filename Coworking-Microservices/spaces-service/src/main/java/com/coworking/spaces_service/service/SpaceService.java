package com.coworking.spaces_service.service;

import com.coworking.spaces_service.presentation.dto.EquipmentDto;
import com.coworking.spaces_service.presentation.dto.SpaceDto;

import java.util.List;

public interface SpaceService {

    public List<SpaceDto> getFilteredSpaces(String city, String district, String type);
}
