package com.world.controller;


import com.world.model.Planet;
import com.world.model.Wizard;
import com.world.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {
    private MainService service;

    public MainController(MainService service) {
        this.service = service;
    }

    @GetMapping("planets")
    public List<Planet> showPlanets() {
        return service.showPlanets();
    }

    @PostMapping("planets")
    public Planet addPlanet(@RequestBody Planet planet) {
        return service.addPlanet(planet);
    }

    @GetMapping("wizards")
    public List<Wizard> showWizards() {
        return  service.showWizards();
    }

    @PostMapping("/wizards")
    public Wizard addWizard(@RequestBody Wizard wizard) {
        return service.addWizard(wizard);
    }

    @PutMapping("/wizard/{id}")
    public Wizard addPlanetToWizard(@PathVariable("id") Long id,  @RequestBody String planetName){
        return service.addPlanetToWizard(planetName, id);
    }

    @DeleteMapping("planets")
    public List<Planet> deletePlanet(@RequestBody String planetName) {
        return service.detelePlanet(planetName);
    }

    @GetMapping("freeWizard")
    public List<Wizard> getFreeWizard() {
        return service.freeWizard();
    }

    @GetMapping("youngWizards")
    public List<Wizard> youngWizards() {
        return service.youngWizards();
    }
}

