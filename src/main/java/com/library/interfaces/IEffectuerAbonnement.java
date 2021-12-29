package com.library.interfaces;

import com.library.entities.Abonnement;
import com.library.entities.Effectuerabonnement;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface IEffectuerAbonnement {

    void create(Effectuerabonnement effectuerabonnement);

    void edit(Effectuerabonnement effectuerabonnement);

    void remove(Effectuerabonnement effectuerabonnement);

    Effectuerabonnement find(Object id);

    void sAbonner(int idAbonnement, int idLecteur) throws ParseException;

    List<Effectuerabonnement> findAll();

    List<Effectuerabonnement> findAllFor(int idLecteur);

}
