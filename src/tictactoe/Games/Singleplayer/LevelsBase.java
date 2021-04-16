package tictactoe.Games.Singleplayer;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import static tictactoe.GameStatus.DrawBase.changeScene;
import tictactoe.PlaysChoice.*;

public class LevelsBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Button easy;
    protected final Button hard;
    protected final Button medium;
    protected final Button back;
    public static String level;

    public LevelsBase() {

        imageView = new ImageView();
        easy = new Button();
        hard = new Button();
        medium = new Button();
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

        easy.setLayoutX(340.0);
        easy.setLayoutY(120.0);
        easy.setMnemonicParsing(false);
        easy.setPrefHeight(51.0);
        easy.setPrefWidth(132.0);
        easy.setStyle("-fx-background-radius: 100; -fx-background-color: D62376;");
        easy.setText("Easy");
        easy.setTextFill(javafx.scene.paint.Color.WHITE);
        easy.setFont(new Font("System Italic", 30.0));

        hard.setLayoutX(340.0);
        hard.setLayoutY(360.0);
        hard.setMnemonicParsing(false);
        hard.setPrefHeight(51.0);
        hard.setPrefWidth(132.0);
        hard.setStyle("-fx-background-radius: 100; -fx-background-color: D62376;");
        hard.setText("Hard");
        hard.setTextFill(javafx.scene.paint.Color.WHITE);
        hard.setFont(new Font("System Italic", 30.0));

        medium.setLayoutX(332.0);
        medium.setLayoutY(240.0);
        medium.setMnemonicParsing(false);
        medium.setPrefHeight(51.0);
        medium.setPrefWidth(152.0);
        medium.setStyle("-fx-background-radius: 100; -fx-background-color: D62376;");
        medium.setText("Medium");
        medium.setTextFill(javafx.scene.paint.Color.WHITE);
        medium.setFont(new Font("System Italic", 30.0));

        back.setLayoutX(52.0);
        back.setLayoutY(510.0);
        back.setMnemonicParsing(false);
        back.setStyle("-fx-background-radius: 100; -fx-background-color: D62376;");
        back.setText("Back");
        back.setTextFill(javafx.scene.paint.Color.WHITE);
        back.setFont(new Font("System Italic", 30.0));

        getChildren().add(imageView);
        getChildren().add(easy);
        getChildren().add(hard);
        getChildren().add(medium);
        getChildren().add(back);
        
        easy.setOnAction((ActionEvent event) -> {
            level = "easy";
            XOChoiceBase root = new XOChoiceBase();
            changeScene(easy,root);
        });
        
        medium.setOnAction((ActionEvent event) -> {
            level = "medium";
            XOChoiceBase root = new XOChoiceBase();
            changeScene(medium,root);
        });
        
        hard.setOnAction((ActionEvent event) -> {
            level = "hard";
            XOChoiceBase root = new XOChoiceBase();
            changeScene(hard,root);
        });
        
        back.setOnAction((ActionEvent event) -> {
            PlaysChoiceBase root = new PlaysChoiceBase();
            changeScene(back,root);
        });
    }
}
