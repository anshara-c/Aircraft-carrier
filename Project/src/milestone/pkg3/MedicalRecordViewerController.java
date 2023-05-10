
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class MedicalRecordViewerController implements Initializable {

    /*private TableView<UserPersonalInfo> medrecTableView;
    private TableColumn<UserPersonalInfo, String> fnameColumn;
    private TableColumn<UserPersonalInfo, String> lnameColumn;
    private TableColumn<UserPersonalInfo, String> bgColumn;
    
    private TableColumn<UserPersonalInfo, Integer> weightColumn;
   
    private TableColumn<UserPersonalInfo,String> phoneColumn;
    private TableColumn<UserPersonalInfo,String> addressColumn;
    private TableColumn<UserPersonalInfo,String> heightColumn1;
    private TableColumn<UserPersonalInfo,String> allergyColumn;
    private TableColumn<UserPersonalInfo,String> sicknessColumn;*/
    @FXML
    private TextArea medrecTxtArea;
    @FXML
    private TextField flname;
    @FXML
    private TextField medTxt;
    private ArrayList<Medicine> MList= new ArrayList<Medicine>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       /* fnameColumn.setCellValueFactory(new PropertyValueFactory<UserPersonalInfo, String>("name"));
        lnameColumn.setCellValueFactory(new PropertyValueFactory<UserPersonalInfo, String>("lastname"));
        bgColumn.setCellValueFactory(new PropertyValueFactory<UserPersonalInfo, String>("bloodgroup"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<UserPersonalInfo, String>("phone"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<UserPersonalInfo, String>("address"));
        heightColumn1.setCellValueFactory(new PropertyValueFactory<UserPersonalInfo, String>("height"));
        weightColumn.setCellValueFactory(new PropertyValueFactory<UserPersonalInfo, Integer>("weight"));
        allergyColumn.setCellValueFactory(new PropertyValueFactory<UserPersonalInfo, String>("Allergy"));
        sicknessColumn.setCellValueFactory(new PropertyValueFactory<UserPersonalInfo, String>("Sickness"));*/
        
       
    }    
     
    @FXML
    private void showMedicaRecodOnButtonClick(ActionEvent event) {
        
        ObjectInputStream ois=null;
         try {
             UserPersonalInfo p;
             //FileInputStream fis = new FileInputStream("stud2.bin");
             //ois = new ObjectInputStream(fis);
             ois = new ObjectInputStream(new FileInputStream("PersonalInformation.bin"));
             
            medrecTxtArea.setText(null);
            
            //int[] arr={1,2,3};
            //System.out.println(arr[3]);
            while(true){
                p= (UserPersonalInfo) ois.readObject();
                //studArr.add((Student) ois.readObject());
                medrecTxtArea.appendText(p.toString()+"\n");
                //outputTxtArea.appendText(s+"\n");
            }
            //ois.close();
                       
        } catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }
        
        
    }
       /* medrecTxtArea.setText("");
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("PersonalInfo.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            UserPersonalInfo person;
            try{
                medrecTxtArea.setText("");
                while(true){
                    System.out.println("Printing objects.");
                    person = (UserPersonalInfo)ois.readObject();
              
                    System.out.println("HashCode="+person.toString());
                    medrecTxtArea.appendText(person.toString());
                }
            }//end of nested try
            catch(Exception e){

            }//nested catch     
           medrecTxtArea.appendText("ALL records SUCCESSFULLY SHOWN...\n");            
        } catch (IOException ex) { } 
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }               
      
    }*/

    @FXML
    private void addMedOnButtonclick(ActionEvent event) {
        
        MList.add(
            new Medicine(  
                   flname.getText(),
                    medTxt.getText()
            ));
    }

    @FXML
    private void saveOnButtonClick(ActionEvent event) {
       try {
                //write code to dump studArr in Stud.txt
                //use FileWriter
                FileWriter fw = new FileWriter("MedicineList.txt");
                String str="";
                for(Medicine s: MList){
                    str += s.getFlName()+", "+s.getMedicine()+"\n";
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
    private void GTD(ActionEvent event) throws IOException {
        ChangeScene(event, "DashboardforDoctor");
    }
}
