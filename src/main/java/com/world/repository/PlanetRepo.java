package com.world.repository;

import com.world.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanetRepo extends JpaRepository<Planet, Long> {
    List<Planet> findByName(String name);
    List<Planet> deleteByName(String name);
}
