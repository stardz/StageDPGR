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
import model.Utilisateur;
import presentation.StageDPGR;

/**
 * FXML Controller class
 *
 * @author B-Zakaria
 */
public class ConfiirmerBloquerController implements Initializable {

    /**
     * Initializes the controller class.
     */
      @FXML 
    Button valider;
    @FXML 
    Button annuler;
    @FXML
    Text nomCompteDebloquer;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nomCompteDebloquer.setText(StageDPGR.selectedUtilisateur.getLoginUtilisateur());
    }  
    
    @FXML 
    public void valider(){
          try {
              Utilisateur u=new Utilisateur();
              u.setLoginUtilisateur(StageDPGR.selectedUtilisateur.getLoginUtilisateur());
              u.setEtatCompte("bloque");
              u.setMpUtilisateur(StageDPGR.selectedUtilisateur.getMpUtilisateur());
              u.setNomUtilisateur(StageDPGR.selectedUtilisateur.getNomUtilisateur());
              u.setPrenomUtilisateur(StageDPGR.selectedUtilisateur.getPrenomUtilisateur());
              u.setProfilUtilisateur(StageDPGR.selectedUtilisateur.getProfilUtilisateur());
              persistance.PersistManager.updateUtilisateur(u);
              StageDPGR.currentTab=6;
              StageDPGR.root=FXMLLoader.load(getClass().getResource("/presentation/FenetrePrincipale.fxml"));
              StageDPGR.refreshRoot1();
              StageDPGR.stage2.close();
          } catch (IOException ex) {
              Logger.getLogger(ConfiirmerBloquerController.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
     @FXML 
    public void annuler(){
        // fermer 2nd stage
        StageDPGR.stage2.close();
    }
    
}
