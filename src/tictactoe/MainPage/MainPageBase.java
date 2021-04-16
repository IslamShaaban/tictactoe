package tictactoe.MainPage;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import  javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import static tictactoe.GameStatus.DrawBase.changeScene;
import tictactoe.SignInUp.*;

public class MainPageBase extends AnchorPane {
     
    protected final ImageView imageView, imageView0;
    protected final Button exit;
    protected final Button signin;
    protected final Button signup;
    protected final Label label;
    protected final Label label0;

    public MainPageBase() {
        
        imageView = new ImageView();
        imageView0 = new ImageView();
        exit = new Button();
        signin = new Button();
        signup = new Button();
        label = new Label();
        label0 = new Label();

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
        
        imageView0.setFitHeight(188.0);
        imageView0.setFitWidth(189.0);
        imageView0.setLayoutX(320.0);
        imageView0.setLayoutY(150.0);
        imageView0.setImage(new Image(getClass().getResource("/tictactoe/Images/xologo.png").toExternalForm()));

        exit.setLayoutX(29.0);
        exit.setLayoutY(520.0);
        exit.setMnemonicParsing(false);
        exit.setPrefHeight(53.0);
        exit.setPrefWidth(93.0);
        exit.setStyle("-fx-background-color: D62376; -fx-background-radius: 100;");
        exit.setText("Exit");
        exit.setTextFill(javafx.scene.paint.Color.WHITE);
        exit.setFont(new Font("System Italic", 30.0));

        signin.setLayoutX(352.0);
        signin.setLayoutY(350.0);
        signin.setMnemonicParsing(false);
        signin.setStyle("-fx-background-color: D62376; -fx-background-radius: 100;");
        signin.setText("Sign In");
        signin.setTextFill(javafx.scene.paint.Color.WHITE);
        signin.setFont(new Font("System Italic", 30.0));
        
        signup.setLayoutX(350.0);
        signup.setLayoutY(450.0);
        signup.setMnemonicParsing(false);
        signup.setStyle("-fx-background-color: D62376; -fx-background-radius: 100;");
        signup.setText("Sign Up");
        signup.setTextFill(javafx.scene.paint.Color.WHITE);
        signup.setFont(new Font("System Italic", 30.0));
        
        label.setLayoutX(330.0);
        label.setLayoutY(57.0);
        label.setText("Welcome");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("System Bold Italic", 36.0));

        label0.setLayoutX(320.0);
        label0.setLayoutY(107.0);
        label0.setText("X/O Game");
        label0.setTextFill(javafx.scene.paint.Color.WHITE);
        label0.setFont(new Font("System Bold", 36.0));

        getChildren().add(imageView);
        getChildren().add(imageView0);
        getChildren().add(exit);
        getChildren().add(signin);
        getChildren().add(signup);
        getChildren().add(label);
        getChildren().add(label0);
        
        exit.setOnAction((ActionEvent event) -> {
            Platform.exit();
        });
        
        signin.setOnAction((ActionEvent event) -> {
            SignInBase root = new SignInBase();
            changeScene(signin,root);
        });
        
        signup.setOnAction((ActionEvent event) -> {
            SignUpBase root = new SignUpBase();
            changeScene(signin,root);
        });
    }
}
