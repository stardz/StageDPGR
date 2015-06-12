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
@Table(name="laboratoire_rattachement")
public class LaboratoireRattachement implements Serializable {

    @Column(name="nom_labo",table="laboratoire_rattachement",length=30)
    @Basic
    private String nomLabo;
    @OneToMany(targetEntity = AffecteLabo.class,mappedBy = "laboratoireRattachement")
    private Collection<AffecteLabo> affecteLaboCollection;
    @Column(name="id_labo",table="laboratoire_rattachement",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idLabo;

    public LaboratoireRattachement() {

    }
   
    public String getNomLabo() {
        return this.nomLabo;
    }

    public void setNomLabo(String nomLabo) {
        this.nomLabo = nomLabo;
    }
   
    public Collection<AffecteLabo> getAffecteLaboCollection() {
        return this.affecteLaboCollection;
    }

    public void setAffecteLaboCollection(Collection<AffecteLabo> affecteLaboCollection) {
        this.affecteLaboCollection = affecteLaboCollection;
    }
   
    public Integer getIdLabo() {
        return this.idLabo;
    }

    public void setIdLabo(Integer idLabo) {
        this.idLabo = idLabo;
    }
}
