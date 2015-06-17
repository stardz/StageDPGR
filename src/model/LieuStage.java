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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "lieu_stage")
public class LieuStage implements Serializable {

    @Column(name = "ville_lieu_stage", table = "lieu_stage", length = 30)
    @Basic
    private String villeLieuStage;
    @OneToMany(targetEntity = AppartientZone.class, mappedBy = "lieuStage")
    private Collection<AppartientZone> appartientZoneCollection;
    @Column(name = "id_lieu", table = "lieu_stage", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idLieu;
    @Column(name = "pays_lieu_stage", table = "lieu_stage", length = 30)
    @Basic
    private String paysLieuStage;

    public LieuStage() {

    }

    public LieuStage(Integer idLieu, String villeLieuStage, String paysLieuStage) {
        this.villeLieuStage = villeLieuStage;
        this.idLieu = idLieu;
        this.paysLieuStage = paysLieuStage;
    }

    public String getVilleLieuStage() {
        return this.villeLieuStage;
    }

    public void setVilleLieuStage(String villeLieuStage) {
        this.villeLieuStage = villeLieuStage;
    }

    public Collection<AppartientZone> getAppartientZoneCollection() {
        return this.appartientZoneCollection;
    }

    public void setAppartientZoneCollection(Collection<AppartientZone> appartientZoneCollection) {
        this.appartientZoneCollection = appartientZoneCollection;
    }

    public Integer getIdLieu() {
        return this.idLieu;
    }

    public void setIdLieu(Integer idLieu) {
        this.idLieu = idLieu;
    }

    public String getPaysLieuStage() {
        return this.paysLieuStage;
    }

    public void setPaysLieuStage(String paysLieuStage) {
        this.paysLieuStage = paysLieuStage;
    }
}
