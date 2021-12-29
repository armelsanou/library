package com.library.interfaces;

import com.library.entities.Abonnement;
import com.library.entities.Categorie;

import java.util.List;
import java.util.Optional;

public interface IAbonnement {

    Abonnement createAbonnement(Abonnement abonnement);

    Abonnement updateAbonnement(Abonnement abonnement);

    void deleteAbonnement(int id);

    Optional<Abonnement> findAbonnement(int id);

    List<Abonnement> findAllAbonnements();

    List<Abonnement> findRange(int[] range);

    int count();

}
