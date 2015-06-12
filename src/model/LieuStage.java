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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="lieu_stage")
public class LieuStage implements Serializable {

    @Column(name="ville_lieu_stage",table="lieu_stage",length=30)
    @Basic
    private String villeLieuStage;
    @Column(name="id_lieu",table="lieu_stage",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idLieu;
    @ManyToMany(targetEntity = ZoneType.class)
    @JoinTable(name="appartient_zone",joinColumns={@JoinColumn(name="id_lieu",referencedColumnName="id_lieu")},inverseJoinColumns={@JoinColumn(name="id_zone",referencedColumnName="id_zone")})
    private Collection<ZoneType> zoneTypeCollection;
    @OneToMany(targetEntity = Stage.class,mappedBy = "lieuStageIdLieu")
    private Collection<Stage> stageCollection;
    @Column(name="pays_lieu_stage",table="lieu_stage",length=30)
    @Basic
    private String paysLieuStage;

    public LieuStage() {

    }
   
    public String getVilleLieuStage() {
        return this.villeLieuStage;
    }

    public void setVilleLieuStage(String villeLieuStage) {
        this.villeLieuStage = villeLieuStage;
    }
   
    public Integer getIdLieu() {
        return this.idLieu;
    }

    public void setIdLieu(Integer idLieu) {
        this.idLieu = idLieu;
    }
   
    public Collection<ZoneType> getZoneTypeCollection() {
        return this.zoneTypeCollection;
    }

    public void setZoneTypeCollection(Collection<ZoneType> zoneTypeCollection) {
        this.zoneTypeCollection = zoneTypeCollection;
    }
   
    public Collection<Stage> getStageCollection() {
        return this.stageCollection;
    }

    public void setStageCollection(Collection<Stage> stageCollection) {
        this.stageCollection = stageCollection;
    }
   
    public String getPaysLieuStage() {
        return this.paysLieuStage;
    }

    public void setPaysLieuStage(String paysLieuStage) {
        this.paysLieuStage = paysLieuStage;
    }
}
