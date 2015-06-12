package model;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="avoir_fonction")
public class AvoirFonction implements Serializable {

    @Column(name="id_fonction",table="avoir_fonction",nullable=false)
    @Id
    private int idFonction;
    @ManyToOne(optional=false,targetEntity = Stagiaire.class)
    @JoinColumn(name="id_stagiaire",referencedColumnName="id_stagiaire",insertable=false,updatable=false)
    private Stagiaire stagiaire;
    @Column(name="id_stagiaire",table="avoir_fonction",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idStagiaire;
    @ManyToOne(optional=false,targetEntity = Fonction.class)
    @JoinColumn(name="id_fonction",referencedColumnName="id_fonction",insertable=false,updatable=false)
    private Fonction fonction;
    @Column(name="date_avoir_fonction",table="avoir_fonction")
    @Temporal(TemporalType.DATE)
    @Basic
    private Date dateAvoirFonction;

    public AvoirFonction() {

    }
   
    public int getIdFonction() {
        return this.idFonction;
    }

    public void setIdFonction(int idFonction) {
        this.idFonction = idFonction;
    }
   
    public Stagiaire getStagiaire() {
        return this.stagiaire;
    }

    public void setStagiaire(Stagiaire stagiaire) {
        this.stagiaire = stagiaire;
    }
   
    public int getIdStagiaire() {
        return this.idStagiaire;
    }

    public void setIdStagiaire(int idStagiaire) {
        this.idStagiaire = idStagiaire;
    }
   
    public Fonction getFonction() {
        return this.fonction;
    }

    public void setFonction(Fonction fonction) {
        this.fonction = fonction;
    }
   
    public Date getDateAvoirFonction() {
        return this.dateAvoirFonction;
    }

    public void setDateAvoirFonction(Date dateAvoirFonction) {
        this.dateAvoirFonction = dateAvoirFonction;
    }
}
