package com.csiiproject.javaFX;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import com.csiiproject.javaFX.Main;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
//    public void alert(ActionEvent e){AlertBox.display("Pop Up", "skill issue");}
//    public void alert2(ActionEvent e){AlertBox.display("lol", "Get good");}

    public void switchEasy(ActionEvent e) throws IOException{
        Parent rootE = FXMLLoader.load(getClass().getResource("Easy.fxml"));
        Scene easyScene = new Scene(rootE);
        Stage window = (Stage)((javafx.scene.Node)e.getSource()).getScene().getWindow();
        window.setScene(easyScene);
        window.show();
    }

    public void switchHard(ActionEvent e) throws IOException{
        Parent rootH = FXMLLoader.load(getClass().getResource("Hard.fxml"));
        Scene hardScene = new Scene(rootH);
        Stage window = (Stage)((javafx.scene.Node)e.getSource()).getScene().getWindow();
        window.setScene(hardScene);
        window.show();
    }
}
