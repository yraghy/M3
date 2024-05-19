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
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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

    //Switch scene methods
    public void switchEasy(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Easy.fxml"));
        Parent rootE = loader.load();
        Scene easyScene = new Scene(rootE);
        Stage window = (Stage)((javafx.scene.Node)e.getSource()).getScene().getWindow();
        easyController easyController = loader.getController();
        easyController.initEasy(rootE);
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
    public void switchInstruct(ActionEvent e) throws IOException {AlertBox.instructions("Instructions");}
    public void switchSettings(ActionEvent e) throws IOException{

    }
    public void switchCredits(ActionEvent e) throws IOException{

    }


    //Button effect methods
    public void shadow(MouseEvent e) throws IOException{
        Button b = (Button)e.getSource();
        b.setEffect(new DropShadow());
    }
    public void removeShadow(MouseEvent e) throws IOException{
        Button b = (Button)e.getSource();
        b.setEffect(null);
    }
}
