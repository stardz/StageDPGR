package model;


import java.io.Serializable;
import java.lang.Boolean;
import java.lang.String;
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
@Table(name="invite_manifestation")
public class InviteManifestation implements Serializable {

    @ManyToOne(optional=false,targetEntity = Manifestation.class)
    @JoinColumn(name="id_manifestation",referencedColumnName="id_manifestation",insertable=false,updatable=false)
    private Manifestation manifestation;
    @ManyToOne(optional=false,targetEntity = Inviteur.class)
    @JoinColumn(name="id_inviteur",referencedColumnName="id_inviteur",insertable=false,updatable=false)
    private Inviteur inviteur;
    @Column(name="dure_conge_scientifique",table="invite_manifestation")
    @Temporal(TemporalType.DATE)
    @Basic
    private Date dureCongeScientifique;
    @Column(name="date_invite_manifestation",table="invite_manifestation")
    @Temporal(TemporalType.DATE)
    @Basic
    private Date dateInviteManifestation;
    @ManyToOne(optional=false,targetEntity = Stagiaire.class)
    @JoinColumn(name="id_stagiaire",referencedColumnName="id_stagiaire",insertable=false,updatable=false)
    private Stagiaire stagiaire;
    @Column(name="id_stagiaire",table="invite_manifestation",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idStagiaire;
    @Column(name="autorisation_de_manif",table="invite_manifestation",length=30)
    @Basic
    private String autorisationDeManif;
    @Column(name="avis_cs_manif",table="invite_manifestation")
    @Basic
    private Boolean avisCsManif;
    @Column(name="id_manifestation",table="invite_manifestation",nullable=false)
    @Id
    private int idManifestation;
    @Column(name="avis_dadpgr_manif",table="invite_manifestation",length=30)
    @Basic
    private String avisDadpgrManif;
    @Column(name="date_debut",table="invite_manifestation")
    @Temporal(TemporalType.DATE)
    @Basic
    private Date dateDebut;
    @Column(name="id_inviteur",table="invite_manifestation",nullable=false)
    @Id
    private int idInviteur;
    @Column(name="date_fin",table="invite_manifestation")
    @Temporal(TemporalType.DATE)
    @Basic
    private Date dateFin;

    public InviteManifestation() {

    }
   
    public Manifestation getManifestation() {
        return this.manifestation;
    }

    public void setManifestation(Manifestation manifestation) {
        this.manifestation = manifestation;
    }
   
    public Inviteur getInviteur() {
        return this.inviteur;
    }

    public void setInviteur(Inviteur inviteur) {
        this.inviteur = inviteur;
    }
   
    public Date getDureCongeScientifique() {
        return this.dureCongeScientifique;
    }

    public void setDureCongeScientifique(Date dureCongeScientifique) {
        this.dureCongeScientifique = dureCongeScientifique;
    }
   
    public Date getDateInviteManifestation() {
        return this.dateInviteManifestation;
    }

    public void setDateInviteManifestation(Date dateInviteManifestation) {
        this.dateInviteManifestation = dateInviteManifestation;
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
   
    public String getAutorisationDeManif() {
        return this.autorisationDeManif;
    }

    public void setAutorisationDeManif(String autorisationDeManif) {
        this.autorisationDeManif = autorisationDeManif;
    }
    
    public Boolean isAvisCsManif() {
        return this.avisCsManif;
    }

    public void setAvisCsManif(Boolean avisCsManif) {
        this.avisCsManif = avisCsManif;
    }
   
    public int getIdManifestation() {
        return this.idManifestation;
    }

    public void setIdManifestation(int idManifestation) {
        this.idManifestation = idManifestation;
    }
   
    public String getAvisDadpgrManif() {
        return this.avisDadpgrManif;
    }

    public void setAvisDadpgrManif(String avisDadpgrManif) {
        this.avisDadpgrManif = avisDadpgrManif;
    }
   
    public Date getDateDebut() {
        return this.dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }
   
    public int getIdInviteur() {
        return this.idInviteur;
    }

    public void setIdInviteur(int idInviteur) {
        this.idInviteur = idInviteur;
    }
   
    public Date getDateFin() {
        return this.dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
}
