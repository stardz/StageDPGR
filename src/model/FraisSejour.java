package model;


import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
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
@Table(name="frais_sejour")
public class FraisSejour implements Serializable {
    
    

    @Column(name="montant_alloc",table="frais_sejour",length=30)  
    @Basic
    private String montantAlloc;
    
    @Column(name="stage_id_stage",table="frais_sejour")
    @Basic
    private Integer stageIdStage;
    
    @OneToMany(targetEntity = Manifestation.class,mappedBy = "fraisSejourNumeroFraisSejour")
    private Collection<Manifestation> manifestationCollection;
    
    
    @Column(name="manifestation_id_manifestation",table="frais_sejour")
    @Basic
    private Integer manifestationIdManifestation;
    
    
    @Column(name="numero_frais_sejour",table="frais_sejour",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer numeroFraisSejour;
    
    
    @OneToMany(targetEntity = Stage.class,mappedBy = "fraisSejourNumeroFraisSejour")
    private Collection<Stage> stageCollection;

    public FraisSejour() {

    }
   
    public String getMontantAlloc() {
        return this.montantAlloc;
    }

    public void setMontantAlloc(String montantAlloc) {
        this.montantAlloc = montantAlloc;
    }
   
    public Integer getStageIdStage() {
        return this.stageIdStage;
    }

    public void setStageIdStage(Integer stageIdStage) {
        this.stageIdStage = stageIdStage;
    }
   
    public Collection<Manifestation> getManifestationCollection() {
        return this.manifestationCollection;
    }

    public void setManifestationCollection(Collection<Manifestation> manifestationCollection) {
        this.manifestationCollection = manifestationCollection;
    }
   
    public Integer getManifestationIdManifestation() {
        return this.manifestationIdManifestation;
    }

    public void setManifestationIdManifestation(Integer manifestationIdManifestation) {
        this.manifestationIdManifestation = manifestationIdManifestation;
    }
   
    public Integer getNumeroFraisSejour() {
        return this.numeroFraisSejour;
    }

    public void setNumeroFraisSejour(Integer numeroFraisSejour) {
        this.numeroFraisSejour = numeroFraisSejour;
    }
   
    public Collection<Stage> getStageCollection() {
        return this.stageCollection;
    }

    public void setStageCollection(Collection<Stage> stageCollection) {
        this.stageCollection = stageCollection;
    }
}
