package com.csiiproject.javaFX;

import game.engine.Battle;
import game.engine.base.Wall;
import game.engine.lanes.Lane;
import game.engine.titans.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class easyController {
    //Static variables
    Parent rootE;
    Battle easyGame;
    @FXML
    static Pane titanSpawner1, titanSpawner2, titanSpawner3;
    private Label eScore, eRes, eTurn, ePhase;
    private ProgressBar wallH1, wallH2, wallH3;
    private ArrayList<Lane> lanesList;
    private Lane lane1, lane2, lane3;
    private Label laneDanger1, laneDanger2, laneDanger3;
    PriorityQueue<Lane> lanes, lanesClone;
    Lane currentLane;

    public void initEasy(Parent rootE) throws IOException {
        this.rootE = rootE;
        easyGame = new Battle(1,0,9,3,250);
        initStats();
        initLanes();
        initWalls();
        titanSpawner1 = (Pane) rootE.lookup("#titanSpawner1E");
        titanSpawner2 = (Pane) rootE.lookup("#titanSpawner2E");
        titanSpawner3 = (Pane) rootE.lookup("#titanSpawner3E");
    }

    //Initialization methods
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
        wallH1.setStyle("-fx-accent: #14ec14;");
        wallH2.setStyle("-fx-accent: #14ec14;");
        wallH3.setStyle("-fx-accent: #14ec14;");
    }
    public void initSpawn(){
        titanSpawner1 = (Pane) rootE.lookup("#titanSpawner1");
        titanSpawner2 = (Pane) rootE.lookup("#titanSpawner2");
        titanSpawner3 = (Pane) rootE.lookup("#titanSpawner3");
    }

    public void updateLabels() {
        eScore.setText("Score: " + easyGame.getScore());
        eRes.setText("Resources: " + easyGame.getResourcesGathered());
        eTurn.setText("Turn: " + easyGame.getNumberOfTurns());
        ePhase.setText("Phase: " + easyGame.getBattlePhase());
        laneDanger1.setText("Danger: " + lane1.getDangerLevel());
        laneDanger2.setText("Danger: " + lane2.getDangerLevel());
        laneDanger3.setText("Danger: " + lane3.getDangerLevel());
        double wall1 = (double) (lane1.getLaneWall().getCurrentHealth()) /lane1.getLaneWall().getBaseHealth();
        double wall2 = (double) (lane1.getLaneWall().getCurrentHealth()) /lane1.getLaneWall().getBaseHealth();
        double wall3 = (double) (lane1.getLaneWall().getCurrentHealth()) /lane1.getLaneWall().getBaseHealth();
        wallH1.setProgress(wall1);
        wallH2.setProgress(wall2);
        wallH3.setProgress(wall3);
    }

    public void passTurn(ActionEvent e) throws IOException {
        easyGame.passTurn();
        spawnTitans();
        updateLabels();
        if(easyGame.isGameOver()){
            switchLoss(e);
        }
    }

    public void switchLoss(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GameOver.fxml"));
        Parent rootL = loader.load();
        Scene lossScene = new Scene(rootL);
        lossScene.getStylesheets().add(this.getClass().getResource("GameOver.css").toExternalForm());
        Stage window = (Stage)((javafx.scene.Node)e.getSource()).getScene().getWindow();
        gameOverController gameOverController = loader.getController();
        int finalScore = easyGame.getScore();
        gameOverController.initLossScreen(rootL, finalScore);
        window.setScene(lossScene);
        window.show();
    }

    //Buy methods
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

    public void spawnTitans(){
        ArrayList<Lane> lanesAR = new ArrayList<Lane>(List.copyOf(easyGame.getLanes()));
        int len = lanesAR.size();
        int tCount = 0;
        for(int i=0; i<len; i++){
            Lane lane = lanesAR.get(i);
            PriorityQueue<Titan> titansPQ = lane.getTitans();
            for(Titan titan:titansPQ) {
                Circle spawn = new Circle();
                int height = titan.getHeightInMeters();
                int distance = titan.getDistance();
                if(titan instanceof PureTitan) {
                    spawn.setFill(Color.BEIGE);
                    spawn.setRadius(titan.getHeightInMeters());
                    spawn.setCenterX(870);
                    spawn.setCenterY(306);
//                    spawn.setTranslateX(distance * 20);
//                    spawn.setTranslateY(tCount * titan.getHeightInMeters() * 220);
//                    spawn.setLayoutX(870);
//                    spawn.setLayoutY(100);
                    spawn.toFront();
                    Label hBar = new Label("Health: " + titan.getCurrentHealth() +"%");
                    hBar.setTextFill(Color.GREEN);
                    hBar.setTranslateX(titan.getDistance() * 20);
                    hBar.setTranslateY(tCount * 220 + titan.getHeightInMeters() - 20);
                    hBar.toFront();
                    if (i == 0) {
                        titanSpawner1.getChildren().add(spawn);
                    } else if (i == 1) {
                        titanSpawner2.getChildren().add(spawn);
                    } else {
                        titanSpawner3.getChildren().add(spawn);
                    }
                }
                else if(titan instanceof AbnormalTitan) {
                    spawn.setFill(Color.ORANGE);
                    spawn.setRadius(titan.getHeightInMeters());
                    spawn.setTranslateX(distance * 20);
                    spawn.setTranslateY(tCount * titan.getHeightInMeters() * 220);
                    Label hBar = new Label("Health: " + titan.getCurrentHealth() +"%");
                    hBar.setTextFill(Color.GREEN);
                    hBar.setTranslateX(titan.getDistance() * 20);
                    hBar.setTranslateY(tCount * 220 + titan.getHeightInMeters() - 20);
                    if (i == 0) {
                        titanSpawner1.getChildren().add(spawn);
                    } else if (i == 1) {
                        titanSpawner2.getChildren().add(spawn);
                    } else {
                        titanSpawner3.getChildren().add(spawn);
                    }
                }
                else if(titan instanceof ArmoredTitan) {
                    spawn.setFill(Color.YELLOW);
                    spawn.setRadius(titan.getHeightInMeters());
                    spawn.setTranslateX(distance * 20);
                    spawn.setTranslateY(tCount * titan.getHeightInMeters() * 220);
                    Label hBar = new Label("Health: " + titan.getCurrentHealth() +"%");
                    hBar.setTextFill(Color.GREEN);
                    hBar.setTranslateX(titan.getDistance() * 20);
                    hBar.setTranslateY(tCount * 220 + titan.getHeightInMeters() - 20);
                    if (i == 0) {
                        titanSpawner1.getChildren().add(spawn);
                    } else if (i == 1) {
                        titanSpawner2.getChildren().add(spawn);
                    } else {
                        titanSpawner3.getChildren().add(spawn);
                    }
                }
                else if(titan instanceof ColossalTitan){
                    spawn.setFill(Color.RED);
                    spawn.setRadius(titan.getHeightInMeters());
                    spawn.setTranslateX(distance * 20);
                    spawn.setTranslateY(tCount * titan.getHeightInMeters() * 220);
                    Label hBar = new Label("Health: " + titan.getCurrentHealth() +"%");
                    hBar.setTextFill(Color.GREEN);
                    hBar.setTranslateX(titan.getDistance() * 20);
                    hBar.setTranslateY(tCount * 220 + titan.getHeightInMeters() - 20);
                    if (i == 0) {
                        titanSpawner1.getChildren().add(spawn);
                    } else if (i == 1) {
                        titanSpawner2.getChildren().add(spawn);
                    } else {
                        titanSpawner3.getChildren().add(spawn);
                    }
                }
            }
            tCount++;
        }
    }

    public void exceptions(Exception e){

    }
}
