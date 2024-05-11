package com.csiiproject.javaFX;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

    public static void display(String title, String message){
        Stage box = new Stage();

        //Blocks user interaction with other windows until issue is resolved
        box.initModality(Modality.APPLICATION_MODAL);
        box.setTitle(title);
        box.setWidth(250);

        Label l1 = new Label(message);
        Button b1 = new Button("Close window");
        b1.setOnAction(e -> box.close());

        VBox lout = new VBox(10);
        lout.getChildren().addAll(l1,b1);
        lout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(lout);
        box.setScene(scene);
        box.showAndWait();
    }
}
