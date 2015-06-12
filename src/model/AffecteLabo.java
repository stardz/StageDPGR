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
@Table(name="affecte_labo")
public class AffecteLabo implements Serializable {

    @Column(name="date_affecte_labo",table="affecte_labo")
    @Temporal(TemporalType.DATE)
    @Basic
    private Date dateAffecteLabo;
    @ManyToOne(optional=false,targetEntity = Stagiaire.class)
    @JoinColumn(name="id_stagiaire",referencedColumnName="id_stagiaire",insertable=false,updatable=false)
    private Stagiaire stagiaire;
    @Column(name="id_stagiaire",table="affecte_labo",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idStagiaire;
    @ManyToOne(optional=false,targetEntity = LaboratoireRattachement.class)
    @JoinColumn(name="id_labo",referencedColumnName="id_labo",insertable=false,updatable=false)
    private LaboratoireRattachement laboratoireRattachement;
    @Column(name="id_labo",table="affecte_labo",nullable=false)
    @Id
    private int idLabo;

    public AffecteLabo() {

    }
   
    public Date getDateAffecteLabo() {
        return this.dateAffecteLabo;
    }

    public void setDateAffecteLabo(Date dateAffecteLabo) {
        this.dateAffecteLabo = dateAffecteLabo;
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
   
    public LaboratoireRattachement getLaboratoireRattachement() {
        return this.laboratoireRattachement;
    }

    public void setLaboratoireRattachement(LaboratoireRattachement laboratoireRattachement) {
        this.laboratoireRattachement = laboratoireRattachement;
    }
   
    public int getIdLabo() {
        return this.idLabo;
    }

    public void setIdLabo(int idLabo) {
        this.idLabo = idLabo;
    }
}
