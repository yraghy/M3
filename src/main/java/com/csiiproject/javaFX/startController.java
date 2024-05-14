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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import com.csiiproject.javaFX.easyController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class startController {

    public static Battle easyGame;
    private Battle hardGame;
    private Label eScore, eRes, eTurn, ePhase;
    private Label hScore, hRes, hTurn, hPhase;
    public static Scene easyScene;
    public Scene hardScene;

    public void switchEasy(ActionEvent e) throws IOException {
        Parent rootE = FXMLLoader.load(getClass().getResource("Easy.fxml"));
        Scene easyScene = new Scene(rootE);
        Stage window = (Stage)((javafx.scene.Node)e.getSource()).getScene().getWindow();
        Battle easyGame = new Battle(1,0,9,3,250);
        Label eScore = (Label) rootE.lookup("#score");
        Label eRes = (Label) rootE.lookup("#resources");
        Label eTurn = (Label) rootE.lookup("#turn");
        Label ePhase = (Label) rootE.lookup("#phase");
        eScore.setText("Score: " + easyGame.getScore());
        eRes.setText("Resources: " + easyGame.getResourcesGathered());
        eTurn.setText("Turn: " + easyGame.getNumberOfTurns());
        ePhase.setText("Phase: " + easyGame.getBattlePhase());
        window.setScene(easyScene);
        window.show();
    }

    public void switchHard(ActionEvent e) throws IOException{
        Parent rootH = FXMLLoader.load(getClass().getResource("Hard.fxml"));
        Scene hardScene = new Scene(rootH);
        Stage window = (Stage)((javafx.scene.Node)e.getSource()).getScene().getWindow();
        Battle hardGame = new Battle(1,0,9,5,125);
        Label hScore = (Label) rootH.lookup("#score");
        Label hRes = (Label) rootH.lookup("#resources");
        Label hTurn = (Label) rootH.lookup("#turn");
        Label phase = (Label) rootH.lookup("#phase");
        hScore.setText("Score: " + hardGame.getScore());
        hRes.setText("Resources: " + hardGame.getResourcesGathered());
        hTurn.setText("Turn: " + hardGame.getNumberOfTurns());
        phase.setText("Phase: " + hardGame.getBattlePhase());
        window.setScene(hardScene);
        window.show();
    }

    public Scene getEasyScene() {return easyScene;}
    public Scene getHardScene() {return hardScene;}
    public Battle getEasyGame() {return easyGame;}
    public Battle getHardGame() {return hardGame;}

}
