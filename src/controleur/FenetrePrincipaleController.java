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
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
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
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import model.DemandeStage;
import model.Diplome;
import model.Fonction;
import model.FraisStage;
import model.Grade;
import model.LaboratoireRattachement;
import model.LieuStage;
import model.Stage;
import model.Stagiaire;
import model.Utilisateur;
import model.ZoneType;
import modelforpresentation.DemandeStagePres;
import modelforpresentation.StagePres;
import modelforpresentation.StagiairePres;
import modelforpresentation.UtilisateurPres;
import persistance.CKey;
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
    TableView tableStages;

    @FXML
    Tab tabBudget, gestionStagiaire, gestionDemandeStage, gestionManifestation, tabStatistiques, tabComptes, tabConfiguration;

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
    Label loggedIn, loggedIn1, loggedIn2, loggedIn3, loggedIn4;

    // Libele gestion des stagiaires
    @FXML
    Label libelleStagiaire1;
    @FXML
    Label libelleStagiaire2;
    @FXML
    Label libelleStagiaire3;
    @FXML
    Label libelleStagiaire4;
    @FXML
    Label libelleStagiaire5;
    @FXML
    Label libelleStagiaire6;
    @FXML
    Label libelleStagiaire7;
    @FXML
    Label libelleStagiaire8;

    /// Libelle  demande de stage
    @FXML
    Label libelleDemandeStage1;
    @FXML
    Label libelleDemandeStage2;
    @FXML
    Label libelleDemandeStage3;
    @FXML
    Label libelleDemandeStage4;
    @FXML
    Label libelleDemandeStage5;
    @FXML
    Label libelleDemandeStage6;

    ////
    @FXML
    ProgressBar progresDemandeStage;
    @FXML
    Label numStageInfo;
    @FXML
    Label concerneStageInfo;
    @FXML
    Label fraissejourStageInfo;
    @FXML
    Label fraisTransportStageInfo;
    @FXML
    Label fraisVisaStageInfo;
    @FXML
    Label fraisAssStageInfo;
    @FXML
    Label fraisTotalStageInfo;
    @FXML
    ComboBox comboFiltre;
    @FXML
    TextField valeurFiltrePointage;
    @FXML
    Label estimatorResult;

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
    private LineChart<Number,Number> lineChartEvolutionBudget;
    @FXML

    private BarChart<String, Number> barChartEtatStages;
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
    @FXML
    TextField fieldLieuConf;

    @FXML
    Button validerDemande, ajouterStagiaire, modifierStagiaire, supprimerStagiaire, creerDemande, modifierDemande, supprimerDemande;
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
    private void showStagiare(ActionEvent event) throws IOException {
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
        StageDPGR.root2 = FXMLLoader.load(getClass().getResource("/presentation/ModifierDemandeStage.fxml"));
        StageDPGR.refreshRoot2();
        StageDPGR.stage2.show();
    }

     @FXML
    private void showDemandeSupprimer(ActionEvent event) throws IOException {
        StageDPGR.root2 = FXMLLoader.load(getClass().getResource("/presentation/confirmerSupDemandeStage.fxml"));
        StageDPGR.refreshRoot2();
        StageDPGR.stage2.show();
    }
    
    @FXML
    private void showStagiareSupprimer(ActionEvent event) throws IOException {
        StageDPGR.root2 = FXMLLoader.load(getClass().getResource("/presentation/confirmerSupStagiaire.fxml"));
        StageDPGR.refreshRoot2();
        StageDPGR.stage2.show();
    }

    @FXML
    private void showStagiareProfile(ActionEvent event) throws IOException {
        StageDPGR.root2 = FXMLLoader.load(getClass().getResource("/presentation/ProfilStagiaire.fxml"));
        StageDPGR.refreshRoot2();
        StageDPGR.stage2.show();
    }

    @FXML
    private void filtrerProfile(ActionEvent event) throws IOException {
        //Data
        ObservableList<StagePres> dataStage = FXCollections.observableArrayList();
        List<Stage> listeStage = persistance.PersistManager.findAllStages();
        int estimateur = 0;
        for (Stage it : listeStage) {
            if (comboFiltre.getValue().toString().equals("Année")/*&&(it.getDateDebutStage().getYear()+"").equals(valeurFiltrePointage.getText())*/) {
                String str = it.getDateDebutStage().toString().split(" ")[it.getDateDebutStage().toString().split(" ").length - 1];
                System.out.println("============" + str);
                if (valeurFiltrePointage.getText().equals(str)) {
                    dataStage.add(new StagePres(it));
                     estimateur += persistance.PersistManager.findFraisStageById(it.getIdStage()).getTotalCout();
                    
                }
            }
        }
        //Remplissage
        tableStages.setItems(dataStage);
        //Sélection d'une cellule
        tableStages.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                StageDPGR.selectedStage = (StagePres) tableStages.getSelectionModel().getSelectedItem();
                FenetrePrincipaleController.this.refreshInfosStageStage();
            }
        });
        // tableStages.getColumns().addAll(idStageCol,dateDStageCol,dateFStageCol,envStageCol,missionStageCol,objStageCol);

        estimatorResult.setText(estimateur + "");
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        statistiques();
        // filtres disponibles
        comboFiltre.getItems().add("Année");
        // TODO
        progresDemandeStage.setProgress(0);

        loggedIn.setText("Logged " + StageDPGR.utilisateurLogged.getProfilUtilisateur());
        loggedIn1.setText("Logged " + StageDPGR.utilisateurLogged.getProfilUtilisateur());

        loggedIn2.setText("Logged " + StageDPGR.utilisateurLogged.getProfilUtilisateur());
        loggedIn3.setText("Logged " + StageDPGR.utilisateurLogged.getProfilUtilisateur());
        loggedIn4.setText("Logged " + StageDPGR.utilisateurLogged.getProfilUtilisateur());

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
                if (StageDPGR.selectedStagiaire == null) {

                    StageDPGR.selectedStagiaire = (StagiairePres) tableStagiares.getItems().get(0);

                }
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
                if (StageDPGR.selectedDemandeStage == null) {
                    StageDPGR.selectedDemandeStage = (DemandeStagePres) tableDemandeStage.getItems().get(0);
                }
                FenetrePrincipaleController.this.refreshInfosDemandeStage();
            }
        });
        /*
         Tableau des Stages
         */
        //Data
        ObservableList<StagePres> dataStage = FXCollections.observableArrayList();
        List<Stage> listeStage = persistance.PersistManager.findAllStages();

        for (Stage it : listeStage) {
            dataStage.add(new StagePres(it));
        }
        // Colonnes
        TableColumn idStageCol = new TableColumn();
        idStageCol.setText("Identifiant Stage");
        idStageCol.setCellValueFactory(new PropertyValueFactory("idStage"));

        TableColumn dateDStageCol = new TableColumn();
        dateDStageCol.setText("Date de Début");
        dateDStageCol.setCellValueFactory(new PropertyValueFactory("dateDebutStage"));

        TableColumn dateFStageCol = new TableColumn();
        dateFStageCol.setText("Date de Fin");
        dateFStageCol.setCellValueFactory(new PropertyValueFactory("dateFinStage"));

        TableColumn envStageCol = new TableColumn();
        envStageCol.setText("Environnement");
        envStageCol.setCellValueFactory(new PropertyValueFactory("environnementStage"));

        TableColumn missionStageCol = new TableColumn();
        missionStageCol.setText("Mission");
        missionStageCol.setCellValueFactory(new PropertyValueFactory("missionStage"));

        TableColumn objStageCol = new TableColumn();
        objStageCol.setText("Objectif");
        objStageCol.setCellValueFactory(new PropertyValueFactory("objectifStage"));

        //Remplissage
        tableStages.setItems(dataStage);
        tableStages.getColumns().addAll(idStageCol, dateDStageCol, dateFStageCol, envStageCol, missionStageCol, objStageCol);

        //Sélection d'une cellule
        tableStages.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                StageDPGR.selectedStage = (StagePres) tableStages.getSelectionModel().getSelectedItem();
                FenetrePrincipaleController.this.refreshInfosStageStage();
            }
        });
        // Remplissage des configs
        remplirConfiguration();

        if (StageDPGR.utilisateurLogged.getProfilUtilisateur().equals("Admin")) {

            validerDemande.setDisable(true);
            tabBudget.setDisable(true);
            tabStatistiques.setDisable(true);

        } else if (StageDPGR.utilisateurLogged.getProfilUtilisateur().equals("MembreCS")) {

            ajouterStagiaire.setDisable(true);
            modifierStagiaire.setDisable(true);
            supprimerStagiaire.setDisable(true);
            creerDemande.setDisable(true);
            modifierDemande.setDisable(true);
            supprimerDemande.setDisable(true);
            tabBudget.setDisable(true);
            tabStatistiques.setDisable(true);
            tabComptes.setDisable(true);
            tabConfiguration.setDisable(true);

        } else if (StageDPGR.utilisateurLogged.getProfilUtilisateur().equals("Agent")) {

            tabBudget.setDisable(true);
            tabStatistiques.setDisable(true);
            tabComptes.setDisable(true);
            tabConfiguration.setDisable(true);

        }
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
        Stagiaire stagiaire = persistance.PersistManager.findStagiaireById(StageDPGR.selectedStagiaire.getIdStagiaire());
        int idStagiaire = stagiaire.getIdStagiaire();
        libelleStagiaire1.setText(StageDPGR.selectedStagiaire.getNomStagiaire());
        libelleStagiaire2.setText(StageDPGR.selectedStagiaire.getPrenomStagiaire());
        libelleStagiaire3.setText(StageDPGR.selectedStagiaire.getTelStagiaire());
        libelleStagiaire4.setText(StageDPGR.selectedStagiaire.getEmailStagiaire());
        libelleStagiaire5.setText(persistance.PersistManager.getSesLabo(idStagiaire).get(0).getNomLabo());
        libelleStagiaire6.setText(persistance.PersistManager.getSesFonction(idStagiaire).get(0).getLibelleFonction());
        libelleStagiaire7.setText(persistance.PersistManager.getSesDiplome(idStagiaire).get(0).getLibelleDeplome());
        libelleStagiaire8.setText(persistance.PersistManager.getSesGrade(idStagiaire).get(0).getLibelleGrade());

    }

    public void refreshInfosDemandeStage() {

        System.out.println("stagestage " + StageDPGR.selectedDemandeStage.getIdStage());

        Stage stage = persistance.PersistManager.findStageById(StageDPGR.selectedDemandeStage.getIdStage());

        Stagiaire stagiaire = persistance.PersistManager.findStagiaireById(StageDPGR.selectedDemandeStage.getIdStagiaire());

        libelleDemandeStage1.setText(stagiaire.getNomStagiaire() + stagiaire.getPrenomStagiaire());

        libelleDemandeStage2.setText(StageDPGR.selectedDemandeStage.getDateDemandeStage());
        libelleDemandeStage4.setText(DateFormatter.formatter.format(stage.getDateDebutStage()));
        libelleDemandeStage5.setText(DateFormatter.formatter.format(stage.getDateFinStage()));
        libelleDemandeStage6.setText(stage.getLieuStageIdLieu().getPaysLieuStage());

        DemandeStage demandeStage = persistance.PersistManager.findDemandeStageByIds(new CKey(StageDPGR.selectedDemandeStage.getIdStage(), StageDPGR.selectedDemandeStage.getIdStagiaire()));
        progresDemandeStage.setProgress(demandeStage.getProgres());

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

    public void refreshInfosStageStage() {
       if(StageDPGR.selectedStage==null)return;
        numStageInfo.setText(" " + StageDPGR.selectedStage.getIdStage());

        int idStagiaire = persistance.PersistManager.getDemandeOfStage(StageDPGR.selectedStage.getIdStage()).getIdStagiaire();

        concerneStageInfo.setText(" " + persistance.PersistManager.findStagiaireById(idStagiaire).getNomStagiaire() + " " + persistance.PersistManager.findStagiaireById(idStagiaire).getPrenomStagiaire());

        FraisStage frais = persistance.PersistManager.getSesFrais(StageDPGR.selectedStage.getIdStage());
        fraissejourStageInfo.setText("" + frais.getMontantSejourFraiStage());
        fraisTransportStageInfo.setText("" + frais.getMontantTransportFraiStage());
        fraisVisaStageInfo.setText("" + frais.getMontantVisaFraiStage());
        fraisAssStageInfo.setText("" + frais.getMontantAssurranceFraiStage());
        int t=frais.getTotalCout();
      //  int total = frais.getMontantSejourFraiStage() + frais.getMontantSejourFraiStage() + frais.getMontantVisaFraiStage() + frais.getMontantAssurranceFraiStage();
        fraisTotalStageInfo.setText(" " + t);
    }
    /*
     Configuration methodes
     */

    @FXML
    private void addGrade(ActionEvent event) throws IOException {
        if (fieldGradeConf.getText() != null) {
            Grade grde = new Grade();
            grde.setIdGrade(persistance.PersistManager.findAllGrades().size() + 1);
            grde.setLibelleGrade(fieldGradeConf.getText());
            persistance.PersistManager.insertGrade(grde);

        }
        StageDPGR.currentTab = 6;
        StageDPGR.root = FXMLLoader.load(getClass().getResource("/presentation/FenetrePrincipale.fxml"));
        StageDPGR.refreshRoot1();
    }

    @FXML
    private void addFonction(ActionEvent event) throws IOException {
        if (fieldFctConf.getText() != null) {
            Fonction fonction = new Fonction();
            fonction.setIdFonction(persistance.PersistManager.findAllFonction().size() + 1);
            fonction.setLibelleFonction(fieldFctConf.getText());
            persistance.PersistManager.insertFonction(fonction);

        }
        StageDPGR.currentTab = 6;
        StageDPGR.root = FXMLLoader.load(getClass().getResource("/presentation/FenetrePrincipale.fxml"));
        StageDPGR.refreshRoot1();
    }

    @FXML
    private void addDiplome(ActionEvent event) throws IOException {
        if (fieldDiplomeConf.getText() != null) {
            Diplome diplome = new Diplome();
            diplome.setIdDiplome(persistance.PersistManager.findAllDiplome().size() + 1);
            diplome.setLibelleDeplome(fieldDiplomeConf.getText());
            persistance.PersistManager.insertDiplome(diplome);

        }
        StageDPGR.currentTab = 6;
        StageDPGR.root = FXMLLoader.load(getClass().getResource("/presentation/FenetrePrincipale.fxml"));
        StageDPGR.refreshRoot1();
    }

    @FXML
    private void addLabo(ActionEvent event) throws IOException {
        if (fieldLaboConf.getText() != null) {
            LaboratoireRattachement labo = new LaboratoireRattachement();
            labo.setIdLabo(persistance.PersistManager.findAllLabo().size() + 1);
            labo.setNomLabo(fieldLaboConf.getText());
            persistance.PersistManager.insertLabo(labo);

        }
        StageDPGR.currentTab = 6;
        StageDPGR.root = FXMLLoader.load(getClass().getResource("/presentation/FenetrePrincipale.fxml"));
        StageDPGR.refreshRoot1();
    }

    @FXML
    private void showValiderDemande(ActionEvent event) throws IOException {
        StageDPGR.root2 = FXMLLoader.load(getClass().getResource("/presentation/ValiderDemande.fxml"));
        StageDPGR.refreshRoot2();
        StageDPGR.stage2.show();
    }

    @FXML
    private void addZone(ActionEvent event) throws IOException {
        if (fieldZoneConf.getText() != null) {
            ZoneType zone = new ZoneType();
            zone.setIdZone(persistance.PersistManager.findAllZones().size() + 1);
            zone.setNomZone(fieldZoneConf.getText());
            persistance.PersistManager.insertZone(zone);
        }
        StageDPGR.currentTab = 6;
        StageDPGR.root = FXMLLoader.load(getClass().getResource("/presentation/FenetrePrincipale.fxml"));
        StageDPGR.refreshRoot1();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void statistiques(){
        int nbDemandeRefusee = 3 ;
        int nbDemandeAcceptee = 7 ;
        int totalDemande = nbDemandeAcceptee + nbDemandeRefusee ;
        nbDemandes.setText(((Integer) totalDemande).toString());
        pieChartAccVsRefuse.getData().add(new PieChart.Data("Acceptée", nbDemandeAcceptee))  ;
        pieChartAccVsRefuse.getData().add(new PieChart.Data("Refusée", nbDemandeRefusee))  ;
        pieChartAccVsRefuse.setLegendSide(Side.LEFT);
        
        int nbDemandeurDoctorant = 15 ;
        int nbDemandeurEns = 5 ;
        int totalDemandeur = nbDemandeurDoctorant + nbDemandeurEns ;
         nbDemandeurs.setText(((Integer) totalDemandeur).toString());
        pieChartdemandeursVsPasDemandeurs.getData().add(new PieChart.Data("Doctorant", nbDemandeurDoctorant))  ;
        pieChartdemandeursVsPasDemandeurs.getData().add(new PieChart.Data("Enseignant chercheur", nbDemandeurEns))  ;
       pieChartdemandeursVsPasDemandeurs.setLabelLineLength(10);
        pieChartdemandeursVsPasDemandeurs.setLegendSide(Side.LEFT);
      
         final Label caption;
        caption = new Label("");
        caption.setTextFill(Color.DARKORANGE);
        caption.setStyle("-fx-font: 24 arial;");
        // children.add(caption);
     /*  if(((Pane) StageDPGR.root).getChildren()!=null){
            ((Pane) StageDPGR.root).getChildren().add(caption);
        }
        else{
            System.err.println("erroror");
        }*/
         


        for (final PieChart.Data data : pieChartAccVsRefuse.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
                    new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent e) {
                           System.out.println(String.valueOf(data.getPieValue()) + "%");
                            
                            caption.setTranslateX(e.getSceneX());
                            caption.setTranslateY(e.getSceneY());
                             caption.setText(String.valueOf(data.getPieValue()) + "%") ;
                             
                          
                                   
                        }
                    });
        }
                for (final PieChart.Data data : pieChartdemandeursVsPasDemandeurs.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
                    new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent e) {
                            System.out.println(String.valueOf(data.getPieValue()) + "%");
                            caption.setText(String.valueOf(data.getPieValue()) + "%");
                            caption.setTranslateX(e.getSceneX());
                            caption.setTranslateY(e.getSceneY());
                            
                        }
                    });
        }
        
                XYChart.Series series1 = new XYChart.Series();
        int nbStagesRefuse = 5 ;
        int nbStagesAccepte = 8  ;
        int nbStagesEnAttente = 14 ;
        series1.getData().add(new XYChart.Data("Stage validé", nbStagesAccepte));
        series1.getData().add(new XYChart.Data("Stage réfusé", nbStagesEnAttente));
        series1.getData().add(new XYChart.Data("Stage en attente", nbStagesRefuse));
        

        barChartEtatStages.getData().add(series1);
        barChartEtatStages.setLegendVisible(false);
        barChartEtatStages.setCategoryGap(50);
        
        
        ///// Line chart
        
                final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("année");
        
        
     //  lineChartEvolutionBudget.getProperties(x)
        
        lineChartEvolutionBudget = new LineChart<Number,Number>(xAxis,yAxis);
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("Budget");
        //populating the series with data
        series.getData().add(new XYChart.Data(2010, 23));
        series.getData().add(new XYChart.Data(2011, 14));
        series.getData().add(new XYChart.Data(2012, 15));
        series.getData().add(new XYChart.Data(2013, 24));
        series.getData().add(new XYChart.Data(2014, 34));
        series.getData().add(new XYChart.Data(2015, 36));

        lineChartEvolutionBudget.getData().add(series);
                
    }
}
