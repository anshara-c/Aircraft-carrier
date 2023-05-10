package milestone.pkg3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SendAllergyListController implements Initializable {

    @FXML
    private TextField iNameTxt;
    @FXML
    private TextField fA1;
    @FXML
    private TextField fA2;
    @FXML
    private TextField fA3;
    @FXML
    private TextField fA4;
    @FXML
    private TextField noFoodTxt;
    private ArrayList<AllergyList> aList = new ArrayList<AllergyList>();

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
        

    }



    @FXML
    private void savetoFileOnButtonClick(ActionEvent event) {
        
        
        //HU.display();
       
            try {
                //write code to dump studArr in Stud.txt
                //use FileWriter
                FileWriter fw = new FileWriter("AllergyList.txt");
                String str="";
                for(AllergyList s: aList){
                    str += "Name: " + s.getiName() + "\n" + "Allergies: " + s.getA1() + ", "
                        + s.getA2() + ", " + s.getA3() + ", " + s.getA4() + "\n Food(s) you should not give:" + s.getNoFood() + "\n";
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
    private void iNameOnMouseClick(MouseEvent event) {
iNameTxt.setText(null);
        
    }

    @FXML
    private void fA1OnMouseClick(MouseEvent event) {fA1.setText(null);
        
    }

    @FXML
    private void fA2OnMouseClick(MouseEvent event) {fA2.setText(null);
      
    }

    @FXML
    private void fA3OnMouseClick(MouseEvent event) {  fA3.setText(null);
       
    }

    @FXML
    private void fA4OnMouseClick(MouseEvent event) { fA4.setText(null);
     
    }

    @FXML
    private void NFOnMouseClick(MouseEvent event) {   noFoodTxt.setText(null);
    }

    @FXML
    private void GTD(ActionEvent event) throws IOException {
        ChangeScene(event, "DashboardforDoctor");
    }

    @FXML
    private void Addtolist(ActionEvent event) {
      
        aList.add(new AllergyList(
                iNameTxt.getText(),
                fA1.getText(),
                fA2.getText(),
                fA3.getText(),
                fA4.getText(),
                noFoodTxt.getText()
        ));
        
    }

}
