/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import controleur.DateFormatter;
import java.util.Date;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.DemandeStage;
import model.Stagiaire;
import model.Utilisateur;
import modelforpresentation.DemandeStagePres;
import modelforpresentation.StagePres;
import modelforpresentation.StagiairePres;
import modelforpresentation.UtilisateurPres;

/**
 *
 * @author Oo
 */
public class StageDPGR extends Application {

    public static Parent root;
    public static Scene scene;
    public static Stage stage;
    
   public static Parent root2;
    public static Scene scene2;
    public static Stage stage2;
    public static int currentTab=new Integer(0);
    public static UtilisateurPres selectedUtilisateur;
    public static StagiairePres selectedStagiaire;
    public static DemandeStagePres selectedDemandeStage;
    public static StagePres selectedStage;
    public static Utilisateur utilisateurLogged;
    @Override
    public void start(Stage stage) throws Exception {
        root = FXMLLoader.load(getClass().getResource("Authentification.fxml"));

        scene = new Scene(root);
        StageDPGR.stage = stage;
        stage.setScene(scene);
        stage.show();
        
        stage2=new Stage()  ;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
    }

    public static void refreshRoot1() {
        StageDPGR.scene = new Scene(StageDPGR.root);
        StageDPGR.stage.setScene(StageDPGR.scene);
        StageDPGR.stage.centerOnScreen();
    }
    
        public static void refreshRoot2() {
        scene2= new Scene(StageDPGR.root2);
        stage2.setResizable(false);
        stage2.setScene(StageDPGR.scene2);
        stage2.centerOnScreen();
        stage2.show();
        
    }

}
