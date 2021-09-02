package com.charliekriska.exoplanets.services;

import com.charliekriska.exoplanets.models.Planet;

import java.util.List;

public interface PlanetService {
    public List<Planet> getPlanets(String sortBy);
}
