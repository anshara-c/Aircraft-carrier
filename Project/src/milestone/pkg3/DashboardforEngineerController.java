
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


public class DashboardforEngineerController implements Initializable {

   
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
    private void Vehiclescene(ActionEvent event) throws IOException {
        ChangeScene(event, "VehicleCheck");
    }

    @FXML
    private void weatherscene(ActionEvent event) {
    }

    @FXML
    private void consumptionscene(ActionEvent event) throws IOException {
        ChangeScene(event, "ReportPieChart");
    }

    @FXML
    private void repairscene(ActionEvent event) {
    }
    
}
