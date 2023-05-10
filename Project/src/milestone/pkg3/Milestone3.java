package milestone.pkg3;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Milestone3 extends Application {

    private double x, y;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));

        Scene scene = new Scene(root);

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                x = event.getSceneX();
                y = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //stage.setX(event.getSceneX() - x);
                //stage.setY(event.getSceneY() - y);

            }
        });
       // stage.setTitle("Main Stage");
        stage.initStyle(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
