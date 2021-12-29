package com.library.implementations;

import com.library.entities.Etatlivre;
import com.library.interfaces.IEtatLivre;
import com.library.repositories.EtatlivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class EtatLivreImpl implements IEtatLivre {

    @PersistenceContext
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }

    @Autowired
    EtatlivreRepository etatLivreRepository;

    @Override
    public Etatlivre createEtatLivre(Etatlivre etatLivre) {
        return etatLivreRepository.save(etatLivre);
    }

    @Override
    public Etatlivre updateEtatLivre(Etatlivre etatLivre) {
        return etatLivreRepository.save(etatLivre);
    }

    @Override
    public void deleteEtatLivre(int id) {
        etatLivreRepository.deleteById(id);
    }

    @Override
    public Optional<Etatlivre> findEtatLivre(int id) {
        return etatLivreRepository.findById(id);
    }

    @Override
    public List<Etatlivre> findAllEtatLivres() {
        return etatLivreRepository.findAll();
    }

}
