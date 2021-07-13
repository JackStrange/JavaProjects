package antSimFiles;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main extends Application {
    private Canvas c = new Canvas(1000,1000);
    private GraphicsContext cCon = c.getGraphicsContext2D();
    private boolean nextFrame = false;
    public static ArrayList<Pheremone> pheremones = new ArrayList<>();
    public static ArrayList<Ant> ants = new ArrayList<>();
    public static ArrayList<Food> foods = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception{
        VBox root = new VBox();
        root.getChildren().add(c);
        for (int i = 0; i < 500; i++) {
            ants.add(new Ant(new Vector(500,500)));
        }
        for(int i = 0; i < 5; i++){
            Random rn = new Random();
            Vector randomPos = new Vector(rn.nextInt(1000),rn.nextInt(1000));
            for(int j = 0; j < 100; j++){
                Vector randomPosAdjust = new Vector(rn.nextInt(40)-20,rn.nextInt(40)-20);
                foods.add(new Food(randomPos.add(randomPosAdjust)));
            }
        }
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1000, 1000, Color.BLACK));
        primaryStage.show();
        Timeline fiveSecondsWonder = new Timeline(
                new KeyFrame(Duration.millis(30),
                        event -> {
                            cCon.clearRect(0,0,c.getWidth(),c.getHeight());
                            drawPheremones();
                            drawAnts(ants);
                            drawFood();
                        }));
        fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
        fiveSecondsWonder.play();
    }

    public void drawAnts(List<Ant> ants){
        for(Ant ant:ants){
            cCon.setFill(Color.GREEN);
            cCon.fillRect(ant.getPos().x - 3,ant.getPos().y - 3,6,6);
            if(ant.isFood()){
                cCon.setFill(Color.LIGHTGREEN);
                cCon.fillOval(ant.getPos().x-3,ant.getPos().y-3,6,6);
            }
            ant.move();
        }
    }

    public void drawPheremones(){
        ArrayList<Pheremone> pheremonesCopy = new ArrayList<>();
        for(Pheremone pheremone:pheremones){
            pheremone.update();
            if(pheremone.getStrength() > 0){
                pheremonesCopy.add(pheremone);
            }
            double colStrength = (double)(1/pheremone.lifespan*pheremone.getStrength());
            switch(pheremone.getType()){
                case TOFOOD: cCon.setFill(Color.rgb(255,0,0,colStrength));
                case TOHOME: cCon.setFill(Color.rgb(0,0,255,colStrength));
            }
            cCon.fillRect(pheremone.getPos().x,pheremone.getPos().y,1,1);
        }
        System.out.println("Dealt with pheremones");
        pheremones = pheremonesCopy;
    }

    public void drawFood(){
        ArrayList<Pheremone> pheremonesCopy = new ArrayList<>();
        for(Food food:foods){
            cCon.setFill(Color.LIGHTGREEN);
            cCon.fillOval(food.getPos().x-3,food.getPos().y-3,6,6);
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
