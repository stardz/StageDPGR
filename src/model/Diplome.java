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
@Table(name="diplome")
public class Diplome implements Serializable {

    @Column(name="id_diplome",table="diplome",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idDiplome;
    @OneToMany(targetEntity = AvoirDiplome.class,mappedBy = "diplome")
    private Collection<AvoirDiplome> avoirDiplomeCollection;
    @Column(name="libelle_deplome",table="diplome",length=30)
    @Basic
    private String libelleDeplome;

    public Diplome() {

    }
   
    public Integer getIdDiplome() {
        return this.idDiplome;
    }

    public void setIdDiplome(Integer idDiplome) {
        this.idDiplome = idDiplome;
    }
   
    public Collection<AvoirDiplome> getAvoirDiplomeCollection() {
        return this.avoirDiplomeCollection;
    }

    public void setAvoirDiplomeCollection(Collection<AvoirDiplome> avoirDiplomeCollection) {
        this.avoirDiplomeCollection = avoirDiplomeCollection;
    }
   
    public String getLibelleDeplome() {
        return this.libelleDeplome;
    }

    public void setLibelleDeplome(String libelleDeplome) {
        this.libelleDeplome = libelleDeplome;
    }
}
