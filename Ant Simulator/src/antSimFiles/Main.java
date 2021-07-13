package antSimFiles;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application {
    Canvas c = new Canvas(1000,1000);
    GraphicsContext cCon = c.getGraphicsContext2D();
    boolean nextFrame = false;

    @Override
    public void start(Stage primaryStage) throws Exception{
        VBox root = new VBox();
        root.getChildren().add(c);
        ArrayList<Ant> ants = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            ants.add(new Ant(new Vector(500,500)));
        }
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1000, 1000, Color.WHITE));
        primaryStage.show();
        Timer myTimer = new Timer();
        myTimer.scheduleAtFixedRate(new TimerTask(){

            @Override
            public void run() {
                System.out.println("Tick");
                drawAnts(ants);
            }
        }, 0, 30);
    }

    public void drawAnts(List<Ant> ants){
        cCon.clearRect(0,0,c.getWidth(),c.getHeight());
        cCon.setFill(Color.RED);
        for(Ant ant:ants){
            cCon.fillRect(ant.getPos().x - 3,ant.getPos().y - 3,6,6);
            ant.move();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
