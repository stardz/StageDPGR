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
@Table(name="inviteur")
public class Inviteur implements Serializable {

    @Column(name="email_inviteur",table="inviteur",length=30)
    @Basic
    private String emailInviteur;
    @Column(name="id_inviteur",table="inviteur",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idInviteur;
    @Column(name="tel_inviteur",table="inviteur",length=30)
    @Basic
    private String telInviteur;
    @Column(name="labo_inviteur",table="inviteur",length=30)
    @Basic
    private String laboInviteur;
    @OneToMany(targetEntity = InviteManifestation.class,mappedBy = "inviteur")
    private Collection<InviteManifestation> inviteManifestationCollection;
    @Column(name="grade_inviteur",table="inviteur",length=30)
    @Basic
    private String gradeInviteur;
    @Column(name="prenom_inviteur",table="inviteur",length=30)
    @Basic
    private String prenomInviteur;
    @Column(name="etablissement_inviteur",table="inviteur",length=30)
    @Basic
    private String etablissementInviteur;
    @Column(name="nom_inviteur",table="inviteur",length=30)
    @Basic
    private String nomInviteur;

    public Inviteur() {

    }
   
    public String getEmailInviteur() {
        return this.emailInviteur;
    }

    public void setEmailInviteur(String emailInviteur) {
        this.emailInviteur = emailInviteur;
    }
   
    public Integer getIdInviteur() {
        return this.idInviteur;
    }

    public void setIdInviteur(Integer idInviteur) {
        this.idInviteur = idInviteur;
    }
   
    public String getTelInviteur() {
        return this.telInviteur;
    }

    public void setTelInviteur(String telInviteur) {
        this.telInviteur = telInviteur;
    }
   
    public String getLaboInviteur() {
        return this.laboInviteur;
    }

    public void setLaboInviteur(String laboInviteur) {
        this.laboInviteur = laboInviteur;
    }
   
    public Collection<InviteManifestation> getInviteManifestationCollection() {
        return this.inviteManifestationCollection;
    }

    public void setInviteManifestationCollection(Collection<InviteManifestation> inviteManifestationCollection) {
        this.inviteManifestationCollection = inviteManifestationCollection;
    }
   
    public String getGradeInviteur() {
        return this.gradeInviteur;
    }

    public void setGradeInviteur(String gradeInviteur) {
        this.gradeInviteur = gradeInviteur;
    }
   
    public String getPrenomInviteur() {
        return this.prenomInviteur;
    }

    public void setPrenomInviteur(String prenomInviteur) {
        this.prenomInviteur = prenomInviteur;
    }
   
    public String getEtablissementInviteur() {
        return this.etablissementInviteur;
    }

    public void setEtablissementInviteur(String etablissementInviteur) {
        this.etablissementInviteur = etablissementInviteur;
    }
   
    public String getNomInviteur() {
        return this.nomInviteur;
    }

    public void setNomInviteur(String nomInviteur) {
        this.nomInviteur = nomInviteur;
    }
}
