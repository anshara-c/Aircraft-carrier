
package milestone.pkg3;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class FoodConsumptionController implements Initializable {

    @FXML
    private TextField carb;
    @FXML
    private TextField fat;
    @FXML
    private TextField fiber;
    @FXML
    private TextField protein;
    @FXML
    private LineChart<String, Integer> graph;
    @FXML
    private TextField protein2;
    @FXML
    private TextField fats2;
    @FXML
    private TextField fiber2;
    @FXML
    private TextField carb2;
    @FXML
    private TextField protein3;
    @FXML
    private TextField carb3;
    @FXML
    private TextField fat3;
    @FXML
    private TextField fiber3;
    @FXML
    private TextField protein4;
    @FXML
    private TextField carb4;
    @FXML
    private TextField fat4;
    @FXML
    private TextField fiber4;
    @FXML
    private Label label;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
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
    private void showgraph(ActionEvent event) {
        graph.getData().clear();
        XYChart.Series<String,Integer> series1 = new XYChart.Series<String,Integer>();
        series1.getData().add(new XYChart.Data<String,Integer>("Jan",Integer.parseInt(protein.getText())));
        series1.getData().add(new XYChart.Data<String,Integer>("Feb",Integer.parseInt(fat.getText())));
        series1.getData().add(new XYChart.Data<String,Integer>("Mar",Integer.parseInt(carb.getText())));
        series1.getData().add(new XYChart.Data<String,Integer>("Apr",Integer.parseInt(fiber.getText())));
        series1.setName("Week 1");
        
       XYChart.Series<String,Integer> series2 = new XYChart.Series<String,Integer>();
        series2.getData().add(new XYChart.Data<String,Integer>("Jan",Integer.parseInt(protein2.getText())));
        series2.getData().add(new XYChart.Data<String,Integer>("Feb",Integer.parseInt(fats2.getText())));
        series2.getData().add(new XYChart.Data<String,Integer>("Mar",Integer.parseInt(carb2.getText())));
        series2.getData().add(new XYChart.Data<String,Integer>("Apr",Integer.parseInt(fiber2.getText())));
        series2.setName("Week 2");
        
        XYChart.Series<String,Integer> series3 = new XYChart.Series<String,Integer>();
        series3.getData().add(new XYChart.Data<String,Integer>("Jan",Integer.parseInt(protein3.getText())));
        series3.getData().add(new XYChart.Data<String,Integer>("Feb",Integer.parseInt(fat3.getText())));
        series3.getData().add(new XYChart.Data<String,Integer>("Mar",Integer.parseInt(carb3.getText())));
        series3.getData().add(new XYChart.Data<String,Integer>("Apr",Integer.parseInt(fiber3.getText())));
        series3.setName("Week 3");
        
         XYChart.Series<String,Integer> series4 = new XYChart.Series<String,Integer>();
        series3.getData().add(new XYChart.Data<String,Integer>("Jan",Integer.parseInt(protein4.getText())));
        series3.getData().add(new XYChart.Data<String,Integer>("Feb",Integer.parseInt(fat4.getText())));
        series3.getData().add(new XYChart.Data<String,Integer>("Mar",Integer.parseInt(carb4.getText())));
        series3.getData().add(new XYChart.Data<String,Integer>("Apr",Integer.parseInt(fiber4.getText())));
        series3.setName("Week 4");
        
       graph.getData().addAll(series1, series2, series3);
        
        for(XYChart.Data<String,Integer> data: series1.getData()){
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
                
                @Override
                public void handle(MouseEvent event) {
                   label.setText("X: "+String.valueOf(data.getXValue())+"\nY: "+String.valueOf(data.getYValue()));
                    Tooltip.install(data.getNode(),new Tooltip("X: "+String.valueOf(data.getXValue())+"\nY: "+String.valueOf(data.getYValue())));
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            }
            );
        }
        for(XYChart.Data<String,Integer> data: series2.getData()){
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    label.setText("X: "+String.valueOf(data.getXValue())+"\nY: "+String.valueOf(data.getYValue()));
                    Tooltip.install(data.getNode(),new Tooltip("X: "+String.valueOf(data.getXValue())+"\nY: "+String.valueOf(data.getYValue())));
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            }
            );
        }
        for(XYChart.Data<String,Integer> data: series3.getData()){
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    label.setText("X: "+String.valueOf(data.getXValue())+"\nY: "+String.valueOf(data.getYValue()));
                    Tooltip.install(data.getNode(),new Tooltip("X: "+String.valueOf(data.getXValue())+"\nY: "+String.valueOf(data.getYValue())));
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            }
            );
        }
    }
   
    
    
    @FXML
    private void save(ActionEvent event) {
    }

    @FXML
    private void GTD(ActionEvent event) throws IOException {
        ChangeScene(event, "DashboardforCook");
    }
}
