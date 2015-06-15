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

/**
 *
 * @author Oo
 */
public class StageDPGR extends Application {

    public static Parent root;
    public static Scene scene;
    public static Stage stage;

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
       // System.out.println("========="+persistance.PersistManager.getUtilisateurByLogin("Agent").getEtatCompte());
        launch(args);
    }

    public static void refreshRoot() {
        StageDPGR.scene = new Scene(StageDPGR.root);
        StageDPGR.stage.setScene(StageDPGR.scene);
        StageDPGR.stage.centerOnScreen();
    }

}
