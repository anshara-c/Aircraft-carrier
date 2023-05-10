/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milestone.pkg3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class MissionListController implements Initializable {

    @FXML
    private Button mfile;
    @FXML
    private ComboBox<String> pType;
    @FXML
    private Label pTypeL;
    @FXML
    private DatePicker mDate;
    @FXML
    private TextArea mArea;
    @FXML
    private Label pTypeL1;
    @FXML
    private Button ShowArrayButton;
    @FXML
    private TextField indexTxt;
    @FXML
    private Label missionType;
    @FXML
    private TextArea showMission;
    private ArrayList<Mission> mList = new ArrayList<Mission>();

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        pType.getItems().add("Fighter");
        pType.getItems().addAll("Scout", "Emergency", "Maintanence");
        pType.setValue("Emergency");
        pTypeL.setText("Selected type of pilot is: Emergency");
    }

    @FXML
    private void SaveOnMouseClicked(ActionEvent event) {

        File f = new File("MissionList.bin");
        ObjectOutputStream oos = null;
        try {
            if (f.exists()) {
                oos = new AppendableObjectOutputStream(new FileOutputStream(f, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(f, true));
            }
            for (Mission mis : mList) {
                oos.writeObject(mis);
            }

            oos.close();
        } catch (Exception e) {
        }

    }

    @FXML
    private void missionTypeOnButtonClick(ActionEvent event) {
        missionType.setText(pType.getValue().toString());
    }

    @FXML
    private void MissionOnMouseClicked(MouseEvent event) {

        mArea.setText(null);
    }

    @FXML
    private void ShowArrayOnMouseClicked(ActionEvent event) {
        ObjectInputStream ois = null;
        try {
            Mission m;
            //FileInputStream fis = new FileInputStream("stud2.bin");
            //ois = new ObjectInputStream(fis);
            ois = new ObjectInputStream(new FileInputStream("MissionList.bin"));

            showMission.setText(null);

            //int[] arr={1,2,3};
            //System.out.println(arr[3]);
            while (true) {
                m = (Mission) ois.readObject();
                //studArr.add((Student) ois.readObject());
                showMission.appendText(m.toString() + "\n");
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
    private void indexOnMouseClicked(MouseEvent event) {
        indexTxt.setText(null);
    }

    @FXML
    private void addMissionOnButtonclick(ActionEvent event) {
        mList.add(
                new Mission(
                        Integer.parseInt(indexTxt.getText()),
                        mArea.getText(),
                        pType.getValue(),
                        mDate.getValue()
                ));
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
//-------------------------------------------------------//

    @FXML
    private void goToDashBoard(ActionEvent event) throws IOException {
        ChangeScene(event, "DashboardforCommandingOfficer");
    }

}
