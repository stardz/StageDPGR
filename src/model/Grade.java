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
@Table(name="grade")
public class Grade implements Serializable {

    @Column(name="libelle_grade",table="grade",length=30)
    @Basic
    private String libelleGrade;
    @OneToMany(targetEntity = AvoirGrade.class,mappedBy = "grade")
    private Collection<AvoirGrade> avoirGradeCollection;
    @OneToMany(targetEntity = AvoirGradeMemCs.class,mappedBy = "grade")
    private Collection<AvoirGradeMemCs> avoirGradeMemCsCollection;
    @Column(name="id_grade",table="grade",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idGrade;

    public Grade() {

    }
   
    public String getLibelleGrade() {
        return this.libelleGrade;
    }

    public void setLibelleGrade(String libelleGrade) {
        this.libelleGrade = libelleGrade;
    }
   
    public Collection<AvoirGrade> getAvoirGradeCollection() {
        return this.avoirGradeCollection;
    }

    public void setAvoirGradeCollection(Collection<AvoirGrade> avoirGradeCollection) {
        this.avoirGradeCollection = avoirGradeCollection;
    }
   
    public Collection<AvoirGradeMemCs> getAvoirGradeMemCsCollection() {
        return this.avoirGradeMemCsCollection;
    }

    public void setAvoirGradeMemCsCollection(Collection<AvoirGradeMemCs> avoirGradeMemCsCollection) {
        this.avoirGradeMemCsCollection = avoirGradeMemCsCollection;
    }
   
    public Integer getIdGrade() {
        return this.idGrade;
    }

    public void setIdGrade(Integer idGrade) {
        this.idGrade = idGrade;
    }
}
