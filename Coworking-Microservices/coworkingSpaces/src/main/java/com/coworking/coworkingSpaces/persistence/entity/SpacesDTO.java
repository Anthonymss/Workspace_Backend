package com.coworking.coworkingSpaces.persistence.entity;

public record SpacesDTO(
        String address,
        String city,
        String description,
        String image,
        double price,
        Type type
) {
}
