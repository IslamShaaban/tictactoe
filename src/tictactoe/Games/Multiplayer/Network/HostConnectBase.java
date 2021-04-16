package tictactoe.Games.Multiplayer.Network;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import static tictactoe.GameStatus.DrawBase.changeScene;
import tictactoe.PlaysChoice.*;

public class HostConnectBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Button button;
    protected final Button button0;
    protected final Button button1;
    public static int host;
    public static boolean flag;

    public HostConnectBase() {

        imageView = new ImageView();
        button = new Button();
        button0 = new Button();
        button1 = new Button();
        host = 0;
        flag = false;

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

        button.setLayoutX(349.0);
        button.setLayoutY(202.0);
        button.setMnemonicParsing(false);
        button.setStyle("-fx-background-color: D62376; -fx-background-radius: 100;");
        button.setText("Host");
        button.setTextFill(javafx.scene.paint.Color.WHITE);
        button.setFont(new Font("System Italic", 30.0));

        button0.setLayoutX(330.0);
        button0.setLayoutY(300.0);
        button0.setMnemonicParsing(false);
        button0.setStyle("-fx-background-color: D62376; -fx-background-radius: 100;");
        button0.setText("Connect");
        button0.setTextFill(javafx.scene.paint.Color.WHITE);
        button0.setFont(new Font("System Italic", 30.0));

        button1.setLayoutX(48.0);
        button1.setLayoutY(505.0);
        button1.setMnemonicParsing(false);
        button1.setStyle("-fx-background-radius: 100; -fx-background-color: D62376;");
        button1.setText("Back");
        button1.setTextFill(javafx.scene.paint.Color.WHITE);
        button1.setFont(new Font("System Italic", 30.0));

        getChildren().add(imageView);
        getChildren().add(button);
        getChildren().add(button0);
        getChildren().add(button1);
        
        button.setOnAction((ActionEvent event) -> {
            host = 1;
            flag = true;
            XOChoiceBase root = new XOChoiceBase();
            changeScene(button,root);
        });
        
        button0.setOnAction((ActionEvent event) -> {
            host = 0;
            XOChoiceBase root = new XOChoiceBase();
            changeScene(button0,root);
        });
        
        button1.setOnAction((ActionEvent event) -> {
            PlaysChoiceBase root = new PlaysChoiceBase();
            changeScene(button1,root);
        });
    }
}
