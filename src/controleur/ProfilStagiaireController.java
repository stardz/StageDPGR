/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Ahmed-PC
 */
public class ProfilStagiaireController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label nomEtPrenomProfil;

    @FXML
    private Label profilNom;
    @FXML
    private Label profilPrenom;
    @FXML
    private Label profilTel;
    @FXML
    private Label profilEmail;
    @FXML
    private Label profilLabo;
    @FXML
    private ComboBox profilEncadreurs;
    @FXML
    private Label profilFonction;
    @FXML
    private Label profilGrade ;
    @FXML
    private Label profilNBStages;
    @FXML
    private Label profilNBStagesAcceptees;
    @FXML
    private Label profilNBStagesRefusees;
    @FXML
    private Label profilNBMF;
    @FXML
    private Label profilNBMFAcceptee;
    @FXML
    private Label profilNBMFRefusee;
    @FXML
    private TableView tableStagesMF ;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // System.out.println(" aa "+nomEtPrenomProfil.getText());
        nomEtPrenomProfil.setText(nomEtPrenomProfil.getText() + "aa");

    }

}
