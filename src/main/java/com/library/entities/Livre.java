package com.library.entities;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author LoicoSquare DeMadrid
 */
@Entity
@Table(catalog = "library", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Livre.findAll", query = "SELECT l FROM Livre l"),
    @NamedQuery(name = "Livre.findByIsbn", query = "SELECT l FROM Livre l WHERE l.isbn = :isbn"),
    @NamedQuery(name = "Livre.findByTitre", query = "SELECT l FROM Livre l WHERE l.titre = :titre"),
    @NamedQuery(name = "Livre.findByDateEdition", query = "SELECT l FROM Livre l WHERE l.dateEdition = :dateEdition"),
    @NamedQuery(name = "Livre.findByAuteur", query = "SELECT l FROM Livre l WHERE l.auteur = :auteur"),
    @NamedQuery(name = "Livre.findByImage", query = "SELECT l FROM Livre l WHERE l.image = :image"),
    @NamedQuery(name = "Livre.findLivreByCategorie", query = "SELECT l FROM Livre l WHERE l.idCategorie = :idCategorie"),
    @NamedQuery(name = "Livre.findByDescription", query = "SELECT l FROM Livre l WHERE l.description = :description")})
public class Livre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer isbn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false, length = 255)
    private String titre;
    @Temporal(TemporalType.DATE)
    private Date dateEdition;
    @Size(max = 255)
    @Column(length = 255)
    private String auteur;
    @Size(max = 255)
    @Column(length = 255)
    private String image;
    @Size(max = 255)
    @Column(length = 255)
    private String description;
    @OneToMany(cascade = CascadeType.ALL,fetch= FetchType.LAZY, mappedBy = "livre")
    @JsonIgnoreProperties("livre")
    private List<Emprunt> empruntList;
    @JoinColumn(name = "idEtatLivre", referencedColumnName = "idEtatLivre")
    @ManyToOne
    @JsonIgnoreProperties("livreList")
    private Etatlivre idEtatLivre;
    @JoinColumn(name = "idCategorie", referencedColumnName = "idCategorie")
    @ManyToOne
    @JsonIgnoreProperties("livreList")
    private Categorie idCategorie;

    public Livre() {
    }

    public Livre(Integer isbn) {
        this.isbn = isbn;
    }

    public Livre(Integer isbn, String titre) {
        this.isbn = isbn;
        this.titre = titre;
    }

    public Livre(Integer isbn, String titre, Date dateEdition, String auteur, String image, String description, Etatlivre idEtatLivre, Categorie idCategorie) {
        this.isbn = isbn;
        this.titre = titre;
        this.dateEdition = dateEdition;
        this.auteur = auteur;
        this.image = image;
        this.description = description;
        this.idEtatLivre = idEtatLivre;
        this.idCategorie = idCategorie;
    }
    
    
    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDateEdition() {
        return dateEdition;
    }

    public void setDateEdition(Date dateEdition) {
        this.dateEdition = dateEdition;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Emprunt> getEmpruntList() {
        return empruntList;
    }

    public void setEmpruntList(List<Emprunt> empruntList) {
        this.empruntList = empruntList;
    }

    public Etatlivre getIdEtatLivre() {
        return idEtatLivre;
    }

    public void setIdEtatLivre(Etatlivre idEtatLivre) {
        this.idEtatLivre = idEtatLivre;
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
        hash += (isbn != null ? isbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livre)) {
            return false;
        }
        Livre other = (Livre) object;
        if ((this.isbn == null && other.isbn != null) || (this.isbn != null && !this.isbn.equals(other.isbn))) {
            return false;
        }
        return true;
    }

    /*@Override
    public String toString() {
        return "Livre{" +
                "isbn=" + isbn +
                ", titre='" + titre + '\'' +
                ", dateEdition=" + dateEdition +
                ", auteur='" + auteur + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", empruntList=" + empruntList +
                ", idEtatLivre=" + idEtatLivre +
                ", idCategorie=" + idCategorie +
                '}';
    }*/
}
