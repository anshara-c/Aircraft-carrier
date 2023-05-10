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
import javafx.stage.Stage;


public class DashboardforCookController implements Initializable {

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void createrecipescene(ActionEvent event) throws IOException {
        ChangeScene(event,"CreateRecipe");
    }

    @FXML
    private void foodlistscene(ActionEvent event) throws IOException {
         ChangeScene(event,"FoodList");
    }

    @FXML
    private void consuptionscene(ActionEvent event) throws IOException {
        ChangeScene(event, "FoodConsumption");
    }

    @FXML
    private void menulistscene(ActionEvent event) {
    }
    
}
