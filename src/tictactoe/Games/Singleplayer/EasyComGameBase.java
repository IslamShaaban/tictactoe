package tictactoe.Games.Singleplayer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import tictactoe.PlaysChoice.*;
import tictactoe.GameStatus.*;
import static tictactoe.GameStatus.DrawBase.changeScene;
import tictactoe.SignInUp.*;
import tictactoe.XODataBase.ox_database;

public class EasyComGameBase extends AnchorPane{
        
    boolean turn= true;
    String winnerChar;     
    ArrayList<Integer> playerSteps= new ArrayList<>();
    ArrayList<Integer> computerSteps= new ArrayList<>();
    String playersteps, computersteps;
    boolean finish = false;
   
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
    private   final String playerName, computerName, computerSymbol, playerSymbol;
    private int  game_id;
    protected final Label Player1abel1;
    protected final Label Playerlabel2;
    protected final Label shape1;
    protected final Label shape2;
    
    public EasyComGameBase() {
        
        playerName = SignInBase.userName;
        computerName = "Computer";
        Player1abel1 = new Label();
        Playerlabel2 = new Label();
        shape1 = new Label();
        shape2 = new Label();
         
        if(XOChoiceBase.symbol.equals("X")){ 
            computerSymbol="O";
            playerSymbol="X";
        }else{
            computerSymbol="X";
            playerSymbol="O";
        }
        
        shape1.setText(playerSymbol);
        shape2.setText(computerSymbol);
        Player1abel1.setText("You");
        Playerlabel2.setText("Computer");
        
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

        GridPane.setColumnIndex(b2, 1);
        b2.setMnemonicParsing(false);
        b2.setPrefHeight(85.0);
        b2.setPrefWidth(104.0);

        GridPane.setColumnIndex(b3, 2);
        b3.setMnemonicParsing(false);
        b3.setPrefHeight(88.0);
        b3.setPrefWidth(101.0);

        GridPane.setRowIndex(b4, 1);
        b4.setMnemonicParsing(false);
        b4.setPrefHeight(84.0);
        b4.setPrefWidth(117.0);

        GridPane.setColumnIndex(b5, 1);
        GridPane.setRowIndex(b5, 1);
        b5.setMnemonicParsing(false);
        b5.setPrefHeight(123.0);
        b5.setPrefWidth(163.0);

        GridPane.setColumnIndex(b6, 2);
        GridPane.setRowIndex(b6, 1);
        b6.setMnemonicParsing(false);
        b6.setPrefHeight(84.0);
        b6.setPrefWidth(101.0);

        GridPane.setRowIndex(b7, 2);
        b7.setMnemonicParsing(false);
        b7.setPrefHeight(84.0);
        b7.setPrefWidth(124.0);

        GridPane.setColumnIndex(b8, 1);
        GridPane.setRowIndex(b8, 2);
        b8.setMnemonicParsing(false);
        b8.setPrefHeight(130.0);
        b8.setPrefWidth(146.0);

        GridPane.setColumnIndex(b9, 2);
        GridPane.setRowIndex(b9, 2);
        b9.setMnemonicParsing(false);
        b9.setPrefHeight(84.0);
        b9.setPrefWidth(101.0);

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

        b1.setOnAction((ActionEvent event) -> {
            buttonCode(b1,1);
        });

        b2.setOnAction((ActionEvent event) -> {
            buttonCode(b2,2);
        });
          
        b3.setOnAction((ActionEvent event) -> {
            buttonCode(b3,3);
        });
        
        b4.setOnAction((ActionEvent event) -> {
            buttonCode(b4,4);
        });
         
        b5.setOnAction((ActionEvent event) -> {
            buttonCode(b5,5);
        });         
        
        b6.setOnAction((ActionEvent event) -> {
            buttonCode(b6,6);
        });         
        b7.setOnAction((ActionEvent event) -> {
            buttonCode(b7,7);
        }); 
        
        b8.setOnAction((ActionEvent event) -> {
            buttonCode(b8,8);
        }); 
        
        b9.setOnAction((ActionEvent event) -> {
            buttonCode(b9,9);
        });        
    }
    
    public void buttonCode(Button btn,int i){
        if(turn == true && finish == false){//player can play
                playerSteps.add(i); //array-list
                btn.setStyle("-fx-font-size: 3em");
                btn.setText(playerSymbol);//Sybmol is X or O depend on his Choice from XOChoice page
                btn.setDisable(true);
                turn=false;//computer can play
            }
            
            if( checkboard() == false && EmptyPosition()== true && turn == false){
                computerRole();
                turn = true;
            }
            
            if(checkboard() == true ){
                if(winnerChar.equals(playerSymbol)){
                    playersteps = playerSteps();
                    computersteps = computerSteps();
                    storeDB();
                    WinningBase root =  new WinningBase();
                    changeScene(btn,root);
                }
                else{  //if Computer is win
                    playersteps = playerSteps();
                    computersteps = computerSteps();
                    storeDB();
                    LosingBase root =  new LosingBase();
                    changeScene(btn,root);
                }
                //if turn not equal true then it turn
            }else if(!EmptyPosition()){
                playersteps = playerSteps();
                computersteps = computerSteps();
                storeDB();
                DrawBase root =  new DrawBase();
                changeScene(btn,root);
            }
    }
    
    public boolean checkboard(){
        boolean retval=false;
                
        if( b1.getText().equals(b4.getText()) && b1.getText().equals(b7.getText()) && !(b1.getText().equals(""))){
            winnerChar = new String(b1.getText());
            retval=true;
        }

        else if( b2.getText().equals(b5.getText()) && b2.getText().equals(b8.getText())&& !(b2.getText().equals(""))){
            winnerChar = new String(b2.getText());
            retval=true;
        }

        else if( b3.getText().equals(b6.getText()) &&b3.getText().equals(b9.getText())&& !(b3.getText().equals(""))){
            winnerChar = new String(b3.getText());
            retval=true;
        }
   
        else if( b1.getText().equals(b3.getText()) && b1.getText().equals(b2.getText())&& !(b1.getText().equals(""))){
            winnerChar = new String(b1.getText()); 
            retval=true;
        }

        else if( b4.getText().equals(b5.getText()) && b5.getText().equals(b6.getText())&& !(b4.getText().equals(""))){
            winnerChar = new String(b4.getText());
            retval=true;
        }
        
        else if( b7.getText().equals(b8.getText()) &&b7.getText().equals(b9.getText())&& !(b7.getText().equals(""))){

            winnerChar = new String(b7.getText()); 
            retval=true;
        }
   
        else if( b1.getText().equals(b5.getText()) && b1.getText().equals(b9.getText())&& !(b1.getText().equals(""))){
            winnerChar = new String(b1.getText()); 
            retval=true;
        }

        else if( b3.getText().equals(b5.getText()) && b3.getText().equals(b7.getText())&& !(b3.getText().equals(""))){
            winnerChar = new String(b3.getText());
            retval=true;
        }

        finish = retval; 
        return retval;
    }

    public boolean  EmptyPosition(){
      boolean retval1=true; 
      if((playerSteps.size() + computerSteps.size()) == 9){
          retval1=false;
      }      
      return retval1;  
    }
    
    public void computerRole(){
        ArrayList<Integer> emptyPostions= new ArrayList<Integer>();
        int postion;
        boolean flag = false;
        for(int i=1 ; i <= 9 ; i++){
            for(int value : playerSteps){
                if(value == i){flag = true;}
            }
       
            if(flag == false){   
                for(int value2 : computerSteps){
                    if(value2 == i){flag = true;}
                }
            }
            
            if(flag == false){
                emptyPostions.add(i);
            }
            flag = false;
        }
        
        postion = emptyPostions.get(new Random().nextInt(emptyPostions.size()));
        computerPlay(postion);
        computerSteps.add(postion);
        turn = true; 
    }
    
    public void computerPlay(int pos){
        switch(pos){
            case 1:
                   b1.setStyle("-fx-text-fill: #0000ff;-fx-font-size: 3em");
                   b1.setText(computerSymbol);
                   b1.setDisable(true);
                   break;
            case 2:
                   b2.setStyle("-fx-text-fill: #0000ff;-fx-font-size: 3em");
                   b2.setText(computerSymbol);
                   b2.setDisable(true);
                   break;
            case 3:
                   b3.setStyle("-fx-text-fill: #0000ff;-fx-font-size: 3em");
                   b3.setText(computerSymbol);
                   b3.setDisable(true);
                   break;
            case 4:
                   b4.setStyle("-fx-text-fill: #0000ff;-fx-font-size: 3em");
                   b4.setText(computerSymbol);
                   b4.setDisable(true);
                   break;
            case 5:
                   b5.setStyle("-fx-text-fill: #0000ff;-fx-font-size: 3em");
                   b5.setText(computerSymbol);
                   b5.setDisable(true);
                   break;
            case 6:
                   b6.setStyle("-fx-text-fill: #0000ff;-fx-font-size: 3em");
                   b6.setText(computerSymbol);
                   b6.setDisable(true);
                   break;
            case 7:
                   b7.setStyle("-fx-text-fill: #0000ff;-fx-font-size: 3em");
                   b7.setText(computerSymbol);
                   b7.setDisable(true);
                   break; 
            case 8:
                   b8.setStyle("-fx-text-fill: #0000ff;-fx-font-size: 3em");
                   b8.setText(computerSymbol);
                   b8.setDisable(true);
                   break;
            case 9:
                   b9.setStyle("-fx-text-fill: #0000ff;-fx-font-size: 3em");
                   b9.setText(computerSymbol);
                   b9.setDisable(true);
                   break;       
            }
    }   
    
    public String playerSteps(){
        String s = Arrays.toString(playerSteps.toArray()).replace("[","").replace("]", "").replace(" ", "").replace(",","");
        return s;
    }
    
    public String computerSteps(){
        String s = Arrays.toString(computerSteps.toArray()).replace("[","").replace("]", "").replace(" ", "").replace(",","");
        return s;
    }
   
    private void storeDB(){
        try {
            game_id =ox_database.storePlayer1_name( playerName);
            ox_database.storePlayer2_name( computerName,game_id);
            ox_database.storeSteps(playerName, playerSymbol,playersteps, 1 ,game_id);
            ox_database.storeSteps(computerName, computerSymbol,computersteps, 2,game_id);
        } catch (SQLException ex) {
            Logger.getLogger(EasyComGameBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}