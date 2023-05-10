package milestone.pkg3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class AvailabiliityOfPilotController implements Initializable {

    @FXML
    private ComboBox availabilityComboBox;
    @FXML
    private TextField nametxt;
    @FXML
    private Button pArrButton;
    @FXML
    private Button pBin;
    @FXML
    private TextField IDtxt;
    private ArrayList<pilot> pList = new ArrayList<pilot>();
    @FXML
    private TextField sqdrntxt;
    @FXML
    private ComboBox pilotTypebox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        availabilityComboBox.getItems().add("Available");
        availabilityComboBox.getItems().add("Unavailable");
        availabilityComboBox.setValue("Availability");

        pilotTypebox.getItems().add("Scout");
        pilotTypebox.getItems().add("Fighter");
        pilotTypebox.getItems().add("Maintenance");
        pilotTypebox.getItems().add("Emergency");
        pilotTypebox.setValue("Emergecy");
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
            Logger.getLogger(DashboardforPilotController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void pArrButtonOnClicked(ActionEvent event) {
        pList.add(
                new pilot(
                        Integer.parseInt(IDtxt.getText()),
                        sqdrntxt.getText(),
                        availabilityComboBox.getValue().toString(),
                        nametxt.getText())
        );
    }

    @FXML
    private void pBInSaveButtonOnClick(ActionEvent event) {
        File f = new File("Pilot.bin");
        ObjectOutputStream oos = null;
        try {
            if (f.exists()) {
                oos = new AppendableObjectOutputStream(new FileOutputStream(f, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(f, true));
            }
            for (pilot p : pList) {
                oos.writeObject(p);
            }

            oos.close();
        } catch (Exception e) {
        }

    }

    @FXML
    private void go2dashboard(ActionEvent event) throws IOException {
        ChangeScene(event, "DashboardforPilot");
    }

}


