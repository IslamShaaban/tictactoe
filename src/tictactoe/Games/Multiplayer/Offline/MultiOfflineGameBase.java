package tictactoe.Games.Multiplayer.Offline;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import tictactoe.PlaysChoice.*;
import tictactoe.GameStatus.DrawBase;
import tictactoe.GameStatus.MultiplayerStatus.*;
import tictactoe.XODataBase.ox_database;

public class MultiOfflineGameBase extends AnchorPane {
    
    protected final ImageView imageView;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final Button b1;
    protected final Button b2;
    protected final Button b3;
    protected final Button b4;
    protected final Button b5;
    protected final Button b6;
    protected final Button b7;
    protected final Button b8;
    protected final Button b9;
    protected final ButtonBar buttonBar;
    private String Player1, Player2, Player1Name, Player2Name;
    protected ArrayList<Integer>player1;
    protected ArrayList<Integer>player2;
    private boolean myplay;
    private boolean IWon = false;
    private String player1Steps, player2Steps;
    private Stage stage;
    protected final Label Player1abel1;
    protected final Label Playerlabel2;
    protected final Label shape1;
    protected final Label shape2;
    protected final Label turn;
    protected final Button[]buttons;
    private int game_id;

    public MultiOfflineGameBase() {
        
        imageView = new ImageView();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        b1 = new Button();
        b2 = new Button();
        b3 = new Button();
        b4 = new Button();
        b5 = new Button();
        b6 = new Button();
        b7 = new Button();
        b8 = new Button();
        b9 = new Button();
        buttonBar = new ButtonBar();
        player1 = new ArrayList();
        player2 = new ArrayList();
        myplay = true;
        Player1abel1 = new Label();
        Playerlabel2 = new Label();
        shape1 = new Label();
        shape2 = new Label();
        turn = new Label();
        
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

        gridPane.setLayoutX(250.0);
        gridPane.setLayoutY(150.0);
        gridPane.setPrefHeight(253.0);
        gridPane.setPrefWidth(313.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(97.0);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(97.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(112.0);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(100.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMaxWidth(116.0);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(116.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        b1.setMnemonicParsing(false);
        b1.setPrefHeight(85.0);
        b1.setPrefWidth(115.0);
        b1.setFont(new Font("System Bold", 40.0));

        GridPane.setColumnIndex(b2, 1);
        b2.setMnemonicParsing(false);
        b2.setPrefHeight(85.0);
        b2.setPrefWidth(104.0);
        b2.setFont(new Font("System Bold", 40.0));

        GridPane.setColumnIndex(b3, 2);
        b3.setMnemonicParsing(false);
        b3.setPrefHeight(88.0);
        b3.setPrefWidth(101.0);
        b3.setFont(new Font("System Bold", 40.0));

        GridPane.setRowIndex(b4, 1);
        b4.setMnemonicParsing(false);
        b4.setPrefHeight(84.0);
        b4.setPrefWidth(117.0);
        b4.setFont(new Font("System Bold", 40.0));

        GridPane.setColumnIndex(b5, 1);
        GridPane.setRowIndex(b5, 1);
        b5.setMnemonicParsing(false);
        b5.setPrefHeight(123.0);
        b5.setPrefWidth(163.0);
        b5.setFont(new Font("System Bold", 40.0));

        GridPane.setColumnIndex(b6, 2);
        GridPane.setRowIndex(b6, 1);
        b6.setMnemonicParsing(false);
        b6.setPrefHeight(84.0);
        b6.setPrefWidth(101.0);
        b6.setFont(new Font("System Bold", 40.0));

        GridPane.setRowIndex(b7, 2);
        b7.setMnemonicParsing(false);
        b7.setPrefHeight(84.0);
        b7.setPrefWidth(124.0);
        b7.setFont(new Font("System Bold", 40.0));

        GridPane.setColumnIndex(b8, 1);
        GridPane.setRowIndex(b8, 2);
        b8.setMnemonicParsing(false);
        b8.setPrefHeight(130.0);
        b8.setPrefWidth(146.0);
        b8.setFont(new Font("System Bold", 40.0));

        GridPane.setColumnIndex(b9, 2);
        GridPane.setRowIndex(b9, 2);
        b9.setMnemonicParsing(false);
        b9.setPrefHeight(84.0);
        b9.setPrefWidth(101.0);
        b9.setFont(new Font("System Bold", 40.0));

        buttonBar.setPrefHeight(40.0);
        buttonBar.setPrefWidth(200.0);
        
        Player1abel1.setLayoutX(40.0);
        Player1abel1.setLayoutY(500.0);
        Player1abel1.setTextFill(javafx.scene.paint.Color.WHITE);
        Player1abel1.setFont(new Font("System Bold", 24.0));

        Playerlabel2.setLayoutX(650.0);
        Playerlabel2.setLayoutY(500.0);
        Playerlabel2.setTextFill(javafx.scene.paint.Color.WHITE);
        Playerlabel2.setFont(new Font("System Bold", 24.0));

        shape1.setLayoutX(70.0);
        shape1.setLayoutY(540.0);
        shape1.setTextFill(javafx.scene.paint.Color.WHITE);
        shape1.setFont(new Font("System Bold", 30.0));

        shape2.setLayoutX(680.0);
        shape2.setLayoutY(540.0);
        shape2.setPrefHeight(35.0);
        shape2.setPrefWidth(119.0);
        shape2.setTextFill(javafx.scene.paint.Color.WHITE);
        shape2.setFont(new Font("System Bold", 30.0));

        turn.setLayoutX(310.0);
        turn.setLayoutY(420.0);
        turn.setTextFill(javafx.scene.paint.Color.WHITE);
        turn.setFont(new Font(30.0));
        turn.setFont(new Font("System Bold", 30.0));
        
        getChildren().add(imageView);
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getChildren().add(b1);
        gridPane.getChildren().add(b2);
        gridPane.getChildren().add(b3);
        gridPane.getChildren().add(b4);
        gridPane.getChildren().add(b5);
        gridPane.getChildren().add(b6);
        gridPane.getChildren().add(b7);
        gridPane.getChildren().add(b8);
        gridPane.getChildren().add(b9);
        Player1abel1.setText("Player 1");
        Playerlabel2.setText("Player 2");
        turn.setText("Player 1 Turn");
        
        getChildren().add(gridPane);
        getChildren().add(buttonBar);
        getChildren().add(shape1);
        getChildren().add(shape2);
        getChildren().add(Player1abel1);
        getChildren().add(Playerlabel2);
        getChildren().add(turn);
        
        myplay = true;
        Player1Name = MultiplayerNameBase.Player1Name;
        Player2Name = MultiplayerNameBase.Player2Name;
        buttons = new Button[9];
        buttons[0] = b1;
        buttons[1] = b2;
        buttons[2] = b3;
        buttons[3] = b4;
        buttons[4] = b5;
        buttons[5] = b6;
        buttons[6] = b7;
        buttons[7] = b8;
        buttons[8] = b9;
        
        if(XOChoiceBase.symbol.equals("X")){
            Player1 = "X";
            Player2 = "O";
        }else{
           Player1 = "O";
           Player2 = "X"; 
        }
        
        shape1.setText(Player1);
        shape2.setText(Player2);
        
        b1.setOnAction((ActionEvent event) -> {
           whoIsTurn(b1,1);
        });
        
        b2.setOnAction((ActionEvent event) -> {
           whoIsTurn(b2,2);
        });
        
        b3.setOnAction((ActionEvent event) -> {
           whoIsTurn(b3,3);
        });
        
        b4.setOnAction((ActionEvent event) -> {
           whoIsTurn(b4,4);
        });
        
        b5.setOnAction((ActionEvent event) -> {
            whoIsTurn(b5,5);
        });
        
        b6.setOnAction((ActionEvent event) -> {
            whoIsTurn(b6,6);
        });
        
        b7.setOnAction((ActionEvent event) -> {
            whoIsTurn(b7,7);
        });
        
        b8.setOnAction((ActionEvent event) -> {
            whoIsTurn(b8,8);
        });
        
        b9.setOnAction((ActionEvent event) -> {
            whoIsTurn(b9,9);
        });
    }
    
    public void whoIsTurn(Button btn,int btnNum){
        if(myplay){
                btn.setText(Player1);
                player1.add(btnNum);
                myplay = false;
                btn.setDisable(true);
                turn.setText("Player 2 Turn");
            }else{
               btn.setText(Player2);
               player2.add(btnNum);
               myplay = true;
               btn.setDisable(true);
               turn.setText("Player 1 Turn");
            }
                      
            if(HasWinner() && IWon){
                WinningPlayer1Scene();
            }else{
                if(HasWinner() && !IWon){
                    WinningPlayer2Scene();
                }else if(!isMoveLeft()){
                    DrawScene();
                }
            }
    }
    
    public boolean isMoveLeft(){
        for(int i = 0; i < 9; i++){
            if(buttons[i].getText().equals("")){
                return true;
            }
        }
        player1Steps = Player1();
        player2Steps = Player2();
        return false;
    }
    
    public String Player1(){
        String Player1 = Arrays.toString(player1.toArray()).replace("[", "").replace("]", "").replace(",", "").replace(" ", "");
        return Player1;
    }
    
    public String Player2(){
        String Player2 = Arrays.toString(player2.toArray()).replace("[", "").replace("]", "").replace(",", "").replace(" ", "");
        return Player2;
    }
    
    public boolean CheckHorizontalWinning(){
        if(!(b1.getText().equals("")) && b1.getText().equals(b2.getText()) && b1.getText().equals(b3.getText())){
            if(b1.getText().equals(Player1)){
                IWon = true;
            }
            return true;
        }

        if(!(b4.getText().equals("")) && b4.getText().equals(b5.getText()) && b4.getText().equals(b6.getText())){
            if(b4.getText().equals(Player1)){
                IWon = true;
            }
            return true;
        }

        if(!(b7.getText().equals("")) && b7.getText().equals(b8.getText()) && b7.getText().equals(b9.getText())){
            if(b7.getText().equals(Player1)){
                IWon = true;
            }
            return true;
        }
        return false;
    }

    public boolean CheckVerticalWinning(){
        if(!(b1.getText().equals("")) && b1.getText().equals(b4.getText()) && b1.getText().equals(b7.getText())){
            if(b1.getText().equals(Player1)){
                IWon = true;
            }
            return true;
        }

        if(!(b2.getText().equals("")) && b2.getText().equals(b5.getText()) &&  b2.getText().equals(b8.getText())){
            if(b2.getText().equals(Player1)){
                IWon = true;
            }
            return true;
        }

        if(!(b3.getText().equals("")) && b3.getText().equals(b6.getText()) &&  b3.getText().equals(b9.getText())){
            if(b3.getText().equals(Player1)){
                IWon = true;
            }
            return true;
        }
        return false;
    }

    public boolean CheckDiagonalWinning(){
        if(!(b1.getText().equals("")) && b1.getText().equals(b5.getText()) && b1.getText().equals(b9.getText())){
            if(b1.getText().equals(Player1)){
                IWon = true;
            }
            return true;
        }
        
        if(!(b3.getText().equals("")) && b3.getText().equals(b5.getText()) && b3.getText().equals(b7.getText())){
            if(b3.getText().equals(Player1)){
                IWon = true;
            }
            return true; 
        }
        return false;
    }

    public boolean HasWinner(){
        if(CheckHorizontalWinning() || CheckDiagonalWinning() || CheckVerticalWinning())
        {
            player1Steps = Player1();
            player2Steps = Player2();
            return true;
        }
       return false;
    }
    
    private void WinningPlayer1Scene(){
        StoreDB();
        WinningPlayer1Base root = new WinningPlayer1Base();
        Scene scene = new Scene(root);
        stage = (Stage)getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
            
    private void WinningPlayer2Scene(){
        StoreDB();
        WinningPlayer2Base root = new WinningPlayer2Base();
        Scene scene = new Scene(root);
        stage = (Stage)getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    private void DrawScene(){
        StoreDB();
        DrawBase root =  new DrawBase();
        Scene scene = new Scene(root);
        Stage stage = (Stage)b1.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
        
    private void StoreDB(){
        try{
            game_id =ox_database.storePlayer1_name( Player1Name);
            ox_database.storePlayer2_name( Player2Name,game_id);
            ox_database.storeSteps(Player1Name,Player1 ,player1Steps, 1 ,game_id);
            ox_database.storeSteps(Player2Name, Player2, player2Steps, 2,game_id);
        }catch(SQLException ex){
            Logger.getLogger(MultiOfflineGameBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }         
}
    
