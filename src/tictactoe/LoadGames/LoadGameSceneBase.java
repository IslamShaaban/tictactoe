package tictactoe.LoadGames;

import java.util.ArrayList;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import static tictactoe.GameStatus.DrawBase.changeScene;
import tictactoe.MainPage.MainPageBase;
import tictactoe.SignInUp.SignInBase;
import tictactoe.XODataBase.ox_database;

public class LoadGameSceneBase extends AnchorPane {

    protected final ImageView imageView;
    protected final MenuButton gamesID;
    protected final ColorAdjust colorAdjust;
    protected final Button load;
    protected final Button back;
    private Stage stage;

    public LoadGameSceneBase() {

        imageView = new ImageView();
        gamesID = new MenuButton();
        colorAdjust = new ColorAdjust();
        load = new Button();
        back = new Button();

        setId("AnchorPane");
        setPrefHeight(600.0);
        setPrefWidth(800.0);

        imageView.setFitHeight(600.0);
        imageView.setFitWidth(814.0);
        imageView.setImage(new Image(getClass().getResource("/tictactoe/Images/background.png").toExternalForm()));

        gamesID.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        gamesID.setContentDisplay(javafx.scene.control.ContentDisplay.TEXT_ONLY);
        gamesID.setLayoutX(209.0);
        gamesID.setLayoutY(74.0);
        gamesID.setMnemonicParsing(false);
        gamesID.setPrefHeight(65.0);
        gamesID.setPrefWidth(409.0);
        gamesID.setScaleShape(false);
        gamesID.setStyle("-fx-background-radius: 100; -fx-background-color: D62376;");
        gamesID.setText("GamesID");
        gamesID.setTextFill(javafx.scene.paint.Color.WHITE);

        gamesID.setFont(new Font(30.0));

        gamesID.setEffect(colorAdjust);

        load.setLayoutX(666.0);
        load.setLayoutY(496.0);
        load.setMnemonicParsing(false);
        load.setStyle("-fx-background-radius: 100; -fx-background-color: D62376;");
        load.setText("Exit");
        load.setTextFill(javafx.scene.paint.Color.WHITE);
        load.setFont(new Font("System Italic", 30.0));

        back.setLayoutX(57.0);
        back.setLayoutY(496.0);
        back.setMnemonicParsing(false);
        back.setStyle("-fx-background-color: D62376; -fx-background-radius: 100;");
        back.setText("Back");
        back.setTextFill(javafx.scene.paint.Color.WHITE);
        back.setFont(new Font(30.0));

        getChildren().add(imageView);
       
        createElements(ox_database.checkgameID(SignInBase.userName));
        
        back.setOnAction((ActionEvent event) -> {
            MainPageBase root = new MainPageBase();
            changeScene(back,root);
        });
        
        load.setOnAction((ActionEvent event) -> {
          Platform.exit(); 
        });
              
        getChildren().add(gamesID);
        getChildren().add(load);
        getChildren().add(back);
    
    }
      
    public void createElements(ArrayList gameId){
        
        ArrayList<MenuItem> elements = new ArrayList<MenuItem>(); 
        for(int i = 0 ; i < gameId.size() ; i++){
            elements.add(new MenuItem());
        } 
        for(int i = 0 ; i < gameId.size() ; i++){
            elements.get(i).setText(String.valueOf(gameId.get(i)));
            gamesID.getItems().add(elements.get(i));
            elements.get(i).setOnAction((ActionEvent e) -> {
                LoadGameBase root = new LoadGameBase(((MenuItem)e.getSource()).getText());
                changeScene(load,root);
            });
            
        }
    }
}
