package com.coworking.spaces_service.service;

import com.coworking.spaces_service.presentation.dto.SpaceDto;
import com.coworking.spaces_service.presentation.dto.SpaceResponseDto;

import java.math.BigDecimal;
import java.util.List;

public interface SpaceService {

    public List<SpaceDto> getFilteredSpaces(String city, String district, String type);
    public SpaceDto getSpaceById(Long id);
    public SpaceResponseDto getInfoSpace(Long id);
}
