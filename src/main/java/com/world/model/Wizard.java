package com.world.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "wizards")
@Data
public class Wizard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private long age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public Collection<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(Collection<Planet> planets) {
        this.planets = planets;
    }

    public void add(Planet planet) {
        planets.add(planet);
    }

    public Wizard() {
    }

    public Wizard(String name, long age) {
        this.name = name;
        this.age = age;
    }

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "wizard_planet",
            joinColumns =
                    { @JoinColumn(name = "wizard_id", referencedColumnName = "id") },
            inverseJoinColumns =
                    { @JoinColumn(name = "planet_id", referencedColumnName = "id") })
    private Collection<Planet> planets;

}
