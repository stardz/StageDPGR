/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
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
    TextField duree, fraisSejour, fraisTransport, fraisAssurance, fraisVisa;

    @FXML
    TextArea objective, environ, mission;

    List<Stagiaire> stagiaireList;
    List<LieuStage> lieuList;

    /**
     * Initializes the controller class.
     */
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

    }

    @FXML
    private void valider(ActionEvent e) throws IOException {
        try {

            Stage stage = new Stage(DateFormatter.formatter.parse(dateFin.getValue().toString()), objective.getText(), lieuList.get(lieu.getSelectionModel().getSelectedIndex()), DateFormatter.formatter.parse(dateDebut.getValue().toString()), environ.getText(), mission.getText());

            stage.setIdStage(StageDPGR.selectedDemandeStage.getIdStage());

            persistance.PersistManager.updateStage(stage);

            FraisStage fraisStage = new FraisStage(persistance.PersistManager.getSesFrais(StageDPGR.selectedDemandeStage.getIdStage()).getIdFraiStage(), Integer.parseInt(fraisTransport.getText()), Integer.parseInt(fraisVisa.getText()), Integer.parseInt(fraisAssurance.getText()), Integer.parseInt(fraisSejour.getText()));

            persistance.PersistManager.updateFraisStage(fraisStage);

            int total = Integer.parseInt(fraisVisa.getText()) + Integer.parseInt(fraisTransport.getText()) + Integer.parseInt(fraisAssurance.getText()) + Integer.parseInt(fraisSejour.getText());

      //      persistance.PersistManager.updateAvoirFraisStage(stage.getIdStage(), fraisStage.getIdFraiStage(), total);
            //  persistance.PersistManager.affectFraisStage(stage.getIdStage(), fraisStage.getIdFraiStage(), total);
          //  persistance.PersistManager.affectDemandeStage(stagiaireList.get(stagiaire.getSelectionModel().getSelectedIndex()).getIdStagiaire(), stage.getIdStage(), DateFormatter.formatter.parse(dateDemande.getValue().toString()));
        } catch (ParseException ex) {
            Logger.getLogger(AjouterDemandeStageController.class.getName()).log(Level.SEVERE, null, ex);
        }

        StageDPGR.currentTab = 1;

        StageDPGR.root = FXMLLoader.load(getClass().getResource("/presentation/FenetrePrincipale.fxml"));

        StageDPGR.refreshRoot1();
        StageDPGR.stage2.close();
    }

    @FXML
    private void annuler(ActionEvent e) {
        StageDPGR.stage2.close();

    }

}
