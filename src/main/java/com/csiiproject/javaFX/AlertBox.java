package com.csiiproject.javaFX;

import game.engine.lanes.Lane;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;

public class AlertBox {

//    public static void display(String title, String message){
//        Stage box = new Stage();
//
//        //Blocks user interaction with other windows until issue is resolved
//        box.initModality(Modality.APPLICATION_MODAL);
//        box.setTitle(title);
//        box.setWidth(250);
//
//        Label l1 = new Label(message);
//        Button b1 = new Button("Close window");
//        b1.setOnAction(e -> box.close());
//
//        VBox lout = new VBox(10);
//        lout.getChildren().addAll(l1,b1);
//        lout.setAlignment(Pos.CENTER);
//
//        Scene scene = new Scene(lout);
//        box.setScene(scene);
//        box.showAndWait();
//    }




    public static void weaponShop(String title) {
    Stage box = new Stage();
    box.initModality(Modality.APPLICATION_MODAL);

    try {
        // Use a relative path to the FXML file
        FXMLLoader loader = new FXMLLoader(AlertBox.class.getResource("/com/csiiproject/javaFX/WeaponShop.fxml"));
        Parent root = loader.load();

        box.setTitle(title);
        box.setWidth(1052);
        box.setHeight(635);

        Scene scene = new Scene(root);
        box.setScene(scene);
        box.setResizable(false);
        box.setFullScreen(false);

        // Get the controller instance if needed
        Controller controller = loader.getController();
        if (controller != null) {
            // Do something with the controller
        }

        box.showAndWait();
    } catch (IOException e) {
        System.err.println("Failed to load WeaponShop.fxml: " + e.getMessage());
        e.printStackTrace();
    }
}

    public static void weaponShop2(String title) {
        Stage box = new Stage();
        box.initModality(Modality.APPLICATION_MODAL);

        try {
            // Use a relative path to the FXML file
            FXMLLoader loader = new FXMLLoader(AlertBox.class.getResource("/com/csiiproject/javaFX/WeaponShop.fxml"));
            Parent root = loader.load();

            box.setTitle(title);
            box.setWidth(1052);
            box.setHeight(635);

            Scene scene = new Scene(root);
            box.setScene(scene);
            box.setResizable(false);
            box.setFullScreen(false);

            // Get the controller instance if needed
            Controller controller = loader.getController();
            if (controller != null) {
                // Do something with the controller
            }

            box.showAndWait();
        } catch (IOException e) {
            System.err.println("Failed to load WeaponShop.fxml: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void weaponShop3(String title) {
        Stage box = new Stage();
        box.initModality(Modality.APPLICATION_MODAL);

        try {
            // Use a relative path to the FXML file
            FXMLLoader loader = new FXMLLoader(AlertBox.class.getResource("/com/csiiproject/javaFX/WeaponShop.fxml"));
            Parent root = loader.load();

            box.setTitle(title);
            box.setWidth(1052);
            box.setHeight(635);

            Scene scene = new Scene(root);
            box.setScene(scene);
            box.setResizable(false);
            box.setFullScreen(false);

            // Get the controller instance if needed
            Controller controller = loader.getController();
            if (controller != null) {
                // Do something with the controller
            }

            box.showAndWait();
        } catch (IOException e) {
            System.err.println("Failed to load WeaponShop.fxml: " + e.getMessage());
            e.printStackTrace();
        }
    }



    public static void gameOver(String title) throws IOException{
        Stage box = new Stage();
        URL url = AlertBox.class.getResource("GameOver.fxml");
        if (url == null) {
        throw new RuntimeException("Resource GameOver.fxml not found");
        }
         Parent root = FXMLLoader.load(url);        //Blocks user interaction with other windows until issue is resolved
        box.initModality(Modality.APPLICATION_MODAL);
        box.setTitle(title);
        box.setTitle(title);
        Scene scene = new Scene(root);
        URL cssUrl = AlertBox.class.getResource("gameOver.css");
        if (cssUrl == null) {
            throw new RuntimeException("Resource gameOver.css not found");
        }
        String loseCss = cssUrl.toExternalForm();
        scene.getStylesheets().add(loseCss);
        box.setScene(scene);
        box.setResizable(false);
        box.setFullScreen(false);
        box.showAndWait();
    }

}
