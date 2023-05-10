
package milestone.pkg3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class FileChooserController implements Initializable {

    @FXML
    private Label view;
    @FXML
    private TextArea report;
    private ArrayList<String> fileTypeList, fileTypeList2; 
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       fileTypeList = new ArrayList<String>();
        fileTypeList.add("*.txt");
        fileTypeList.add("*.doc");
        fileTypeList.add("*.docx");
        fileTypeList.add("*.TXT");
        fileTypeList.add("*.DOC");
        fileTypeList.add("*.DOCX");

        fileTypeList2 = new ArrayList<String>();
        fileTypeList2.add("*.*");
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
        ChangeScene(event, "DashboardforCommandingOfficer");
    }

    @FXML
    private void save(ActionEvent event) {
        
        try {
                FileWriter fw = new FileWriter("OverallReport.txt");
                String str="";
                str += report.getText();
                   
                
                fw.write(str);
                fw.close();
            } catch (IOException ex) {
             
            }
        
       /* FileChooser fc = new FileChooser();
        File f = fc.showSaveDialog(null);
        System.out.println("Edited Content will be written in: "+f.getAbsolutePath());*/
    }

    @FXML
    private void open1(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files", fileTypeList));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("All files", fileTypeList2));
        //File f2 = fc.showSaveDialog(null);
        File f = fc.showOpenDialog(null);
        if(f != null){
            try {
                Scanner sc = new Scanner(f);
                String str="";
                while(sc.hasNextLine()){
                    str+=sc.nextLine()+"\n";
                }
                view.setText(str);
            } catch (FileNotFoundException ex) {
                
            }
        }
   

    }

    @FXML
    private void openmany(ActionEvent event) {
         FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files", fileTypeList));
        List<File> files = fc.showOpenMultipleDialog(null);
        String str="";
        for(File f: files){
            if(f != null){
                try {
                    Scanner sc = new Scanner(f);
                    
                    while(sc.hasNextLine()){
                        str+=sc.nextLine()+"\n";
                    }
                    str+="\n";
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(FileChooserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        view.setText(str);
   
    }
    
}
