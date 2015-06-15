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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

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
    ChoiceBox profil;
    @FXML
    Button valider;
    @FXML
    Button annuler;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
