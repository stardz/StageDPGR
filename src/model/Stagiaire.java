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
@Table(name="stagiaire")
public class Stagiaire implements Serializable {

    @Column(name="prenom_stagiaire",table="stagiaire",length=30)
    @Basic
    private String prenomStagiaire;
    @Column(name="tel_stagiaire",table="stagiaire",length=30)
    @Basic
    private String telStagiaire;
    @Column(name="nom_stagiaire",table="stagiaire",length=30)
    @Basic
    private String nomStagiaire;
    @Column(name="email_stagiaire",table="stagiaire",length=30)
    @Basic
    private String emailStagiaire;
    @OneToMany(targetEntity = AvoirGrade.class,mappedBy = "stagiaire")
    private Collection<AvoirGrade> avoirGradeCollection;
    @OneToMany(targetEntity = DemandeStage.class,mappedBy = "stagiaire")
    private Collection<DemandeStage> demandeStageCollection;
    @OneToMany(targetEntity = AvoirFonction.class,mappedBy = "stagiaire")
    private Collection<AvoirFonction> avoirFonctionCollection;
    @OneToMany(targetEntity = EncadrePar.class,mappedBy = "stagiaire")
    private Collection<EncadrePar> encadreParCollection;
    @Column(name="id_stagiaire",table="stagiaire",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idStagiaire;
    @OneToMany(targetEntity = InviteManifestation.class,mappedBy = "stagiaire")
    private Collection<InviteManifestation> inviteManifestationCollection;
    @OneToMany(targetEntity = AvoirDiplome.class,mappedBy = "stagiaire")
    private Collection<AvoirDiplome> avoirDiplomeCollection;
    @OneToMany(targetEntity = AffecteLabo.class,mappedBy = "stagiaire")
    private Collection<AffecteLabo> affecteLaboCollection;

    public Stagiaire() {

    }

    public Stagiaire(String prenomStagiaire, String telStagiaire, String nomStagiaire, String emailStagiaire, Collection<AvoirGrade> avoirGradeCollection, Collection<AvoirFonction> avoirFonctionCollection, Collection<AvoirDiplome> avoirDiplomeCollection, Collection<AffecteLabo> affecteLaboCollection) {
        this.prenomStagiaire = prenomStagiaire;
        this.telStagiaire = telStagiaire;
        this.nomStagiaire = nomStagiaire;
        this.emailStagiaire = emailStagiaire;
        this.avoirGradeCollection = avoirGradeCollection;
        this.avoirFonctionCollection = avoirFonctionCollection;
        this.avoirDiplomeCollection = avoirDiplomeCollection;
        this.affecteLaboCollection = affecteLaboCollection;
    }

    
    public String getPrenomStagiaire() {
        return this.prenomStagiaire;
    }

    public void setPrenomStagiaire(String prenomStagiaire) {
        this.prenomStagiaire = prenomStagiaire;
    }
   
    public String getTelStagiaire() {
        return this.telStagiaire;
    }

    public void setTelStagiaire(String telStagiaire) {
        this.telStagiaire = telStagiaire;
    }
   
    public String getNomStagiaire() {
        return this.nomStagiaire;
    }

    public void setNomStagiaire(String nomStagiaire) {
        this.nomStagiaire = nomStagiaire;
    }
   
    public String getEmailStagiaire() {
        return this.emailStagiaire;
    }

    public void setEmailStagiaire(String emailStagiaire) {
        this.emailStagiaire = emailStagiaire;
    }
   
    public Collection<AvoirGrade> getAvoirGradeCollection() {
        return this.avoirGradeCollection;
    }

    public void setAvoirGradeCollection(Collection<AvoirGrade> avoirGradeCollection) {
        this.avoirGradeCollection = avoirGradeCollection;
    }
   
    public Collection<DemandeStage> getDemandeStageCollection() {
        return this.demandeStageCollection;
    }

    public void setDemandeStageCollection(Collection<DemandeStage> demandeStageCollection) {
        this.demandeStageCollection = demandeStageCollection;
    }
   
    public Collection<AvoirFonction> getAvoirFonctionCollection() {
        return this.avoirFonctionCollection;
    }

    public void setAvoirFonctionCollection(Collection<AvoirFonction> avoirFonctionCollection) {
        this.avoirFonctionCollection = avoirFonctionCollection;
    }
   
    public Collection<EncadrePar> getEncadreParCollection() {
        return this.encadreParCollection;
    }

    public void setEncadreParCollection(Collection<EncadrePar> encadreParCollection) {
        this.encadreParCollection = encadreParCollection;
    }
   
    public Integer getIdStagiaire() {
        return this.idStagiaire;
    }

    public void setIdStagiaire(Integer idStagiaire) {
        this.idStagiaire = idStagiaire;
    }
   
    public Collection<InviteManifestation> getInviteManifestationCollection() {
        return this.inviteManifestationCollection;
    }

    public void setInviteManifestationCollection(Collection<InviteManifestation> inviteManifestationCollection) {
        this.inviteManifestationCollection = inviteManifestationCollection;
    }
   
    public Collection<AvoirDiplome> getAvoirDiplomeCollection() {
        return this.avoirDiplomeCollection;
    }

    public void setAvoirDiplomeCollection(Collection<AvoirDiplome> avoirDiplomeCollection) {
        this.avoirDiplomeCollection = avoirDiplomeCollection;
    }
   
    public Collection<AffecteLabo> getAffecteLaboCollection() {
        return this.affecteLaboCollection;
    }

    public void setAffecteLaboCollection(Collection<AffecteLabo> affecteLaboCollection) {
        this.affecteLaboCollection = affecteLaboCollection;
    }
}
