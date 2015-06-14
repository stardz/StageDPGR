package model;


import java.io.Serializable;
import java.io.Serializable;
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
@Table(name="appartient_zone")
public class AppartientZone implements Serializable {

    @ManyToOne(optional=false,targetEntity = ZoneType.class)
    @JoinColumn(name="id_zone",referencedColumnName="id_zone",insertable=false,updatable=false)
    private ZoneType zoneType;
    @Column(name="id_lieu",table="appartient_zone",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idLieu;
    @Column(name="commentaires",table="appartient_zone")
    @Basic
    private Serializable commentaires;
    @Column(name="id_zone",table="appartient_zone",nullable=false)
    @Id
    private int idZone;
    @ManyToOne(optional=false,targetEntity = LieuStage.class)
    @JoinColumn(name="id_lieu",referencedColumnName="id_lieu",insertable=false,updatable=false)
    private LieuStage lieuStage;

    public AppartientZone() {

    }
   
    public ZoneType getZoneType() {
        return this.zoneType;
    }

    public void setZoneType(ZoneType zoneType) {
        this.zoneType = zoneType;
    }
   
    public int getIdLieu() {
        return this.idLieu;
    }

    public void setIdLieu(int idLieu) {
        this.idLieu = idLieu;
    }
   
    public Serializable getCommentaires() {
        return this.commentaires;
    }

    public void setCommentaires(Serializable commentaires) {
        this.commentaires = commentaires;
    }
   
    public int getIdZone() {
        return this.idZone;
    }

    public void setIdZone(int idZone) {
        this.idZone = idZone;
    }
   
    public LieuStage getLieuStage() {
        return this.lieuStage;
    }

    public void setLieuStage(LieuStage lieuStage) {
        this.lieuStage = lieuStage;
    }
}
