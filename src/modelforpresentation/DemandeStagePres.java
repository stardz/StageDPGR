package modelforpresentation;


import model.*;
import java.io.Serializable;
import java.lang.String;
import java.util.Date;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class DemandeStagePres implements Serializable {

    
    
    
    
    
    private StringProperty dateDemandeStage;
    private IntegerProperty idStagiaire;
    private IntegerProperty idStage;
    private StringProperty avisDadpgrStage;
    private StringProperty avisCsStage;
    private StringProperty autorisationDeStage;
    public DemandeStagePres() {

    }
   public DemandeStagePres(DemandeStage dmdStage) {
         this.setIdStage(dmdStage.getIdStage());
         this.setIdStagiaire(dmdStage.getIdStagiaire());
         this.setDateDemandeStage(dmdStage.getDateDemandeStage().toString());
         this.setAutorisationDeStage(dmdStage.getAutorisationDeStage());
         this.setAvisDadpgrStage(dmdStage.getAvisDadpgrStage());
         this.setAvisCsStage(dmdStage.getAvisCsStage());
    }
    public IntegerProperty idStagiaireProperty() { return idStagiaire; }
    public IntegerProperty idStageProperty() { return idStage; }
    public StringProperty dateDemandeStageProperty() { return dateDemandeStage; }
    public StringProperty avisDadpgrStageStageProperty() { return avisDadpgrStage; }
    public StringProperty avisCsStageStageProperty() { return avisCsStage; }
    public StringProperty autorisationDeStageStageProperty() { return autorisationDeStage; }
    
    
    public String getAvisDadpgrStage() {
        return this.avisDadpgrStage.getValue();
    }

    public void setAvisDadpgrStage(String avisDadpgrStage) {
        this.avisDadpgrStage = new SimpleStringProperty(avisDadpgrStage);
    }
   
    

    
    public String getAutorisationDeStage() {
        return this.autorisationDeStage.getValue();
    }

    public void setAutorisationDeStage(String autorisationDeStage) {
        this.autorisationDeStage =new SimpleStringProperty(autorisationDeStage);
    }
   
    public int getIdStagiaire() {
        return this.idStagiaire.getValue();
    }

    public void setIdStagiaire(int idStagiaire) {
        this.idStagiaire = new SimpleIntegerProperty(idStagiaire);
    }
   
    public int getIdStage() {
        return this.idStage.getValue();
    }

    public void setIdStage(int idStage) {
        this.idStage = new SimpleIntegerProperty(idStage);
    }
   
    public String getDateDemandeStage() {
        return this.dateDemandeStage.getValue();
    }

    public void setDateDemandeStage(String dateDemandeStage) {
        this.dateDemandeStage = new SimpleStringProperty(dateDemandeStage);
    }
   
    public String getAvisCsStage() {
        return this.avisCsStage.getValue();
    }

    public void setAvisCsStage(String avisCsStage) {
        this.avisCsStage = new SimpleStringProperty(avisCsStage);
    }
}
