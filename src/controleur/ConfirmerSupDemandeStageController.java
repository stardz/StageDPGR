/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import model.DemandeStage;
import persistance.CKey;
import presentation.StageDPGR;

/**
 * FXML Controller class
 *
 * @author oSunshine
 */
public class ConfirmerSupDemandeStageController implements Initializable {

    @FXML
    Button confirmer;
    @FXML
    Button annuler;
    @FXML
    Text nomCompteSupprimer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nomCompteSupprimer.setText(StageDPGR.selectedStagiaire.getNomStagiaire() + " " + StageDPGR.selectedStagiaire.getPrenomStagiaire());

    }

    @FXML
    public void confirmer() {

        List<DemandeStage> listDemande = persistance.PersistManager.getSesDemandeStage(StageDPGR.selectedStagiaire.getIdStagiaire());

        for (DemandeStage demande : listDemande) {
            persistance.PersistManager.deleteDemandeStage(new CKey(demande.getIdStage(), StageDPGR.selectedStagiaire.getIdStagiaire()));

        }
        
        StageDPGR.currentTab = 0;
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
