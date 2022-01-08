package com.library.interfaces;

import com.library.entities.Emprunt;
import com.library.entities.EmpruntPK;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface IEmprunt {

    void create(Emprunt emprunt);

    void editDate(Emprunt emprunt);

    void remove(Emprunt emprunt);

    ResponseEntity<Emprunt> emprunterLivre(int isbn, int idLecteur);

    Emprunt find(int isbn, int idLecteur, Date dateEmprunt);

    Emprunt nonRemis(int isbn, int idLecteur);

    Emprunt find(EmpruntPK id);

    List<Emprunt> findAllByIdLecteur(int idLecteur);

    Emprunt edit(Emprunt e);

    List<Emprunt> findAll();

    Emprunt avertirLecteur(int isbn, int idLecteur, Date dateEmprunt);

    Emprunt remettreLivre(int isbn, int idLecteur, Date dateEmprunt) throws ParseException;

}
