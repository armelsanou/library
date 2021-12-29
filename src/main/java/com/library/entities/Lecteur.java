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
 * @author LoicoSquare DeMadrid
 */
@Entity
@Table(catalog = "library", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lecteur.findAll", query = "SELECT l FROM Lecteur l"),
    @NamedQuery(name = "Lecteur.findByIdLecteur", query = "SELECT l FROM Lecteur l WHERE l.idLecteur = :idLecteur"),
    @NamedQuery(name = "Lecteur.findByNom", query = "SELECT l FROM Lecteur l WHERE l.nom = :nom"),
    @NamedQuery(name = "Lecteur.findByPrenom", query = "SELECT l FROM Lecteur l WHERE l.prenom = :prenom"),
    @NamedQuery(name = "Lecteur.findByEmail", query = "SELECT l FROM Lecteur l WHERE l.email = :email"),
    @NamedQuery(name = "Lecteur.findByLogin", query = "SELECT l FROM Lecteur l WHERE l.login = :login"),
    @NamedQuery(name = "Lecteur.findByLoginAndPass", query = "SELECT l FROM Lecteur l WHERE l.email = :login AND l.mdp = :mdp OR l.login = :login AND l.mdp = :mdp"),
    @NamedQuery(name = "Lecteur.findByMdp", query = "SELECT l FROM Lecteur l WHERE l.mdp = :mdp")})
public class Lecteur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idLecteur;
    @Size(max = 255)
    @Column(length = 255)
    private String nom;
    @Size(max = 255)
    @Column(length = 255)
    private String prenom;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(length = 255)
    private String email;
    @Size(max = 255)
    @Column(length = 255)
    private String login;
    @Size(max = 255)
    @Column(length = 255)
    private String mdp;
    @Size(max = 255)
    @Column(length = 255)
    private String telephone;
    @OneToMany(mappedBy = "lecteur")
    @JsonIgnoreProperties("lecteur")
    private List<Emprunt> empruntList;
    @OneToMany(mappedBy = "lecteur")
    @JsonIgnoreProperties("lecteur")
    private List<Effectuerabonnement> effectuerabonnementList;
    @Size(max = 255)
    @Column(length = 255)
    private String role = "lecteur";
    @Size(max = 255)
    @Column(length = 255)
    private String photo;

    public Lecteur() {
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Lecteur(Integer idLecteur) {
        this.idLecteur = idLecteur;
    }

    public Lecteur(String nom, String prenom, String email, String login, String mdp, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.login = login;
        this.mdp = mdp;
        this.telephone = telephone;
    }

    public Lecteur(String nom, String prenom, String email, String login, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.login = login;
        this.mdp = mdp;
    }
    

    public Integer getIdLecteur() {
        return idLecteur;
    }

    public void setIdLecteur(Integer idLecteur) {
        this.idLecteur = idLecteur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @XmlTransient
    public List<Emprunt> getEmpruntList() {
        return empruntList;
    }

    public void setEmpruntList(List<Emprunt> empruntList) {
        this.empruntList = empruntList;
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
        hash += (idLecteur != null ? idLecteur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lecteur)) {
            return false;
        }
        Lecteur other = (Lecteur) object;
        if ((this.idLecteur == null && other.idLecteur != null) || (this.idLecteur != null && !this.idLecteur.equals(other.idLecteur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Lecteur{" +
                "idLecteur=" + idLecteur +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", mdp='" + mdp + '\'' +
                ", telephone='" + telephone + '\'' +
                ", empruntList=" + empruntList +
                ", effectuerabonnementList=" + effectuerabonnementList +
                ", role='" + role + '\'' +
                '}';
    }
}
