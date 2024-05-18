package com.csiiproject.javaFX;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class Main extends Application {

    private ImageView backgroundImage;

    public void start(Stage window) throws IOException {
        URL url = getClass().getResource("CleanStart.fxml");
        if (url == null) {
            throw new RuntimeException("Resource CleanStart.fxml not found");
        }
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        String css = Objects.requireNonNull(this.getClass().getResource("main.css")).toExternalForm();
        scene.getStylesheets().add(css); //adds css stylesheet to main menu scene
        window.setTitle("Attack On Titan: Utopia");
        window.setScene(scene);
        window.setResizable(false);
//        window.setFullScreen(true);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

