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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="stage")
public class Stage implements Serializable {

    @Column(name="date_fin_stage",table="stage")
    @Temporal(TemporalType.DATE)
    @Basic
    private Date dateFinStage;
    @Column(name="objectif_stage",table="stage",length=256)
    @Basic
    private String objectifStage;
    @ManyToOne(targetEntity = LieuStage.class)
    @JoinColumn(name="lieu_stage_id_lieu",referencedColumnName="id_lieu")
    private LieuStage lieuStageIdLieu;
    @Column(name="date_debut_stage",table="stage")
    @Temporal(TemporalType.DATE)
    @Basic
    private Date dateDebutStage;
    @OneToMany(targetEntity = AvoirFraiStage.class,mappedBy = "stage")
    private Collection<AvoirFraiStage> avoirFraiStageCollection;
    @OneToMany(targetEntity = AvoirPv.class,mappedBy = "stage")
    private Collection<AvoirPv> avoirPvCollection;
    @OneToMany(targetEntity = DemandeStage.class,mappedBy = "stage")
    private Collection<DemandeStage> demandeStageCollection;
    @Column(name="id_stage",table="stage",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idStage;
    @Column(name="environnement_stage",table="stage",length=256)
    @Basic
    private String environnementStage;
    @Column(name="mission_stage",table="stage",length=256)
    @Basic
    private String missionStage;
    @ManyToOne(targetEntity = FraisSejour.class)
    @JoinColumn(name="frais_sejour_numero_frais_sejour",referencedColumnName="numero_frais_sejour")
    private FraisSejour fraisSejourNumeroFraisSejour;
    @OneToMany(targetEntity = AvoirEtat.class,mappedBy = "stage")
    private Collection<AvoirEtat> avoirEtatCollection;

    public Stage() {

    }

    public Stage(Date dateFinStage, String objectifStage, LieuStage lieuStageIdLieu, Date dateDebutStage, String environnementStage, String missionStage) {
        this.dateFinStage = dateFinStage;
        this.objectifStage = objectifStage;
        this.lieuStageIdLieu = lieuStageIdLieu;
        this.dateDebutStage = dateDebutStage;
        this.environnementStage = environnementStage;
        this.missionStage = missionStage;
    }
   
    public Date getDateFinStage() {
        return this.dateFinStage;
    }

    public void setDateFinStage(Date dateFinStage) {
        this.dateFinStage = dateFinStage;
    }
   
    public String getObjectifStage() {
        return this.objectifStage;
    }

    public void setObjectifStage(String objectifStage) {
        this.objectifStage = objectifStage;
    }
   
    public LieuStage getLieuStageIdLieu() {
        return this.lieuStageIdLieu;
    }

    public void setLieuStageIdLieu(LieuStage lieuStageIdLieu) {
        this.lieuStageIdLieu = lieuStageIdLieu;
    }
   
    public Date getDateDebutStage() {
        return this.dateDebutStage;
    }

    public void setDateDebutStage(Date dateDebutStage) {
        this.dateDebutStage = dateDebutStage;
    }
   
    public Collection<AvoirFraiStage> getAvoirFraiStageCollection() {
        return this.avoirFraiStageCollection;
    }

    public void setAvoirFraiStageCollection(Collection<AvoirFraiStage> avoirFraiStageCollection) {
        this.avoirFraiStageCollection = avoirFraiStageCollection;
    }
   
    public Collection<AvoirPv> getAvoirPvCollection() {
        return this.avoirPvCollection;
    }

    public void setAvoirPvCollection(Collection<AvoirPv> avoirPvCollection) {
        this.avoirPvCollection = avoirPvCollection;
    }
   
    public Collection<DemandeStage> getDemandeStageCollection() {
        return this.demandeStageCollection;
    }

    public void setDemandeStageCollection(Collection<DemandeStage> demandeStageCollection) {
        this.demandeStageCollection = demandeStageCollection;
    }
   
    public Integer getIdStage() {
        return this.idStage;
    }

    public void setIdStage(Integer idStage) {
        this.idStage = idStage;
    }
   
    public String getEnvironnementStage() {
        return this.environnementStage;
    }

    public void setEnvironnementStage(String environnementStage) {
        this.environnementStage = environnementStage;
    }
   
    public String getMissionStage() {
        return this.missionStage;
    }

    public void setMissionStage(String missionStage) {
        this.missionStage = missionStage;
    }
   
    public FraisSejour getFraisSejourNumeroFraisSejour() {
        return this.fraisSejourNumeroFraisSejour;
    }

    public void setFraisSejourNumeroFraisSejour(FraisSejour fraisSejourNumeroFraisSejour) {
        this.fraisSejourNumeroFraisSejour = fraisSejourNumeroFraisSejour;
    }
   
    public Collection<AvoirEtat> getAvoirEtatCollection() {
        return this.avoirEtatCollection;
    }

    public void setAvoirEtatCollection(Collection<AvoirEtat> avoirEtatCollection) {
        this.avoirEtatCollection = avoirEtatCollection;
    }
}
