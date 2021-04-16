package tictactoe.GameStatus;

import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.util.Duration;
import static tictactoe.GameStatus.DrawBase.changeScene;
import tictactoe.MainPage.*;

public class WinningSavedBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Button exit;
    protected final Button back;
    protected final Label label;
    protected final ImageView imageView0;

    public WinningSavedBase() {

        imageView = new ImageView();
        exit = new Button();
        back = new Button();
        label = new Label();
        imageView0 = new ImageView();

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

        exit.setLayoutX(660.0);
        exit.setLayoutY(510.0);
        exit.setMnemonicParsing(false);
        exit.setStyle("-fx-background-radius: 100; -fx-background-color: D62376;");
        exit.setText("Exit");
        exit.setTextFill(javafx.scene.paint.Color.WHITE);
        exit.setFont(new Font("System Italic", 30.0));

        back.setLayoutX(52.0);
        back.setLayoutY(510.0);
        back.setMnemonicParsing(false);
        back.setStyle("-fx-background-radius: 100; -fx-background-color: D62376;");
        back.setText("Back");
        back.setTextFill(javafx.scene.paint.Color.WHITE);
        back.setFont(new Font("System Italic", 30.0));

        label.setLayoutX(335.0);
        label.setLayoutY(110.0);
        label.setText("You Won");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font(48.0));
        ScaleTransition scaleTransition = new ScaleTransition(); 
        scaleTransition.setDuration(Duration.millis(1000)); 
        scaleTransition.setNode(label); 
        scaleTransition.setByY(1.5); 
        scaleTransition.setByX(1.5);  
        scaleTransition.setCycleCount(50); 
        scaleTransition.setAutoReverse(false); 
        scaleTransition.play();

        imageView0.setFitHeight(240.0);
        imageView0.setFitWidth(240.0);
        imageView0.setLayoutX(290.0);
        imageView0.setLayoutY(190.0);
        imageView0.setImage(new Image(getClass().getResource("/tictactoe/Images/winner.gif").toExternalForm()));

        getChildren().add(imageView);
        getChildren().add(exit);
        getChildren().add(back);
        getChildren().add(label);
        getChildren().add(imageView0);
        
        exit.setOnAction((ActionEvent event) -> {
            Platform.exit();
        });
        
        back.setOnAction((ActionEvent event) -> {
            MainPageBase root = new MainPageBase();
            changeScene(back,root);
        });
    }
}