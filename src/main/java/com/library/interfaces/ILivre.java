package com.library.interfaces;

import com.library.entities.Categorie;
import com.library.entities.Livre;

import java.util.List;
import java.util.Optional;

public interface ILivre {

    Livre createLivre(Livre livre);

    Livre updateLivre(Livre livre);

    void deleteLivre(Integer isbn);

    Optional<Livre> findLivre(Integer isbn);

    List<Livre> findAllLivres();

    List<Livre> findAllLivresNonEmpruntes();

    List<Livre> findAllLivreByCategorie(Categorie idCategorie);

}
