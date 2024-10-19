package com.coworking.coworkingSpaces.persistence.repository;

import com.coworking.coworkingSpaces.persistence.entity.Spaces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpaceRepository extends JpaRepository<Spaces, Long> {
}
