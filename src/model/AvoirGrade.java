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
@Table(name="avoir_grade")
public class AvoirGrade implements Serializable {

    @ManyToOne(optional=false,targetEntity = Stagiaire.class)
    @JoinColumn(name="id_stagiaire",referencedColumnName="id_stagiaire",insertable=false,updatable=false)
    private Stagiaire stagiaire;
    @ManyToOne(optional=false,targetEntity = Grade.class)
    @JoinColumn(name="id_grade",referencedColumnName="id_grade",insertable=false,updatable=false)
    private Grade grade;
    @Column(name="id_stagiaire",table="avoir_grade",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idStagiaire;
    @Column(name="date_avoir_grade",table="avoir_grade")
    @Temporal(TemporalType.DATE)
    @Basic
    private Date dateAvoirGrade;
    @Column(name="id_grade",table="avoir_grade",nullable=false)
    @Id
    private int idGrade;

    public AvoirGrade() {

    }
   
    public Stagiaire getStagiaire() {
        return this.stagiaire;
    }

    public void setStagiaire(Stagiaire stagiaire) {
        this.stagiaire = stagiaire;
    }
   
    public Grade getGrade() {
        return this.grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
   
    public int getIdStagiaire() {
        return this.idStagiaire;
    }

    public void setIdStagiaire(int idStagiaire) {
        this.idStagiaire = idStagiaire;
    }
   
    public Date getDateAvoirGrade() {
        return this.dateAvoirGrade;
    }

    public void setDateAvoirGrade(Date dateAvoirGrade) {
        this.dateAvoirGrade = dateAvoirGrade;
    }
   
    public int getIdGrade() {
        return this.idGrade;
    }

    public void setIdGrade(int idGrade) {
        this.idGrade = idGrade;
    }
}
