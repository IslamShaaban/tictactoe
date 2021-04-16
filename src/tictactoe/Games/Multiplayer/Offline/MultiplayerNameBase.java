package tictactoe.Games.Multiplayer.Offline;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.text.Font;
import static tictactoe.GameStatus.DrawBase.changeScene;
import tictactoe.PlaysChoice.*;
import tictactoe.SignInUp.*;

public class MultiplayerNameBase extends AnchorPane {

    protected final ImageView imageView;
    protected final TextField firstplayer;
    protected final TextField secondplayer;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Button confirm;
    protected final Button exit;
    protected final Button back;
    public static String Player1Name, Player2Name;

    public MultiplayerNameBase() {

        imageView = new ImageView();
        firstplayer = new TextField();
        secondplayer = new TextField();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        confirm = new Button();
        exit = new Button();
        back = new Button();

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
        
        firstplayer.setLayoutX(120.0);
        firstplayer.setLayoutY(280.0);
        firstplayer.setPrefHeight(40.0);
        firstplayer.setPrefWidth(220.0);
        firstplayer.setFont(new Font("System Bold", 20.0));
        firstplayer.setText(SignInBase.userName);
        firstplayer.setDisable(true);

        secondplayer.setLayoutX(465.0);
        secondplayer.setLayoutY(280.0);
        secondplayer.setPrefHeight(40.0);
        secondplayer.setPrefWidth(220.0);
        secondplayer.setFont(new Font("System Bold", 20.0));

        label.setLayoutX(122.0);
        label.setLayoutY(220.0);
        label.setText("First Player");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("System Italic", 30.0));

        label0.setLayoutX(465.0);
        label0.setLayoutY(220.0);
        label0.setText("Second Player");
        label0.setTextFill(javafx.scene.paint.Color.WHITE);
        label0.setFont(new Font("System Italic", 30.0));

        label1.setLayoutX(180.0);
        label1.setLayoutY(72.0);
        label1.setText("Enter Players Names");
        label1.setTextFill(javafx.scene.paint.Color.WHITE);
        label1.setFont(new Font("System Italic", 50.0));

        confirm.setLayoutX(330.0);
        confirm.setLayoutY(350.0);
        confirm.setMnemonicParsing(false);
        confirm.setStyle("-fx-background-radius: 100; -fx-background-color: D62376;");
        confirm.setText("Confirm");
        confirm.setTextFill(javafx.scene.paint.Color.WHITE);
        confirm.setFont(new Font("System Italic", 30.0));

        back.setLayoutX(52.0);
        back.setLayoutY(510.0);
        back.setMnemonicParsing(false);
        back.setStyle("-fx-background-radius: 100; -fx-background-color: D62376;");
        back.setText("Back");
        back.setTextFill(javafx.scene.paint.Color.WHITE);
        back.setFont(new Font("System Italic", 30.0));

        exit.setLayoutX(660.0);
        exit.setLayoutY(510.0);
        exit.setMnemonicParsing(false);
        exit.setStyle("-fx-background-color: D62376; -fx-background-radius: 100;");
        exit.setText("Exit");
        exit.setTextFill(javafx.scene.paint.Color.WHITE);
        exit.setFont(new Font("System Italic", 30.0));

        getChildren().add(imageView);
        getChildren().add(firstplayer);
        getChildren().add(secondplayer);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(confirm);
        getChildren().add(exit);
        getChildren().add(back);
        
        confirm.setOnAction((ActionEvent event) -> {
            if (firstplayer.getText().equals("") || secondplayer.getText().equals("")) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("Text Field Error :(");
                alert.setContentText("Please Enter Names of Players!!!");
                alert.showAndWait();
            } else {
                Player1Name = firstplayer.getText();
                Player2Name = secondplayer.getText();
                XOChoiceBase root = new XOChoiceBase();
                changeScene(confirm,root);
            }
        });
        
        exit.setOnAction((ActionEvent event) -> {
            Platform.exit();
        });
        
        back.setOnAction((ActionEvent event) -> {
            OnlineOfflineBase root = new OnlineOfflineBase();
            changeScene(back,root);
        });
    }
}
