package com.world.repository;

import com.world.model.Wizard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WizardRepo extends JpaRepository<Wizard, Long> {
}
