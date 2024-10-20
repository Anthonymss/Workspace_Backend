package com.coworking.coworkingSpaces.presentation;

import com.coworking.coworkingSpaces.persistence.entity.SpacesDTO;
import com.coworking.coworkingSpaces.service.impl.SpacesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/spaces")
public class SpacesController {

    private final SpacesService spacesService;

    public SpacesController(SpacesService spacesService) {
        this.spacesService = spacesService;
    }

    @GetMapping
    public ResponseEntity<List<SpacesDTO>> getAllSpaces() {
        return ResponseEntity.ok(spacesService.getAllSpaces());
    }
}
