package model;


import java.io.Serializable;
import java.lang.Integer;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="frais_stage")
public class FraisStage implements Serializable {

    @Column(name="montant_transport_frai_stage",table="frais_stage")
    @Basic
    private Integer montantTransportFraiStage;
    @Column(name="montant_visa_frai_stage",table="frais_stage")
    @Basic
    private Integer montantVisaFraiStage;
    @Column(name="montant_assurrance_frai_stage",table="frais_stage")
    @Basic
    private Integer montantAssurranceFraiStage;
    @Column(name="id_frai_stage",table="frais_stage",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idFraiStage;
    @OneToMany(targetEntity = AvoirFraiStage.class,mappedBy = "fraisStage")
    private Collection<AvoirFraiStage> avoirFraiStageCollection;
    @Column(name="montant_sejour_frai_stage",table="frais_stage")
    @Basic
    private Integer montantSejourFraiStage;

    public FraisStage() {

    }

    public FraisStage(Integer idFraiStage,Integer montantTransportFraiStage, Integer montantVisaFraiStage, Integer montantAssurranceFraiStage,  Integer montantSejourFraiStage) {
        this.montantTransportFraiStage = montantTransportFraiStage;
        this.montantVisaFraiStage = montantVisaFraiStage;
        this.montantAssurranceFraiStage = montantAssurranceFraiStage;
        this.idFraiStage = idFraiStage;
        this.montantSejourFraiStage = montantSejourFraiStage;
    }
   
    
    public Integer getMontantTransportFraiStage() {
        return this.montantTransportFraiStage;
    }

    public void setMontantTransportFraiStage(Integer montantTransportFraiStage) {
        this.montantTransportFraiStage = montantTransportFraiStage;
    }
   
    public Integer getMontantVisaFraiStage() {
        return this.montantVisaFraiStage;
    }

    public void setMontantVisaFraiStage(Integer montantVisaFraiStage) {
        this.montantVisaFraiStage = montantVisaFraiStage;
    }
   
    public Integer getMontantAssurranceFraiStage() {
        return this.montantAssurranceFraiStage;
    }

    public void setMontantAssurranceFraiStage(Integer montantAssurranceFraiStage) {
        this.montantAssurranceFraiStage = montantAssurranceFraiStage;
    }
   
    public Integer getIdFraiStage() {
        return this.idFraiStage;
    }

    public void setIdFraiStage(Integer idFraiStage) {
        this.idFraiStage = idFraiStage;
    }
   
    public Collection<AvoirFraiStage> getAvoirFraiStageCollection() {
        return this.avoirFraiStageCollection;
    }

    public void setAvoirFraiStageCollection(Collection<AvoirFraiStage> avoirFraiStageCollection) {
        this.avoirFraiStageCollection = avoirFraiStageCollection;
    }
   
    public Integer getMontantSejourFraiStage() {
        return this.montantSejourFraiStage;
    }

    public void setMontantSejourFraiStage(Integer montantSejourFraiStage) {
        this.montantSejourFraiStage = montantSejourFraiStage;
    }
}
