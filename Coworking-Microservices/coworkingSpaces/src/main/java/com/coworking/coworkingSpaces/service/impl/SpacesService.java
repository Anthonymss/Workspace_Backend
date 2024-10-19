package com.coworking.coworkingSpaces.service.impl;

import com.coworking.coworkingSpaces.persistence.entity.SpacesDTO;
import com.coworking.coworkingSpaces.persistence.repository.SpaceRepository;
import com.coworking.coworkingSpaces.service.SpacesServiceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpacesService implements SpacesServiceRepository {

    private final SpaceRepository spaceRepository;

    public SpacesService(SpaceRepository spaceRepository) {
        this.spaceRepository = spaceRepository;
    }

    @Override
    public List<SpacesDTO> getAllSpaces() {
        List<SpacesDTO> getAllSpaces = new ArrayList<>();
        spaceRepository.findAll().forEach(spaces -> {
            getAllSpaces.add(new SpacesDTO(
                    spaces.getAddress(),
                    spaces.getCity(),
                    spaces.getDescription(),
                    spaces.getImage(),
                    spaces.getPrice(),
                    spaces.getType()
            ));
        });
        return getAllSpaces;
    }
}
