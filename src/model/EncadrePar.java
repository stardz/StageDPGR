package model;


import java.io.Serializable;
import java.lang.String;
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
@Table(name="encadre_par")
public class EncadrePar implements Serializable {

    @Column(name="date_encadre_par",table="encadre_par")
    @Temporal(TemporalType.DATE)
    @Basic
    private Date dateEncadrePar;
    @Column(name="id_encadrant",table="encadre_par",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idEncadrant;
    @Column(name="objectifs",table="encadre_par",length=256)
    @Basic
    private String objectifs;
    @ManyToOne(optional=false,targetEntity = Encadrant.class)
    @JoinColumn(name="id_encadrant",referencedColumnName="id_encadrant",insertable=false,updatable=false)
    private Encadrant encadrant;
    @Column(name="sujet_these",table="encadre_par",length=256)
    @Basic
    private String sujetThese;
    @ManyToOne(optional=false,targetEntity = Stagiaire.class)
    @JoinColumn(name="id_stagiaire",referencedColumnName="id_stagiaire",insertable=false,updatable=false)
    private Stagiaire stagiaire;
    @Column(name="id_stagiaire",table="encadre_par",nullable=false)
    @Id
    private int idStagiaire;
    @Column(name="travaux_accomplis",table="encadre_par",length=256)
    @Basic
    private String travauxAccomplis;

    public EncadrePar() {

    }
   
    public Date getDateEncadrePar() {
        return this.dateEncadrePar;
    }

    public void setDateEncadrePar(Date dateEncadrePar) {
        this.dateEncadrePar = dateEncadrePar;
    }
   
    public int getIdEncadrant() {
        return this.idEncadrant;
    }

    public void setIdEncadrant(int idEncadrant) {
        this.idEncadrant = idEncadrant;
    }
   
    public String getObjectifs() {
        return this.objectifs;
    }

    public void setObjectifs(String objectifs) {
        this.objectifs = objectifs;
    }
   
    public Encadrant getEncadrant() {
        return this.encadrant;
    }

    public void setEncadrant(Encadrant encadrant) {
        this.encadrant = encadrant;
    }
   
    public String getSujetThese() {
        return this.sujetThese;
    }

    public void setSujetThese(String sujetThese) {
        this.sujetThese = sujetThese;
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
   
    public String getTravauxAccomplis() {
        return this.travauxAccomplis;
    }

    public void setTravauxAccomplis(String travauxAccomplis) {
        this.travauxAccomplis = travauxAccomplis;
    }
}
