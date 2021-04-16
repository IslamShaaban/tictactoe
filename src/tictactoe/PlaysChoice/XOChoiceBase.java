package tictactoe.PlaysChoice;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import static tictactoe.GameStatus.DrawBase.changeScene;
import tictactoe.Games.Singleplayer.*;
import tictactoe.Games.Multiplayer.Network.*;
import tictactoe.Games.Multiplayer.Offline.*;

public class XOChoiceBase extends AnchorPane {
  
    protected final ImageView imageView;
    protected static Button X;
    protected static Button O;
    protected final Button back;
    protected final Button exit;
    public static String symbol = "";
    public static int playerjoin;

    public XOChoiceBase() {
        imageView = new ImageView();
        XOChoiceBase.X = new Button();
        XOChoiceBase.O = new Button();
        back = new Button();
        exit = new Button();
        playerjoin = 0;
        
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

        X.setLayoutX(100.0);
        X.setLayoutY(130.0);
        X.setMnemonicParsing(false);
        X.setPrefHeight(256.0);
        X.setPrefWidth(300.0);
        X.setStyle("-fx-background-COLOR: DE0E80; -fx-background-radius: 50;");
        X.setText("X");
        X.setTextFill(javafx.scene.paint.Color.WHITE);
        X.setFont(new Font(140.0));

        O.setLayoutX(420.0);
        O.setLayoutY(130.0);
        O.setMnemonicParsing(false);
        O.setPrefHeight(256.0);
        O.setPrefWidth(300.0);
        O.setStyle("-fx-background-radius: 50;");
        O.setText("O");
        O.setTextFill(javafx.scene.paint.Color.WHITE);
        O.setFont(new Font(140.0));

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
        getChildren().add(X);
        getChildren().add(O);
        getChildren().add(back);
        getChildren().add(exit);
        
        X.setOnAction((ActionEvent event) -> {
            symbol = "X";
            X.setDisable(true);
            if (PlaysChoiceBase.Mode.equals("Single")) {
                if (LevelsBase.level.equals("easy")) {
                    EasyComGameBase root = new EasyComGameBase();
                    changeScene(X,root);
                } else {
                    if (LevelsBase.level.equals("medium")) {
                        MediumComGameBase root = new MediumComGameBase();
                        changeScene(X,root);
                    } else {
                        if (LevelsBase.level.equals("hard")) {
                            HardComGameBase root = new HardComGameBase();
                            changeScene(X,root);
                        }
                    }
                }
            } else {
                if (OnlineOfflineBase.Multi == 1) {
                    MultiOfflineGameBase root = new MultiOfflineGameBase();
                    changeScene(X,root);
                } else {
                    OnlineGame root = new OnlineGame();
                    changeScene(X,root);
                }
            }
        });
        
        O.setOnAction((ActionEvent event) -> {
            symbol = "O";
            O.setDisable(true);
            if (PlaysChoiceBase.Mode.equals("Single")) {
                if (LevelsBase.level.equals("easy")) {
                    EasyComGameBase root = new EasyComGameBase();
                    changeScene(O,root);
                } else {
                    if (LevelsBase.level.equals("medium")) {
                        MediumComGameBase root = new MediumComGameBase();
                        changeScene(O,root);
                    } else {
                        if (LevelsBase.level.equals("hard")) {
                            HardComGameBase root = new HardComGameBase();
                            changeScene(O,root);
                        }
                    }
                }
            } else {
                if (OnlineOfflineBase.Multi == 1) {
                    MultiOfflineGameBase root = new MultiOfflineGameBase();
                    changeScene(X,root);
                } else {
                    OnlineGame root = new OnlineGame();
                    changeScene(O,root);
                }
            }
        });
        
        exit.setOnAction((ActionEvent event) -> {
            Platform.exit();
        });
        
        back.setOnAction((ActionEvent event) -> {
            if (PlaysChoiceBase.Mode.equals("Single")) {
                LevelsBase root = new LevelsBase();
                changeScene(back,root);
            } else {
                if (OnlineOfflineBase.Multi == 1) {
                    MultiplayerNameBase root = new MultiplayerNameBase();
                    changeScene(back,root);
                } else {
                    HostConnectBase root = new HostConnectBase();
                    changeScene(back,root);
                }
            }
        });
    }
}