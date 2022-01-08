/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Armel Sanou
 */
@Entity
@Table(catalog = "library", schema = "")
@XmlRootElement
@NamedQueries({
     @NamedQuery(name = "Abonnement.findAll", query = "SELECT a FROM Abonnement a"),
    @NamedQuery(name = "Abonnement.findByIdAbonnement", query = "SELECT a FROM Abonnement a WHERE a.idAbonnement = :idAbonnement"),
    @NamedQuery(name = "Abonnement.findByLibelle", query = "SELECT a FROM Abonnement a WHERE a.libelle = :libelle"),
    @NamedQuery(name = "Abonnement.findByPeriode", query = "SELECT a FROM Abonnement a WHERE a.periode = :periode"),
    @NamedQuery(name = "Abonnement.findByPrix", query = "SELECT a FROM Abonnement a WHERE a.prix = :prix"),
    @NamedQuery(name = "Abonnement.findByDescription", query = "SELECT a FROM Abonnement a WHERE a.description = :description")})
public class Abonnement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idAbonnement;
    @Size(max = 255)
    @Column(length = 255)
    private String libelle;
    @Size(max = 255)
    @Column(length = 255)
    private String periode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 12)
    private Float prix;
    @Size(max = 255)
    @Column(length = 255)
    private String description;
    @OneToMany(fetch= FetchType.LAZY, mappedBy = "abonnement")
    @JsonIgnoreProperties("abonnement")
    private List<Effectuerabonnement> effectuerabonnementList;

    public Abonnement() {
    }

    public Abonnement(Integer idAbonnement) {
        this.idAbonnement = idAbonnement;
    }

    public Integer getIdAbonnement() {
        return idAbonnement;
    }

    public void setIdAbonnement(Integer idAbonnement) {
        this.idAbonnement = idAbonnement;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Effectuerabonnement> getEffectuerabonnementList() {
        return effectuerabonnementList;
    }

    public void setEffectuerabonnementList(List<Effectuerabonnement> effectuerabonnementList) {
        this.effectuerabonnementList = effectuerabonnementList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAbonnement != null ? idAbonnement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Abonnement)) {
            return false;
        }
        Abonnement other = (Abonnement) object;
        if ((this.idAbonnement == null && other.idAbonnement != null) || (this.idAbonnement != null && !this.idAbonnement.equals(other.idAbonnement))) {
            return false;
        }
        return true;
    }
}
