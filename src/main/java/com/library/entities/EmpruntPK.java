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
public class EmpruntPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int isbn;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int idLecteur;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateEmprunt;

    public EmpruntPK() {
    }

    public EmpruntPK(int isbn, int idLecteur, Date dateEmprunt) {
        this.isbn = isbn;
        this.idLecteur = idLecteur;
        this.dateEmprunt = dateEmprunt;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getIdLecteur() {
        return idLecteur;
    }

    public void setIdLecteur(int idLecteur) {
        this.idLecteur = idLecteur;
    }

    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) isbn;
        hash += (int) idLecteur;
        hash += (dateEmprunt != null ? dateEmprunt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpruntPK)) {
            return false;
        }
        EmpruntPK other = (EmpruntPK) object;
        if (this.isbn != other.isbn) {
            return false;
        }
        if (this.idLecteur != other.idLecteur) {
            return false;
        }
        if ((this.dateEmprunt == null && other.dateEmprunt != null) || (this.dateEmprunt != null && !this.dateEmprunt.equals(other.dateEmprunt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "controller.EmpruntPK[ isbn=" + isbn + ", idLecteur=" + idLecteur + ", dateEmprunt=" + dateEmprunt + " ]";
    }
    
}
