package com.library.repositories;

import com.library.entities.Abonnement;
import com.library.entities.Effectuerabonnement;
import com.library.entities.EffectuerabonnementPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EffectuerAbonnementRepository extends JpaRepository<Effectuerabonnement, EffectuerabonnementPK> {

}