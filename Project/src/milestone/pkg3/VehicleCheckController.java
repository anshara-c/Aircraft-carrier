package milestone.pkg3;

import java.io.FileWriter;
import java.io.IOException;
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
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class VehicleCheckController implements Initializable {

    @FXML
    private TextField vNameTxt;
    @FXML
    private TextField vNumberTxt;
    @FXML
    private RadioButton noRadioButton;
    @FXML
    private RadioButton yesRadioButton;
    private ArrayList<Vehicle> vList = new ArrayList<Vehicle>();
    private ArrayList<Problemreport> rList = new ArrayList<Problemreport>();
    private ToggleGroup t1;
    @FXML
    private TextArea reportTxtArea;
    @FXML
    private TextField EngfnmaeTxt;
    @FXML
    private TextField EmpIdTxt;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        t1 = new ToggleGroup();
        noRadioButton.setToggleGroup(t1);
        yesRadioButton.setToggleGroup(t1);

        yesRadioButton.setSelected(true);

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
    private void confirmarrayOnButtonClick(ActionEvent event) {
        if (yesRadioButton.isSelected()) {
            vList.add(new Vehicle(vNameTxt.getText(),
                    Integer.parseInt(vNumberTxt.getText())
            ));

        } else if (noRadioButton.isSelected()) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Warning Alert");
            a.setContentText("Send an alert to the commmanding officer ASAP!");
            a.setHeaderText(null);
            a.showAndWait();
        }

    }

    @FXML
    private void emaiOnButtonClick(ActionEvent event) {
        rList.add(new Problemreport(reportTxtArea.getText(),
                EngfnmaeTxt.getText(),
                Integer.parseInt(EmpIdTxt.getText())
        ));

        try {
            //write code to dump studArr in Stud.txt
            //use FileWriter
            FileWriter fw = new FileWriter("MaintenanceReport.txt");
            String str = "";
            for (Problemreport s : rList) {
                str += s.getName() + "   " + s.getIndex() + "\n" + s.getText() + "\n";
                //str += s; 
                //if toString is overridden to return
                //return id+","+name+","+cgpa+"\n"
            }
            fw.write(str);
            fw.close();
        } catch (IOException ex) {
            //  Logger.getLogger(FXMLMainSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void GTD(ActionEvent event) throws IOException {
        ChangeScene(event, "DashboardforEngineer");
    }

}
