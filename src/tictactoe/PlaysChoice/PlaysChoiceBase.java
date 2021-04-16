package tictactoe.PlaysChoice;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import static tictactoe.GameStatus.DrawBase.changeScene;
import tictactoe.SignInUp.*;
import tictactoe.Games.Singleplayer.*;
import tictactoe.LoadGames.*;
import tictactoe.MainPage.MainPageBase;


public class PlaysChoiceBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Button singlePlayer;
    protected final Button multiPlayers;
    protected final Button loadGames;
    protected final Button signout;
    public static String Mode;
    
    public PlaysChoiceBase() {

        imageView = new ImageView();
        singlePlayer = new Button();
        multiPlayers = new Button();
        loadGames = new Button();
        signout = new Button();

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
        
        singlePlayer.setLayoutX(300.0);
        singlePlayer.setLayoutY(120.0);
        singlePlayer.setMnemonicParsing(false);
        singlePlayer.setStyle("-fx-background-color: D62376; -fx-background-radius: 100;");
        singlePlayer.setText("Single Player");
        singlePlayer.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        singlePlayer.setTextFill(javafx.scene.paint.Color.WHITE);
        singlePlayer.setFont(new Font("System Italic", 29.0));

        multiPlayers.setLayoutX(310.0);
        multiPlayers.setLayoutY(240.0);
        multiPlayers.setMnemonicParsing(false);
        multiPlayers.setStyle("-fx-background-color: D62376; -fx-background-radius: 100;");
        multiPlayers.setText("Multiplayer");
        multiPlayers.setTextFill(javafx.scene.paint.Color.WHITE);
        multiPlayers.setFont(new Font("System Italic", 30.0));
        
        loadGames.setLayoutX(305.0);
        loadGames.setLayoutY(360.0);
        loadGames.setMnemonicParsing(false);
        loadGames.setStyle("-fx-background-color: D62376; -fx-background-radius: 100;");
        loadGames.setText("Load Games");
        loadGames.setTextFill(javafx.scene.paint.Color.WHITE);
        loadGames.setFont(new Font("System Italic", 30.0));

        signout.setLayoutX(52.0);
        signout.setLayoutY(510.0);
        signout.setMnemonicParsing(false);
        signout.setStyle("-fx-background-radius: 100; -fx-background-color: D62376;");
        signout.setText("Sign Out");
        signout.setTextFill(javafx.scene.paint.Color.WHITE);
        signout.setFont(new Font("System Italic", 30.0));

        getChildren().add(imageView);
        getChildren().add(singlePlayer);
        getChildren().add(multiPlayers);
        getChildren().add(loadGames);
        getChildren().add(signout);
        
        singlePlayer.setOnAction((ActionEvent event) -> {
            Mode = "Single";
            LevelsBase root = new LevelsBase();
            changeScene(singlePlayer,root);
        });
        
        multiPlayers.setOnAction((ActionEvent event) -> {
            Mode = "Multi";
            OnlineOfflineBase root = new OnlineOfflineBase();
            changeScene(multiPlayers,root);
        });
        
        loadGames.setOnAction((ActionEvent event) -> {
            LoadGameSceneBase root = new LoadGameSceneBase();
            changeScene(loadGames,root);
        });
        
        signout.setOnAction((ActionEvent event) -> {
            if(!SignInBase.userName.equals("") || !SignUpBase.userName.equals("")){
                SignInBase.userName = "";
                SignUpBase.userName = ""; 
            }
            MainPageBase root = new MainPageBase();
            changeScene(signout,root);
        });
    }
}
