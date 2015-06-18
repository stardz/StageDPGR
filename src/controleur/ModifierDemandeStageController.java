/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.FraisStage;
import model.LieuStage;
import model.Stage;
import model.Stagiaire;
import presentation.StageDPGR;

/**
 * FXML Controller class
 *
 * @author oSunshine
 */
public class ModifierDemandeStageController implements Initializable {

    @FXML
    ComboBox<String> stagiaire, lieu;

    @FXML
    DatePicker dateDemande, dateDebut, dateFin;

    @FXML
    TextField fraisSejour, fraisTransport, fraisAssurance, fraisVisa;

    @FXML
    TextArea objective, environ, mission;

    List<Stagiaire> stagiaireList;
    List<LieuStage> lieuList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        stagiaireList = persistance.PersistManager.findAllStagiaires();

        //  persistance.PersistManager.insertLieuStage(new LieuStage(persistance.PersistManager.findAllLieuStage().size()+1,"Constantine","Algerie"));
        for (Stagiaire st : stagiaireList) {
            stagiaire.getItems().add(st.getNomStagiaire() + "  " + st.getPrenomStagiaire());
        }

        Stagiaire stagiaireTmp = persistance.PersistManager.findStagiaireById(StageDPGR.selectedDemandeStage.getIdStagiaire());
        stagiaire.getSelectionModel().select(stagiaireTmp.getNomStagiaire() + "  " + stagiaireTmp.getPrenomStagiaire());

        lieuList = persistance.PersistManager.findAllLieuStage();

        for (LieuStage l : lieuList) {
            lieu.getItems().add(l.getPaysLieuStage() + " : " + l.getVilleLieuStage());
        }

        // Lieu lieuTmp = persistance.PersistManager.findLieuStageById(idLieuStage);
        lieu.getSelectionModel().select(null);
        //  FraisStage fraisStage = new FraisStage(persistance.PersistManager.getSesFrais(StageDPGR.selectedDemandeStage.getIdStage()).getIdFraiStage(), Integer.parseInt(fraisTransport.getText()), Integer.parseInt(fraisVisa.getText()), Integer.parseInt(fraisAssurance.getText()), Integer.parseInt(fraisSejour.getText()));
        FraisStage fraisStage = persistance.PersistManager.getSesFrais(StageDPGR.selectedDemandeStage.getIdStage());
        fraisSejour.setText(fraisStage.getMontantSejourFraiStage() + "");
        fraisTransport.setText(fraisStage.getMontantTransportFraiStage() + "");
        fraisAssurance.setText(fraisStage.getMontantAssurranceFraiStage() + "");
        fraisVisa.setText(fraisStage.getMontantVisaFraiStage() + "");

        Stage st = persistance.PersistManager.findStageById(StageDPGR.selectedDemandeStage.getIdStage());

        environ.setText(st.getEnvironnementStage());
        objective.setText(st.getObjectifStage());
        mission.setText(st.getMissionStage());

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        dateDebut.setValue(LocalDate.parse(DateFormatter.formatter.format(st.getDateDebutStage()), dateTimeFormatter));
        dateFin.setValue(LocalDate.parse(DateFormatter.formatter.format(st.getDateFinStage()), dateTimeFormatter));

    }

    @FXML
    private void valider(ActionEvent e) throws IOException {

        boolean arreter = false;

        try {
            if (Regex.dateValid(DateFormatter.formatter.format(DateFormatter.formatter.parse(dateDemande.getValue().toString())), "yyyy-mm-dd")) {
                dateDemande.setStyle(" -fx-background-color: #9eee48");

            } else {
                arreter = true;
                dateDemande.setStyle(" -fx-background-color: #ff6d6d");
            }
            if (Regex.dateValid(DateFormatter.formatter.format(DateFormatter.formatter.parse(dateDebut.getValue().toString())), "yyyy-mm-dd")) {
                dateDebut.setStyle(" -fx-background-color: #9eee48");

            } else {
                arreter = true;
                dateDebut.setStyle(" -fx-background-color: #ff6d6d");
            }
            if (Regex.dateValid(DateFormatter.formatter.format(DateFormatter.formatter.parse(dateFin.getValue().toString())), "yyyy-mm-dd")) {
                dateFin.setStyle(" -fx-background-color: #9eee48");

            } else {
                arreter = true;
                dateFin.setStyle(" -fx-background-color: #ff6d6d");
            }
            if (Regex.isInteger(fraisSejour.getText())) {
                fraisSejour.setStyle(" -fx-background-color: #9eee48");

            } else {
                arreter = true;
                fraisSejour.setStyle(" -fx-background-color: #ff6d6d");
            }
            if (Regex.isInteger(fraisTransport.getText())) {
                fraisTransport.setStyle(" -fx-background-color: #9eee48");

            } else {
                arreter = true;
                fraisTransport.setStyle(" -fx-background-color: #ff6d6d");
            }
            if (Regex.isInteger(fraisAssurance.getText())) {
                fraisAssurance.setStyle(" -fx-background-color: #9eee48");

            } else {
                arreter = true;
                fraisAssurance.setStyle(" -fx-background-color: #ff6d6d");
            }
            if (Regex.isInteger(fraisVisa.getText())) {
                fraisVisa.setStyle(" -fx-background-color: #9eee48");

            } else {
                arreter = true;
                fraisVisa.setStyle(" -fx-background-color: #ff6d6d");
            }

            if (!arreter) {
                Stage stage = new Stage(DateFormatter.formatter.parse(dateFin.getValue().toString()), objective.getText(), lieuList.get(lieu.getSelectionModel().getSelectedIndex()), DateFormatter.formatter.parse(dateDebut.getValue().toString()), environ.getText(), mission.getText());

                stage.setIdStage(StageDPGR.selectedDemandeStage.getIdStage());

                persistance.PersistManager.updateStage(stage);

                FraisStage fraisStage = new FraisStage(persistance.PersistManager.getSesFrais(StageDPGR.selectedDemandeStage.getIdStage()).getIdFraiStage(), Integer.parseInt(fraisTransport.getText()), Integer.parseInt(fraisVisa.getText()), Integer.parseInt(fraisAssurance.getText()), Integer.parseInt(fraisSejour.getText()));

                persistance.PersistManager.updateFraisStage(fraisStage);

                int total = Integer.parseInt(fraisVisa.getText()) + Integer.parseInt(fraisTransport.getText()) + Integer.parseInt(fraisAssurance.getText()) + Integer.parseInt(fraisSejour.getText());

                StageDPGR.currentTab = 1;

                StageDPGR.root = FXMLLoader.load(getClass().getResource("/presentation/FenetrePrincipale.fxml"));

                StageDPGR.refreshRoot1();
                StageDPGR.stage2.close();

            }
            //persistance.PersistManager.updateDemandeStage(stagiaireList.get(stagiaire.getSelectionModel().getSelectedIndex()).getIdStagiaire(), stage.getIdStage(), DateFormatter.formatter.parse(dateDemande.getValue().toString()));
        } catch (ParseException ex) {
            Logger.getLogger(AjouterDemandeStageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void annuler(ActionEvent e) {
        StageDPGR.stage2.close();

    }

}
