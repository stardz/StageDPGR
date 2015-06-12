package model;


import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="pv")
public class Pv implements Serializable {

    @Column(name="id_pv",table="pv",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idPv;
    @Column(name="lieu_pv",table="pv",length=30)
    @Basic
    private String lieuPv;
    @Column(name="remarques_pv",table="pv",length=256)
    @Basic
    private String remarquesPv;
    @Column(name="date_pv",table="pv")
    @Temporal(TemporalType.DATE)
    @Basic
    private Date datePv;
    @OneToMany(targetEntity = AvoirPv.class,mappedBy = "pv")
    private Collection<AvoirPv> avoirPvCollection;
    @Column(name="heure_debut",table="pv")
    @Basic
    private Integer heureDebut;
    @Column(name="decision_pv",table="pv",length=30)
    @Basic
    private String decisionPv;
    @Column(name="heure_fin",table="pv")
    @Basic
    private Integer heureFin;

    public Pv() {

    }
   
    public Integer getIdPv() {
        return this.idPv;
    }

    public void setIdPv(Integer idPv) {
        this.idPv = idPv;
    }
   
    public String getLieuPv() {
        return this.lieuPv;
    }

    public void setLieuPv(String lieuPv) {
        this.lieuPv = lieuPv;
    }
   
    public String getRemarquesPv() {
        return this.remarquesPv;
    }

    public void setRemarquesPv(String remarquesPv) {
        this.remarquesPv = remarquesPv;
    }
   
    public Date getDatePv() {
        return this.datePv;
    }

    public void setDatePv(Date datePv) {
        this.datePv = datePv;
    }
   
    public Collection<AvoirPv> getAvoirPvCollection() {
        return this.avoirPvCollection;
    }

    public void setAvoirPvCollection(Collection<AvoirPv> avoirPvCollection) {
        this.avoirPvCollection = avoirPvCollection;
    }
   
    public Integer getHeureDebut() {
        return this.heureDebut;
    }

    public void setHeureDebut(Integer heureDebut) {
        this.heureDebut = heureDebut;
    }
   
    public String getDecisionPv() {
        return this.decisionPv;
    }

    public void setDecisionPv(String decisionPv) {
        this.decisionPv = decisionPv;
    }
   
    public Integer getHeureFin() {
        return this.heureFin;
    }

    public void setHeureFin(Integer heureFin) {
        this.heureFin = heureFin;
    }
}
