/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author LoicoSquare DeMadrid
 */
@Embeddable
public class EffectuerabonnementPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int idLecteur;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int idAbonnement;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateDebutAbonnement;

    public EffectuerabonnementPK() {
    }

    public EffectuerabonnementPK(int idLecteur, int idAbonnement, Date dateAbonnement) {
        this.idLecteur = idLecteur;
        this.idAbonnement = idAbonnement;
        this.dateDebutAbonnement = dateAbonnement;
    }

    public int getIdLecteur() {
        return idLecteur;
    }

    public void setIdLecteur(int idLecteur) {
        this.idLecteur = idLecteur;
    }

    public int getIdAbonnement() {
        return idAbonnement;
    }

    public void setIdAbonnement(int idAbonnement) {
        this.idAbonnement = idAbonnement;
    }

    public Date getDateDebutAbonnement() {
        return dateDebutAbonnement;
    }

    public void setDateDebutAbonnement(Date dateDebutAbonnement) {
        this.dateDebutAbonnement = dateDebutAbonnement;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idLecteur;
        hash += (int) idAbonnement;
        hash += (dateDebutAbonnement != null ? dateDebutAbonnement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EffectuerabonnementPK)) {
            return false;
        }
        EffectuerabonnementPK other = (EffectuerabonnementPK) object;
        if (this.idLecteur != other.idLecteur) {
            return false;
        }
        if (this.idAbonnement != other.idAbonnement) {
            return false;
        }
        if ((this.dateDebutAbonnement == null && other.dateDebutAbonnement != null) || (this.dateDebutAbonnement != null && !this.dateDebutAbonnement.equals(other.dateDebutAbonnement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "controller.exceptions.EffectuerabonnementPK[ idLecteur=" + idLecteur + ", idAbonnement=" + idAbonnement + ", dateAbonnement=" + dateDebutAbonnement + " ]";
    }
}
