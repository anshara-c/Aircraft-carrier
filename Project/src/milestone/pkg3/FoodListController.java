
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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class FoodListController implements Initializable {

    @FXML
    private TableColumn<food, String> foodnameColumn;
    @FXML
    private TableColumn<food, Integer> quantityColumn;
    @FXML
    private TextField foodnameTxt;
    @FXML
    private TextField quantityTxt;
    @FXML
    private TableView<food> foodlistTableView;
    private ArrayList<food> FoodList = new ArrayList<food>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //set up the columns in the table
        foodnameColumn.setCellValueFactory(new PropertyValueFactory<food,String>("FoodName"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<food,Integer>("Quantity"));
        
        //load dummy data
     //   foodlistTableView.setItems(getAssigned());    
        
        //Allow first and last name to be edittable
        /*assignTable.setEditable(true);
        pname.setCellFactory(TextFieldTableCell.forTableColumn());
        mIndex.setCellFactory(TextFieldTableCell.forTableColumn());*/
        
        //allow the table to select multiple rows at once
       // foodlistTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }    

    @FXML
    private void ShowInTableOnButtonClick(ActionEvent event) {
         food f = new food(
                 foodnameTxt.getText(),
                 (Integer.parseInt(quantityTxt.getText())
                                               ));
        foodlistTableView.getItems().add(f);
        }
    

    @FXML
    private void SaveTotextFileonButtonClick(ActionEvent event) {
        
         FoodList.add(
            new food(  
                   foodnameTxt.getText(),
                   Integer.parseInt(quantityTxt.getText())
                )  
       );
          try {
                //write code to dump studArr in Stud.txt
                //use FileWriter
                FileWriter fw = new FileWriter("FoodList.txt");
                String str="";
                for(food s: FoodList){
                    str += s.getFoodName()+"   "+s.getQuantity()+"\n";
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
    private void gotodashboard(ActionEvent event) throws IOException {
        ChangeScene(event, "DashboardforCook");
    }

    
}
