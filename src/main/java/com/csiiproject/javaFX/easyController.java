package com.csiiproject.javaFX;

import game.engine.Battle;
import game.engine.lanes.Lane;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class easyController {
    Parent rootE;
    Battle easyGame;
    private Label eScore, eRes, eTurn, ePhase;
    private ProgressBar wallH1, wallH2, wallH3;
    private ArrayList<Lane> lanesList;
    private Lane lane1, lane2, lane3;
    private Label laneDanger1, laneDanger2, laneDanger3;
    PriorityQueue<Lane> lanes, lanesClone;
    Lane currentLane;

    public void startEasyGame(Parent rootE) throws IOException {
        this.rootE = rootE;
        easyGame = new Battle(1,0,9,3,250);
        initStats();
        initLanes();
        initWalls();
    }
    public void initStats(){
        eScore = (Label) rootE.lookup("#score");
        eRes = (Label) rootE.lookup("#resources");
        eTurn = (Label) rootE.lookup("#turn");
        ePhase = (Label) rootE.lookup("#phase");
        eScore.setText("Score: " + easyGame.getScore());
        eRes.setText("Resources: " + easyGame.getResourcesGathered());
        eTurn.setText("Turn: " + easyGame.getNumberOfTurns());
        ePhase.setText("Phase: " + easyGame.getBattlePhase());
    }
    public void initLanes(){
        lanesList = new ArrayList<>();
        lanesList.addAll(easyGame.getLanes());
        lane1 = lanesList.get(0);
        lane2 = lanesList.get(1);
        lane3 = lanesList.get(2);
        laneDanger1 = (Label) rootE.lookup("#eDangerLane1");
        laneDanger2 = (Label) rootE.lookup("#eDangerLane2");
        laneDanger3 = (Label) rootE.lookup("#eDangerLane3");
        laneDanger1.setText("Danger: " + lane1.getDangerLevel());
        laneDanger2.setText("Danger: " + lane2.getDangerLevel());
        laneDanger3.setText("Danger: " + lane3.getDangerLevel());
    }
    public void initWalls(){
        wallH1 = (ProgressBar) rootE.lookup("#eWallH1");
        wallH2 = (ProgressBar) rootE.lookup("#eWallH2");
        wallH3 = (ProgressBar) rootE.lookup("#eWallH3");
        wallH1.setProgress(1);
        wallH2.setProgress(1);
        wallH3.setProgress(1);
    }
    public void updateLabels() {
        eScore.setText("Score: " + easyGame.getScore());
        eRes.setText("Resources: " + easyGame.getResourcesGathered());
        eTurn.setText("Turn: " + easyGame.getNumberOfTurns());
        ePhase.setText("Phase: " + easyGame.getBattlePhase());
        laneDanger1.setText("Danger: " + lane1.getDangerLevel());
        laneDanger2.setText("Danger: " + lane2.getDangerLevel());
        laneDanger3.setText("Danger: " + lane3.getDangerLevel());
    }

    public void LaneSelect(ActionEvent e) {
        GridPane grid;
    }

    public void buy(ActionEvent e) throws IOException {
        AlertBox.weaponShop("weapon shop");
//        currentLane =
    }

    public void passTurn(ActionEvent e) throws IOException {
        easyGame.passTurn();
        updateLabels();
    }


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
