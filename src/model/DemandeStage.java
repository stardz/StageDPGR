package model;


import java.io.Serializable;
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
@Table(name="demande_stage")
public class DemandeStage implements Serializable {

    @ManyToOne(optional=false,targetEntity = Stage.class)
    @JoinColumn(name="id_stage",referencedColumnName="id_stage",insertable=false,updatable=false)
    private Stage stage;
    @Column(name="avis_dadpgr_stage",table="demande_stage",length=30)
    @Basic
    private String avisDadpgrStage;
    @ManyToOne(optional=false,targetEntity = Stagiaire.class)
    @JoinColumn(name="id_stagiaire",referencedColumnName="id_stagiaire",insertable=false,updatable=false)
    private Stagiaire stagiaire;
    @Column(name="autorisation_de_stage",table="demande_stage",length=30)
    @Basic
    private String autorisationDeStage;
    @Column(name="id_stagiaire",table="demande_stage",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idStagiaire;
    @Column(name="id_stage",table="demande_stage",nullable=false)
    @Id
    private int idStage;
    @Column(name="date_Demande_Stage",table="demande_stage")
    @Temporal(TemporalType.DATE)
    @Basic
    private Date dateDemandeStage;
    @Column(name="avis_cs_stage",table="demande_stage",length=30)
    @Basic
    private String avisCsStage;

    public DemandeStage() {

    }
   
    public Stage getStage() {
        return this.stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
   
    public String getAvisDadpgrStage() {
        return this.avisDadpgrStage;
    }

    public void setAvisDadpgrStage(String avisDadpgrStage) {
        this.avisDadpgrStage = avisDadpgrStage;
    }
   
    public Stagiaire getStagiaire() {
        return this.stagiaire;
    }

    public void setStagiaire(Stagiaire stagiaire) {
        this.stagiaire = stagiaire;
    }
   
    public String getAutorisationDeStage() {
        return this.autorisationDeStage;
    }

    public void setAutorisationDeStage(String autorisationDeStage) {
        this.autorisationDeStage = autorisationDeStage;
    }
   
    public int getIdStagiaire() {
        return this.idStagiaire;
    }

    public void setIdStagiaire(int idStagiaire) {
        this.idStagiaire = idStagiaire;
    }
   
    public int getIdStage() {
        return this.idStage;
    }

    public void setIdStage(int idStage) {
        this.idStage = idStage;
    }
   
    public Date getDateDemandeStage() {
        return this.dateDemandeStage;
    }

    public void setDateDemandeStage(Date dateDemandeStage) {
        this.dateDemandeStage = dateDemandeStage;
    }
   
    public String getAvisCsStage() {
        return this.avisCsStage;
    }

    public void setAvisCsStage(String avisCsStage) {
        this.avisCsStage = avisCsStage;
    }
}
