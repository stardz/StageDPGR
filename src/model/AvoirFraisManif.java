package model;


import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="avoir_frais_manif")
public class AvoirFraisManif implements Serializable {

    @ManyToOne(optional=false,targetEntity = Manifestation.class)
    @JoinColumn(name="id_manifestation",referencedColumnName="id_manifestation",insertable=false,updatable=false)
    private Manifestation manifestation;
    @Column(name="id_frais_manif",table="avoir_frais_manif",nullable=false)
    @Id
    private int idFraisManif;
    @Column(name="total_frais_manif",table="avoir_frais_manif")
    @Basic
    private Integer totalFraisManif;
    @ManyToOne(optional=false,targetEntity = FraisManif.class)
    @JoinColumn(name="id_frais_manif",referencedColumnName="id_frais_manif",insertable=false,updatable=false)
    private FraisManif fraisManif;
    @Column(name="id_manifestation",table="avoir_frais_manif",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idManifestation;

    public AvoirFraisManif() {

    }
   
    public Manifestation getManifestation() {
        return this.manifestation;
    }

    public void setManifestation(Manifestation manifestation) {
        this.manifestation = manifestation;
    }
   
    public int getIdFraisManif() {
        return this.idFraisManif;
    }

    public void setIdFraisManif(int idFraisManif) {
        this.idFraisManif = idFraisManif;
    }
   
    public Integer getTotalFraisManif() {
        return this.totalFraisManif;
    }

    public void setTotalFraisManif(Integer totalFraisManif) {
        this.totalFraisManif = totalFraisManif;
    }
   
    public FraisManif getFraisManif() {
        return this.fraisManif;
    }

    public void setFraisManif(FraisManif fraisManif) {
        this.fraisManif = fraisManif;
    }
   
    public int getIdManifestation() {
        return this.idManifestation;
    }

    public void setIdManifestation(int idManifestation) {
        this.idManifestation = idManifestation;
    }
}
