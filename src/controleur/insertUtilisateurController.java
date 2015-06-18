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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Utilisateur;
import presentation.StageDPGR;

/**
 * FXML Controller class
 *
 * @author Oo
 */
public class insertUtilisateurController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    TextField psedou;
    @FXML
    TextField nom;
    @FXML
    TextField prenom;
    @FXML
    TextField motPasse;
    @FXML
    TextField CMotPasse;
    @FXML
    ComboBox profil;
    @FXML
    Button valider;
    @FXML
    Button annuler;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        profil.getItems().add("Agent");
        profil.getItems().add("DADPGR");
        profil.getItems().add("MembreCS");
    }
    @FXML
    private void valider(ActionEvent event) throws IOException{
        Utilisateur u=new Utilisateur();
        u.setLoginUtilisateur(psedou.getText());
        u.setEtatCompte("actif");
        u.setMpUtilisateur(motPasse.getText());
        u.setNomUtilisateur(nom.getText());
        u.setPrenomUtilisateur(prenom.getText());
        u.setProfilUtilisateur(profil.getValue().toString());
        StageDPGR.currentTab=5;
        persistance.PersistManager.insertUtilisateur(u);
        StageDPGR.root=FXMLLoader.load(getClass().getResource("/presentation/FenetrePrincipale.fxml"));
        StageDPGR.refreshRoot1();
        StageDPGR.stage2.close();
    }
    @FXML
    private void annuler(ActionEvent event) throws IOException{
        // close seconde stage
        StageDPGR.stage2.close();
    }

}
