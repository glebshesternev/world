package com.world.service;

import com.world.exception.PlanetAlreadyExists;
import com.world.model.Planet;
import com.world.model.Wizard;
import com.world.repository.PlanetRepo;
import com.world.repository.WizardRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class MainService {
    PlanetRepo planetRepo;
    WizardRepo wizardRepo;

    public MainService(PlanetRepo planetRepo, WizardRepo wizardRepo) {
        this.planetRepo = planetRepo;
        this.wizardRepo = wizardRepo;
    }

    public Planet addPlanet(Planet planet) throws PlanetAlreadyExists {
        List<Planet> test = planetRepo.findByName(planet.getName());
        if (test.size() != 0)
            throw new PlanetAlreadyExists("Planet already exist");
        return planetRepo.save(planet);
    }

    public List<Planet> showPlanets() {
        List<Planet> planets = new ArrayList<>();
        planetRepo.findAll().forEach(planets :: add);
        return planets;
    }

    public Wizard addWizard(Wizard wizard) {
        return wizardRepo.save(wizard);
    }

    public List<Wizard> showWizards() {
        List<Wizard> wizards = new ArrayList<>();
        wizardRepo.findAll().forEach(wizards::add);
        return wizards;
    }

    public Wizard addPlanetToWizard(String planetName, Long id) {
        Planet planet = planetRepo.findByName(planetName).get(0);
        Wizard wizard = wizardRepo.findById(id).get();
        planet.setWizard(wizard);
        return wizard;
    }

    public List<Planet> detelePlanet(String planetName) {
        return planetRepo.deleteByName(planetName);
    }

    public List<Wizard> freeWizard() {
        List<Wizard> wizards = wizardRepo.findAll();
        List<Wizard> freeWizards = new ArrayList<>();
        for (Wizard wizard : wizards) {
            if (wizard.getPlanets().size() == 0)
            freeWizards.add(wizard);
        }
        return freeWizards;
    }

    public List<Wizard> youngWizards() {
        List<Wizard> wizards = wizardRepo.findAll();
        wizards.sort(new Comparator<Wizard>() {
            @Override
            public int compare(Wizard o1, Wizard o2) {
                if (o1.getAge() == o2.getAge()) return 0;
                else if (o1.getAge()> o2.getAge()) return 1;
                else return -1;
            }

        });
        return wizards;
    }
}
