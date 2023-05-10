
package milestone.pkg3;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ReportPieChartController implements Initializable {

    @FXML
    private PieChart piechart;
    @FXML
    private Label label;
  
    @FXML
    private TextField oil;
    @FXML
    private TextField oil1;
    @FXML
    private TextField oil11;
    @FXML
    private TextField oil111;
    @FXML
    private Label label1;
    @FXML
    private Label label11;
    @FXML
    private Label label111;
    @FXML
    private Label label2;
    
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
        // TODO
    }    

    @FXML
    private void GTD(ActionEvent event) throws IOException {
        ChangeScene(event, "DashboardforEngineer");
    }

    @FXML
    private void show(ActionEvent event) {
        ObservableList <PieChart.Data> list = FXCollections.observableArrayList(
            new PieChart.Data("Week 1",Integer.parseInt(oil.getText())),
            new PieChart.Data("Week 2",Integer.parseInt(oil1.getText())),
            new PieChart.Data("Week 3",Integer.parseInt(oil11.getText())),
            new PieChart.Data("Week 4",Integer.parseInt(oil111.getText()))
        );
        
        piechart.setData(list);
        
        for(PieChart.Data data: piechart.getData()){
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                   label2.setText(String.valueOf(data.getPieValue())+ "Litres");
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            }
            );
        }
    } 
}

    /* pList.add(new OilConsumption4Pc(Integer.parseInt(oil.getText())));
      
  }

        
        
         ObservableList <PieChart.Data> list = FXCollections.observableArrayList(pList);
            
        
        pieChart.setData(list);
        
        for(PieChart.Data data: pieChart.getData()){
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    statusLabel.setText(String.valueOf(data.getPieValue()));
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            }
            );*/
        
           

    