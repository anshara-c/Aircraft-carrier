package milestone.pkg3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class PersonalInfoController implements Initializable {

    @FXML
    private TextField ufnameTxt;
    @FXML
    private TextField ulnameTxt;
    @FXML
    private TextField bgTxt;
    @FXML
    private Button saveinfobutton;
    @FXML
    private RadioButton noRadioButton;

    @FXML
    private TextField uphnTxt;
    @FXML
    private TextField uaddTxt;

    @FXML
    private CheckBox BloodPressurecheckbox;
    @FXML
    private CheckBox SleepParalysisCheckBox;
    @FXML
    private CheckBox FrequentCoughCheckBox;
    @FXML
    private CheckBox GastricCheckBox;

    @FXML
    private CheckBox SeaSicknessCheckBox;

    @FXML
    private TextField uHeightTxt;

    @FXML
    private TextField uWeighTxt;
    @FXML
    private RadioButton yesRadioButton1;
    @FXML
    private RadioButton noRadioButton1;
    @FXML
    private RadioButton yesRadioButton;
    @FXML
    private CheckBox ConstipationCheckBox;
    private ToggleGroup tg, tg1;
    @FXML
    private TextArea allergyTxtArea;
    @FXML
    private TextArea illnessTxtArea;
    @FXML
    private CheckBox dairyCheckBox;
    @FXML
    private CheckBox beefCheckBox;
    @FXML
    private CheckBox nutsCheckBox;
    @FXML
    private CheckBox shrimpCheckBox;
    @FXML
    private Button saveinfobutton1;
    private ArrayList<UserPersonalInfo> upiList = new ArrayList<UserPersonalInfo>();

    //private ArrayList<pilot> PilotArr = new ArrayList<pilot>();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tg = new ToggleGroup();
        noRadioButton.setToggleGroup(tg);
        yesRadioButton.setToggleGroup(tg);

        tg1 = new ToggleGroup();
        noRadioButton1.setToggleGroup(tg1);
        yesRadioButton1.setToggleGroup(tg1);

        //noRadioButton.setSelected(true);
        noRadioButton1.setSelected(true);

    }

    @FXML
    private void saveinfobuttonOnButtonClick(ActionEvent event) {
        File f = new File("PersonalInformation.bin");
        ObjectOutputStream oos = null;
        try {
            if (f.exists()) {
                oos = new AppendableObjectOutputStream(new FileOutputStream(f, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(f, true));
            }
            for (UserPersonalInfo upi : upiList) {
                oos.writeObject(upi);
            }

            oos.close();
        } catch (Exception e) {
        }

        /* File f = null;
         FileOutputStream fos = null;      
         ObjectOutputStream oos = null;
        
        try {
            f = new File("PersonalInfo.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            UserPersonalInfo person = new UserPersonalInfo (  
                  
                    ufnameTxt.getText(),
                    ulnameTxt.getText(),
                    bgTxt.getText(),
                    uphnTxt.getText(),
                    uaddTxt.getText(),
                    uHeightTxt.getText(),
                    Integer.parseInt(uWeighTxt.getText()),
                    allergyTxtArea.getText(),
                    illnessTxtArea.getText()
           );
            oos.writeObject(person);
            person.display();
        } catch (IOException ex) {
            Logger.getLogger(MissionListController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(PersonalInfoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                
          /* UserPersonalInfo person = new UserPersonalInfo (  
                  
                    ufnameTxt.getText(),
                    ulnameTxt.getText(),
                    bgTxt.getText(),
                    uphnTxt.getText(),
                    uaddTxt.getText(),
                    uHeightTxt.getText(),
                    Integer.parseInt(uWeighTxt.getText()),
                    allergyTxtArea.getText(),
                    illnessTxtArea.getText()
           );
          
                  
                
        //idTxt.setText(null);    nameTxt.setText(null);  cgpaTxt.setText(null);  deptTxt.setText(null);
       person.display();
        File f = new File("PersonalInfo.bin");
        ObjectOutputStream oos=null;
        try {
            if(f.exists())
                oos = new AppendableObjectOutputStream(new FileOutputStream(f,true));
            else
                oos = new ObjectOutputStream(new FileOutputStream(f,true));
            //ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Stud.bin"));
            oos.writeObject(person);
            oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }*/
    }

    @FXML
    private void allergyOnButtonClick1(ActionEvent event) {

        if (noRadioButton1.isSelected()) {
            allergyTxtArea.setText("No Allergies");
        } else if (yesRadioButton1.isSelected()) {
            String str1 = "";
            if (shrimpCheckBox.isSelected()) {
                str1 += "Shrimp " + "\n";
            }
            if (nutsCheckBox.isSelected()) {
                str1 += "Nuts " + "\n";
            }
            if (dairyCheckBox.isSelected()) {
                str1 += "Dairy " + "\n";
            }
            if (beefCheckBox.isSelected()) {
                str1 += "Beef " + "\n";
            }
            allergyTxtArea.setText(str1);
        }
    }

    @FXML
    private void illnessOnButtonClick(ActionEvent event) {
        if (noRadioButton1.isSelected()) {
            allergyTxtArea.setText("No Illness");
        } else if (yesRadioButton1.isSelected()) {
            String str2 = "";
            if (BloodPressurecheckbox.isSelected()) {
                str2 += "BloodPressure " + "\n";
            }
            if (SleepParalysisCheckBox.isSelected()) {
                str2 += "SleepParalysis " + "\n";
            }
            if (FrequentCoughCheckBox.isSelected()) {
                str2 += "FrequentCough " + "\n";
            }
            if (GastricCheckBox.isSelected()) {
                str2 += "Gastric " + "\n";
            }
            if (ConstipationCheckBox.isSelected()) {
                str2 += "Constipatition " + "\n";
            }
            if (SeaSicknessCheckBox.isSelected()) {
                str2 += "SeaSickness " + "\n";
            }
            illnessTxtArea.setText(str2);
        }

    }

    @FXML
    private void add2ArraybuttonOnButtonClick(ActionEvent event) {
        upiList.add(
                new UserPersonalInfo(
                        ufnameTxt.getText(),
                        ulnameTxt.getText(),
                        bgTxt.getText(),
                        uphnTxt.getText(),
                        uaddTxt.getText(),
                        uHeightTxt.getText(),
                        Integer.parseInt(uWeighTxt.getText()),
                        allergyTxtArea.getText(),
                        illnessTxtArea.getText()
                ));

    }

    @FXML
    private void gotodashboard(ActionEvent event) {
    }

}

// showCustomInformationAlert("File is saved");
// else{
// showCustomInformationAlert("The task is cancelled!"); 
// }

/* private void go2dashboardOnButtonClick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("MissionList.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        //stage.setScene(scene2);
        //Stage s2 = new Stage(); s2.setScene(scene2);  s2.show();
               
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene2);
        window.show();
        
   /* }*/
 /* private void showCustomInformationAlert(String str) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(str);
        a.showAndWait();         
    }   */
