package com.mycompany.simplejavafx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Circle face = new Circle(125,125,80);
        face.setFill(Color.YELLOW);
        face.setStroke(Color.GREEN);
        
        Circle rightEye=new Circle(86,100,10);
        rightEye.setFill(Color.WHITE);
        rightEye.setStroke(Color.BISQUE);
        
        Circle leftEye=new Circle(162,100,10);
        leftEye.setFill(Color.WHITE);
        leftEye.setStroke(Color.BISQUE);
        
        Arc mouth = new Arc(125,150,45,35,0,-180);
        mouth.setFill(Color.WHITE);
        mouth.setStroke(Color.BLUE);
        mouth.setType(ArcType.OPEN);
        
        Group root=new Group(face,rightEye,leftEye,mouth);
        Scene scene=new Scene(root,250,275,Color.YELLOW);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}