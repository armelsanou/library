package com.library.implementations;

import com.library.entities.Rayon;
import com.library.interfaces.IRayon;
import com.library.interfaces.IRayon;
import com.library.repositories.RayonRepository;
import com.library.repositories.RayonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service
public class RayonImpl implements IRayon {

    @PersistenceContext
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }

    @Autowired
    RayonRepository rayonRepository;

    @Override
    public Rayon createRayon(Rayon Rayon) {
        return rayonRepository.save(Rayon);
    }

    @Override
    public Rayon updateRayon(Rayon Rayon) {
        return rayonRepository.save(Rayon);
    }

    @Override
    public void deleteRayon(int id) {
        rayonRepository.deleteById(id);
    }

    @Override
    public Optional<Rayon> findRayon(int id) {
        return rayonRepository.findById(id);
    }

    @Override
    public List<Rayon> findAllRayons() {
        return rayonRepository.findAll();
    }

}
