package com.library.implementations;

import com.library.entities.Abonnement;
import com.library.interfaces.IAbonnement;
import com.library.repositories.AbonnementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class AbonnementImpl implements IAbonnement {

    @PersistenceContext
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }

    @Autowired
    AbonnementRepository abonnementRepository;

    @Override
    public Abonnement createAbonnement(Abonnement abonnement) {
        return abonnementRepository.save(abonnement);
    }

    @Override
    public Abonnement updateAbonnement(Abonnement abonnement) {
        return abonnementRepository.save(abonnement);
    }

    @Override
    public void deleteAbonnement(int id) {
        abonnementRepository.deleteById(id);
    }

    @Override
    public Optional<Abonnement> findAbonnement(int id) {
        return abonnementRepository.findById(id);
    }

    @Override
    public List<Abonnement> findAllAbonnements() {
        return abonnementRepository.findAll();
    }

    @Override
    public List<Abonnement> findRange(int[] range) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

}
