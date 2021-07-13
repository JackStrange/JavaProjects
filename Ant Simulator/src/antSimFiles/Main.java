package antSimFiles;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        VBox root = new VBox();
        Canvas c = new Canvas(1000,1000);
        GraphicsContext cCon = c.getGraphicsContext2D();
        root.getChildren().add(c);
        cCon.fillRect(10,10,20,20);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1000, 1000, Color.WHITE));
        primaryStage.show();
    }

    public void drawAnts(List<Ant> ants){

    }


    public static void main(String[] args) {
        launch(args);
    }
}
