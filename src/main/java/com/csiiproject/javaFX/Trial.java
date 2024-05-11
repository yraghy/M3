package com.csiiproject.javaFX;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Trial extends Application {

    @Override
    public void start(Stage stage) throws IOException{
        GridPane root = new GridPane();
        Label l1 = new Label("Hello!");
        GridPane.setHalignment(l1, HPos.RIGHT);
        Scene scene = new Scene(root,1000,800);
        stage.setScene(scene);
        stage.setTitle("Trial");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
