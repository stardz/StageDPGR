/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import model.AvoirGrade;
import model.Diplome;
import model.Fonction;
import model.Grade;
import model.LaboratoireRattachement;
import model.Stagiaire;
import presentation.StageDPGR;

/**
 * FXML Controller class
 *
 * @author oSunshine
 */
public class AjouterStagiaireController implements Initializable {

    @FXML
    private TextField email, nom, prenom, tel;

    @FXML
    private ComboBox<String> grade, labo, fonction, diplome;

    /**
     * Initializes the controller class.
     */
    List<Grade> grades;
    List<LaboratoireRattachement> labos;
    List<Fonction> fonctions;
    List<Diplome> diplomes;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        grades = persistance.PersistManager.findAllGrades();

        for (Grade gradeSelected : grades) {

            grade.getItems().add(gradeSelected.getLibelleGrade());

        }

        labos = persistance.PersistManager.findAllLabo();

        for (LaboratoireRattachement laboSelected : labos) {

            labo.getItems().add(laboSelected.getNomLabo());

        }

        fonctions = persistance.PersistManager.findAllFonction();

        for (Fonction fonctionSelected : fonctions) {

            fonction.getItems().add(fonctionSelected.getLibelleFonction());

        }

        diplomes = persistance.PersistManager.findAllDiplome();

        for (Diplome diplomeSelected : diplomes) {

            diplome.getItems().add(diplomeSelected.getLibelleDeplome());

        }

        grade.getSelectionModel().selectFirst();
        labo.getSelectionModel().selectFirst();
        fonction.getSelectionModel().selectFirst();
        diplome.getSelectionModel().selectFirst();

    }

    @FXML
    public void valider(ActionEvent e) throws IOException {

        boolean arreter = false;
        // email, nom, prenom, tel
        if (Regex.verifNominal(nom.getText())) {

            nom.setStyle(" -fx-background-color: #9eee48");

        } else {
            arreter = true;
            nom.setStyle(" -fx-background-color: #ff6d6d");
        }
        if (Regex.verifNominal(prenom.getText())) {

            prenom.setStyle(" -fx-background-color: #9eee48");

        } else {
            arreter = true;
            prenom.setStyle(" -fx-background-color: #ff6d6d");
        }

        if (Regex.isInteger(tel.getText())) {

            tel.setStyle(" -fx-background-color: #9eee48");

        } else {
            arreter = true;
            tel.setStyle(" -fx-background-color: #ff6d6d");
        }
        if (Regex.isEmail(email.getText())) {
            email.setStyle(" -fx-background-color: #9eee48");
        } else {
            arreter = true;
            email.setStyle(" -fx-background-color: #ff6d6d");
        }
        if (!arreter) {
            Stagiaire stagiaire;
            stagiaire = new Stagiaire(prenom.getText(), tel.getText(), nom.getText(), email.getText(), null, null, null, null);
            stagiaire.setIdStagiaire(persistance.PersistManager.findAllStagiaires().size() + 1);
            persistance.PersistManager.insertStagiaire(stagiaire);

            LaboratoireRattachement lab = labos.get(labo.getSelectionModel().getSelectedIndex());

            persistance.PersistManager.affectLabo(lab.getIdLabo(), stagiaire.getIdStagiaire(), Date.valueOf(LocalDate.now()));

            Diplome dip = diplomes.get(diplome.getSelectionModel().getSelectedIndex());

            persistance.PersistManager.affectDeplome(dip.getIdDiplome(), stagiaire.getIdStagiaire(), Date.valueOf(LocalDate.now()));

            Grade gr = grades.get(grade.getSelectionModel().getSelectedIndex());

            persistance.PersistManager.affectGrade(gr.getIdGrade(), stagiaire.getIdStagiaire(), Date.valueOf(LocalDate.now()));

            Fonction fct = fonctions.get(fonction.getSelectionModel().getSelectedIndex());

            persistance.PersistManager.affectFonction(fct.getIdFonction(), stagiaire.getIdStagiaire(), Date.valueOf(LocalDate.now()));

            StageDPGR.currentTab = 0;

            StageDPGR.root = FXMLLoader.load(getClass().getResource("/presentation/FenetrePrincipale.fxml"));

            StageDPGR.refreshRoot1();
            StageDPGR.stage2.close();
        }
    }

    @FXML
    public void annuler(ActionEvent e) {
        StageDPGR.stage2.close();
    }
}
