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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Diplome;
import model.Fonction;
import model.Grade;
import model.LaboratoireRattachement;
import model.Stagiaire;
import modelforpresentation.StagiairePres;
import presentation.StageDPGR;

/**
 * FXML Controller class
 *
 * @author oSunshine
 */
public class ModifierStagiaireController implements Initializable {

    @FXML
    private TextField email, nom, prenom, tel;

    @FXML
    private MenuButton grade, labo, fonction, diplome;
    private Stagiaire stagiaire;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      /*  grade.getItems().addAll("Enseignant", "Enseignant chercheur", "Ingénieure");
         labo.getItems().addAll("Labo ESI");
         fonction.getItems().addAll("Enseignant");
         diplome.getItems().addAll("Ingeniorat", "Doctorat");

         grade.getSelectionModel().selectFirst();
         labo.getSelectionModel().selectFirst();
         fonction.getSelectionModel().selectFirst();
         diplome.getSelectionModel().selectFirst();
         */
        
        email.setText(StageDPGR.selectedStagiaire.getEmailStagiaire());
        nom.setText(StageDPGR.selectedStagiaire.getNomStagiaire());
        prenom.setText(StageDPGR.selectedStagiaire.getPrenomStagiaire());
        tel.setText(StageDPGR.selectedStagiaire.getTelStagiaire());

        List<Grade> grades = persistance.PersistManager.findAllGrades();

        for (Grade gradeSelected : grades) {

            grade.getItems().add(new CheckMenuItem(gradeSelected.getLibelleGrade()));

        }

        List<LaboratoireRattachement> labos;
        labos = persistance.PersistManager.findAllLabo();

        for (LaboratoireRattachement laboSelected : labos) {

            labo.getItems().add(new CheckMenuItem(laboSelected.getNomLabo()));

        }
        List<Fonction> fonctions;
        fonctions = persistance.PersistManager.findAllFonction();

        for (Fonction fonctionSelected : fonctions) {

            fonction.getItems().add(new CheckMenuItem(fonctionSelected.getLibelleFonction()));

        }

        List<Diplome> diplomes;
        diplomes = persistance.PersistManager.findAllDiplome();

        for (Diplome diplomeSelected : diplomes) {

            diplome.getItems().add(new CheckMenuItem(diplomeSelected.getLibelleDeplome()));

        }

    }

    @FXML
    public void valider(ActionEvent e) throws IOException {

        stagiaire = new Stagiaire(prenom.getText(), tel.getText(), nom.getText(), email.getText(), null, null, null, null);
        stagiaire.setIdStagiaire(StageDPGR.selectedStagiaire.getIdStagiaire());
        persistance.PersistManager.updateStagiaire(stagiaire);

        StageDPGR.currentTab = 0;

        StageDPGR.root = FXMLLoader.load(getClass().getResource("/presentation/FenetrePrincipale.fxml"));

        StageDPGR.refreshRoot1();
        StageDPGR.stage2.close();

    }

    @FXML
    public void annuler(ActionEvent e) {
        StageDPGR.stage2.close();
    }
}
