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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="manifestation")
public class Manifestation implements Serializable {

    @OneToMany(targetEntity = AvoirFraisManif.class,mappedBy = "manifestation")
    private Collection<AvoirFraisManif> avoirFraisManifCollection;
    @OneToMany(targetEntity = InviteManifestation.class,mappedBy = "manifestation")
    private Collection<InviteManifestation> inviteManifestationCollection;
    @Column(name="objet_invitation",table="manifestation",length=256)
    @Basic
    private String objetInvitation;
    @Column(name="id_manifestation",table="manifestation",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idManifestation;
    @ManyToOne(targetEntity = FraisSejour.class)
    @JoinColumn(name="frais_sejour_numero_frais_sejour",referencedColumnName="numero_frais_sejour")
    private FraisSejour fraisSejourNumeroFraisSejour;

    public Manifestation() {

    }
   
    public Collection<AvoirFraisManif> getAvoirFraisManifCollection() {
        return this.avoirFraisManifCollection;
    }

    public void setAvoirFraisManifCollection(Collection<AvoirFraisManif> avoirFraisManifCollection) {
        this.avoirFraisManifCollection = avoirFraisManifCollection;
    }
   
    public Collection<InviteManifestation> getInviteManifestationCollection() {
        return this.inviteManifestationCollection;
    }

    public void setInviteManifestationCollection(Collection<InviteManifestation> inviteManifestationCollection) {
        this.inviteManifestationCollection = inviteManifestationCollection;
    }
   
    public String getObjetInvitation() {
        return this.objetInvitation;
    }

    public void setObjetInvitation(String objetInvitation) {
        this.objetInvitation = objetInvitation;
    }
   
    public Integer getIdManifestation() {
        return this.idManifestation;
    }

    public void setIdManifestation(Integer idManifestation) {
        this.idManifestation = idManifestation;
    }
   
    public FraisSejour getFraisSejourNumeroFraisSejour() {
        return this.fraisSejourNumeroFraisSejour;
    }

    public void setFraisSejourNumeroFraisSejour(FraisSejour fraisSejourNumeroFraisSejour) {
        this.fraisSejourNumeroFraisSejour = fraisSejourNumeroFraisSejour;
    }
}
