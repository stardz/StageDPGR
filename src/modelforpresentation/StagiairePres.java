package modelforpresentation;


import model.*;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Collection;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


public class StagiairePres implements Serializable {

   
    private StringProperty prenomStagiaire;
    
    private StringProperty telStagiaire;
   
    private StringProperty nomStagiaire;
   
    private StringProperty emailStagiaire;
    
    private IntegerProperty idStagiaire;
   

    public StagiairePres() {

    }
    public StagiairePres(Stagiaire stagiaire) {
             this.idStagiaire=new SimpleIntegerProperty(stagiaire.getIdStagiaire());
             this.emailStagiaire=new SimpleStringProperty(stagiaire.getEmailStagiaire());
             this.nomStagiaire=new SimpleStringProperty(stagiaire.getNomStagiaire());
             this.prenomStagiaire=new SimpleStringProperty(stagiaire.getPrenomStagiaire());
             this.telStagiaire=new SimpleStringProperty(stagiaire.getTelStagiaire());
    }
   public IntegerProperty idStagiaireProperty() { return idStagiaire; }
   public StringProperty emailStagiaireProperty() { return emailStagiaire; }
   public StringProperty nomStagiaireProperty() { return nomStagiaire; }
   public StringProperty telStagiaireProperty() { return telStagiaire; }
   public StringProperty prenomStagiaireProperty() { return prenomStagiaire; }
    public String getPrenomStagiaire() {
        return this.prenomStagiaire.getValue();
    }

    public void setIdStagiaire(int idStagiaire) {
        this.idStagiaire = new SimpleIntegerProperty(idStagiaire);
    }

    public int getIdStagiaire() {
        return idStagiaire.getValue();
    }

    public void setPrenomStagiaire(String prenomStagiaire) {
        this.prenomStagiaire = new SimpleStringProperty(prenomStagiaire);
    }
   
    public String getTelStagiaire() {
        return this.telStagiaire.getValue();
    }

    public void setTelStagiaire(String telStagiaire) {
        this.telStagiaire =new SimpleStringProperty( telStagiaire);
    }
   
    public String getNomStagiaire() {
        return this.nomStagiaire.getValue();
    }

    public void setNomStagiaire(String nomStagiaire) {
        this.nomStagiaire =new SimpleStringProperty( nomStagiaire);
    }
   
    public String getEmailStagiaire() {
        return this.emailStagiaire.getValue();
    }

    public void setEmailStagiaire(String emailStagiaire) {
        this.emailStagiaire = new SimpleStringProperty(emailStagiaire);
    }
   
   
   
}
