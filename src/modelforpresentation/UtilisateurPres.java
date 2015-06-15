package modelforpresentation;


import model.*;
import java.io.Serializable;
import java.lang.String;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class UtilisateurPres implements Serializable {

    private StringProperty loginUtilisateur;
   
    private StringProperty mpUtilisateur;
    
    private StringProperty profilUtilisateur;
    
    private StringProperty etatCompte;
   
    private StringProperty nomUtilisateur;
    
    private StringProperty prenomUtilisateur;

    public UtilisateurPres() {

    }
    public UtilisateurPres(Utilisateur user) {
           this.setNomUtilisateur(user.getNomUtilisateur());
           this.setPrenomUtilisateur(user.getPrenomUtilisateur());
           this.setLoginUtilisateur(user.getLoginUtilisateur());
           this.setMpUtilisateur(user.getMpUtilisateur());
           this.setEtatCompte(user.getEtatCompte());
           this.setProfilUtilisateur(user.getProfilUtilisateur());
    }
    public StringProperty loginUtilisateurProperty() { return loginUtilisateur; }
    public StringProperty mpUtilisateurProperty() { return mpUtilisateur; }
    public StringProperty profilUtilisateurProperty() { return profilUtilisateur; }
    public StringProperty etatCompteProperty() { return etatCompte; }
    public StringProperty nomUtilisateurProperty() { return nomUtilisateur; }
    public StringProperty prenomUtilisateurProperty() { return prenomUtilisateur; }
    
    public String getLoginUtilisateur() {
        return this.loginUtilisateur.getValue();
    }

    public void setLoginUtilisateur(String loginUtilisateur) {
        this.loginUtilisateur = new SimpleStringProperty(loginUtilisateur);
    }
   
    public String getMpUtilisateur() {
        return this.mpUtilisateur.getValue();
    }

    public void setMpUtilisateur(String mpUtilisateur) {
        this.mpUtilisateur =new SimpleStringProperty(mpUtilisateur);
    }
   
    public String getProfilUtilisateur() {
        return this.profilUtilisateur.getValue();
    }

    public void setProfilUtilisateur(String profilUtilisateur) {
        this.profilUtilisateur = new SimpleStringProperty(profilUtilisateur);
    }
   
    public String getEtatCompte() {
        return this.etatCompte.getValue();
    }

    public void setEtatCompte(String etatCompte) {
        this.etatCompte = new SimpleStringProperty(etatCompte);
    }
   
    public String getNomUtilisateur() {
        return this.nomUtilisateur.getValue();
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur =new SimpleStringProperty( nomUtilisateur);
    }
   
    public String getPrenomUtilisateur() {
        return this.prenomUtilisateur.getValue();
    }

    public void setPrenomUtilisateur(String prenomUtilisateur) {
        this.prenomUtilisateur =new SimpleStringProperty( prenomUtilisateur);
    }
}
