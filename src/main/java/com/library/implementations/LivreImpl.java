package com.library.implementations;

import com.library.entities.Categorie;
import com.library.entities.Emprunt;
import com.library.entities.Livre;
import com.library.interfaces.ILivre;
import com.library.repositories.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service
public class LivreImpl implements ILivre {

    @PersistenceContext
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }

    @Autowired
    LivreRepository livreRepository;

    @Override
    public Livre createLivre(Livre Livre) {
        return livreRepository.save(Livre);
    }

    @Override
    public Livre updateLivre(Livre Livre) {
        return livreRepository.save(Livre);
    }

    @Override
    public void deleteLivre(Integer isbn) {
        livreRepository.deleteById(isbn);
    }

    @Override
    public Optional<Livre> findLivre(Integer id) {
        return livreRepository.findById(id);
    }

    @Override
    public List<Livre> findAllLivres() {
        return livreRepository.findAll();
    }

    @Override
    public List<Livre> findAllLivresNonEmpruntes() {
        Query query = getEntityManager().createQuery("SELECT l FROM Livre l WHERE l.isbn NOT IN (SELECT e.empruntPK.isbn FROM Emprunt e) OR l.isbn IN (SELECT e.empruntPK.isbn FROM Emprunt e WHERE e.dateRetourEff IS NOT NULL)");
        return (List<Livre>) query.getResultList();
    }

    @Override
    public List<Livre> findAllLivreByCategorie(Categorie idCategorie) {
        System.out.println("id "+idCategorie);
        try {
            Query query = getEntityManager().createNamedQuery("Livre.findLivreByCategorie")
                    .setParameter("idCategorie", idCategorie);
            return (List<Livre>) query.getResultList();
        }catch (Exception e){
            System.out.println("exception "+e.getMessage());
        }
        return null;
    }

}
