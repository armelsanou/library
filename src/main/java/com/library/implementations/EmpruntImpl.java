package com.library.implementations;

import com.library.entities.Emprunt;
import com.library.entities.EmpruntPK;
import com.library.entities.Rayon;
import com.library.interfaces.IEmprunt;
import com.library.interfaces.IRayon;
import com.library.repositories.EmpruntRepository;
import com.library.repositories.EtatlivreRepository;
import com.library.repositories.RayonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmpruntImpl implements IEmprunt {

    @PersistenceContext
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }

    @Autowired
    EmpruntRepository empruntRepository;

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
    public void emprunterLivre(int isbn, int idLecteur) {

        //emprunter un livre revient tout simplement à creer un objet emprunt
        //EmpruntPK k = new EmpruntPK();
        //k.setIsbn(isbn);
        //k.setIdLecteur(idLecteur);

        String format = "yyyy/MM/dd";

        SimpleDateFormat formater = new SimpleDateFormat(format);
        //String dateTexte = " "; //venant de la vue si recuperé en string
        //Date date3 = null;
        //try {
        //     date3 = formater.parse(dateTexte);
        //} catch (ParseException ex) {
        //      Logger.getLogger(LecteurFacade.class.getName()).log(Level.SEVERE, null, ex);
        //}

        Date date1 = new Date(); // Date d'Emprunt

        Date date2 = new Date(); // Date retout théorique

        int annee = date1.getYear();
        int mois = date1.getMonth();
        int jour = date1.getDate();

        if (mois == 9 || mois == 7 || mois == 6 || mois == 4 || mois == 2 || mois == 0) {

            if (jour < 25) {
                jour = jour + 7;
            } else {
                switch (jour) {
                    case 25:
                        jour = 01;
                        mois++;
                        break;
                    case 26:
                        jour = 02;
                        mois++;
                        break;
                    case 27:
                        jour = 03;
                        mois++;
                        break;
                    case 28:
                        jour = 04;
                        mois++;
                        break;
                    case 29:
                        jour = 05;
                        mois++;
                        break;
                    case 30:
                        jour = 06;
                        mois++;
                        break;
                    case 31:
                        jour = 07;
                        mois++;
                        break;
                    default:
                        break;
                }

            }
            date2 = new Date(annee, mois, jour);
        }

        if (mois == 10 || mois == 8 || mois == 5 || mois == 3) {//mois de 30 jours

            if (jour < 24) {
                jour = jour + 7;
            } else {
                switch (jour) {
                    case 24:
                        jour = 01;
                        mois++;
                        break;
                    case 25:
                        jour = 02;
                        mois++;
                        break;
                    case 26:
                        jour = 03;
                        mois++;
                        break;
                    case 27:
                        jour = 04;
                        mois++;
                        break;
                    case 28:
                        jour = 05;
                        mois++;
                        break;
                    case 29:
                        jour = 06;
                        mois++;
                        break;
                    case 30:
                        jour = 07;
                        mois++;
                        break;
                    default:
                        break;
                }
            }
            date2 = new Date(annee, mois, jour);
        }
        if (mois == 11) { //Decembre

            if (jour < 25) {
                jour = jour + 7;
            } else {
                switch (jour) {
                    case 25:
                        jour = 01;
                        mois = 0;
                        annee++;
                        break;
                    case 26:
                        jour = 02;
                        mois = 0;
                        annee++;
                        break;
                    case 27:
                        jour = 03;
                        mois = 0;
                        annee++;
                        break;
                    case 28:
                        jour = 04;
                        mois = 0;
                        annee++;
                        break;
                    case 29:
                        jour = 05;
                        mois = 0;
                        annee++;
                        break;
                    case 30:
                        jour = 06;
                        mois = 0;
                        annee++;
                        break;
                    case 31:
                        jour = 07;
                        mois = 0;
                        annee++;
                        break;
                    default:
                        break;
                }
            }
            date2 = new Date(annee, mois, jour);
        }
        if (mois == 1) {//mois de 30 jours

            if (jour < 22) {
                jour = jour + 7;
            } else {
                switch (jour) {
                    case 22:
                        jour = 01;
                        mois++;
                        break;
                    case 23:
                        jour = 02;
                        mois++;
                        break;
                    case 24:
                        jour = 03;
                        mois++;
                        break;
                    case 25:
                        jour = 04;
                        mois++;
                        break;
                    case 26:
                        jour = 05;
                        mois++;
                        break;
                    case 27:
                        jour = 06;
                        mois++;
                        break;
                    case 28:
                        jour = 07;
                        mois++;
                        break;
                    default:
                        break;
                }
            }
            date2 = new Date(annee, mois, jour);
        }
        int avert = 0;//venant de la vue

        Emprunt e = new Emprunt(isbn, idLecteur, date1);

        e.setDateRetourTheo(date2);
//         e.setDateEmprunt(date3);
        e.setNbrAvertissement(avert);

        //getEntityManager().persist(e);
        empruntRepository.save(e);
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
    public void avertirLecteur(int isbn, int idLecteur, Date dateEmprunt) {
        Emprunt emprunt = (Emprunt) this.find(isbn, idLecteur,dateEmprunt);
        System.out.println("foud"+emprunt);
        emprunt.setNbrAvertissement(emprunt.getNbrAvertissement()+1);
        empruntRepository.save(emprunt);
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
