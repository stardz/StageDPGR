package model;


import java.io.Serializable;
import java.lang.String;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="etat_stage")
public class EtatStage implements Serializable {

    @Column(name="etat_stage",table="etat_stage",nullable=false,length=30)
    @Id
    private String etatStage;
    @OneToMany(targetEntity = AvoirEtat.class,mappedBy = "etatStage1")
    private Collection<AvoirEtat> avoirEtatCollection;

    public EtatStage() {

    }
   
    public String getEtatStage() {
        return this.etatStage;
    }

    public void setEtatStage(String etatStage) {
        this.etatStage = etatStage;
    }
   
    public Collection<AvoirEtat> getAvoirEtatCollection() {
        return this.avoirEtatCollection;
    }

    public void setAvoirEtatCollection(Collection<AvoirEtat> avoirEtatCollection) {
        this.avoirEtatCollection = avoirEtatCollection;
    }
}
