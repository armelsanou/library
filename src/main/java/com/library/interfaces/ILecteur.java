package com.library.interfaces;

import com.library.entities.Lecteur;

import java.util.List;
import java.util.Optional;

public interface ILecteur {

    Lecteur createLecteur(Lecteur lecteur);

    Lecteur updateLecteur(Lecteur lecteur);

    void deleteLecteur(int id);

    Optional<Lecteur> findLecteur(int id);

    Lecteur findLecteur(Object login, Object pass);

    List<Lecteur> findAllLecteurs();

    int count();

}
