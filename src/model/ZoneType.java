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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="zone_type")
public class ZoneType implements Serializable {

    @ManyToMany(targetEntity = LieuStage.class,mappedBy = "zoneTypeCollection")
    private Collection<LieuStage> lieuStageCollection;
    @Column(name="nom_zone",table="zone_type",length=30)
    @Basic
    private String nomZone;
    @Column(name="id_zone",table="zone_type",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idZone;

    public ZoneType() {

    }
   
    public Collection<LieuStage> getLieuStageCollection() {
        return this.lieuStageCollection;
    }

    public void setLieuStageCollection(Collection<LieuStage> lieuStageCollection) {
        this.lieuStageCollection = lieuStageCollection;
    }
   
    public String getNomZone() {
        return this.nomZone;
    }

    public void setNomZone(String nomZone) {
        this.nomZone = nomZone;
    }
   
    public Integer getIdZone() {
        return this.idZone;
    }

    public void setIdZone(Integer idZone) {
        this.idZone = idZone;
    }
}
