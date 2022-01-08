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
    @NamedQuery(name = "Etatlivre.findAll", query = "SELECT e FROM Etatlivre e"),
    @NamedQuery(name = "Etatlivre.findByIdEtatLivre", query = "SELECT e FROM Etatlivre e WHERE e.idEtatLivre = :idEtatLivre"),
    @NamedQuery(name = "Etatlivre.findByEtat", query = "SELECT e FROM Etatlivre e WHERE e.etat = :etat")})
public class Etatlivre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idEtatLivre;
    @Size(max = 255)
    @Column(length = 255)
    private String etat;
    @OneToMany(mappedBy = "idEtatLivre",fetch= FetchType.LAZY)
    @JsonIgnoreProperties("idEtatLivre")
    private List<Livre> livreList;

    public Etatlivre() {
    }

    public Etatlivre(Integer idEtatLivre) {
        this.idEtatLivre = idEtatLivre;
    }

    public Integer getIdEtatLivre() {
        return idEtatLivre;
    }

    public void setIdEtatLivre(Integer idEtatLivre) {
        this.idEtatLivre = idEtatLivre;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @XmlTransient
    public List<Livre> getLivreList() {
        return livreList;
    }

    public void setLivreList(List<Livre> livreList) {
        this.livreList = livreList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEtatLivre != null ? idEtatLivre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etatlivre)) {
            return false;
        }
        Etatlivre other = (Etatlivre) object;
        if ((this.idEtatLivre == null && other.idEtatLivre != null) || (this.idEtatLivre != null && !this.idEtatLivre.equals(other.idEtatLivre))) {
            return false;
        }
        return true;
    }
}
