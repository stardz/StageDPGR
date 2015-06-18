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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import presentation.StageDPGR;

/**
 * FXML Controller class
 *
 * @author B-Zakaria
 */
public class ConfirmerSupController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    Button confirmer;
    @FXML
    Button annuler;
    @FXML
    Text nomCompteSupprimer;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        nomCompteSupprimer.setText(StageDPGR.selectedUtilisateur.getNomUtilisateur() + "  " + StageDPGR.selectedUtilisateur.getPrenomUtilisateur());

    }

    @FXML
    public void confirmer() {
        persistance.PersistManager.deleteSesDiplomes(StageDPGR.selectedStagiaire.getIdStagiaire());
        persistance.PersistManager.deleteSesLabo(StageDPGR.selectedStagiaire.getIdStagiaire());
        persistance.PersistManager.deleteSesGrade(StageDPGR.selectedStagiaire.getIdStagiaire());
        persistance.PersistManager.deleteSesFonction(StageDPGR.selectedStagiaire.getIdStagiaire());
        //persistance.PersistManager.del
        persistance.PersistManager.deleteStagiaire(StageDPGR.selectedStagiaire.getIdStagiaire());
        StageDPGR.currentTab = 5;
        try {
            StageDPGR.root = FXMLLoader.load(getClass().getResource("/presentation/FenetrePrincipale.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ConfirmerSupController.class.getName()).log(Level.SEVERE, null, ex);
        }
        StageDPGR.refreshRoot1();
        StageDPGR.stage2.close();
    }

    @FXML
    public void annuler() {
        // close seconde stage
        StageDPGR.stage2.close();
    }

}
