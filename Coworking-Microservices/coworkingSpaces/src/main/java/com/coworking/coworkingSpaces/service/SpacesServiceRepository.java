package com.coworking.coworkingSpaces.service;

import com.coworking.coworkingSpaces.persistence.entity.SpacesDTO;

import java.util.List;

public interface SpacesServiceRepository {

    List<SpacesDTO> getAllSpaces();
}
