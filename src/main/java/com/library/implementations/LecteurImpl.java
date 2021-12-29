package com.library.implementations;

import com.library.entities.Lecteur;
import com.library.interfaces.ILecteur;
import com.library.repositories.LecteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service
public class LecteurImpl implements ILecteur {

    @PersistenceContext
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }

    @Autowired
    LecteurRepository lecteurRepository;

    @Override
    public Lecteur createLecteur(Lecteur lecteur) {
        return lecteurRepository.save(lecteur);
    }

    @Override
    public Lecteur updateLecteur(Lecteur lecteur) {
        return lecteurRepository.save(lecteur);
    }

    @Override
    public void deleteLecteur(int id) {
        lecteurRepository.deleteById(id);
    }

    @Override
    public Optional<Lecteur> findLecteur(int id) {
        return lecteurRepository.findById(id);
    }

    @Override
    public Lecteur findLecteur(Object login, Object pass) {
        System.out.println("params"+login +" "+pass);
        try {
            Query query = getEntityManager().createNamedQuery("Lecteur.findByLoginAndPass")
                    .setParameter("login", login)
                    .setParameter("mdp", pass);
            return (Lecteur) query.getSingleResult();
        }catch (Exception e){
            System.out.println("exception "+e.getMessage());
        }
        return null;
    }

    @Override
    public List<Lecteur> findAllLecteurs() {
        return lecteurRepository.findAll();
    }

    @Override
    public int count() {
        return 0;
    }
}
