package com.csiiproject.javaFX;
import game.engine.Battle;
import game.engine.base.Wall;
import game.engine.exceptions.InsufficientResourcesException;
import game.engine.exceptions.InvalidLaneException;
import game.engine.lanes.Lane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import com.csiiproject.javaFX.Main;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import com.csiiproject.javaFX.easyController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class hardController {

    Battle hardGame;


    public void buy(ActionEvent e) throws Exception {AlertBox.weaponShop("weapon shop");}

    public void passTurn(ActionEvent e) throws IOException {hardGame.passTurn();}

    public void loseTrial(ActionEvent e) throws IOException{AlertBox.gameOver("Game Over");}

    public void mainMenuReturn(ActionEvent e) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("CleanStart.fxml"));
        Scene mainMenuScene = new Scene(root);
        Stage window = (Stage)((javafx.scene.Node)e.getSource()).getScene().getWindow();
        window.setScene(mainMenuScene);
        window.show();
    }


}
