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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Utilisateur;
import modelforpresentation.UtilisateurPres;
import presentation.StageDPGR;

/**
 * FXML Controller class
 *
 * @author oSunshine
 */
public class FenetrePrincipaleController implements Initializable {

    @FXML
    TableView tableComptes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        /*
                Tableau des comptes
        */
        //Data
        ObservableList<UtilisateurPres> dataComptes = FXCollections.observableArrayList();
        List<Utilisateur> listeUsrs=persistance.PersistManager.findAllUtilisateur();
        
        System.out.println("================="+listeUsrs.toString());
        for(Utilisateur it:listeUsrs){
            dataComptes.add(new UtilisateurPres(it));
        }
        // Colonnes
        TableColumn loginCol = new TableColumn();
        loginCol.setText("Login");
        loginCol.setCellValueFactory(new PropertyValueFactory("loginUtilisateur"));

        TableColumn mpCol = new TableColumn();
        mpCol.setText("Password");
        mpCol.setCellValueFactory(new PropertyValueFactory("mpUtilisateur"));

        TableColumn profileCol = new TableColumn();
        profileCol.setText("Profile");
        profileCol.setCellValueFactory(new PropertyValueFactory("profilUtilisateur"));

        TableColumn etatCol = new TableColumn();
        etatCol.setText("EtatDeCompte");
        etatCol.setCellValueFactory(new PropertyValueFactory("etatCompte"));

        TableColumn nomUsrCol = new TableColumn();
        nomUsrCol.setText("Nom");
        nomUsrCol.setCellValueFactory(new PropertyValueFactory("nomUtilisateur"));

        TableColumn prenomUsrCol = new TableColumn();
        prenomUsrCol.setText("Prenom");
        prenomUsrCol.setCellValueFactory(new PropertyValueFactory("prenomUtilisateur"));
        
        //Remplissage
        tableComptes.setItems(dataComptes);
        tableComptes.getColumns().addAll(nomUsrCol,prenomUsrCol,loginCol,mpCol,profileCol,etatCol);
    }
    
    @FXML
    private void afficherProfilStagiaireOnAction(ActionEvent event){
        System.out.println("click profile");
        try {
            StageDPGR.root = FXMLLoader.load(getClass().getResource("/presentation/ProfilStagiaire.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(FenetrePrincipaleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
