package com.library.interfaces;

import com.library.entities.Categorie;

import java.util.List;
import java.util.Optional;

public interface ICategorie {

    Categorie createCategorie(Categorie categorie);

    Categorie updateCategorie(Categorie categorie);

    void deleteCategorie(int id);

    Optional<Categorie> findCategorie(int id);

    List<Categorie> findAllCategories();

}
