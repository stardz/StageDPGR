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
@Table(name="fonction")
public class Fonction implements Serializable {

    @Column(name="id_fonction",table="fonction",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idFonction;
    @Column(name="libelle_fonction",table="fonction",length=30)
    @Basic
    private String libelleFonction;
    @OneToMany(targetEntity = AvoirFctMemCs.class,mappedBy = "fonction")
    private Collection<AvoirFctMemCs> avoirFctMemCsCollection;
    @OneToMany(targetEntity = AvoirFonction.class,mappedBy = "fonction")
    private Collection<AvoirFonction> avoirFonctionCollection;

    public Fonction() {

    }
   
    public Integer getIdFonction() {
        return this.idFonction;
    }

    public void setIdFonction(Integer idFonction) {
        this.idFonction = idFonction;
    }
   
    public String getLibelleFonction() {
        return this.libelleFonction;
    }

    public void setLibelleFonction(String libelleFonction) {
        this.libelleFonction = libelleFonction;
    }
   
    public Collection<AvoirFctMemCs> getAvoirFctMemCsCollection() {
        return this.avoirFctMemCsCollection;
    }

    public void setAvoirFctMemCsCollection(Collection<AvoirFctMemCs> avoirFctMemCsCollection) {
        this.avoirFctMemCsCollection = avoirFctMemCsCollection;
    }
   
    public Collection<AvoirFonction> getAvoirFonctionCollection() {
        return this.avoirFonctionCollection;
    }

    public void setAvoirFonctionCollection(Collection<AvoirFonction> avoirFonctionCollection) {
        this.avoirFonctionCollection = avoirFonctionCollection;
    }
}
