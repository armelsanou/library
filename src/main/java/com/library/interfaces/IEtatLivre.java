package com.library.interfaces;

import com.library.entities.Etatlivre;

import java.util.List;
import java.util.Optional;

public interface IEtatLivre {

    Etatlivre createEtatLivre(Etatlivre etatLivre);

    Etatlivre updateEtatLivre(Etatlivre etatLivre);

    void deleteEtatLivre(int id);

    Optional<Etatlivre> findEtatLivre(int id);

    List<Etatlivre> findAllEtatLivres();

}
