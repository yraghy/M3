package com.csiiproject.javaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class popUps extends Application {

    public void start(Stage window){
        Button b1 = new Button("Click me ;)");
        StackPane layout = new StackPane();
        layout.getChildren().add(b1);
        Scene scene = new Scene(layout,1000,650);

    }

    public static void display(){

    }

    public static void main(String[] args) {
        launch(args);
    }
}
