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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.DemandeStage;
import model.Diplome;
import model.Fonction;
import model.Grade;
import model.LaboratoireRattachement;
import model.LieuStage;
import model.Stagiaire;
import model.Utilisateur;
import model.ZoneType;
import modelforpresentation.DemandeStagePres;
import modelforpresentation.StagiairePres;
import modelforpresentation.UtilisateurPres;
import presentation.StageDPGR;

/**
 * FXML Controller class
 *
 * @author oSunshine
 */
public class FenetrePrincipaleController implements Initializable {

    @FXML
    TabPane tabPane;
    @FXML
    TableView tableStagiares;
    @FXML
    TableView tableDemandeStage;
    @FXML
    TableView tableComptes;
    @FXML
    Label libelleCompte1;
    @FXML
    Label libelleCompte2;
    @FXML
    Label libelleCompte3;
    @FXML
    Label libelleCompte4;
    @FXML
    Label libelleCompte5;
    @FXML
    ProgressBar progresDemandeStage;

    /**
     * **********************Statistiques***************************
     */
    @FXML
    private Label nbDemandes;
    @FXML
    private Label nbDemandeurs;
    @FXML
    private PieChart pieChartAccVsRefuse;
    @FXML
    private PieChart pieChartdemandeursVsPasDemandeurs;
    @FXML
    private LineChart lineChartEvolutionBudget;
    @FXML

    private BarChart barChartStages;
    @FXML
    private ToggleGroup groupTypes;
    @FXML
    private ToggleGroup groupProfils;
    @FXML
    private ComboBox<String> comboAnnée;
    /*
     ********************************* Configurations ************************************
     */
    @FXML
    ComboBox comboFctConf;
    @FXML
    ComboBox comboDiplomeConf;
    @FXML
    ComboBox comboGradeConf;
    @FXML
    ComboBox comboLaboConf;
    @FXML
    ComboBox comboLieuConf;
    @FXML
    ComboBox affctedZoneConf;
    @FXML
    ComboBox comboZoneConf;

    @FXML
    TextField fieldFctConf;
    @FXML
    TextField fieldDiplomeConf;
    @FXML
    TextField fieldGradeConf;
    @FXML
    TextField fieldLaboConf;
    @FXML
    TextField fieldZoneConf;
    /*
     Actions comptes
     */

    @FXML
    private void showCompteAjouter(ActionEvent event) throws IOException {
        StageDPGR.root2 = FXMLLoader.load(getClass().getResource("/presentation/insererUtilisateur.fxml"));
        StageDPGR.refreshRoot2();
        StageDPGR.stage2.show();
    }

    @FXML
    private void showCompteSupprimer(ActionEvent event) throws IOException {
        StageDPGR.root2 = FXMLLoader.load(getClass().getResource("/presentation/confirmerSup.fxml"));
        StageDPGR.refreshRoot2();
        StageDPGR.stage2.show();
    }

    @FXML
    private void showCompteModifier(ActionEvent event) throws IOException {
        StageDPGR.root2 = FXMLLoader.load(getClass().getResource("/presentation/modifierUtilisateur.fxml"));
        StageDPGR.refreshRoot2();
        StageDPGR.stage2.show();
    }

    @FXML
    private void showCompteBloquer(ActionEvent event) throws IOException {
        StageDPGR.root2 = FXMLLoader.load(getClass().getResource("/presentation/confiirmerBloquer.fxml"));
        StageDPGR.refreshRoot2();
        StageDPGR.stage2.show();
    }

    @FXML
    private void showCompteDeBloquer(ActionEvent event) throws IOException {
        StageDPGR.root2 = FXMLLoader.load(getClass().getResource("/presentation/Compte_Debloquer.fxml"));
        StageDPGR.refreshRoot2();
        StageDPGR.stage2.show();
    }

    @FXML
    private void showStagiareAjouter(ActionEvent event) throws IOException {
        StageDPGR.root2 = FXMLLoader.load(getClass().getResource("/presentation/AjouterStagiaire.fxml"));
        StageDPGR.refreshRoot2();
        StageDPGR.stage2.show();
    }

    @FXML
    private void showStagiareModifier(ActionEvent event) throws IOException {
        if (StageDPGR.selectedStagiaire != null) {
            StageDPGR.root2 = FXMLLoader.load(getClass().getResource("/presentation/ModifierStagiaire.fxml"));
            StageDPGR.refreshRoot2();
            StageDPGR.stage2.show();
        } else {

        }
    }

    @FXML
    private void showDemandeAjouter(ActionEvent event) throws IOException {
        StageDPGR.root2 = FXMLLoader.load(getClass().getResource("/presentation/AjouterDemandeStage.fxml"));
        StageDPGR.refreshRoot2();
        StageDPGR.stage2.show();
    }

    @FXML
    private void showDemandeModifier(ActionEvent event) throws IOException {
        // StageDPGR.root2 = FXMLLoader.load(getClass().getResource("/presentation/ajouterStagiaire.fxml"));
        //  StageDPGR.refreshRoot2();
        //StageDPGR.stage2.show();
    }

    @FXML
    private void showStagiareSupprimer(ActionEvent event) throws IOException {
        //   StageDPGR.root2 = FXMLLoader.load(getClass().getResource("/presentation/ajouterStagiaire.fxml"));
        StageDPGR.refreshRoot2();
        StageDPGR.stage2.show();
    }

    @FXML
    private void showStagiareProfile(ActionEvent event) throws IOException {
        StageDPGR.root2 = FXMLLoader.load(getClass().getResource("/presentation/ProfilStagiaire.fxml"));
        StageDPGR.refreshRoot2();
        StageDPGR.stage2.show();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        progresDemandeStage.setProgress(0.6);
        //set Current Tab
        SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
        selectionModel.select(StageDPGR.currentTab);
        /*
         Tableau des comptes
         */
        //Data
        ObservableList<UtilisateurPres> dataComptes = FXCollections.observableArrayList();
        List<Utilisateur> listeUsrs = persistance.PersistManager.findAllUtilisateur();

        for (Utilisateur it : listeUsrs) {
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
        tableComptes.getColumns().addAll(nomUsrCol, prenomUsrCol, loginCol, mpCol, profileCol, etatCol);

        //Sélection d'une cellule
        tableComptes.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                StageDPGR.selectedUtilisateur = (UtilisateurPres) tableComptes.getSelectionModel().getSelectedItem();
                FenetrePrincipaleController.this.refreshInfosCompte();
            }
        });
        /*
         Tableau des Stagiares
         */
        //Data
        ObservableList<StagiairePres> dataStagiaires = FXCollections.observableArrayList();
        List<Stagiaire> listeStagiares = persistance.PersistManager.findAllStagiaires();

        for (Stagiaire it : listeStagiares) {
            dataStagiaires.add(new StagiairePres(it));
        }
        // Colonnes
        TableColumn idStagiaireCol = new TableColumn();
        idStagiaireCol.setText("Identifiant");
        idStagiaireCol.setCellValueFactory(new PropertyValueFactory("idStagiaire"));

        TableColumn nomStagiaireCol = new TableColumn();
        nomStagiaireCol.setText("Nom");
        nomStagiaireCol.setCellValueFactory(new PropertyValueFactory("nomStagiaire"));

        TableColumn prenomStagiaireCol = new TableColumn();
        prenomStagiaireCol.setText("Prenom");
        prenomStagiaireCol.setCellValueFactory(new PropertyValueFactory("prenomStagiaire"));

        TableColumn emailStagiaireCol = new TableColumn();
        emailStagiaireCol.setText("Email");
        emailStagiaireCol.setCellValueFactory(new PropertyValueFactory("emailStagiaire"));

        TableColumn telStagiaireCol = new TableColumn();
        telStagiaireCol.setText("N° Telephone");
        telStagiaireCol.setCellValueFactory(new PropertyValueFactory("telStagiaire"));
        //Remplissage
        tableStagiares.setItems(dataStagiaires);
        tableStagiares.getColumns().addAll(idStagiaireCol, nomStagiaireCol, prenomStagiaireCol, emailStagiaireCol, telStagiaireCol);

        //Sélection d'une cellule
        tableStagiares.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                StageDPGR.selectedStagiaire = (StagiairePres) tableStagiares.getSelectionModel().getSelectedItem();
                FenetrePrincipaleController.this.refreshInfosStagiaire();
            }
        });
        /*
         Tableau des demandes De Stage
         */
        //Data
        ObservableList<DemandeStagePres> dataDmdStage = FXCollections.observableArrayList();
        List<DemandeStage> listeDmsStage = persistance.PersistManager.findAllDemandeStages();

        for (DemandeStage it : listeDmsStage) {
            dataDmdStage.add(new DemandeStagePres(it));
        }
        // Colonnes
        TableColumn idStagiaireDmdStageCol = new TableColumn();
        idStagiaireDmdStageCol.setText("Identifiant Stagiaire");
        idStagiaireDmdStageCol.setCellValueFactory(new PropertyValueFactory("idStagiaire"));

        TableColumn idStageDmdStageCol = new TableColumn();
        idStageDmdStageCol.setText("Identifiant Stage");
        idStageDmdStageCol.setCellValueFactory(new PropertyValueFactory("idStage"));

        TableColumn dateDmdStageCol = new TableColumn();
        dateDmdStageCol.setText("Date de demande");
        dateDmdStageCol.setCellValueFactory(new PropertyValueFactory("dateDemandeStage"));

        TableColumn avisDGDmdStageCol = new TableColumn();
        avisDGDmdStageCol.setText("Avis DAGPGR");
        avisDGDmdStageCol.setCellValueFactory(new PropertyValueFactory("avisDadpgrStage"));

        TableColumn avisCSDmdStageCol = new TableColumn();
        avisCSDmdStageCol.setText("Avis Conseil Scientifique");
        avisCSDmdStageCol.setCellValueFactory(new PropertyValueFactory("avisCsStage"));

        TableColumn autorisationDmdStageCol = new TableColumn();
        autorisationDmdStageCol.setText("Autorisation de Stage");
        autorisationDmdStageCol.setCellValueFactory(new PropertyValueFactory("autorisationDeStage"));
        //Remplissage
        tableDemandeStage.setItems(dataDmdStage);
        tableDemandeStage.getColumns().addAll(idStagiaireCol, idStageDmdStageCol, dateDmdStageCol, avisDGDmdStageCol, avisCSDmdStageCol, autorisationDmdStageCol);

        //Sélection d'une cellule
        tableDemandeStage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                StageDPGR.selectedDemandeStage = (DemandeStagePres) tableDemandeStage.getSelectionModel().getSelectedItem();
                FenetrePrincipaleController.this.refreshInfosDemandeStage();
            }
        });

        // Remplissage des configs
        remplirConfiguration();
    }

    @FXML
    private void afficherProfilStagiaireOnAction(ActionEvent event) {
        System.out.println("click profile");
        try {
            StageDPGR.root2 = FXMLLoader.load(getClass().getResource("/presentation/ProfilStagiaire.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(FenetrePrincipaleController.class.getName()).log(Level.SEVERE, null, ex);
        }
        StageDPGR.refreshRoot2();
    }

    public void refreshInfosCompte() {
        libelleCompte1.setText(StageDPGR.selectedUtilisateur.getLoginUtilisateur());
        libelleCompte2.setText(StageDPGR.selectedUtilisateur.getNomUtilisateur());
        libelleCompte3.setText(StageDPGR.selectedUtilisateur.getPrenomUtilisateur());
        libelleCompte4.setText(StageDPGR.selectedUtilisateur.getProfilUtilisateur());
        libelleCompte5.setText(StageDPGR.selectedUtilisateur.getEtatCompte());
    }

    public void refreshInfosStagiaire() {
        // MAJ les informations d'un stagiaire
    }

    public void refreshInfosDemandeStage() {

    }

    @FXML
    private void modifierStagiaire(ActionEvent e) {

        try {
            StageDPGR.root2 = FXMLLoader.load(getClass().getResource("/presentation/ModifierStagiaire.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(FenetrePrincipaleController.class.getName()).log(Level.SEVERE, null, ex);
        }
        StageDPGR.refreshRoot2();
    }

    @FXML
    private void ajouterStagiaire(ActionEvent e) {

        try {
            StageDPGR.root2 = FXMLLoader.load(getClass().getResource("/presentation/AjouterStagiaire.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(FenetrePrincipaleController.class.getName()).log(Level.SEVERE, null, ex);
        }
        StageDPGR.refreshRoot2();
    }

    @FXML
    private void validerStatistiquesOnAction(ActionEvent event) {

    }

    public void remplirConfiguration() {
        List<Fonction> fctsConf = persistance.PersistManager.findAllFonction();
        for (Fonction it : fctsConf) {
            comboFctConf.getItems().add(it.getLibelleFonction());
        }

        List<Grade> grdsConf = persistance.PersistManager.findAllGrades();
        for (Grade it : grdsConf) {
            comboGradeConf.getItems().add(it.getLibelleGrade());
        }

        List<Diplome> dplmsConf = persistance.PersistManager.findAllDiplome();
        for (Diplome it : dplmsConf) {
            comboDiplomeConf.getItems().add(it.getLibelleDeplome());
        }

        List<LaboratoireRattachement> labosConf = persistance.PersistManager.findAllLabo();
        for (LaboratoireRattachement it : labosConf) {
            comboLaboConf.getItems().add(it.getNomLabo());
        }

        List<LieuStage> lieuxConf = persistance.PersistManager.findAllLieuStage();
        for (LieuStage it : lieuxConf) {
            comboLieuConf.getItems().add(it.getPaysLieuStage() + " :: " + it.getVilleLieuStage());
        }

        List<ZoneType> zonesConf = persistance.PersistManager.findAllZones();
        for (ZoneType it : zonesConf) {
            comboZoneConf.getItems().add(it.getNomZone());
            affctedZoneConf.getItems().add(it.getNomZone());
        }
    }
    @FXML
    private void logOut(MouseEvent mouseEvent) throws IOException {
         StageDPGR.root = FXMLLoader.load(getClass().getResource("/presentation/Authentification.fxml"));
         StageDPGR.refreshRoot1();          
    }
}
