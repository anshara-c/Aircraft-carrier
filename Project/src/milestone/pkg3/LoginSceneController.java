/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milestone.pkg3;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginSceneController implements Initializable {

    @FXML
    private TextField usernameTxt;
    @FXML
    private TextField passwordTxt;
    @FXML
    private ComboBox<String> userComboBox;
    @FXML
    private Label selecteduserLabel;
    @FXML
    private Button LoginButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        userComboBox.getItems().addAll("Pilot", "Cook", "Engineer", "Commanding officer", "Doctor");
        selecteduserLabel.setText(null);
    }    

    @FXML
    private void clearUNOnMouseClick(MouseEvent event) {
        usernameTxt.clear();
    }

    @FXML
    private void clearPWOnMouseClick(MouseEvent event) {
        passwordTxt.clear();
    }
 private void ChangeScene(ActionEvent event, String str) throws IOException {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(str + ".fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();

        } catch (ClassCastException ex) {
            Logger.getLogger(MissionAllocationController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    
}
    @FXML
    private void loginOnButtonClick(ActionEvent event) throws IOException {
        
        if (selecteduserLabel.equals("Pilot")) {
          {
                if (usernameTxt.getText().equals(pilot.getUserName())){
                    if (Integer.parseInt(passwordTxt.getText())==(pilot.getPassword())){
                        
              ChangeScene(event, "DashboardforPilot");

        } 
        
    
    

    }
                    else {
                     Alert a = new Alert(Alert.AlertType.WARNING);
                           a.setTitle("Warning Alert");
                           a.setContentText("Wrong Password!");
                           a.setHeaderText(null);
                           a.showAndWait();         
                    }
                       

                       

                    } 
                    }
                }

            
        
       
   
    

    @FXML
    private void changePWOnMouseClick(MouseEvent event) {
    }

    @FXML
    private void selectuserOnButtonClick(ActionEvent event) {
        selecteduserLabel.setText(userComboBox.getValue());
    }
    
}
