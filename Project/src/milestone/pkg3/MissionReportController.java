package milestone.pkg3;

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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MissionReportController implements Initializable {

    @FXML
    private TextArea mReportArea;
    @FXML
    private TextField missionIndex;
    @FXML
    private TextField pilotName;
    @FXML
    private TextArea complainReportArea;
    @FXML
    private Button saveReport;
    @FXML
    private Button go2Dashboard;
    private ArrayList<Report> RepList = new ArrayList<Report>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void saveReportOnButtonClick(ActionEvent event) {
        RepList.add(
                new Report(
                        mReportArea.getText(),
                        complainReportArea.getText(),
                        pilotName.getText(),
                        Integer.parseInt(missionIndex.getText()))
        );

        try {
            FileOutputStream fos = new FileOutputStream("PilotReport.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Report r : RepList) {
                oos.writeObject(r);
            }
            oos.close();
        } catch (Exception e) {
        }

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
    private void go2DashboardOnButtonClick(ActionEvent event) throws IOException {
        ChangeScene(event, "DashboardforPilot");
    }

}
