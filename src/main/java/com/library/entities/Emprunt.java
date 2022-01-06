/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LoicoSquare DeMadrid
 */
@Entity
@Table(catalog = "library", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Emprunt.findAll", query = "SELECT e FROM Emprunt e"),
    @NamedQuery(name = "Emprunt.findByIsbn", query = "SELECT e FROM Emprunt e WHERE e.empruntPK.isbn = :isbn"),
    @NamedQuery(name = "Emprunt.findByIdLecteur", query = "SELECT e FROM Emprunt e WHERE e.empruntPK.idLecteur = :idLecteur"),
    @NamedQuery(name = "Emprunt.findByDateRetourTheo", query = "SELECT e FROM Emprunt e WHERE e.dateRetourTheo = :dateRetourTheo"),
    @NamedQuery(name = "Emprunt.findByDateRetourEff", query = "SELECT e FROM Emprunt e WHERE e.dateRetourEff = :dateRetourEff"),
    @NamedQuery(name = "Emprunt.findByNbrAvertissement", query = "SELECT e FROM Emprunt e WHERE e.nbrAvertissement = :nbrAvertissement")})
public class Emprunt implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmpruntPK empruntPK;
    @Temporal(TemporalType.DATE)    
    private Date dateRetourTheo;
    @Temporal(TemporalType.DATE)
    private Date dateRetourEff;
    private Integer nbrAvertissement;
    @JoinColumn(name = "isbn", referencedColumnName = "isbn", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("empruntList")
    private Livre livre;
    @JoinColumn(name = "idLecteur", referencedColumnName = "idLecteur", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("empruntList")
    private Lecteur lecteur;

    public Emprunt() {
    }

    public Emprunt(EmpruntPK empruntPK) {
        this.empruntPK = empruntPK;
    }

    public Emprunt(int isbn, int idLecteur, Date dateEmprunt) {
        this.empruntPK = new EmpruntPK(isbn, idLecteur, dateEmprunt);
    }
    public Emprunt(int isbn, int idLecteur, Date dateEmprunt, Date dateRetour) {
        this.empruntPK = new EmpruntPK(isbn, idLecteur, dateEmprunt);
        this.dateRetourEff = dateRetour;
    }

    public EmpruntPK getEmpruntPK() {
        return empruntPK;
    }

    public Emprunt(EmpruntPK empruntPK, Date dateRetourTheo, Date dateRetourEff, Integer nbrAvertissement) {
        this.empruntPK = empruntPK;
        this.dateRetourTheo = dateRetourTheo;
        this.dateRetourEff = dateRetourEff;
        this.nbrAvertissement = nbrAvertissement;
    }

    
    
    public void setEmpruntPK(EmpruntPK empruntPK) {
        this.empruntPK = empruntPK;
    }

    public Date getDateRetourTheo() {
        return dateRetourTheo;
    }

    public void setDateRetourTheo(Date dateRetourTheo) {
        this.dateRetourTheo = dateRetourTheo;
    }

    public Date getDateRetourEff() {
        return dateRetourEff;
    }

    public void setDateRetourEff(Date dateRetourEff) {
        this.dateRetourEff = dateRetourEff;
    }

    public Integer getNbrAvertissement() {
        return nbrAvertissement;
    }

    public void setNbrAvertissement(Integer nbrAvertissement) {
        this.nbrAvertissement = nbrAvertissement;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Lecteur getLecteur() {
        return lecteur;
    }

    public void setLecteur(Lecteur lecteur) {
        this.lecteur = lecteur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empruntPK != null ? empruntPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emprunt)) {
            return false;
        }
        Emprunt other = (Emprunt) object;
        if ((this.empruntPK == null && other.empruntPK != null) || (this.empruntPK != null && !this.empruntPK.equals(other.empruntPK))) {
            return false;
        }
        return true;
    }

    /*@Override
    public String toString() {
        return "Emprunt{" +
                "empruntPK=" + empruntPK +
                ", dateRetourTheo=" + dateRetourTheo +
                ", dateRetourEff=" + dateRetourEff +
                ", nbrAvertissement=" + nbrAvertissement +
                ", livre=" + livre +
                ", lecteur=" + lecteur +
                '}';
    }*/
}
