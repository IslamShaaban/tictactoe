package tictactoe;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import tictactoe.MainPage.MainPageBase;


public class Tictactoe extends Application {
   
    @Override
    public void start(Stage stage) throws Exception {
                 
        MainPageBase root = new MainPageBase();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("XO Game");
        stage.getIcons().add((new Image(getClass().getResource("/tictactoe/Images/xoicon.png").toExternalForm())));
        stage.maximizedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue) 
            {
                stage.setMaximized(false);
            }
        });
        
        stage.setResizable(false); //This Method to Prevent user from Resize Mode
        stage.show(); //This Method to Show The Game
    }
    
    public static void main(String[] args) {
        launch(args);
    }  
}
