/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistance;

import java.util.List;
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
    public static List<Stagiaire> findAllStagiaires(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Stagiaire> query =entityManager.createQuery("SELECT c FROM Stagiaire c", Stagiaire.class);
        List<Stagiaire> result = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    } 
    public static Stagiaire findStagiaireById(int id){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Stagiaire stagiare=null;
        stagiare= entityManager.find(Stagiaire.class, id); 
        entityManager.getTransaction().commit();
        entityManager.close();
        return stagiare;
    } 
    public static void insertStagiaire(Stagiaire stagiaire){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(stagiaire);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    /*
    Stages
    */
    public static void insertStage(Stage stage){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(stage);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public static List<Stage> findAllStages(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Stage> query =entityManager.createQuery("SELECT c FROM Stage c", Stage.class);
        List<Stage> result = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }
    public static Stage findStageById(int id){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Stage stage=null;
        stage= entityManager.find(Stage.class, id); 
        entityManager.getTransaction().commit();
        entityManager.close();
        return stage;
    }
    /*
    Manifestation
    */
     public static void insertManifestation(Manifestation manif){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(manif);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
     public static List<Manifestation> findAllManifestations(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Manifestation> query =entityManager.createQuery("SELECT c FROM Manifestation c", Manifestation.class);
        List<Manifestation> result = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }
     public static Manifestation findManifestationById(int id){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Manifestation manifestation=null;
        manifestation= entityManager.find(Manifestation.class, id); 
        entityManager.getTransaction().commit();
        entityManager.close();
        return manifestation;
    }
     /*
     Demandes de Stage
     */
      public static void insertDemandeStage(DemandeStage demandeStage){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(demandeStage);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
       public static List<DemandeStage> findAllDemandeStages(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<DemandeStage> query =entityManager.createQuery("SELECT c FROM DemandeStage c", DemandeStage.class);
        List<DemandeStage> result = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }
      /*
      Demande de participation a une manifestation
      */
        public static void insertInviterManifestation(InviteManifestation inviteManifestation){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(inviteManifestation);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
        public static List<InviteManifestation> findAllInviteManifestations(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<InviteManifestation> query =entityManager.createQuery("SELECT c FROM InviteManifestation c", InviteManifestation.class);
        List<InviteManifestation> result = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }
        /*
        Grade
        */
        public static void insertGrade(Grade grade){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(grade);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
        public static List<Grade> findAllGrades(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Grade> query =entityManager.createQuery("SELECT c FROM Grade c", Grade.class);
        List<Grade> result = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }
        /*
        Configurations
        */
        public static void insertFonction(Fonction fonction){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(fonction);
        entityManager.getTransaction().commit();
        entityManager.close();
        }
        public static List<Fonction> findAllFonction(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Fonction> query =entityManager.createQuery("SELECT c FROM Fonction c", Fonction.class);
        List<Fonction> result = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }
        public static void insertDiplome(Diplome diplome){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(diplome);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
        public static List<Diplome> findAllDiplome(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Diplome> query =entityManager.createQuery("SELECT c FROM Diplome c", Diplome.class);
        List<Diplome> result = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }
        public static void insertZone(ZoneType zone){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(zone);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
        public static List<ZoneType> findAllZones(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<ZoneType> query =entityManager.createQuery("SELECT c FROM ZoneType c", ZoneType.class);
        List<ZoneType> result = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }
         public static void insertLabo(LaboratoireRattachement labo){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(labo);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
          public static List<LaboratoireRattachement> findAllLabo(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<LaboratoireRattachement> query =entityManager.createQuery("SELECT c FROM LaboratoireRattachement c", LaboratoireRattachement.class);
        List<LaboratoireRattachement> result = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }
         /*
         Statistiques
         */
         
         /*
         Utilisateurs
         */
}
