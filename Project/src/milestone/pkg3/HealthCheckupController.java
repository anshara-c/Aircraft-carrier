
package milestone.pkg3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class HealthCheckupController implements Initializable {

    @FXML
    private TextField personfnameTxt;
    @FXML
    private TextField personlnameTxt;
    @FXML
    private TableColumn<HealthUser, String> fnameColumn;
    @FXML
    private TableColumn<HealthUser, String> lnameColumn;
    @FXML
    private TableColumn<HealthUser, String> uTypeColumn;
    @FXML
    private TableColumn<HealthUser, String> GenderColumn;
    @FXML
    private TableColumn<HealthUser, String> TempColumn;
    @FXML
    private TableColumn<HealthUser, Integer> BpColumn;
    @FXML
    private TableColumn<HealthUser, String> PhysicalColumn;
    @FXML
    private ComboBox<String> injurySignComboBox;
    @FXML
    private ComboBox<String> selectedUserComboBox;
    @FXML
    private TextField TempTxt;
    @FXML
    private TextField BPTxt;
    @FXML
    private Label selectedUserLabel;
    @FXML
    private TableView<HealthUser> HealthTableView;
    @FXML
    private Label selectedGenderrLabel;
    @FXML
    private RadioButton isMale;
    @FXML
    private RadioButton isFenale;
    private ToggleGroup t1;
    
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        t1= new ToggleGroup();
        isMale.setToggleGroup(t1);
        isFenale.setToggleGroup(t1);
        
        isMale.setSelected(true);
  
        fnameColumn.setCellValueFactory(new PropertyValueFactory<HealthUser, String>("name"));
        lnameColumn.setCellValueFactory(new PropertyValueFactory<HealthUser, String>("lastname"));
        uTypeColumn.setCellValueFactory(new PropertyValueFactory<HealthUser, String>("User"));
        GenderColumn.setCellValueFactory(new PropertyValueFactory<HealthUser, String>("Gender"));
        TempColumn.setCellValueFactory(new PropertyValueFactory<HealthUser, String>("Temperature"));
        BpColumn.setCellValueFactory(new PropertyValueFactory<HealthUser, Integer>("BloodPressure"));
        PhysicalColumn.setCellValueFactory(new PropertyValueFactory<HealthUser, String>("PhysicalInjury"));
        
       
        selectedUserComboBox.getItems().addAll("Pilot", "Cook", "Engineer", "Commanding officer");
        injurySignComboBox.getItems().addAll("Yes", "No");
        selectedGenderrLabel.setText(null);
        selectedUserLabel.setText(null);
    }    

    @FXML
    private void selectUserOnButtonClick(ActionEvent event) {
         selectedUserLabel.setText(selectedUserComboBox.getValue());
    }

    @FXML
    private void showInTableOnButtonClick(ActionEvent event) {
        ObjectInputStream ois=null;
        ObservableList<HealthUser> UserList = FXCollections.observableArrayList();
         try {
            HealthUser s;
            ois = new ObjectInputStream(new FileInputStream("HealthFile.bin"));
            while(true){
                s = (HealthUser) ois.readObject();
                UserList.add(s);
            }
            //s.display();
            //tableView.getItems().add(s);
            //tableView.setItems(studList);
        } catch (Exception ex) {            
            try {
                HealthTableView.setItems(UserList);
                if(ois!=null)
                    ois.close();
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
            ex.printStackTrace();
        }        
    }

    @FXML
    private void saveInFileOnButtonClick(ActionEvent event) {
         HealthUser HU = new HealthUser( 
                    TempTxt.getText(),
                    Integer.parseInt(BPTxt.getText()),
                    selectedGenderrLabel.getText(),
                    selectedUserLabel.getText(),
                    injurySignComboBox.getValue(),
                    personfnameTxt.getText(),  
                    personlnameTxt.getText()
                );
        TempTxt.setText(null);    personfnameTxt.setText(null);  personlnameTxt.setText(null);  BPTxt.setText(null);
        HU.display();
        File f = new File("HealthFile.bin");
        ObjectOutputStream oos=null;
        try {
            if(f.exists())
                oos = new AppendableObjectOutputStream(new FileOutputStream(f,true));
            else
                oos = new ObjectOutputStream(new FileOutputStream(f,true));
            //ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Stud.bin"));
            oos.writeObject(HU);
            oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void RadioButtonOnClick(ActionEvent event) {
         if(isMale.isSelected()) selectedGenderrLabel.setText("Male");
        else if(isFenale.isSelected()) selectedGenderrLabel.setText("Female");
        
    }

    @FXML
    private void gTD(ActionEvent event) throws IOException {
        ChangeScene(event, "DashboardforDoctor");
    }
    
}
