/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import model.Utilisateur;
import presentation.StageDPGR;

/**
 * FXML Controller class
 *
 * @author oSunshine
 */
public class AuthentificationController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    TextField nomUtilisateur;
    @FXML
    TextField motdePasse;

    @FXML
    private void connexion(ActionEvent event) {
        Utilisateur usr = persistance.PersistManager.getUtilisateurByLogin(nomUtilisateur.getText());
        if(usr == null){
            nomUtilisateur.setEffect(new DropShadow(10, Color.RED));
        }else if (usr.getMpUtilisateur().equals(persistance.PersistManager.cryptWithMD5(motdePasse.getText()))) {
            try {
                StageDPGR.root = FXMLLoader.load(getClass().getResource("/presentation/FenetrePrincipale.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(AuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
            }
            StageDPGR.refreshRoot();
        }else{
               motdePasse.setEffect(new DropShadow(10, Color.RED));
        }

        

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
