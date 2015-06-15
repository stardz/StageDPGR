/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.util.Date;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Stagiaire;
import model.Utilisateur;
import modelforpresentation.UtilisateurPres;

/**
 *
 * @author Oo
 */
public class StageDPGR extends Application {

    public static Parent root;
    public static Scene scene;
    public static Stage stage;
    public static UtilisateurPres selectedUtilisateur;  

    @Override
    public void start(Stage stage) throws Exception {
        root = FXMLLoader.load(getClass().getResource("Authentification.fxml"));

        scene = new Scene(root);
        StageDPGR.stage = stage;
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Utilisateur user=new Utilisateur();
      user.setLoginUtilisateur("Agent");
        user.setEtatCompte("123");
        user.setMpUtilisateur("123");
        user.setNomUtilisateur("123");
        user.setPrenomUtilisateur("123");
        user.setProfilUtilisateur("123");
        persistance.PersistManager.updateUtilisateur(user);
        launch(args);
    }

    public static void refreshRoot() {
        StageDPGR.scene = new Scene(StageDPGR.root);
        StageDPGR.stage.setScene(StageDPGR.scene);
        StageDPGR.stage.centerOnScreen();
    }

}
