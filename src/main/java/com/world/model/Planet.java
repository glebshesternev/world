package com.world.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "planets")
public class Planet {

    private @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    private String name;

    public Planet() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Wizard getWizard() {
        return wizard;
    }

    public void setWizard(Wizard wizard) {
        this.wizard = wizard;
    }

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "wizard_planet",
            joinColumns =
                    { @JoinColumn(name = "wizard_id", referencedColumnName = "id") },
            inverseJoinColumns =
                    { @JoinColumn(name = "planet_id", referencedColumnName = "id") })
    private Wizard wizard;
}