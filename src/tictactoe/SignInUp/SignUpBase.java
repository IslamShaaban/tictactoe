package tictactoe.SignInUp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import static tictactoe.GameStatus.DrawBase.changeScene;
import tictactoe.PlaysChoice.*;
import tictactoe.MainPage.MainPageBase;

public class SignUpBase extends AnchorPane {
   
    protected final ImageView imageView;
    protected final Label label;
    protected final TextField fnamefield;
    protected final TextField lnamefield;
    protected final Button register;
    protected final Label label0;
    protected final Label label1;
    protected final Button back;
    public    static String userName;
    private   String USERNAME_PATTERN;
    private   static Pattern pattern;

    public SignUpBase() {

        imageView = new ImageView();
        label = new Label();
        fnamefield = new TextField();
        lnamefield = new TextField();
        register = new Button();
        label0 = new Label();
        label1 = new Label();
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

        label.setLayoutX(350.0);
        label.setLayoutY(72.0);
        label.setText("Sign Up");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("System Italic", 50.0));

        fnamefield.setLayoutX(350.0);
        fnamefield.setLayoutY(200.0);
        fnamefield.setPrefHeight(40.0);
        fnamefield.setPrefWidth(220.0);
        fnamefield.setFont(new Font("System Italic", 20.0));

        lnamefield.setLayoutX(350.0);
        lnamefield.setLayoutY(280.0);
        lnamefield.setPrefHeight(40.0);
        lnamefield.setPrefWidth(220.0);
        lnamefield.setFont(new Font("System Italic", 20.0));

        register.setLayoutX(350.0);
        register.setLayoutY(340.0);
        register.setMnemonicParsing(false);
        register.setStyle("-fx-background-color: D62376; -fx-background-radius: 100;");
        register.setText("Register");
        register.setTextFill(javafx.scene.paint.Color.WHITE);
        register.setFont(new Font("System Italic", 30.0));

        label0.setLayoutX(170.0);
        label0.setLayoutY(195.0);
        label0.setText("First Name");
        label0.setTextFill(javafx.scene.paint.Color.WHITE);
        label0.setFont(new Font("System Italic", 30.0));

        label1.setLayoutX(170.0);
        label1.setLayoutY(275.0);
        label1.setText("Last Name");
        label1.setTextFill(javafx.scene.paint.Color.WHITE);
        label1.setFont(new Font("System Italic", 30.0));

        back.setLayoutX(52.0);
        back.setLayoutY(510.0);
        back.setMnemonicParsing(false);
        back.setStyle("-fx-background-radius: 100; -fx-background-color: D62376;");
        back.setText("Back");
        back.setTextFill(javafx.scene.paint.Color.WHITE);
        back.setFont(new Font("System Italic", 30.0));

        getChildren().add(imageView);
        getChildren().add(label);
        getChildren().add(fnamefield);
        getChildren().add(lnamefield);
        getChildren().add(register);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(back);
                
        USERNAME_PATTERN = "^[a-zA-Z]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";
        pattern = Pattern.compile(USERNAME_PATTERN);

        register.setOnAction((ActionEvent event) -> {
            userName = fnamefield.getText() + lnamefield.getText();
            if (!isValid(userName)) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Alert");
                alert.setHeaderText("Error");
                alert.setContentText("Please Enter a Valid User Name");
                alert.showAndWait();
            } else {
                userName = fnamefield.getText() + " " + lnamefield.getText();
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Alert");
                alert.setHeaderText("Congratulations");
                alert.setContentText("Thank You for Registeration, You Signed Up Successfully");
                alert.showAndWait();
                SignInBase.userName = userName;
                PlaysChoiceBase root = new PlaysChoiceBase();
                changeScene(back,root);
            }
        });
        
        back.setOnAction((ActionEvent event) -> {
            MainPageBase root = new MainPageBase();
            changeScene(back,root);
        });
    }
    
    public static boolean isValid(String username) {
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }
}
