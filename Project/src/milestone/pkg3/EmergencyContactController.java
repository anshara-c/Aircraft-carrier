
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


public class EmergencyContactController implements Initializable {

    @FXML
    private Button save2Filebutton;
    @FXML
    private TextField fnameTxt;
    @FXML
    private TextField lnameTxt;
    @FXML
    private TextField addTxt;
    @FXML
    private TextField phnTxt;
    @FXML
    private ComboBox<String> relationshipComboBox;
     private ArrayList<Person> PersonArr = new ArrayList<Person>();

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
        relationshipComboBox.getItems().add("Sister");
         relationshipComboBox.getItems().add("Brother");
         relationshipComboBox.getItems().add("Mother");
         relationshipComboBox.getItems().add("Father");
         relationshipComboBox.getItems().add("Uncle");
         relationshipComboBox.getItems().add("Aunt");
        relationshipComboBox.setValue("Father");  
    }    

    @FXML
    private void SaveToFileOnButtonClick(ActionEvent event) {
        PersonArr.add(
            new Person(  
                   relationshipComboBox.getValue(),
                    fnameTxt.getText(),
                    lnameTxt.getText(),
                    phnTxt.getText(),
                    addTxt.getText())
                     );
        File f = new File("EmergencyInfo.bin");
        ObjectOutputStream oos=null;
        try {
            if(f.exists())
                oos = new AppendableObjectOutputStream(new FileOutputStream(f,true));
            else
                oos = new ObjectOutputStream(new FileOutputStream(f,true));
                for(Person p: PersonArr){
                    oos.writeObject(p);}
                
                oos.close();
            }
            catch(Exception e){}
        
            }

    @FXML
    private void GTD(ActionEvent event) throws IOException {
        ChangeScene(event, "DashboardforPilot");
    }

    }

