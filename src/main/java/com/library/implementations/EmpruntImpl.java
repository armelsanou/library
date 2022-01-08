package com.library.implementations;

import com.library.entities.Effectuerabonnement;
import com.library.entities.Emprunt;
import com.library.entities.EmpruntPK;
import com.library.interfaces.IEmprunt;
import com.library.repositories.EmpruntRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class EmpruntImpl implements IEmprunt {

    @PersistenceContext
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }

    @Autowired
    EmpruntRepository empruntRepository;

    @Autowired
    EffectuerAbonnementImpl effectuerAbonnement;

    @Override
    public void create(Emprunt emprunt) {

    }

    @Override
    public void editDate(Emprunt e) {
        Emprunt emprunt = new Emprunt();
        emprunt = find(e.getEmpruntPK());
        emprunt.setDateRetourEff(e.getDateRetourEff());
    }

    @Override
    public void remove(Emprunt emprunt) {

    }

    @Override
    public ResponseEntity<Emprunt> emprunterLivre(int isbn, int idLecteur) {

        List<Effectuerabonnement> abonnementsLecteurList = effectuerAbonnement.findAllFor(idLecteur);

        String format = "yyyy/MM/dd";

        SimpleDateFormat formater = new SimpleDateFormat(format);

        Date date1 = new Date(); // Date d'Emprunt

        Date date2 = null; // Date retout théorique

        //Si un lecteur a souscrit à plusieurs abonnements, la date de retour sera celle de l'abonnement le plus grand
        if (abonnementsLecteurList.size() > 0){
            if (abonnementsLecteurList.size() == 1){
                date2 = abonnementsLecteurList.get(0).getDateFinAbonnement();
            }else{
                abonnementsLecteurList.sort((dat1, dat2) -> dat1.getDateFinAbonnement().compareTo(dat2.getDateFinAbonnement()));
                date2 = abonnementsLecteurList.get(abonnementsLecteurList.size()-1).getDateFinAbonnement();
            }
            if(date2.compareTo(date1) > 0 || date2.compareTo(date1) == 0) {
                Emprunt e = new Emprunt(isbn, idLecteur, date1);
                e.setNbrAvertissement(0);
                e.setDateRetourTheo(date2);
                return ResponseEntity.ok(empruntRepository.save(e));
                //return ResponseEntity.ok("Le livre ayant pour code ISBN "+isbn+" a été emprunté avec succès; vous devez le remettre le: "+date2);
            } else {
                //return ResponseEntity.ok("Votre abonnement est fini veuillez renouveler");
                return ResponseEntity.ok(null);
            }
        }{
            //return ResponseEntity.ok("Vous devez prendre un abonnement");
            return ResponseEntity.ok(null);
        }
    }

    @Override
    public Emprunt find(int isbn, int idLecteur, Date dateEmprunt) {
        Query query = getEntityManager().createQuery("SELECT e FROM Emprunt e WHERE e.empruntPK.isbn = :isbn AND e.empruntPK.idLecteur = :idLecteur AND e.empruntPK.dateEmprunt = :dateEmprunt")
                .setParameter("idLecteur", idLecteur)
                .setParameter("isbn", isbn)
                .setParameter("dateEmprunt", dateEmprunt);
        return (Emprunt) query.getSingleResult();
    }

    @Override
    public Emprunt find(EmpruntPK epk){
        return (Emprunt) getEntityManager().find(Emprunt.class, epk);
    }

    @Override
    public Emprunt edit(Emprunt entity) {
        return empruntRepository.save(entity);
    }

    @Override
    public List<Emprunt> findAll() {
        return getEntityManager().createQuery("SELECT e FROM Emprunt e").getResultList();
    }

    @Override
    public Emprunt avertirLecteur(int isbn, int idLecteur, Date dateEmprunt) {
        Emprunt emprunt = (Emprunt) this.find(isbn, idLecteur,dateEmprunt);
        emprunt.setNbrAvertissement(emprunt.getNbrAvertissement()+1);
        return empruntRepository.save(emprunt);
    }

    @Override
    public Emprunt remettreLivre(int isbn, int idLecteur, Date dateEmprunt) throws ParseException {
        Emprunt emprunt = (Emprunt) this.find(isbn, idLecteur,dateEmprunt);

        LocalDate date1 = LocalDate.now(); //Date retour

        Date dateRetourEff = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(date1));

        emprunt.setDateRetourEff(dateRetourEff);

        return empruntRepository.save(emprunt);
    }

    @Override
    public Emprunt nonRemis(int isbn, int idLecteur) {
        Query query = getEntityManager().createQuery("SELECT e FROM Emprunt e WHERE e.empruntPK.isbn = :isbn AND e.empruntPK.idLecteur = :idLecteur AND e.dateRetourEff is null")
                .setParameter("idLecteur", idLecteur)
                .setParameter("isbn", isbn);
        return (Emprunt) query.getSingleResult();
    }

    @Override
    public List<Emprunt> findAllByIdLecteur(int idLecteur) {
        return getEntityManager().createNamedQuery("Emprunt.findByIdLecteur").setParameter("idLecteur", idLecteur).getResultList();
    }


}
