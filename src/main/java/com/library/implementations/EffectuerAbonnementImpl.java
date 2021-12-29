package com.library.implementations;

import com.library.entities.Abonnement;
import com.library.entities.Effectuerabonnement;
import com.library.interfaces.IEffectuerAbonnement;
import com.library.repositories.EffectuerAbonnementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class EffectuerAbonnementImpl implements IEffectuerAbonnement {

    @PersistenceContext
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }

    @Autowired
    EffectuerAbonnementRepository effectuerabonnementRepository;

    @Override
    public void create(Effectuerabonnement effectuerabonnement) {

    }

    @Override
    public void edit(Effectuerabonnement effectuerabonnement) {

    }

    @Override
    public void remove(Effectuerabonnement effectuerabonnement) {

    }

    @Override
    public Effectuerabonnement find(Object id) {
        return null;
    }

    @Override
    public void sAbonner(int idAbonnement, int idLecteur) throws ParseException {

        Abonnement abonnement = getEntityManager().find(Abonnement.class, idAbonnement);

        LocalDate date1 = LocalDate.now(); //Date d'Abonnement

        LocalDate date2 = date1.plusWeeks(Long.parseLong(abonnement.getPeriode())); // Date retour de fin d'abonnement

        Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(date1));

        Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(date2));

        Effectuerabonnement e = new Effectuerabonnement(
                idLecteur,
                abonnement.getIdAbonnement(), startDate
        );

        e.setDateFinAbonnement(endDate);

        //getEntityManager().persist(e);
        effectuerabonnementRepository.save(e);
    }

    @Override
    public List<Effectuerabonnement> findAll() {
        return effectuerabonnementRepository.findAll();
    }

    @Override
    public List<Effectuerabonnement> findAllFor(int idLecteur) {
        Query query = getEntityManager().createQuery("SELECT e FROM Effectuerabonnement e WHERE e.effectuerabonnementPK.idLecteur = :idLecteur")
                .setParameter("idLecteur", idLecteur);
        return query.getResultList();
    }


}
