package com.csiiproject.javaFX;
import game.engine.Battle;
import game.engine.exceptions.InsufficientResourcesException;
import game.engine.exceptions.InvalidLaneException;
import game.engine.lanes.Lane;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class Controller  {

    private Lane buyLane;

    public Controller(Battle easyGame) throws IOException {
    this.easyGame = easyGame;
    Platform.runLater(() -> {
        lane1buy = new Button();
        lane1buy.setUserData(1);
        lane2buy = new Button();
        lane2buy.setUserData(2);
        lane3buy = new Button();
        lane3buy.setUserData(3);

        bBuy1 = new Button();
        bBuy1.setUserData(1);
        bBuy2 = new Button();
        bBuy2.setUserData(2);
        bBuy3 = new Button();
        bBuy3.setUserData(3);
        bBuy4 = new Button();
        bBuy4.setUserData(4);
    });
}





    public void initialize() {

        assert bBuy1 != null;
        bBuy1.setOnAction(e -> {
            try {
                purchaseAntiTitanShell(e);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        assert bBuy2 != null;
        bBuy2.setOnAction(e -> {
            try {
                purchaseSpear(e);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        assert bBuy3 != null;
        bBuy3.setOnAction(e -> {
            try {
                purchaseCannon(e);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        assert bBuy4 != null;
        bBuy4.setOnAction(e -> {
            try {
                purchaseTrap(e);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public int getLane() {
        SharedState sharedState = SharedState.getInstance();
        return sharedState.getLaneNumber();  // Get the laneNumber from SharedState
    }

    private StackPane stackPane;
    public void purchaseAntiTitanShell(ActionEvent e) throws InvalidLaneException, InsufficientResourcesException {

        SharedState sharedState = SharedState.getInstance();
        int laneNumber = sharedState.getLaneNumber();  // To get the value

        Lane lane = easyGame.getLane(laneNumber);
        easyGame.purchaseWeapon(1 , lane);


        Optional<Image> overlayImageOpt = loadImage("WeaponShop/antiTitanShell.png");
        if (overlayImageOpt.isPresent()) {
            ImageView overlayImageView = new ImageView(overlayImageOpt.get());
            GridPane gridPane = (GridPane) lanes;
            gridPane.add(overlayImageView, 0, getRow());
        } else {
            System.out.println("Image not found: WeaponShop/antiTitanShell.png");
        }


}

    private Optional<Image> loadImage(String resourcePath) {
    URL resourceUrl = getClass().getClassLoader().getResource(resourcePath);
    if (resourceUrl != null) {
        return Optional.of(new Image(resourceUrl.toExternalForm()));
    } else {
        return Optional.empty();
    }
}




    public void purchaseSpear(ActionEvent e) throws InvalidLaneException, InsufficientResourcesException {
        SharedState sharedState = SharedState.getInstance();
        int laneNumber = sharedState.getLaneNumber();  // To get the value

        Lane lane = easyGame.getLane(laneNumber);
        easyGame.purchaseWeapon(2 , lane);

        Optional<Image> overlayImageOpt = loadImage("WeaponShop/spear.png");
        if (overlayImageOpt.isPresent()) {
            ImageView overlayImageView = new ImageView(overlayImageOpt.get());
            GridPane gridPane = (GridPane) lanes;
            gridPane.add(overlayImageView, 0, getRow());
        } else {
            System.out.println("Image not found: WeaponShop/spear.png");
        }
    }

    public int getRow() {
        SharedState sharedState = SharedState.getInstance();
        int laneNumber = sharedState.getLaneNumber();
        switch (laneNumber) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            default:
                throw new IllegalArgumentException("Invalid lane number: " + laneNumber);
        }
    }

    public void purchaseCannon(ActionEvent e) throws InvalidLaneException, InsufficientResourcesException {
        SharedState sharedState = SharedState.getInstance();
        int laneNumber = sharedState.getLaneNumber();  // To get the value

        Lane lane = easyGame.getLane(laneNumber);
        easyGame.purchaseWeapon(3 , lane);

        Optional<Image> overlayImageOpt = loadImage("WeaponShop/cannon.png");
        if (overlayImageOpt.isPresent()) {
            ImageView overlayImageView = new ImageView(overlayImageOpt.get());
            GridPane gridPane = (GridPane) lanes;
            gridPane.add(overlayImageView, 0, getRow());
        } else {
            System.out.println("Image not found: WeaponShop/cannon.png");
        }
    }
    public void purchaseTrap(ActionEvent e) throws InvalidLaneException, InsufficientResourcesException {
        SharedState sharedState = SharedState.getInstance();
        int laneNumber = sharedState.getLaneNumber();  // To get the value

        Lane lane = easyGame.getLane(laneNumber);
        easyGame.purchaseWeapon(4 , lane);

        Optional<Image> overlayImageOpt = loadImage("WeaponShop/mine.png");
        if (overlayImageOpt.isPresent()) {
            ImageView overlayImageView = new ImageView(overlayImageOpt.get());
            GridPane gridPane = (GridPane) lanes;
            gridPane.add(overlayImageView, 0, getRow());
        } else {
            System.out.println("Image not found: WeaponShop/mine.png");
        }
    }












    public void mainMenuReturn(ActionEvent e) throws IOException{
        URL url = getClass().getResource("CleanStart.fxml");
        if (url == null) {
            throw new RuntimeException("Resource CleanStart.fxml not found");
        }
        Parent root = FXMLLoader.load(url);
        Scene mainMenuScene = new Scene(root);
        Stage window = (Stage)((javafx.scene.Node)e.getSource()).getScene().getWindow();
        window.setScene(mainMenuScene);
        window.show();
    }

    public void retAfterLoss(ActionEvent e) throws IOException{
        URL url = getClass().getResource("CleanStart.fxml");
        if (url == null) {
            throw new RuntimeException("Resource CleanStart.fxml not found");
        }
        Parent root = FXMLLoader.load(url);
        Scene mainMenuScene = new Scene(root);
        Stage window = (Stage)((javafx.scene.Node)e.getSource()).getScene().getWindow();
        window.setScene(mainMenuScene);
        window.show();
    }





    //Trial Methods
    public void loseTrial(ActionEvent e) throws IOException{AlertBox.gameOver("Game Over");}







public void closeShop(ActionEvent event) {
    // Get the current stage
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

    // Close the stage
    stage.close();
}

    public Pane lanes;
    public int laneNumber = -1;
    Pane lanePane;


// Method to get a node from a GridPane at a specific position


    public ImageView lane1Weapon = new ImageView();
    public ImageView lane2Weapon = new ImageView();
    public ImageView lane3Weapon = new ImageView();




    @FXML
    public Button lane1buy;
    @FXML
    public Button lane2buy;
    @FXML
    public Button lane3buy;

    public Controller() throws IOException {
    }






    public Button bBuy1;
    public Button bBuy2;
    public Button bBuy3;
    public Button bBuy4;










    // ... other code ...
    public Image loadWeaponImage(int weaponCode) throws MalformedURLException {
        URL resource = new URL("http://www.example.com");
        switch (weaponCode) {
            case 1:
                resource = getClass().getResource("/WeaponShop/antiTitanShell.png");
                break;
            case 2:
                resource = getClass().getResource("/WeaponShop/spear.png");
                break;
            case 3:
                resource = getClass().getResource("/WeaponShop/cannon.png");
                break;
            case 4:
                resource = getClass().getResource("/WeaponShop/mine.png");
                break;
            default:
                throw new IllegalStateException("Unexpected weapon code: " + weaponCode);
        }
        if (resource == null) {
            throw new RuntimeException("Resource not found for weapon code: " + weaponCode);
        }
        return new Image(resource.toExternalForm());
    }


Battle easyGame = new Battle();



}
