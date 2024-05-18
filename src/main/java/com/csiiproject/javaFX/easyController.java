package com.csiiproject.javaFX;
import game.engine.Battle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class easyController {

    Battle easyGame = startController.easyGame;


    private final AtomicInteger selectedLaneNumber = new AtomicInteger();

    public easyController() throws IOException {
    }


    public void initialize() {
        assert lane1buy != null;
        lane1buy.setOnAction(e -> {
            try {
                buy(e);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        assert lane2buy != null;
        lane2buy.setOnAction(e -> {
            try {
                buy2(e);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        assert lane3buy != null;
        lane3buy.setOnAction(e -> {
            try {
                buy3(e);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
    }



    public Button bBuy1;
    public Button bBuy2;
    public Button bBuy3;
    public Button bBuy4;



    public void buy(ActionEvent e) throws Exception {
        SharedState sharedState = SharedState.getInstance();
        sharedState.setLaneNumber(1);  // To set the value
        AlertBox.weaponShop("weapon shop");
    }
    public void buy2(ActionEvent e) throws Exception {
        SharedState sharedState = SharedState.getInstance();
        sharedState.setLaneNumber(2);  // To set the value
        AlertBox.weaponShop("weapon shop");
    }
    public void buy3(ActionEvent e) throws Exception {
        SharedState sharedState = SharedState.getInstance();
        sharedState.setLaneNumber(3);  // To set the value
        AlertBox.weaponShop("weapon shop");
    }



        Controller controller = new Controller(easyGame);
    public void passTurn(ActionEvent e) throws IOException {
        easyGame.passTurn();
    }




    @FXML
    public Button lane1buy;
    @FXML
    public Button lane2buy;
    @FXML
    public Button lane3buy;




}
