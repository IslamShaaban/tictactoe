package tictactoe.Games.Singleplayer;

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
import tictactoe.GameStatus.*;
import tictactoe.SignInUp.*;
import tictactoe.XODataBase.ox_database;

public class HardComGameBase extends AnchorPane {
    
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
    protected final Button[] buttons;
    protected final ButtonBar buttonBar;
    private   final ArrayList<Integer>playerSteps;
    private   final ArrayList<Integer>computerSteps;
    private final String playerName, computerName, computerSymbol, playerSymbol;
    private String playersteps, computersteps;
    private Stage stage;
    private boolean turn, finish;
    private String winnerChar;
    protected final Label Player1abel1;
    protected final Label Playerlabel2;
    protected final Label shape1;
    protected final Label shape2;

    public HardComGameBase() {
        
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
        
        Player1abel1 = new Label();
        Playerlabel2 = new Label();
        shape1 = new Label();
        shape2 = new Label();
                
        buttonBar = new ButtonBar();
        turn = true;
        finish = false;
        playerSteps = new ArrayList<>();
        computerSteps = new ArrayList<>();
        
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
        b8.setFont(new Font("System Italic Bold", 40.0));

        GridPane.setColumnIndex(b9, 2);
        GridPane.setRowIndex(b9, 2);
        b9.setMnemonicParsing(false);
        b9.setPrefHeight(84.0);
        b9.setPrefWidth(101.0);
        b9.setFont(new Font("System Italic Bold", 40.0));

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
        shape1.setLayoutX(50.0);
        shape1.setLayoutY(540.0);
        shape1.setTextFill(javafx.scene.paint.Color.WHITE);
        shape1.setFont(new Font("System Bold", 30.0));
        shape2.setLayoutX(700.0);
        shape2.setLayoutY(540.0);
        shape2.setPrefHeight(35.0);
        shape2.setPrefWidth(119.0);
        shape2.setTextFill(javafx.scene.paint.Color.WHITE);
        shape2.setFont(new Font("System Bold", 30.0));
        
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
        getChildren().add(gridPane);
        getChildren().add(buttonBar);
        getChildren().add(shape1);
        getChildren().add(shape2);
        getChildren().add(Player1abel1);
        getChildren().add(Playerlabel2);
   
        playerName = SignInBase.userName;
        
        computerName = "Computer";
         
        if(XOChoiceBase.symbol.equals("X")){ 
            computerSymbol="O";
            playerSymbol="X";
        }else{
            computerSymbol="X";
            playerSymbol="O";
        }
        
        Player1abel1.setText("You");
        Playerlabel2.setText("Computer");
        shape1.setText(playerSymbol);
        shape2.setText(computerSymbol);

        b1.setOnAction((ActionEvent event) -> {
            HardButtonCode(b1,1);
        });
        
        b2.setOnAction((ActionEvent event) -> {
            HardButtonCode(b2,2);
        });
        
        b3.setOnAction((ActionEvent event) -> {
            HardButtonCode(b3,3);
        });
        
        b4.setOnAction((ActionEvent event) -> {
            HardButtonCode(b4,4);
        });
        
        b5.setOnAction((ActionEvent event) -> {
            HardButtonCode(b5,5);
        });
        
        b6.setOnAction((ActionEvent event) -> {
            HardButtonCode(b6,6);
        });
        
        b7.setOnAction((ActionEvent event) -> {
            HardButtonCode(b7,7);
        });
        
        b8.setOnAction((ActionEvent event) -> {
            HardButtonCode(b8,8);
        });
        
        b9.setOnAction((ActionEvent event) -> {
            HardButtonCode(b9,9);
        });
    }
    
    public void HardButtonCode(Button btn,int i){
        if(turn && !finish){
            buttonAction(btn, i, playerSymbol);
        }

        if(!checkboard() && isMovesLeft() && !turn){
            computerPlay();
            turn = true;
        }
        sceneHandler();
    }
    
    public int makeMove(){
        int i = 0;
        int bestScore = Integer.MIN_VALUE;
        for (int l = 0; l < 9; l++){
            if(buttons[l].getText().equals("")){
                buttons[l].setText(computerSymbol);
                int  score = minimax(buttons, 0, false);
                buttons[l].setText("");
                if (score > bestScore){
                    bestScore = score;
                    i = l;
                }
            }
        }
        return i;
    }
    
    public int minimax(Button[] buttons, int depth, boolean isMaximizing){
        
        if(checkboard() && winnerChar.equals(computerSymbol)){
            return 10;
        }
        
        if(checkboard() && winnerChar.equals(playerSymbol)){
            return -10;
        }
        
        if(!isMovesLeft()){
            return 0;
        }
        
        int bestScore;
        int score;
        
        if(isMaximizing){
            bestScore = Integer.MIN_VALUE;
            for (int l = 0; l < 9; l++){
                if(buttons[l].getText().equals("")){
                    buttons[l].setText(computerSymbol);
                    score = minimax(buttons, depth+1, false);
                    buttons[l].setText("");
                    bestScore = Math.max(score, bestScore);
                }
            }
            return bestScore;
        }else{
            bestScore = Integer.MAX_VALUE;
            for (int l = 0; l < 9; l++){
                if(buttons[l].getText().equals("")){
                    buttons[l].setText(playerSymbol);
                    score = minimax(buttons, depth+1, true);
                    buttons[l].setText("");
                    bestScore = Math.min(score, bestScore);
                }
            }
            return bestScore;
        }  
    }
    
    public boolean checkboard(){
        boolean retval = false;
        if( b1.getText().equals(b4.getText()) && b1.getText().equals(b7.getText()) && !(b1.getText().equals(""))){
            winnerChar = new String(b1.getText());
            retval=true;
        }else if( b2.getText().equals(b5.getText()) && b2.getText().equals(b8.getText())&& !(b2.getText().equals(""))){
            winnerChar = new String(b2.getText());
            retval=true;
        }else if( b3.getText().equals(b6.getText()) &&b3.getText().equals(b9.getText())&& !(b3.getText().equals(""))){
            winnerChar = new String(b3.getText());
            retval=true;
        }else if( b1.getText().equals(b3.getText()) && b1.getText().equals(b2.getText())&& !(b1.getText().equals(""))){
            winnerChar = new String(b1.getText()); 
            retval=true;
        }else if( b4.getText().equals(b5.getText()) && b5.getText().equals(b6.getText())&& !(b4.getText().equals(""))){
            winnerChar = new String(b4.getText());
            retval=true;
        }else if( b7.getText().equals(b8.getText()) &&b7.getText().equals(b9.getText())&& !(b7.getText().equals(""))){
            winnerChar = new String(b7.getText()); 
            retval=true;
        }else if( b1.getText().equals(b5.getText()) && b1.getText().equals(b9.getText())&& !(b1.getText().equals(""))){
            winnerChar = new String(b1.getText()); 
            retval=true;  
        }else if( b3.getText().equals(b5.getText()) && b3.getText().equals(b7.getText())&& !(b3.getText().equals(""))){
            winnerChar = new String(b3.getText());
            retval=true;
        }
        finish = retval; 
        return retval;
    }
    
    public void computerPlay(){
        switch(makeMove()){
            case 0:
                buttonChange(b1, computerSymbol);
                computerSteps.add(1);
                break;
            case 1:
                buttonChange(b2, computerSymbol);
                computerSteps.add(2);
                break;
            case 2:
                buttonChange(b3, computerSymbol);
                computerSteps.add(3);
                break;
            case 3:
                buttonChange(b4, computerSymbol);
                computerSteps.add(4);
                break;
            case 4:
                buttonChange(b5, computerSymbol);
                computerSteps.add(5);
                break;
            case 5:
                buttonChange(b6, computerSymbol);
                computerSteps.add(6);
                break;
            case 6:
                buttonChange(b7, computerSymbol);
                computerSteps.add(7);
                break; 
            case 7:
                buttonChange(b8, computerSymbol);
                computerSteps.add(8);
                break;
            case 8:
                buttonChange(b9, computerSymbol);
                computerSteps.add(9);
                break;       
        }
    }
    
    public void sceneHandler(){
        if(checkboard() == true ){
            if(winnerChar.equals(playerSymbol))
            {
            //smily face appear
                playersteps = playerSteps();
                computersteps = computerSteps();
                WinningScene();  
            }else  //if Computer is win
            {
              //sad face appear 
                playersteps = playerSteps();
                computersteps = computerSteps();
                LosingScene();
            }
        }
                //if turn not equal true then it turn 
        else if(!isMovesLeft()){
            playersteps = playerSteps();
            computersteps = computerSteps();
            DrawScene();
        }   
    }
    
    public Boolean isMovesLeft(){
        for (int i = 0; i < 9; i++){ 
            if (buttons[i].getText().equals("")){   
                return true;
            }
        }
        return false;
    }
    
    public String playerSteps(){
        String s = Arrays.toString(playerSteps.toArray()).replace("[","").replace("]", "").replace(" ", "").replace(",","");
        return s;
    }
    
    public String computerSteps(){
        String s = Arrays.toString(computerSteps.toArray()).replace("[","").replace("]", "").replace(" ", "").replace(",","");
        return s;
    }
    
    public void WinningScene(){
        StoreDB();
        WinningBase root = new WinningBase();
        Scene scene = new Scene(root);
        stage = (Stage)getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
            
    public void LosingScene(){
        StoreDB();
        LosingBase root = new LosingBase();
        Scene scene = new Scene(root);
        stage = (Stage)getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    public void DrawScene(){
        StoreDB();
        DrawBase root =  new DrawBase();
        Scene scene = new Scene(root);
        Stage stage = (Stage)b1.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    public void buttonAction(Button btn ,int i,String symbol){
        playerSteps.add(i); //array-list
        btn.setStyle("-fx-font-size: 3em");
        btn.setText(playerSymbol);
        btn.setDisable(true);
        turn=false;
    }
    
    public void buttonChange(Button btn, String symbol){
        btn.setStyle("-fx-text-fill: #0000ff;-fx-font-size: 3em");
        btn.setText(symbol);
        btn.setDisable(true);
    }
    
    private void StoreDB(){
        try{
           int game_id = ox_database.storePlayer1_name(playerName); // Logger.getLogger(Eas/yComGameBase.class.getName()).log(Level.SEVERE, null, ex);
           ox_database.storePlayer2_name( computerName,game_id);
           ox_database.storeSteps(playerName,playerSymbol ,playersteps, 1 ,game_id);
           ox_database.storeSteps(computerName, computerSymbol, computersteps, 2,game_id);
           System.out.println(playerName);
        }catch(SQLException ex){
           Logger.getLogger(HardComGameBase.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}