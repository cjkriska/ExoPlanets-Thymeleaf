package com.charliekriska.exoplanets.controllers;

import com.charliekriska.exoplanets.models.Planet;
import com.charliekriska.exoplanets.services.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/planets")
public class PlanetListController {

    private PlanetService planetService;

    @Autowired
    public PlanetListController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @GetMapping("/list")
    public String listPlanets(@RequestParam(defaultValue = "") String sortBy, Model theModel) {
        List<Planet> planets = planetService.getPlanets(sortBy);
        theModel.addAttribute("planets", planets);

        return "planet-list";
    }

}
