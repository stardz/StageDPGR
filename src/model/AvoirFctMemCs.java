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
@Table(name="avoir_fct_mem_cs")
public class AvoirFctMemCs implements Serializable {

    @ManyToOne(optional=false,targetEntity = MembreCs.class)
    @JoinColumn(name="id_membre_cs",referencedColumnName="id_membre_cs",insertable=false,updatable=false)
    private MembreCs membreCs;
    @Column(name="id_fonction",table="avoir_fct_mem_cs",nullable=false)
    @Id
    private int idFonction;
    @ManyToOne(optional=false,targetEntity = Fonction.class)
    @JoinColumn(name="id_fonction",referencedColumnName="id_fonction",insertable=false,updatable=false)
    private Fonction fonction;
    @Column(name="date_avoir_grade_mem_cs",table="avoir_fct_mem_cs")
    @Temporal(TemporalType.DATE)
    @Basic
    private Date dateAvoirGradeMemCs;
    @Column(name="id_membre_cs",table="avoir_fct_mem_cs",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idMembreCs;

    public AvoirFctMemCs() {

    }
   
    public MembreCs getMembreCs() {
        return this.membreCs;
    }

    public void setMembreCs(MembreCs membreCs) {
        this.membreCs = membreCs;
    }
   
    public int getIdFonction() {
        return this.idFonction;
    }

    public void setIdFonction(int idFonction) {
        this.idFonction = idFonction;
    }
   
    public Fonction getFonction() {
        return this.fonction;
    }

    public void setFonction(Fonction fonction) {
        this.fonction = fonction;
    }
   
    public Date getDateAvoirGradeMemCs() {
        return this.dateAvoirGradeMemCs;
    }

    public void setDateAvoirGradeMemCs(Date dateAvoirGradeMemCs) {
        this.dateAvoirGradeMemCs = dateAvoirGradeMemCs;
    }
   
    public int getIdMembreCs() {
        return this.idMembreCs;
    }

    public void setIdMembreCs(int idMembreCs) {
        this.idMembreCs = idMembreCs;
    }
}
