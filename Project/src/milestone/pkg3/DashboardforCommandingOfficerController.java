
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

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class DashboardforCommandingOfficerController implements Initializable {

    /**
     * Initializes the controller class.
     */
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
    private void MissionListscene(ActionEvent event) throws IOException {
        
        ChangeScene(event, "MissionList");
    }

    @FXML
    private void assignMissionscene(ActionEvent event) throws IOException {
        ChangeScene(event, "MissionAllocation");
    }

    @FXML
    private void generatereportsene(ActionEvent event) throws IOException {
        ChangeScene(event, "FileChooser");
      
    }

    @FXML
    private void complainscene(ActionEvent event) {
    }

    @FXML
    private void reviewscene(ActionEvent event) {
    }
    
}
