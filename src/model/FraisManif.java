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
@Table(name="frais_manif")
public class FraisManif implements Serializable {

    @Column(name="montant_sejour_frais_manif",table="frais_manif")
    @Basic
    private Integer montantSejourFraisManif;
    @Column(name="montant_visa_frais_manif",table="frais_manif")
    @Basic
    private Integer montantVisaFraisManif;
    @OneToMany(targetEntity = AvoirFraisManif.class,mappedBy = "fraisManif")
    private Collection<AvoirFraisManif> avoirFraisManifCollection;
    @Column(name="id_frais_manif",table="frais_manif",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idFraisManif;
    @Column(name="montant_assurance_frais_manif",table="frais_manif")
    @Basic
    private Integer montantAssuranceFraisManif;
    @Column(name="montant_transport_frais_manif",table="frais_manif")
    @Basic
    private Integer montantTransportFraisManif;
    @Column(name="frais_inscription_frais_manif",table="frais_manif")
    @Basic
    private Integer fraisInscriptionFraisManif;

    public FraisManif() {

    }
   
    public Integer getMontantSejourFraisManif() {
        return this.montantSejourFraisManif;
    }

    public void setMontantSejourFraisManif(Integer montantSejourFraisManif) {
        this.montantSejourFraisManif = montantSejourFraisManif;
    }
   
    public Integer getMontantVisaFraisManif() {
        return this.montantVisaFraisManif;
    }

    public void setMontantVisaFraisManif(Integer montantVisaFraisManif) {
        this.montantVisaFraisManif = montantVisaFraisManif;
    }
   
    public Collection<AvoirFraisManif> getAvoirFraisManifCollection() {
        return this.avoirFraisManifCollection;
    }

    public void setAvoirFraisManifCollection(Collection<AvoirFraisManif> avoirFraisManifCollection) {
        this.avoirFraisManifCollection = avoirFraisManifCollection;
    }
   
    public Integer getIdFraisManif() {
        return this.idFraisManif;
    }

    public void setIdFraisManif(Integer idFraisManif) {
        this.idFraisManif = idFraisManif;
    }
   
    public Integer getMontantAssuranceFraisManif() {
        return this.montantAssuranceFraisManif;
    }

    public void setMontantAssuranceFraisManif(Integer montantAssuranceFraisManif) {
        this.montantAssuranceFraisManif = montantAssuranceFraisManif;
    }
   
    public Integer getMontantTransportFraisManif() {
        return this.montantTransportFraisManif;
    }

    public void setMontantTransportFraisManif(Integer montantTransportFraisManif) {
        this.montantTransportFraisManif = montantTransportFraisManif;
    }
   
    public Integer getFraisInscriptionFraisManif() {
        return this.fraisInscriptionFraisManif;
    }

    public void setFraisInscriptionFraisManif(Integer fraisInscriptionFraisManif) {
        this.fraisInscriptionFraisManif = fraisInscriptionFraisManif;
    }
}
