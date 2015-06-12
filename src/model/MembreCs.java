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
@Table(name="membre_cs")
public class MembreCs implements Serializable {

    @OneToMany(targetEntity = AvoirFctMemCs.class,mappedBy = "membreCs")
    private Collection<AvoirFctMemCs> avoirFctMemCsCollection;
    @OneToMany(targetEntity = AvoirPv.class,mappedBy = "membreCs")
    private Collection<AvoirPv> avoirPvCollection;
    @OneToMany(targetEntity = AvoirGradeMemCs.class,mappedBy = "membreCs")
    private Collection<AvoirGradeMemCs> avoirGradeMemCsCollection;
    @Column(name="nom_mem_cs",table="membre_cs",length=30)
    @Basic
    private String nomMemCs;
    @Column(name="prenom_mem_cs",table="membre_cs",length=30)
    @Basic
    private String prenomMemCs;
    @Column(name="id_membre_cs",table="membre_cs",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idMembreCs;

    public MembreCs() {

    }
   
    public Collection<AvoirFctMemCs> getAvoirFctMemCsCollection() {
        return this.avoirFctMemCsCollection;
    }

    public void setAvoirFctMemCsCollection(Collection<AvoirFctMemCs> avoirFctMemCsCollection) {
        this.avoirFctMemCsCollection = avoirFctMemCsCollection;
    }
   
    public Collection<AvoirPv> getAvoirPvCollection() {
        return this.avoirPvCollection;
    }

    public void setAvoirPvCollection(Collection<AvoirPv> avoirPvCollection) {
        this.avoirPvCollection = avoirPvCollection;
    }
   
    public Collection<AvoirGradeMemCs> getAvoirGradeMemCsCollection() {
        return this.avoirGradeMemCsCollection;
    }

    public void setAvoirGradeMemCsCollection(Collection<AvoirGradeMemCs> avoirGradeMemCsCollection) {
        this.avoirGradeMemCsCollection = avoirGradeMemCsCollection;
    }
   
    public String getNomMemCs() {
        return this.nomMemCs;
    }

    public void setNomMemCs(String nomMemCs) {
        this.nomMemCs = nomMemCs;
    }
   
    public String getPrenomMemCs() {
        return this.prenomMemCs;
    }

    public void setPrenomMemCs(String prenomMemCs) {
        this.prenomMemCs = prenomMemCs;
    }
   
    public Integer getIdMembreCs() {
        return this.idMembreCs;
    }

    public void setIdMembreCs(Integer idMembreCs) {
        this.idMembreCs = idMembreCs;
    }
}
