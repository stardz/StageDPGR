/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ComboBox;
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
    private ComboBox<String> grade, labo, fonction, diplome;
    private Stagiaire stagiaire;

    /**
     * Initializes the controller class.
     */
    List<Grade> grades;
    List<Fonction> fonctions;
    List<Diplome> diplomes;
    List<LaboratoireRattachement> labos;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        email.setText(StageDPGR.selectedStagiaire.getEmailStagiaire());
        nom.setText(StageDPGR.selectedStagiaire.getNomStagiaire());
        prenom.setText(StageDPGR.selectedStagiaire.getPrenomStagiaire());
        tel.setText(StageDPGR.selectedStagiaire.getTelStagiaire());

        grades = persistance.PersistManager.findAllGrades();

        for (Grade gradeSelected : grades) {

            grade.getItems().add((gradeSelected.getLibelleGrade()));

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

        /*        Diplome diplomeTmp = persistance.PersistManager.getSesDiplome(StageDPGR.selectedDemandeStage.getIdStagiaire()).get(0);
         diplome.getSelectionModel().select(diplomeTmp.getLibelleDeplome());
         */
        /*        Grade gradeTmp = persistance.PersistManager.getSesGrade(StageDPGR.selectedDemandeStage.getIdStagiaire()).get(0);
         grade.getSelectionModel().select(gradeTmp.getLibelleGrade());

         Fonction fonctionTmp = persistance.PersistManager.getSesFonction(StageDPGR.selectedDemandeStage.getIdStagiaire()).get(0);
         fonction.getSelectionModel().select(fonctionTmp.getLibelleFonction());

         LaboratoireRattachement laboTmp = persistance.PersistManager.getSesLabo(StageDPGR.selectedDemandeStage.getIdStagiaire()).get(0);
         labo.getSelectionModel().select(laboTmp.getNomLabo());
         */
        
        grade.getSelectionModel().selectFirst();
        labo.getSelectionModel().selectFirst();
        fonction.getSelectionModel().selectFirst();
        diplome.getSelectionModel().selectFirst();

    }

    @FXML
    public void valider(ActionEvent e) throws IOException {

        stagiaire = new Stagiaire(prenom.getText(), tel.getText(), nom.getText(), email.getText(), null, null, null, null);
        stagiaire.setIdStagiaire(StageDPGR.selectedStagiaire.getIdStagiaire());
        persistance.PersistManager.updateStagiaire(stagiaire);
///////////////
        Diplome dip = diplomes.get(diplome.getSelectionModel().getSelectedIndex());

        persistance.PersistManager.deleteSesDiplomes(stagiaire.getIdStagiaire());

        persistance.PersistManager.affectDeplome(dip.getIdDiplome(), stagiaire.getIdStagiaire(), Date.valueOf(LocalDate.now()));
///////////////
        LaboratoireRattachement lab = labos.get(labo.getSelectionModel().getSelectedIndex());

        persistance.PersistManager.deleteSesLabo(stagiaire.getIdStagiaire());

        persistance.PersistManager.affectLabo(lab.getIdLabo(), stagiaire.getIdStagiaire(), Date.valueOf(LocalDate.now()));
///////////////
        Grade gr = grades.get(grade.getSelectionModel().getSelectedIndex());

        persistance.PersistManager.deleteSesGrade(stagiaire.getIdStagiaire());

        persistance.PersistManager.affectGrade(gr.getIdGrade(), stagiaire.getIdStagiaire(), Date.valueOf(LocalDate.now()));
/////////////
        Fonction fct = fonctions.get(fonction.getSelectionModel().getSelectedIndex());

        persistance.PersistManager.deleteSesFonction(stagiaire.getIdStagiaire());

        persistance.PersistManager.affectFonction(fct.getIdFonction(), stagiaire.getIdStagiaire(), Date.valueOf(LocalDate.now()));

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
