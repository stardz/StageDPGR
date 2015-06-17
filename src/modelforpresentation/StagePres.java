package modelforpresentation;


import model.*;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


public class StagePres {

    
    private StringProperty dateFinStage;
    
    private StringProperty objectifStage;
    
    private StringProperty dateDebutStage;
   
    private IntegerProperty idStage;
    
    private StringProperty environnementStage;
     
    private StringProperty missionStage;
   

    public StagePres() {

    }
    public StagePres(Stage stage) {
       this.setIdStage(stage.getIdStage());
       this.setDateDebutStage(stage.getDateDebutStage().toString());
       this.setDateFinStage(stage.getDateFinStage().toString());
       this.setObjectifStage(stage.getObjectifStage());
       this.setMissionStage(stage.getMissionStage());
       this.setEnvironnementStage(stage.getEnvironnementStage());
    }
    public IntegerProperty loginUtilisateurProperty() { return idStage; }
    public StringProperty dateFinStageProperty() { return dateFinStage; }
    public StringProperty dateDebutStageProperty() { return dateDebutStage; }
    public StringProperty objectifStageProperty() { return objectifStage; }
    public StringProperty environnementStageProperty() { return environnementStage; }
    public StringProperty missionStageProperty() { return missionStage; }
    
    public String getDateFinStage() {
        return this.dateFinStage.getValue();
    }

    public void setDateFinStage(String dateFinStage) {
        this.dateFinStage =new SimpleStringProperty(dateFinStage) ;
    }
   
    public String getObjectifStage() {
        return this.objectifStage.getValue();
    }

    public void setObjectifStage(String objectifStage) {
        this.objectifStage =new SimpleStringProperty(objectifStage) ;
    }
   
   
   
    public String getDateDebutStage() {
        return this.dateDebutStage.getValue();
    }

    public void setDateDebutStage(String dateDebutStage) {
        this.dateDebutStage =new SimpleStringProperty(dateDebutStage);
    }
 
    public Integer getIdStage() {
        return this.idStage.getValue();
    }

    public void setIdStage(Integer idStage) {
        this.idStage = new SimpleIntegerProperty(idStage);
    }
   
    public String getEnvironnementStage() {
        return this.environnementStage.getValue();
    }

    public void setEnvironnementStage(String environnementStage) {
        this.environnementStage =new SimpleStringProperty(environnementStage) ;
    }
   
    public String getMissionStage() {
        return this.missionStage.getValue();
    }

    public void setMissionStage(String missionStage) {
        this.missionStage =new SimpleStringProperty(missionStage) ;
    }
   
    
   
   
}
