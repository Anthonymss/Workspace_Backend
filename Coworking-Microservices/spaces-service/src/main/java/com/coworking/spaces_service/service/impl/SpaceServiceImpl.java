package com.coworking.spaces_service.service.impl;

import com.coworking.spaces_service.exception.NotFoundSpace;
import com.coworking.spaces_service.persistence.entity.Space;
import com.coworking.spaces_service.persistence.repository.EquipmentRepository;
import com.coworking.spaces_service.persistence.repository.SpaceEquipmentRepository;
import com.coworking.spaces_service.persistence.repository.SpaceRepository;
import com.coworking.spaces_service.presentation.dto.EquipmentDto;
import com.coworking.spaces_service.presentation.dto.SpaceDto;
import com.coworking.spaces_service.service.SpaceService;
import com.coworking.spaces_service.util.enums.SpaceType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SpaceServiceImpl implements SpaceService {

    private final SpaceRepository spaceRepository;
    private final SpaceEquipmentRepository spaceEquipmentRepository;
    private final EquipmentRepository equipmentRepository;
    private final Map<String, List<SpaceDto>> spacesCache = new ConcurrentHashMap<>();//Flyweight cache

    @Override
    public List<SpaceDto> getFilteredSpaces(String city, String district, String type) {
        String cacheKey = generateCacheKey(city, district, type);
        if (spacesCache.containsKey(cacheKey)) {
            System.out.println("Se cargo desde el cache ...");
            return spacesCache.get(cacheKey);
        }
        SpaceType spaceType = null;
        if (type != null && !type.isEmpty()) {
            spaceType = parseSpaceType(type);
        }
        List<Space> spaces = spaceRepository.findSpaces(city, district, spaceType);
        List<SpaceDto> spaceDtos = spaces.stream().map(this::convertToDto).collect(Collectors.toList());

        spacesCache.put(cacheKey, spaceDtos);
        return spaceDtos;
    }

    @Override
    public SpaceDto getSpaceById(Long id) {
        if(!spaceRepository.existsById(id)) {
            throw new NotFoundSpace("No space found with id " + id);
        }
        return convertToDto(spaceRepository.getReferenceById(id));
    }

    @Override
    public BigDecimal getPriceHourById(Long id) {
        if(!spaceRepository.existsById(id)) {
            throw new NotFoundSpace("No space found with id " + id);
        }
        return spaceRepository.getReferenceById(id).getPricePerHour();
    }

    private String generateCacheKey(String city, String district, String type) {
        return String.join("_", city == null ? "" : city, district == null ? "" : district, type == null ? "" : type);
    }

    private SpaceType parseSpaceType(String type) {
        try {
            return SpaceType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid spaceType provided: " + type);
            return null;
        }
    }
    private SpaceDto convertToDto(Space space) {
        String siteName =space.getSite().getCity()+" - "+space.getSite().getDistrict() ;
        List<EquipmentDto> equipmentDtoList = space.getSpaceEquipments().stream()
                .map(equipment -> EquipmentDto.builder()
                        .id(equipment.getEquipment().getId())
                        .name(equipment.getEquipment().getName())
                        .description(equipment.getEquipment().getDescription())
                        .quantity(equipment.getQuantity())
                        .build())
                .collect(Collectors.toList());

        return SpaceDto.builder()
                .id(space.getId())
                .name(space.getName())
                .description(space.getDescription())
                .capacity(space.getCapacity())
                .pricePerHour(space.getPricePerHour())
                .urlImage(space.getUrlImage())
                .siteName(siteName)
                .address(space.getSite().getAddress())
                .spaceType(space.getSpaceType().name())
                .ListEquipment(equipmentDtoList)
                .build();
    }
    public void updateCache() {
        this.spacesCache.clear();
    }
}
