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
@Table(name="avoir_grade_mem_cs")
public class AvoirGradeMemCs implements Serializable {

    @ManyToOne(optional=false,targetEntity = MembreCs.class)
    @JoinColumn(name="id_membre_cs",referencedColumnName="id_membre_cs",insertable=false,updatable=false)
    private MembreCs membreCs;
    @ManyToOne(optional=false,targetEntity = Grade.class)
    @JoinColumn(name="id_grade",referencedColumnName="id_grade",insertable=false,updatable=false)
    private Grade grade;
    @Column(name="id_grade",table="avoir_grade_mem_cs",nullable=false)
    @Id
    private int idGrade;
    @Column(name="id_membre_cs",table="avoir_grade_mem_cs",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idMembreCs;
    @Column(name="date_avoir_fonction_mem_cs",table="avoir_grade_mem_cs")
    @Temporal(TemporalType.DATE)
    @Basic
    private Date dateAvoirFonctionMemCs;

    public AvoirGradeMemCs() {

    }
   
    public MembreCs getMembreCs() {
        return this.membreCs;
    }

    public void setMembreCs(MembreCs membreCs) {
        this.membreCs = membreCs;
    }
   
    public Grade getGrade() {
        return this.grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
   
    public int getIdGrade() {
        return this.idGrade;
    }

    public void setIdGrade(int idGrade) {
        this.idGrade = idGrade;
    }
   
    public int getIdMembreCs() {
        return this.idMembreCs;
    }

    public void setIdMembreCs(int idMembreCs) {
        this.idMembreCs = idMembreCs;
    }
   
    public Date getDateAvoirFonctionMemCs() {
        return this.dateAvoirFonctionMemCs;
    }

    public void setDateAvoirFonctionMemCs(Date dateAvoirFonctionMemCs) {
        this.dateAvoirFonctionMemCs = dateAvoirFonctionMemCs;
    }
}
