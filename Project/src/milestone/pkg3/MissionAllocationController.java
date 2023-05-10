package milestone.pkg3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import milestone.pkg3.AppendableObjectOutputStream;
public class MissionAllocationController implements Initializable {

    @FXML
    private TableView<missionAssignment> assignTable;
    @FXML
    private Button addPI;
    @FXML
    private TextField pilotIndex;
    @FXML
    private TextField missionIndex;
    @FXML
    private TableColumn<missionAssignment, String> pname;
    @FXML
    private TableColumn<missionAssignment, Integer> mIndex;
    @FXML
    private Button displaypilotbutton;
    @FXML
    private TextArea pilotViewArea;
    @FXML
    private Button saveAllocation;
    private ArrayList<missionAssignment> mList = new ArrayList<missionAssignment>();
    @FXML
    private Button saveaList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //set up the columns in the table
        pname.setCellValueFactory(new PropertyValueFactory<missionAssignment, String>("name"));
        mIndex.setCellValueFactory(new PropertyValueFactory<missionAssignment, Integer>("missionIndex"));

        //load dummy data
        assignTable.setItems(getAssigned());

        //Allow first and last name to be edittable
        /*assignTable.setEditable(true);
        pname.setCellFactory(TextFieldTableCell.forTableColumn());
        mIndex.setCellFactory(TextFieldTableCell.forTableColumn());*/
        //allow the table to select multiple rows at once
        assignTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    public ObservableList<missionAssignment> getAssigned() {
        ObservableList<missionAssignment> assignment = FXCollections.observableArrayList();
        assignment.add(new missionAssignment("roger", 1));
        assignment.add(new missionAssignment("paul", 2));
        assignment.add(new missionAssignment("helen", 3));
        return assignment;
    }

    @FXML
    private void addPIOnButtonClicked(ActionEvent event) {
        missionAssignment newAssignment = new missionAssignment(pilotIndex.getText(),
                (Integer.parseInt(missionIndex.getText())));
        assignTable.getItems().add(newAssignment);
    }

    @FXML
    private void displayPilotButtonClicked(ActionEvent event) {
        ObjectInputStream ois = null;
        try {
            pilot p;
            //FileInputStream fis = new FileInputStream("stud2.bin");
            //ois = new ObjectInputStream(fis);
            ois = new ObjectInputStream(new FileInputStream("Pilot.bin"));

            pilotViewArea.setText(null);

            //int[] arr={1,2,3};
            //System.out.println(arr[3]);
            while (true) {
                p = (pilot) ois.readObject();
                //studArr.add((Student) ois.readObject());
                pilotViewArea.appendText(p.toString() + "\n");
                //outputTxtArea.appendText(s+"\n");
            }
            //ois.close();

        } catch (Exception ex) {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex1) {
            }
        }
    }

    @FXML
    private void saveAllocationButtonOnClick(ActionEvent event) {

        File f = new File("missionAllocationList.bin");
        ObjectOutputStream oos = null;
        try {
            if (f.exists()) {
                oos = new AppendableObjectOutputStream(new FileOutputStream(f, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(f, true));
            }
            for (missionAssignment mA : mList) {
                oos.writeObject(mA);
            }

            oos.close();
        } catch (Exception e) {
        }

    }

    @FXML
    private void saveAListOnButtonClicked(ActionEvent event) {
        mList.add(
                new missionAssignment(
                        pilotIndex.getText(),
                        Integer.parseInt(missionIndex.getText())
                )
        );
    }
//-------------------------------------------------------//
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
    private void GotoDashBoard(ActionEvent event) throws IOException {
        ChangeScene(event, "DashboardforCommandingOfficer");
    }

}
