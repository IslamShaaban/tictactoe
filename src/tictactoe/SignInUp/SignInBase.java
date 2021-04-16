package tictactoe.SignInUp;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ProgressIndicator;
import static tictactoe.GameStatus.DrawBase.changeScene;
import tictactoe.MainPage.MainPageBase;
import tictactoe.PlaysChoice.PlaysChoiceBase;
import tictactoe.XODataBase.ox_database;

public class SignInBase extends AnchorPane {
  
    protected final ImageView imageView;
    protected final Label label;
    protected final TextField usrnamefield;
    protected final Button signin;
    protected final Label label0;
    protected final Button back;
    protected boolean found;
    public static String userName;
    protected final Label please;
    ProgressIndicator progressIndicator = new ProgressIndicator();

    public SignInBase(){

        imageView = new ImageView();
        label = new Label();
        usrnamefield = new TextField();
        signin = new Button();
        label0 = new Label();
        back = new Button();
        please = new Label();

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

        label.setLayoutX(350.0);
        label.setLayoutY(72.0);
        label.setText("Sign In");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("System Italic", 50.0));

        usrnamefield.setLayoutX(350.0);
        usrnamefield.setLayoutY(250.0);
        usrnamefield.setPrefHeight(40.0);
        usrnamefield.setPrefWidth(220.0);
        usrnamefield.setFont(new Font("System Italic", 20.0));

        signin.setLayoutX(350.0);
        signin.setLayoutY(340.0);
        signin.setMnemonicParsing(false);
        signin.setStyle("-fx-background-color: D62376; -fx-background-radius: 100;");
        signin.setText("Sign In");
        signin.setTextFill(javafx.scene.paint.Color.WHITE);
        signin.setFont(new Font("System Italic", 30.0));

        label0.setLayoutX(170.0);
        label0.setLayoutY(245.0);
        label0.setText("User Name");
        label0.setTextFill(javafx.scene.paint.Color.WHITE);
        label0.setFont(new Font("System Italic", 30.0));

        back.setLayoutX(52.0);
        back.setLayoutY(510.0);
        back.setMnemonicParsing(false);
        back.setStyle("-fx-background-radius: 100; -fx-background-color: D62376;");
        back.setText("Back");
        back.setTextFill(javafx.scene.paint.Color.WHITE);
        back.setFont(new Font("System Italic", 30.0));
        
        progressIndicator.setLayoutX(300.0);
        progressIndicator.setLayoutY(150.0);
        progressIndicator.setMinWidth(200);
        progressIndicator.setMinHeight(200);
        progressIndicator.setStyle(" -fx-progress-color: FFFDFE;");
        
        please.setLayoutX(280.0);
        please.setLayoutY(340.0);
        please.setText("Please Wait");
        please.setTextFill(javafx.scene.paint.Color.WHITE);
        please.setFont(new Font("System Italic", 50.0));

        getChildren().add(imageView);
        getChildren().add(label);
        getChildren().add(usrnamefield);
        getChildren().add(signin);
        getChildren().add(label0);
        getChildren().add(back);
        getChildren().add(progressIndicator);
        getChildren().add(please);
        progressIndicator.setVisible(false);
        please.setVisible(false);
        
        signin.setOnAction((ActionEvent event) -> {
            
            if (usrnamefield.getText().equals("")) {
                ShowChildren();
                Alert alert1 = new Alert(AlertType.ERROR);
                alert1.setTitle("Alert");
                alert1.setHeaderText("Error");
                alert1.setContentText("Please Enter valid User Name******");
                alert1.showAndWait();
                
            } else {
                HideChildren();
                userName=usrnamefield.getText();
                boolean check =false;
                try {
                    //HideChildren();
                    check=ox_database.checkfullName(userName);
                    if (check == true) {
                        //HideChildren();
                        PlaysChoiceBase root = new PlaysChoiceBase();
                        changeScene(back,root);
                    } else {
                        //ShowChildren();
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Alert");
                        alert.setHeaderText("Error");
                        alert.setContentText("You need to sign-up ");
                        alert.showAndWait();
                        SignUpBase root = new SignUpBase();
                        changeScene(back,root);
                    }
                }catch (SQLException ex) {                    
                    Logger.getLogger(SignInBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } 
        );
        
        back.setOnAction((ActionEvent event) -> {
            MainPageBase root = new MainPageBase();
            changeScene(back,root);
        });
        
    }
    public void ShowChildren(){
        label0.setVisible(true);
        label.setVisible(true);
        signin.setVisible(true);
        back.setVisible(true);
        usrnamefield.setVisible(true);
        progressIndicator.setVisible(false);
        please.setVisible(false);
    }
    
    public void HideChildren(){
        
        progressIndicator.setVisible(true);
        please.setVisible(true);
        label0.setVisible(false);
        label.setVisible(false);
        signin.setVisible(false);
        back.setVisible(false);
        usrnamefield.setVisible(false);
        System.out.println("in");
    }
    
}