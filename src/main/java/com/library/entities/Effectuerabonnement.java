package com.library.entities;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LoicoSquare DeMadrid
 */
@Entity
@Table(catalog = "library", schema = "")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Effectuerabonnement.findAll", query = "SELECT e FROM Effectuerabonnement e"),
        @NamedQuery(name = "Effectuerabonnement.findByIdLecteur", query = "SELECT e FROM Effectuerabonnement e WHERE e.effectuerabonnementPK.idLecteur = :idLecteur"),
        @NamedQuery(name = "Effectuerabonnement.findByIdAbonnement", query = "SELECT e FROM Effectuerabonnement e WHERE e.effectuerabonnementPK.idAbonnement = :idAbonnement"),
        @NamedQuery(name = "Effectuerabonnement.findByDateFinAbonnement", query = "SELECT e FROM Effectuerabonnement e WHERE e.dateFinAbonnement = :dateFinAbonnement")})
public class Effectuerabonnement implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EffectuerabonnementPK effectuerabonnementPK;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateFinAbonnement;
    @JoinColumn(name = "idLecteur", referencedColumnName = "idLecteur", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("effectuerabonnementList")
    private Lecteur lecteur;
    @JoinColumn(name = "idAbonnement", referencedColumnName = "idAbonnement", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("effectuerabonnementList")
    private Abonnement abonnement;

    public Effectuerabonnement() {
    }

    public Effectuerabonnement(EffectuerabonnementPK effectuerabonnementPK) {
        this.effectuerabonnementPK = effectuerabonnementPK;
    }

    public Effectuerabonnement(EffectuerabonnementPK effectuerabonnementPK, Date dateFinAbonnement) {
        this.effectuerabonnementPK = effectuerabonnementPK;
        this.dateFinAbonnement = dateFinAbonnement;
    }

    public Effectuerabonnement(int idLecteur, int idAbonnement, Date dateAbonnement) {
        this.effectuerabonnementPK = new EffectuerabonnementPK(idLecteur, idAbonnement, dateAbonnement);
    }

    public EffectuerabonnementPK getEffectuerabonnementPK() {
        return effectuerabonnementPK;
    }

    public void setEffectuerabonnementPK(EffectuerabonnementPK effectuerabonnementPK) {
        this.effectuerabonnementPK = effectuerabonnementPK;
    }

    public Date getDateFinAbonnement() {
        return dateFinAbonnement;
    }

    public void setDateFinAbonnement(Date dateFinAbonnement) {
        this.dateFinAbonnement = dateFinAbonnement;
    }

    public Lecteur getLecteur() {
        return lecteur;
    }

    public void setLecteur(Lecteur lecteur) {
        this.lecteur = lecteur;
    }

    public Abonnement getAbonnement() {
        return abonnement;
    }

    public void setAbonnement(Abonnement abonnement) {
        this.abonnement = abonnement;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (effectuerabonnementPK != null ? effectuerabonnementPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Effectuerabonnement)) {
            return false;
        }
        Effectuerabonnement other = (Effectuerabonnement) object;
        if ((this.effectuerabonnementPK == null && other.effectuerabonnementPK != null) || (this.effectuerabonnementPK != null && !this.effectuerabonnementPK.equals(other.effectuerabonnementPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "controller.exceptions.Effectuerabonnement[ effectuerabonnementPK=" + effectuerabonnementPK + " ]";
    }
}
