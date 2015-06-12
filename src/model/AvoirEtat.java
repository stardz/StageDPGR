package model;


import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="avoir_etat")
public class AvoirEtat implements Serializable {

    @Column(name="etat_stage",table="avoir_etat",nullable=false,length=30)
    @Id
    private String etatStage;
    @ManyToOne(optional=false,targetEntity = Stage.class)
    @JoinColumn(name="id_stage",referencedColumnName="id_stage",insertable=false,updatable=false)
    private Stage stage;
    @ManyToOne(optional=false,targetEntity = EtatStage.class)
    @JoinColumn(name="etat_stage",referencedColumnName="etat_stage",insertable=false,updatable=false)
    private EtatStage etatStage1;
    @Column(name="id_stage",table="avoir_etat",nullable=false)
    @Id
    private int idStage;
    @Column(name="date_avoir_etat",table="avoir_etat")
    @Temporal(TemporalType.DATE)
    @Basic
    private Date dateAvoirEtat;

    public AvoirEtat() {

    }
   
    public String getEtatStage() {
        return this.etatStage;
    }

    public void setEtatStage(String etatStage) {
        this.etatStage = etatStage;
    }
   
    public Stage getStage() {
        return this.stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
   
    public EtatStage getEtatStage1() {
        return this.etatStage1;
    }

    public void setEtatStage1(EtatStage etatStage1) {
        this.etatStage1 = etatStage1;
    }
   
    public int getIdStage() {
        return this.idStage;
    }

    public void setIdStage(int idStage) {
        this.idStage = idStage;
    }
   
    public Date getDateAvoirEtat() {
        return this.dateAvoirEtat;
    }

    public void setDateAvoirEtat(Date dateAvoirEtat) {
        this.dateAvoirEtat = dateAvoirEtat;
    }
}
