package model;


import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="avoir_frai_stage")
public class AvoirFraiStage implements Serializable {

    @ManyToOne(optional=false,targetEntity = Stage.class)
    @JoinColumn(name="id_stage",referencedColumnName="id_stage",insertable=false,updatable=false)
    private Stage stage;
    @Column(name="id_frai_stage",table="avoir_frai_stage",nullable=false)
    @Id
    private int idFraiStage;
    @Column(name="total_frais_stage",table="avoir_frai_stage")
    @Basic
    private Integer totalFraisStage;
    @Column(name="id_stage",table="avoir_frai_stage",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idStage;
    @ManyToOne(optional=false,targetEntity = FraisStage.class)
    @JoinColumn(name="id_frai_stage",referencedColumnName="id_frai_stage",insertable=false,updatable=false)
    private FraisStage fraisStage;

    public AvoirFraiStage() {

    }
   
    public Stage getStage() {
        return this.stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
   
    public int getIdFraiStage() {
        return this.idFraiStage;
    }

    public void setIdFraiStage(int idFraiStage) {
        this.idFraiStage = idFraiStage;
    }
   
    public Integer getTotalFraisStage() {
        return this.totalFraisStage;
    }

    public void setTotalFraisStage(Integer totalFraisStage) {
        this.totalFraisStage = totalFraisStage;
    }
   
    public int getIdStage() {
        return this.idStage;
    }

    public void setIdStage(int idStage) {
        this.idStage = idStage;
    }
   
    public FraisStage getFraisStage() {
        return this.fraisStage;
    }

    public void setFraisStage(FraisStage fraisStage) {
        this.fraisStage = fraisStage;
    }
}
