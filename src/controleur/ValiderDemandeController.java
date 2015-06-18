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
import model.DemandeStage;
import persistance.CKey;
import presentation.StageDPGR;

/**
 * FXML Controller class
 *
 * @author Oo
 */
public class ValiderDemandeController implements Initializable {

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

      nomCompteSupprimer.setText(StageDPGR.utilisateurLogged.getProfilUtilisateur() );

    }

    @FXML
    public void confirmer() {
        int res=5;
        DemandeStage dmd=persistance.PersistManager.findDemandeStageByIds(new CKey(StageDPGR.selectedDemandeStage.getIdStage(),StageDPGR.selectedDemandeStage.getIdStagiaire()));
        if(StageDPGR.utilisateurLogged.getProfilUtilisateur().equals("Agent")||StageDPGR.utilisateurLogged.getProfilUtilisateur().equals("Admin")){
            res=dmd.validerAut();
        }else if(StageDPGR.utilisateurLogged.getProfilUtilisateur().equals("DADPGR")){
            res=dmd.validerDA();
        }else if(StageDPGR.utilisateurLogged.getProfilUtilisateur().equals("MembreCS")){
            res=dmd.validerCS();
        }
        if(res==0){
            nomCompteSupprimer.setText("C'est déja validé");
            return;
        }
        else if(res==-1){
            nomCompteSupprimer.setText("Vous n'avez pas encore le droit!");
            return;
        }
        persistance.PersistManager.updateDemandeStage(dmd);
        StageDPGR.currentTab = 1;
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
