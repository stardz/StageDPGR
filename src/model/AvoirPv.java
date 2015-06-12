package model;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="avoir_pv")
public class AvoirPv implements Serializable {

    @Column(name="id_pv",table="avoir_pv",nullable=false)
    @Id
    private int idPv;
    @ManyToOne(optional=false,targetEntity = MembreCs.class)
    @JoinColumn(name="id_membre_cs",referencedColumnName="id_membre_cs",insertable=false,updatable=false)
    private MembreCs membreCs;
    @ManyToOne(optional=false,targetEntity = Stage.class)
    @JoinColumn(name="id_stage",referencedColumnName="id_stage",insertable=false,updatable=false)
    private Stage stage;
    @ManyToOne(optional=false,targetEntity = Pv.class)
    @JoinColumn(name="id_pv",referencedColumnName="id_pv",insertable=false,updatable=false)
    private Pv pv;
    @Column(name="id_stage",table="avoir_pv",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idStage;
    @Column(name="id_membre_cs",table="avoir_pv",nullable=false)
    @Id
    private int idMembreCs;

    public AvoirPv() {

    }
   
    public int getIdPv() {
        return this.idPv;
    }

    public void setIdPv(int idPv) {
        this.idPv = idPv;
    }
   
    public MembreCs getMembreCs() {
        return this.membreCs;
    }

    public void setMembreCs(MembreCs membreCs) {
        this.membreCs = membreCs;
    }
   
    public Stage getStage() {
        return this.stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
   
    public Pv getPv() {
        return this.pv;
    }

    public void setPv(Pv pv) {
        this.pv = pv;
    }
   
    public int getIdStage() {
        return this.idStage;
    }

    public void setIdStage(int idStage) {
        this.idStage = idStage;
    }
   
    public int getIdMembreCs() {
        return this.idMembreCs;
    }

    public void setIdMembreCs(int idMembreCs) {
        this.idMembreCs = idMembreCs;
    }
}
