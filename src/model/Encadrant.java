package model;


import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="encadrant")
public class Encadrant implements Serializable {

    @Column(name="id_encadrant",table="encadrant",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idEncadrant;
    @OneToMany(targetEntity = EncadrePar.class,mappedBy = "encadrant")
    private Collection<EncadrePar> encadreParCollection;
    @Column(name="prenom_encadrant",table="encadrant",length=30)
    @Basic
    private String prenomEncadrant;
    @Column(name="nom_encadrant",table="encadrant",length=30)
    @Basic
    private String nomEncadrant;

    public Encadrant() {

    }
   
    public Integer getIdEncadrant() {
        return this.idEncadrant;
    }

    public void setIdEncadrant(Integer idEncadrant) {
        this.idEncadrant = idEncadrant;
    }
   
    public Collection<EncadrePar> getEncadreParCollection() {
        return this.encadreParCollection;
    }

    public void setEncadreParCollection(Collection<EncadrePar> encadreParCollection) {
        this.encadreParCollection = encadreParCollection;
    }
   
    public String getPrenomEncadrant() {
        return this.prenomEncadrant;
    }

    public void setPrenomEncadrant(String prenomEncadrant) {
        this.prenomEncadrant = prenomEncadrant;
    }
   
    public String getNomEncadrant() {
        return this.nomEncadrant;
    }

    public void setNomEncadrant(String nomEncadrant) {
        this.nomEncadrant = nomEncadrant;
    }
}
