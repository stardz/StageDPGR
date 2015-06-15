package model;


import java.io.Serializable;
import java.lang.String;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Utilisateur")
public class Utilisateur implements Serializable {

    @Column(name="login_utilisateur",table="Utilisateur",nullable=false,length=2147483647)
    @Id
    private String loginUtilisateur;
    @Column(name="mp_utilisateur",table="Utilisateur",length=2147483647)
    @Basic
    private String mpUtilisateur;
    @Column(name="profil_utilisateur",table="Utilisateur",length=2147483647)
    @Basic
    private String profilUtilisateur;
    @Column(name="etat_compte",table="Utilisateur",length=2147483647)
    @Basic
    private String etatCompte;
    @Column(name="nom_utilisateur",table="Utilisateur",length=2147483647)
    @Basic
    private String nomUtilisateur;
    @Column(name="prenom_utilisateur",table="Utilisateur",length=2147483647)
    @Basic
    private String prenomUtilisateur;

    public Utilisateur() {

    }
   
    public String getLoginUtilisateur() {
        return this.loginUtilisateur;
    }

    public void setLoginUtilisateur(String loginUtilisateur) {
        this.loginUtilisateur = loginUtilisateur;
    }
   
    public String getMpUtilisateur() {
        return this.mpUtilisateur;
    }

    public void setMpUtilisateur(String mpUtilisateur) {
        this.mpUtilisateur = mpUtilisateur;
    }
   
    public String getProfilUtilisateur() {
        return this.profilUtilisateur;
    }

    public void setProfilUtilisateur(String profilUtilisateur) {
        this.profilUtilisateur = profilUtilisateur;
    }
   
    public String getEtatCompte() {
        return this.etatCompte;
    }

    public void setEtatCompte(String etatCompte) {
        this.etatCompte = etatCompte;
    }
   
    public String getNomUtilisateur() {
        return this.nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }
   
    public String getPrenomUtilisateur() {
        return this.prenomUtilisateur;
    }

    public void setPrenomUtilisateur(String prenomUtilisateur) {
        this.prenomUtilisateur = prenomUtilisateur;
    }
}
