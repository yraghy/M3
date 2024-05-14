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

public class easyController {

    Battle easyGame = startController.easyGame;

    public void buy(ActionEvent e) throws IOException {AlertBox.weaponShop("weapon shop");}

    public void passTurn(ActionEvent e) throws IOException {easyGame.passTurn();}

//        public void getLane() {
//        lane1buy.setOnAction(e -> handleButtonPress(1));
//        lane2buy.setOnAction(e -> handleButtonPress(2));
//        lane3buy.setOnAction(e -> handleButtonPress(3));
//    }
//
//    Scene root = startController.easyScene;
//    Button C1buy = (Button)(root.lookup("#bBuy1"));
//    Button C2buy = (Button)(root.lookup("#bBuy2"));
//    Button C3buy = (Button)(root.lookup("#bBuy3"));
//    Button C4buy = (Button)(root.lookup("#bBuy4"));
//    GridPane lanes = (GridPane) root.lookup("#lanes");

//    root.getChildren().addAll(C1buy, C2buy, C3buy,C4buy);





//    public void getCode() {
//        C1buy.setOnAction(e -> handleButtonPress(1));
//        C2buy.setOnAction(e -> handleButtonPress(2));
//        C3buy.setOnAction(e -> handleButtonPress(3));
//        C4buy.setOnAction(e -> handleButtonPress(4));
//    }

//    public void buyWeapon(ActionEvent e) throws InsufficientResourcesException, InvalidLaneException, IOException {
//
//        easyGame.purchaseWeapon(getCode(), getLane());
//
//    }
}
