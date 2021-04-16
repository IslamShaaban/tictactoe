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
import tictactoe.Games.Multiplayer.Network.*;
import tictactoe.Games.Singleplayer.*;
import tictactoe.PlaysChoice.*;
import tictactoe.Games.Multiplayer.Offline.*;

public class LosingBase extends AnchorPane {
    
    protected final ImageView imageView;
    protected final Button playagain;
    protected final Button exit;
    protected final Button back;
    protected final Label label;
    protected final ImageView imageView0;

    public LosingBase() {
        
        imageView = new ImageView();
        playagain = new Button();
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

        playagain.setLayoutX(320.0);
        playagain.setLayoutY(350.0);
        playagain.setMnemonicParsing(false);
        playagain.setStyle("-fx-background-radius: 100; -fx-background-color: D62376;");
        playagain.setText("Play Again");
        playagain.setTextFill(javafx.scene.paint.Color.WHITE);
        playagain.setFont(new Font("System Italic", 30.0));

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

        label.setLayoutX(345.0);
        label.setLayoutY(70.0);
        label.setText("Loser");
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

        imageView0.setFitHeight(200.0);
        imageView0.setFitWidth(200.0);
        imageView0.setLayoutX(307.0);
        imageView0.setLayoutY(150.0);
        imageView0.setImage(new Image(getClass().getResource("/tictactoe/Images/loser.gif").toExternalForm()));

        getChildren().add(imageView);
        getChildren().add(playagain);
        getChildren().add(exit);
        getChildren().add(back);
        getChildren().add(label);
        getChildren().add(imageView0);
        
        if(OnlineOfflineBase.Multi == 2){
        playagain.setVisible(false);
        }
        
        exit.setOnAction((ActionEvent event) -> {
            
            Platform.exit();
        });
        
        back.setOnAction((ActionEvent event) -> {
            
            if(PlaysChoiceBase.Mode.equals("Single")){
               LevelsBase root = new LevelsBase();
               changeScene(playagain,root);
            }else{
                if(OnlineOfflineBase.Multi == 1){
                    PlaysChoiceBase root = new PlaysChoiceBase();
                    changeScene(back,root);
                }else{
                    HostConnectBase root = new HostConnectBase();
                    changeScene(back,root);
                }
            }     
        });
        
        playagain.setOnAction((ActionEvent event) -> {
            
            if(PlaysChoiceBase.Mode.equals("Single")){
                if(LevelsBase.level.equals("easy")){
                    EasyComGameBase root = new EasyComGameBase();
                    changeScene(playagain,root);
                }else{
                    if(LevelsBase.level.equals("medium")){
                        MediumComGameBase root = new MediumComGameBase();
                        changeScene(playagain,root);
                    }else{
                        HardComGameBase root = new HardComGameBase();
                        changeScene(playagain,root);
                    }
                }
            }else{
                if(OnlineOfflineBase.Multi == 1){
                    MultiOfflineGameBase root = new MultiOfflineGameBase();
                    changeScene(playagain,root);
                }else{
                    OnlineGame root = new OnlineGame();
                    changeScene(playagain,root);
                }
            }
        });    
    }
}