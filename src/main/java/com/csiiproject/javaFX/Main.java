package com.csiiproject.javaFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private ImageView backgroundImage;

    public void start(Stage window) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("altStart.fxml"));
        Scene scene = new Scene(root);
//        String css = this.getClass().getResource("main.css").toExternalForm();
//        scene.getStylesheets().add(css);
        window.setTitle("Attack On Titan: Utopia");
        window.setScene(scene);
//        window.setResizable(false);
//        window.setFullScreen(true);
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
