/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistance;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.*;

/**
 *
 * @author Oo
 */
public class PersistManager {
    /*
     Stagiaires
     */

    public static List<Stagiaire> findAllStagiaires() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Stagiaire> query = entityManager.createQuery("SELECT c FROM Stagiaire c", Stagiaire.class);
        List<Stagiaire> result = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }

    public static Stagiaire findStagiaireById(int id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Stagiaire stagiare = null;
        stagiare = entityManager.find(Stagiaire.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return stagiare;
    }

    public static void insertStagiaire(Stagiaire stagiaire) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(stagiaire);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
    public static void updateStagiaire(Stagiaire stagiaire) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Stagiaire st=entityManager.find(Stagiaire.class, stagiaire.getIdStagiaire());
        st.setIdStagiaire(stagiaire.getIdStagiaire());
        st.setNomStagiaire(stagiaire.getNomStagiaire());
        st.setPrenomStagiaire(stagiaire.getPrenomStagiaire());
        st.setEmailStagiaire(stagiaire.getEmailStagiaire());
        st.setTelStagiaire(stagiaire.getTelStagiaire());
       // entityManager.persist(stagiaire);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
    public static void deleteStagiaire(int idStagiaire){
         EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
       model.Stagiaire stagiaire = null;
        stagiaire = entityManager.find(Stagiaire.class, idStagiaire);
      model.Stagiaire toBeRemoved = entityManager.merge(stagiaire);
       entityManager.remove(toBeRemoved);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public static void affectLabo(int idLabo, int idStagiaire, Date date) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        AffecteLabo affLabo = new AffecteLabo();
        affLabo.setIdLabo(idLabo);
        affLabo.setIdStagiaire(idStagiaire);
        affLabo.setDateAffecteLabo(date);
        entityManager.persist(affLabo);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static List<LaboratoireRattachement> getSesLabo(int idStagiaire) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<AffecteLabo> query = entityManager.createQuery("SELECT c FROM AffecteLabo c", AffecteLabo.class);
        List<AffecteLabo> affecteLaboListe = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        List<LaboratoireRattachement> result = new ArrayList<LaboratoireRattachement>();
        for (AffecteLabo it : affecteLaboListe) {
            if (it.getIdStagiaire() == idStagiaire) {
                result.add(findLaboById(it.getIdLabo()));
            }
        }
        return result;
    }
    public static void deleteSesLabo(int idStagiaire){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<AffecteLabo> query = entityManager.createQuery("SELECT c FROM AffecteLabo c", AffecteLabo.class);
        List<AffecteLabo> avoirLaboListe = query.getResultList();
        AffecteLabo affLabo;
        AffecteLabo affLaboRemove;
        LaboratoireRattachement toBeRemoved;
        LaboratoireRattachement dpl;
        for (AffecteLabo it : avoirLaboListe) {
            if (it.getIdStagiaire() == idStagiaire) {
               
               affLaboRemove=entityManager.merge(it); 
               entityManager.remove(affLaboRemove);
               dpl=findLaboById(it.getIdLabo());
               toBeRemoved=entityManager.merge(dpl);
             //  entityManager.remove(toBeRemoved);
            }
        }    
        entityManager.getTransaction().commit();
        entityManager.close();
   }
    public static void affectEncadrant(int idEncadrant, int idStagiaire, Date dateEncad, String sujetThese, String travAccomplis, String objectifs) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        EncadrePar encPar = new EncadrePar();
        encPar.setIdStagiaire(idStagiaire);
        encPar.setIdEncadrant(idEncadrant);
        encPar.setDateEncadrePar(dateEncad);
        encPar.setObjectifs(objectifs);
        encPar.setTravauxAccomplis(travAccomplis);
        encPar.setSujetThese(sujetThese);
        entityManager.persist(encPar);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static List<Encadrant> getSesEncadrant(int idStagiaire) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<EncadrePar> query = entityManager.createQuery("SELECT c FROM EncadrePar c", EncadrePar.class);
        List<EncadrePar> encadreParListe = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        List<Encadrant> result = new ArrayList<Encadrant>();
        for (EncadrePar it : encadreParListe) {
            if (it.getIdStagiaire() == idStagiaire) {
                result.add(findEncadrantById(it.getIdEncadrant()));
            }
        }
        return result;
    }
    
    public static void affectDeplome(int idDimplome, int idStagiaire, Date date) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        AvoirDiplome avDiplome = new AvoirDiplome();
        avDiplome.setDateAvoirDiplome(date);
        avDiplome.setIdDiplome(idDimplome);
        avDiplome.setIdStagiaire(idStagiaire);
        entityManager.persist(avDiplome);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static List<Diplome> getSesDiplome(int idStagiaire) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<AvoirDiplome> query = entityManager.createQuery("SELECT c FROM AvoirDiplome c", AvoirDiplome.class);
        List<AvoirDiplome> avoirDiplomeListe = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        List<Diplome> result = new ArrayList<Diplome>();
        for (AvoirDiplome it : avoirDiplomeListe) {
            if (it.getIdStagiaire() == idStagiaire) {
                result.add(findDiplomeById(it.getIdDiplome()));
            }
        }
        return result;
    }
   public static void deleteSesDiplomes(int idStagiaire){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<AvoirDiplome> query = entityManager.createQuery("SELECT c FROM AvoirDiplome c", AvoirDiplome.class);
        List<AvoirDiplome> avoirDiplomeListe = query.getResultList();
        AvoirDiplome avDiplome;
        AvoirDiplome avDiplomeRemove;
        Diplome toBeRemoved;
        Diplome dpl;
        for (AvoirDiplome it : avoirDiplomeListe) {
            if (it.getIdStagiaire() == idStagiaire) {
               
               avDiplomeRemove=entityManager.merge(it); 
               entityManager.remove(avDiplomeRemove);
               dpl=findDiplomeById(it.getIdDiplome());
               toBeRemoved=entityManager.merge(dpl);
            //   entityManager.remove(toBeRemoved);
            }
        }    
        entityManager.getTransaction().commit();
        entityManager.close();
   }
    public static void affectGrade(int idGrade, int idStagiaire, Date date) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        AvoirGrade avGrade = new AvoirGrade();
        avGrade.setDateAvoirGrade(date);
        avGrade.setIdGrade(idGrade);
        avGrade.setIdStagiaire(idStagiaire);
        entityManager.persist(avGrade);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
   public static void deleteSesGrade(int idStagiaire){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<AvoirGrade> query = entityManager.createQuery("SELECT c FROM AvoirGrade c", AvoirGrade.class);
        List<AvoirGrade> avoirGradeListe = query.getResultList();
        AvoirGrade avGrade;
        AvoirGrade avGradeRemove;
        Grade toBeRemoved;
        Grade dpl;
        for (AvoirGrade it : avoirGradeListe) {
            if (it.getIdStagiaire() == idStagiaire) {
               avGradeRemove=entityManager.merge(it); 
               entityManager.remove(avGradeRemove);
               dpl=findGradeById(it.getIdGrade());
               toBeRemoved=entityManager.merge(dpl);
             //  entityManager.remove(toBeRemoved);
            }
        }    
        entityManager.getTransaction().commit();
        entityManager.close();
   }
    public static List<Grade> getSesGrade(int idStagiaire) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<AvoirGrade> query = entityManager.createQuery("SELECT c FROM AvoirGrade c", AvoirGrade.class);
        List<AvoirGrade> avoirGradeListe = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        List<Grade> result = new ArrayList<Grade>();
        for (AvoirGrade it : avoirGradeListe) {
            if (it.getIdStagiaire() == idStagiaire) {
                result.add(findGradeById(it.getIdGrade()));
            }
        }
        return result;
    }
    
    public static void affectFonction(int idFonction, int idStagiaire, Date date) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        AvoirFonction avFonction = new AvoirFonction();
        avFonction.setDateAvoirFonction(date);
        avFonction.setIdFonction(idFonction);
        avFonction.setIdStagiaire(idStagiaire);
        entityManager.persist(avFonction);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static List<Fonction> getSesFonction(int idStagiaire) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<AvoirFonction> query = entityManager.createQuery("SELECT c FROM AvoirFonction c", AvoirFonction.class);
        List<AvoirFonction> avoirFonctionListe = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        List<Fonction> result = new ArrayList<Fonction>();
        for (AvoirFonction it : avoirFonctionListe) {
            if (it.getIdStagiaire() == idStagiaire) {
                result.add(findFonctionById(it.getIdFonction()));
            }
        }
        return result;
    }
    public static void deleteSesFonction(int idStagiaire){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<AvoirFonction> query = entityManager.createQuery("SELECT c FROM AvoirFonction c", AvoirFonction.class);
        List<AvoirFonction> avoirFonctionListe = query.getResultList();
        AvoirFonction avFonction;
        AvoirFonction avFonctionRemove;
        Grade toBeRemoved;
        Grade dpl;
        for (AvoirFonction it : avoirFonctionListe) {
            if (it.getIdStagiaire() == idStagiaire) {
               avFonctionRemove=entityManager.merge(it); 
               entityManager.remove(avFonctionRemove);
               dpl=findGradeById(it.getIdFonction());
               toBeRemoved=entityManager.merge(dpl);
          //     entityManager.remove(toBeRemoved);
            }
        }    
        entityManager.getTransaction().commit();
        entityManager.close();
   }
    /*
     Stages
     */

    public static void insertStage(Stage stage) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(stage);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public static void updateStage(Stage stage){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Stage stg=findStageById(stage.getIdStage());
        stg.setIdStage(stage.getIdStage());
        stg.setDateDebutStage(stage.getDateDebutStage());
        stg.setDateFinStage(stage.getDateFinStage());
        stg.setObjectifStage(stage.getObjectifStage());
        stg.setEnvironnementStage(stage.getEnvironnementStage());
        stg.setMissionStage(stage.getMissionStage());
       
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public static List<Stage> findAllStages() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Stage> query = entityManager.createQuery("SELECT c FROM Stage c", Stage.class);
        List<Stage> result = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }

    public static Stage findStageById(int id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Stage stage = null;
        stage = entityManager.find(Stage.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return stage;
    }

    public static void attribuerPv(int idStage, int idPv, int[] idsMemCs) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        AvoirPv avoirPv = new AvoirPv();
        avoirPv.setIdStage(idStage);
        avoirPv.setIdPv(idPv);
        for (int i : idsMemCs) {
            avoirPv.setIdMembreCs(i);
            entityManager.persist(avoirPv);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static List<Pv> getSesPv(int idStage) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<AvoirPv> query = entityManager.createQuery("SELECT c FROM AvoirPv c", AvoirPv.class);
        List<AvoirPv> avoirPvListe = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        List<Pv> result = new ArrayList<Pv>();
        for (AvoirPv it : avoirPvListe) {
            if (it.getIdStage() == idStage) {
                result.add(findPvById(it.getIdStage()));
            }
        }
        return result;
    }
    
    /*
    Frais stage
    */
    
    public static FraisStage getSesFrais(int idStage) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
         TypedQuery<AvoirFraiStage> query = entityManager.createQuery("SELECT c FROM AvoirFraiStage c where c.idStage=:arg1", AvoirFraiStage.class).setParameter("arg1",idStage);
        List<AvoirFraiStage> avFraiStage = null;
        avFraiStage=query.getResultList();
            
//   AvoirFraiStage avFraiStage=entityManager.find(AvoirFraiStage.class,new CKey(idStage, idStage));
        FraisStage fraisStage=entityManager.find(FraisStage.class,avFraiStage.get(avFraiStage.size()-1).getIdFraiStage());
        entityManager.getTransaction().commit();
        return fraisStage;
    }
    
    /*
     Manifestation
     */

    public static void insertManifestation(Manifestation manif) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(manif);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static List<Manifestation> findAllManifestations() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Manifestation> query = entityManager.createQuery("SELECT c FROM Manifestation c", Manifestation.class);
        List<Manifestation> result = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }

    public static Manifestation findManifestationById(int id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Manifestation manifestation = null;
        manifestation = entityManager.find(Manifestation.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return manifestation;
    }

    /*
     Demandes de Stage
     */
    public static void insertDemandeStage(DemandeStage demandeStage) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(demandeStage);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public static void deleteDemandeStage(CKey cKey){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<DemandeStage> query = entityManager.createQuery("SELECT c FROM DemandeStage c where c.idStage=:arg1 AND c.idStagiaire=:arg2", DemandeStage.class).setParameter("arg1",cKey.key1);
        query.setParameter("arg2", cKey.key2);
        List<DemandeStage> demandeStages = query.getResultList();
        DemandeStage dmdStage=demandeStages.get(demandeStages.size()-1);
        DemandeStage toBeRemoved = entityManager.merge(dmdStage);
        entityManager.remove(toBeRemoved);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public static List<DemandeStage> findAllDemandeStages() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<DemandeStage> query = entityManager.createQuery("SELECT c FROM DemandeStage c", DemandeStage.class);
        List<DemandeStage> result = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }

    public static void affectDemandeStage(int idStagiaire, int idStage, Date dateDemandeStage) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        DemandeStage demandeStage = new DemandeStage();
        demandeStage.setDateDemandeStage(dateDemandeStage);
        demandeStage.setIdStage(idStage);
        demandeStage.setIdStagiaire(idStagiaire);
        demandeStage.setAvisDadpgrStage("ATT");
        demandeStage.setAvisCsStage("ATT");
        demandeStage.setAutorisationDeStage("ATT");
        entityManager.persist(demandeStage);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static List<DemandeStage> getSesDemandeStage(int idStagiaire) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<DemandeStage> query = entityManager.createQuery("SELECT c FROM DemandeStage c", DemandeStage.class);
        List<DemandeStage> demandeStagesListe = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        List<DemandeStage> result = new ArrayList<DemandeStage>();
        for (DemandeStage it : demandeStagesListe) {
            if (it.getIdStagiaire() == idStagiaire) {
                result.add(it);
            }
        }
        return result;
    }
    public static DemandeStage getDemandeOfStage(int idStage){
         EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<DemandeStage> query = entityManager.createQuery("SELECT c FROM DemandeStage c where c.idStage=:arg1", DemandeStage.class).setParameter("arg1",idStage);
        List<DemandeStage> demandeStages = query.getResultList();
        DemandeStage dmdStage=demandeStages.get(demandeStages.size()-1);
        entityManager.getTransaction().commit();
        entityManager.close();
        return dmdStage;
    }
    public static DemandeStage findDemandeStageByIds(CKey cKey){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<DemandeStage> query = entityManager.createQuery("SELECT c FROM DemandeStage c where c.idStage=:arg1 AND c.idStagiaire=:arg2", DemandeStage.class).setParameter("arg1",cKey.key1);
        query.setParameter("arg2", cKey.key2);
        List<DemandeStage> demandeStages = query.getResultList();
        DemandeStage dmdStage=demandeStages.get(demandeStages.size()-1);
       
        entityManager.getTransaction().commit();
        entityManager.close();
        return dmdStage;
    }
    public static void updateDemandeStage(DemandeStage dmd){
         EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<DemandeStage> query = entityManager.createQuery("SELECT c FROM DemandeStage c where c.idStage=:arg1 AND c.idStagiaire=:arg2", DemandeStage.class).setParameter("arg1",dmd.getIdStage());
        query.setParameter("arg2",dmd.getIdStagiaire());
        List<DemandeStage> demandeStages = query.getResultList();
        DemandeStage dmdStage=demandeStages.get(demandeStages.size()-1);
       dmdStage.setAutorisationDeStage(dmd.getAutorisationDeStage());
       dmdStage.setAvisCsStage(dmd.getAvisCsStage());
       dmdStage.setAvisDadpgrStage(dmd.getAvisDadpgrStage());
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    /*
     Pvs
     */

    public static void insertPv(Pv pv) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(pv);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static List<Pv> findAllPv() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Pv> query = entityManager.createQuery("SELECT c FROM Pv c", Pv.class);
        List<Pv> result = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }

    public static Pv findPvById(int idPv) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Pv pv = null;
        pv = entityManager.find(Pv.class, idPv);
        entityManager.getTransaction().commit();
        entityManager.close();
        return pv;
    }
    /*
     Demande de participation a une manifestation
     */

    public static void insertInviterManifestation(InviteManifestation inviteManifestation) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(inviteManifestation);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static List<InviteManifestation> findAllInviteManifestations() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<InviteManifestation> query = entityManager.createQuery("SELECT c FROM InviteManifestation c", InviteManifestation.class);
        List<InviteManifestation> result = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }
    /*
     Grade
     */

    public static void insertGrade(Grade grade) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(grade);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static List<Grade> findAllGrades() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Grade> query = entityManager.createQuery("SELECT c FROM Grade c", Grade.class);
        List<Grade> result = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }

    public static Grade findGradeById(int idGrade) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Grade grade = null;
        grade = entityManager.find(Grade.class, idGrade);
        entityManager.getTransaction().commit();
        entityManager.close();
        return grade;
    }
    /*
     Encadrant
     */

    public static void insertEncadrant(Encadrant encadrant) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(encadrant);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static List<Encadrant> findAllEncadrant() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Encadrant> query = entityManager.createQuery("SELECT c FROM Encadrant c", Encadrant.class);
        List<Encadrant> result = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }

    public static Encadrant findEncadrantById(int idEncadrant) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Encadrant encadrant = null;
        encadrant = entityManager.find(Encadrant.class, idEncadrant);
        entityManager.getTransaction().commit();
        entityManager.close();
        return encadrant;
    }
    /*
     Membres CS
     */

    public static void insertMemCS(MembreCs membreCs) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(membreCs);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static List<MembreCs> findAllMembreCs() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<MembreCs> query = entityManager.createQuery("SELECT c FROM MembreCs c", MembreCs.class);
        List<MembreCs> result = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }

    public static MembreCs findMembreCsById(int idMembreCs) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        MembreCs membreCs = null;
        membreCs = entityManager.find(MembreCs.class, idMembreCs);
        entityManager.getTransaction().commit();
        entityManager.close();
        return membreCs;
    }

    public static void affectGradeMemCS(int idGrade, int idMemCS, Date date) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        AvoirGradeMemCs avGradeMemCs = new AvoirGradeMemCs();
        avGradeMemCs.setDateAvoirFonctionMemCs(date);
        avGradeMemCs.setIdGrade(idGrade);
        avGradeMemCs.setIdMembreCs(idMemCS);
        entityManager.persist(avGradeMemCs);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static void affectFonctionMemCS(int idFonction, int idMemCS, Date date) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        AvoirFctMemCs avFctMemCs = new AvoirFctMemCs();
        avFctMemCs.setDateAvoirGradeMemCs(date);
        avFctMemCs.setIdFonction(idFonction);
        avFctMemCs.setIdMembreCs(idMemCS);
        entityManager.persist(avFctMemCs);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    /*
     Configurations
     */
    public static void insertFonction(Fonction fonction) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(fonction);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static List<Fonction> findAllFonction() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Fonction> query = entityManager.createQuery("SELECT c FROM Fonction c", Fonction.class);
        List<Fonction> result = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }

    public static Fonction findFonctionById(int idFonction) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Fonction fonction = null;
        fonction = entityManager.find(Fonction.class, idFonction);
        entityManager.getTransaction().commit();
        entityManager.close();
        return fonction;
    }

    public static void insertDiplome(Diplome diplome) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(diplome);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static List<Diplome> findAllDiplome() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Diplome> query = entityManager.createQuery("SELECT c FROM Diplome c", Diplome.class);
        List<Diplome> result = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }

    public static Diplome findDiplomeById(int idDiplome) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Diplome diplome = null;
        diplome = entityManager.find(Diplome.class, idDiplome);
        entityManager.getTransaction().commit();
        entityManager.close();
        return diplome;
    }

    public static void insertLabo(LaboratoireRattachement labo) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(labo);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static List<LaboratoireRattachement> findAllLabo() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<LaboratoireRattachement> query = entityManager.createQuery("SELECT c FROM LaboratoireRattachement c", LaboratoireRattachement.class);
        List<LaboratoireRattachement> result = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }

    public static LaboratoireRattachement findLaboById(int idLabo) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        LaboratoireRattachement laboratoireRattachement = null;
        laboratoireRattachement = entityManager.find(LaboratoireRattachement.class, idLabo);
        entityManager.getTransaction().commit();
        entityManager.close();
        return laboratoireRattachement;
    }

    /*
     Frais de stage
     */
    public static void insertFraisStage(FraisStage fraisStage) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(fraisStage);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public static void affectFraisStage(int idStage,int idFraisStage,int totalFrais){
       EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        AvoirFraiStage avFraisStage=new AvoirFraiStage();
        avFraisStage.setIdFraiStage(idFraisStage);
        avFraisStage.setIdStage(idStage);
        avFraisStage.setTotalFraisStage(totalFrais);
        entityManager.persist(avFraisStage);
       entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static List<FraisStage> findAllFraisStage() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<FraisStage> query = entityManager.createQuery("SELECT c FROM FraisStage c", FraisStage.class);
        List<FraisStage> result = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }

    public static FraisStage findFraisStageById(int idFraisStage) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        FraisStage fraisStage = null;
        fraisStage = entityManager.find(FraisStage.class, idFraisStage);
        entityManager.getTransaction().commit();
        entityManager.close();
        return fraisStage;
    }
    public static void updateFraisStage(FraisStage fraisStage){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        FraisStage fr=findFraisStageById(fraisStage.getIdFraiStage());
        fr.setIdFraiStage(fraisStage.getIdFraiStage());
        fr.setMontantAssurranceFraiStage(fraisStage.getMontantAssurranceFraiStage());
        fr.setMontantSejourFraiStage(fraisStage.getMontantSejourFraiStage());
        fr.setMontantTransportFraiStage(fraisStage.getMontantTransportFraiStage());
        fr.setMontantVisaFraiStage(fraisStage.getMontantVisaFraiStage());
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    /*
     Lieu de Stage
     */

    public static void insertLieuStage(LieuStage lieuStage) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(lieuStage);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static List<LieuStage> findAllLieuStage() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<LieuStage> query = entityManager.createQuery("SELECT c FROM LieuStage c", LieuStage.class);
        List<LieuStage> result = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }

    public static LieuStage findLieuStageById(int idLieuStage) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        LieuStage lieuStage = null;
        lieuStage = entityManager.find(LieuStage.class, idLieuStage);
        entityManager.getTransaction().commit();
        entityManager.close();
        return lieuStage;
    }

    public static void affectZoneLieu(int idZone, int idLieu) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        AppartientZone appZone = new AppartientZone();
        appZone.setCommentaires("rien");
        appZone.setIdLieu(idLieu);
        appZone.setIdZone(idZone);
        entityManager.persist(appZone);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    /*
     Zones
     */

    public static void insertZone(ZoneType zone) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(zone);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static List<ZoneType> findAllZones() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<ZoneType> query = entityManager.createQuery("SELECT c FROM ZoneType c", ZoneType.class);
        List<ZoneType> result = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }

    public static ZoneType findZoneById(int idZoneType) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        ZoneType zoneType = null;
        zoneType = entityManager.find(ZoneType.class, idZoneType);
        entityManager.getTransaction().commit();
        entityManager.close();
        return zoneType;
    }
    /*
     Etats
     */

    public static void insertEtatStage(EtatStage etatStage) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(etatStage);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static List<EtatStage> findAllEtatStage() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<EtatStage> query = entityManager.createQuery("SELECT c FROM EtatStage c", EtatStage.class);
        List<EtatStage> result = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }

    public static EtatStage findEtatStageById(String etatStageCle) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        EtatStage etatStage = null;
        etatStage = entityManager.find(EtatStage.class, etatStageCle);
        entityManager.getTransaction().commit();
        entityManager.close();
        return etatStage;
    }

    public static void affectEtatStage(int idStage, String etatStage, Date dateAffectation) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        AvoirEtat avoirEtat = new AvoirEtat();
        avoirEtat.setEtatStage(etatStage);
        avoirEtat.setIdStage(idStage);
        avoirEtat.setDateAvoirEtat(dateAffectation);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    /*
     Statistiques
     */

     /*
     Utilisateurs
     */
    public static void insertUtilisateur(Utilisateur usr){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("DEFAULT_PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        String encryptedMP=cryptWithMD5(usr.getMpUtilisateur());
        usr.setMpUtilisateur(encryptedMP);
        entityManager.persist(usr);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public static Utilisateur getUtilisateurByLogin(String login){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("DEFAULT_PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Utilisateur user=null;
        user=entityManager.find(Utilisateur.class, login);
        entityManager.getTransaction().commit();
        entityManager.close();
        return user;
    } 
    public static List<Utilisateur> findAllUtilisateur() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("DEFAULT_PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Utilisateur> query = entityManager.createQuery("SELECT c FROM Utilisateur c", Utilisateur.class);
        List<Utilisateur> result = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }
    public static String cryptWithMD5(String pass){
        MessageDigest md;
        try {
        md = MessageDigest.getInstance("MD5");
        byte[] passBytes = pass.getBytes();
        md.reset();
        byte[] digested = md.digest(passBytes);
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<digested.length;i++){
            sb.append(Integer.toHexString(0xff & digested[i]));
        }
        return sb.toString();
    } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
//  Logger.getLogger(CryptWithMD5.class.getName()).log(Level.SEVERE, null, ex);
    }
        return null;
   }
    public static void updateUtilisateur(Utilisateur usr){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("DEFAULT_PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Utilisateur u=entityManager.find(Utilisateur.class,usr.getLoginUtilisateur());
        u.setLoginUtilisateur(usr.getLoginUtilisateur());
        u.setEtatCompte(usr.getEtatCompte());
        u.setMpUtilisateur(usr.getMpUtilisateur());
        u.setNomUtilisateur(usr.getNomUtilisateur());
        u.setPrenomUtilisateur(usr.getPrenomUtilisateur());
        u.setProfilUtilisateur(usr.getProfilUtilisateur());
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public static void deleteUtilisateur(String login){
          EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("DEFAULT_PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
       Utilisateur user =getUtilisateurByLogin(login);
      Utilisateur toBeRemoved = entityManager.merge(user);
       entityManager.remove(toBeRemoved);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
