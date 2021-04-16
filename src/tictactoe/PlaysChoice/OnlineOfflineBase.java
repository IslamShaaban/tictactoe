package tictactoe.PlaysChoice;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import static tictactoe.GameStatus.DrawBase.changeScene;
import tictactoe.Games.Multiplayer.Network.*;
import tictactoe.Games.Multiplayer.Offline.*;

public class OnlineOfflineBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Button button;
    protected final Button button0;
    protected final Button button1;
    protected final Button button2;
    public static int Multi;

    public OnlineOfflineBase() {

        imageView = new ImageView();
        button = new Button();
        button0 = new Button();
        button1 = new Button();
        button2 = new Button();
        Multi = 1;

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(800.0);

        imageView.setFitHeight(800.0);
        imageView.setFitWidth(706.0);
        imageView.setLayoutX(-1.0);
        imageView.setLayoutY(-3.0);
        imageView.setImage(new Image(getClass().getResource("/tictactoe/Images/background.png").toExternalForm()));
        imageView.setFitHeight(USE_PREF_SIZE);
        imageView.setFitWidth(USE_PREF_SIZE);

        button.setLayoutX(352.0);
        button.setLayoutY(208.0);
        button.setMnemonicParsing(false);
        button.setStyle("-fx-background-radius: 100; -fx-background-color: D62376;");
        button.setText("Offline");
        button.setTextFill(javafx.scene.paint.Color.WHITE);
        button.setFont(new Font("System Italic", 30.0));

        button0.setLayoutX(353.0);
        button0.setLayoutY(314.0);
        button0.setMnemonicParsing(false);
        button0.setStyle("-fx-background-radius: 100; -fx-background-color: D62376;");
        button0.setText("Online");
        button0.setTextFill(javafx.scene.paint.Color.WHITE);
        button0.setFont(new Font("System Italic", 30.0));

        button1.setLayoutX(651.0);
        button1.setLayoutY(508.0);
        button1.setMnemonicParsing(false);
        button1.setStyle("-fx-background-color: D62376; -fx-background-radius: 100;");
        button1.setText("Exit");
        button1.setTextFill(javafx.scene.paint.Color.WHITE);
        button1.setFont(new Font(30.0));

        button2.setLayoutX(61.0);
        button2.setLayoutY(508.0);
        button2.setMnemonicParsing(false);
        button2.setStyle("-fx-background-radius: 100; -fx-background-color: D62376;");
        button2.setText("Back");
        button2.setTextFill(javafx.scene.paint.Color.WHITE);
        button2.setFont(new Font(30.0));

        getChildren().add(imageView);
        getChildren().add(button);
        getChildren().add(button0);
        getChildren().add(button1);
        getChildren().add(button2);
        
        button.setOnAction((ActionEvent event) -> {
            Multi = 1;
            MultiplayerNameBase root = new MultiplayerNameBase();
            changeScene(button,root);
        });
        
        button0.setOnAction((ActionEvent event) -> {
            Multi = 2;
            HostConnectBase root = new HostConnectBase();
            changeScene(button0,root);
        });
        
        button1.setOnAction((ActionEvent event) -> {
            Platform.exit();
        });
        
        button2.setOnAction((ActionEvent event) -> {
            PlaysChoiceBase root = new PlaysChoiceBase();
            changeScene(button2,root);
        });

    }
}
