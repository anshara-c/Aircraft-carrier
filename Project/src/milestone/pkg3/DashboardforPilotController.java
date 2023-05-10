
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
import milestone.pkg3.AppendableObjectOutputStream;

public class DashboardforPilotController implements Initializable {

    
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
    private void availabilityscene(ActionEvent event) throws IOException {
        ChangeScene(event, "AvailabiliityOfPilot");
    }

    @FXML
    private void missionreportscene(ActionEvent event) throws IOException {
         ChangeScene(event, "MissionReport");
    }

    @FXML
    private void personalinfoscene(ActionEvent event) throws IOException {
         ChangeScene(event, "Personalinformation");
    }

    @FXML
    private void contactengineerscene(ActionEvent event) throws IOException {
        ChangeScene(event, "EmergencyContact");
    }

    @FXML
    private void missionpreparescene(ActionEvent event) {
    }

    
}
