/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controleur;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import model.Utilisateur;
import presentation.StageDPGR;

/**
 * FXML Controller class
 *
 * @author Oopc
 */
public class Compte_DebloquerController implements Initializable {

   /**
     * Initializes the controller class.
     */
    @FXML
    Text nomCompteDebloquer;
    @FXML
    private void confirmer(ActionEvent event) throws IOException{
        Utilisateur u=new Utilisateur();
        u.setLoginUtilisateur(StageDPGR.selectedUtilisateur.getLoginUtilisateur());
        u.setEtatCompte("actif");
        u.setMpUtilisateur(StageDPGR.selectedUtilisateur.getMpUtilisateur());
        u.setNomUtilisateur(StageDPGR.selectedUtilisateur.getNomUtilisateur());
        u.setPrenomUtilisateur(StageDPGR.selectedUtilisateur.getPrenomUtilisateur());
        u.setProfilUtilisateur(StageDPGR.selectedUtilisateur.getProfilUtilisateur());
        persistance.PersistManager.updateUtilisateur(u);
        StageDPGR.currentTab=6;
        StageDPGR.root=FXMLLoader.load(getClass().getResource("/presentation/FenetrePrincipale.fxml"));
        StageDPGR.refreshRoot1();
        StageDPGR.stage2.close();
    }
    @FXML
    private void annuler(ActionEvent event) throws IOException{
        // close seconde stage
        StageDPGR.stage2.close();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
        nomCompteDebloquer.setText(StageDPGR.selectedUtilisateur.getLoginUtilisateur());
    }    
}
