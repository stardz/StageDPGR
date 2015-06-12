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
@Table(name="avoir_diplome")
public class AvoirDiplome implements Serializable {

    @Column(name="id_diplome",table="avoir_diplome",nullable=false)
    @Id
    private int idDiplome;
    @Column(name="date_avoir_diplome",table="avoir_diplome")
    @Temporal(TemporalType.DATE)
    @Basic
    private Date dateAvoirDiplome;
    @ManyToOne(optional=false,targetEntity = Stagiaire.class)
    @JoinColumn(name="id_stagiaire",referencedColumnName="id_stagiaire",insertable=false,updatable=false)
    private Stagiaire stagiaire;
    @Column(name="id_stagiaire",table="avoir_diplome",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idStagiaire;
    @ManyToOne(optional=false,targetEntity = Diplome.class)
    @JoinColumn(name="id_diplome",referencedColumnName="id_diplome",insertable=false,updatable=false)
    private Diplome diplome;

    public AvoirDiplome() {

    }
   
    public int getIdDiplome() {
        return this.idDiplome;
    }

    public void setIdDiplome(int idDiplome) {
        this.idDiplome = idDiplome;
    }
   
    public Date getDateAvoirDiplome() {
        return this.dateAvoirDiplome;
    }

    public void setDateAvoirDiplome(Date dateAvoirDiplome) {
        this.dateAvoirDiplome = dateAvoirDiplome;
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
   
    public Diplome getDiplome() {
        return this.diplome;
    }

    public void setDiplome(Diplome diplome) {
        this.diplome = diplome;
    }
}
