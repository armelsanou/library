/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Armel Sanou
 */
@Entity
@Table(catalog = "library", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rayon.findAll", query = "SELECT r FROM Rayon r"),
    @NamedQuery(name = "Rayon.findByIdRayon", query = "SELECT r FROM Rayon r WHERE r.idRayon = :idRayon"),
    @NamedQuery(name = "Rayon.findByLibelle", query = "SELECT r FROM Rayon r WHERE r.libelle = :libelle")})
public class Rayon implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idRayon;
    @Size(max = 255)
    @Column(length = 255)
    private String libelle;
    @JoinColumn(name = "idCategorie", referencedColumnName = "idCategorie")
    @ManyToOne
    @JsonIgnoreProperties("rayonList")
    private Categorie idCategorie;

    public Rayon() {
    }

    public Rayon(Integer idRayon) {
        this.idRayon = idRayon;
    }

    public Integer getIdRayon() {
        return idRayon;
    }

    public void setIdRayon(Integer idRayon) {
        this.idRayon = idRayon;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Categorie getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Categorie idCategorie) {
        this.idCategorie = idCategorie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRayon != null ? idRayon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rayon)) {
            return false;
        }
        Rayon other = (Rayon) object;
        if ((this.idRayon == null && other.idRayon != null) || (this.idRayon != null && !this.idRayon.equals(other.idRayon))) {
            return false;
        }
        return true;
    }
}
