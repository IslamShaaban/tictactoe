package tictactoe.LoadGames;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import tictactoe.GameStatus.*;
import static tictactoe.GameStatus.DrawBase.changeScene;
import tictactoe.XODataBase.ox_database;

public class LoadGameBase extends AnchorPane implements Runnable {

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
    private Thread th;
    private int count;
    private boolean flag;
    private ArrayList<String> myArr=new ArrayList<>();   //string 
    private ArrayList<Integer>Plays;       //integer 
    private String GamePlays;
    private String firstSymbol;
    private String secondSymbol;
    private String firstName;
    //private String secondname;
    private boolean IWon;
    private Stage stage;
    ResultSet rs=null;
    String steps = new String();
    String [] playerSteps = new String[2];
    public int ID;
    
    public LoadGameBase(String str) {

        ID = Integer.valueOf(str);
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
        th = new Thread(this);
        count = 1;
        Plays = new ArrayList<>();
        IWon = false;
        flag = true;
        
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
        
        th.start();
    }
    
    @Override
    public void run(){
        
        Connection con = null;
        Statement stmt = null ;
        try{
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tictactoe","root",ox_database.password);
            stmt = con.createStatement() ;
            String insertestring = new String("SELECT player_name,player_ch,player_steps,first_player FROM tictactoe.steps WHERE game_id ='"+ID+"'");
            rs= stmt.executeQuery(insertestring);

            int x=0;
            while(rs.next()){
            if(rs.getInt(4)==1 && x==0){
                firstName=rs.getString(1);
                playerSteps[0]=rs.getString(3);
                firstSymbol = rs.getString(2);
                if(firstSymbol.equals("X") || firstSymbol.equals("x") ){
                    secondSymbol = "O";
                }else{
                    secondSymbol = "X";}

            }else if(rs.getInt(4)==2 && x==0){
                playerSteps[1]=rs.getString(3);
                secondSymbol = rs.getString(2);
                if(secondSymbol.equals("X") || secondSymbol.equals("x")){
                    firstSymbol = "O";
                }
                else{firstSymbol = "X";
                }

            }if(x==1){
                if(rs.getInt(4)==2){
                    playerSteps[1]=rs.getString(3);
                }else{
                    playerSteps[0]=rs.getString(3);
                    firstName=rs.getString(1);
                }
            }
             x++;
            }
            char[] ch = new char[playerSteps[0].length()]; 
            String []step= new String[playerSteps[0].length()]; 

            for(int j=0;j<playerSteps[0].length();j++){
                ch[j]= playerSteps[0].charAt(j);          
                step[j]=Character.toString(ch[j]); 
            }

            char[] ch1= new char[playerSteps[1].length()]; 
            String []step1= new String[playerSteps[1].length()]; 

            for(int j=0;j<playerSteps[1].length();j++){
               ch1[j]= playerSteps[1].charAt(j);          
               step1[j]=Character.toString(ch1[j]); 
            }

            int length =(playerSteps[0].length()<playerSteps[1].length())?playerSteps[0].length():playerSteps[1].length();

            for(int index=0 ; index<length ; index++){
                 myArr.add(step[index]); 
                 myArr.add(step1[index]);
            }    

            if(playerSteps[0].length()!=playerSteps[1].length()){
                String lastel=playerSteps[0].length()>playerSteps[1].length()?step[length]:step1[length];
                myArr.add(lastel);
            }

        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        for(String s: myArr){
            Plays.add(Integer.parseInt(s));
        }
        
            threadSleep();
            for(int i: Plays){
                switch(i){
                    case 1:
                        switchCaseCode(b1);
                        break;
                    case 2:
                        switchCaseCode(b2);
                        break;
                    case 3:
                        switchCaseCode(b3);
                        break;
                    case 4:
                        switchCaseCode(b4);
                        break;
                    case 5:
                        switchCaseCode(b5);
                        break;
                    case 6:
                        switchCaseCode(b6);
                        break;
                    case 7:
                        switchCaseCode(b7);
                        break;
                    case 8:
                        switchCaseCode(b8);
                        break;
                    case 9:
                        switchCaseCode(b9);
                        break;
                }
            }
        Platform.runLater(()->{
            sceneHandler();
        });
        
        try {
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoadGameBase.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }

    public void switchCaseCode(Button btn){
       Platform.runLater(()->{
       if(count % 2 != 0){
            btn.setStyle("-fx-font-size: 3em");
            btn.setText(firstSymbol);
            btn.setDisable(true);
        }else{
            btn.setStyle("-fx-font-size: 3em");
            btn.setText(secondSymbol);
            btn.setDisable(true);
        }
        count++;
       });
       threadSleep();
    }
        
    public boolean CheckHorizontalWinning(){
        if(!(b1.getText().equals("")) && b1.getText().equals(b2.getText()) && b1.getText().equals(b3.getText())){
            if(b1.getText().equals(firstSymbol)){
                IWon = true;
            }     
          return true;
        }

        if(!(b4.getText().equals("")) && b4.getText().equals(b5.getText()) && b4.getText().equals(b6.getText())){
            if(b4.getText().equals(firstSymbol)){
                IWon = true;
                System.out.println("winner "+firstName);
            }
            return true;
        }

        if(!(b7.getText().equals("")) && b7.getText().equals(b8.getText()) && b7.getText().equals(b9.getText())){
            if(b7.getText().equals(firstSymbol)){
                IWon = true;
            }
            return true;
        }
        return false;
    }

    public boolean CheckVerticalWinning(){
        if(!(b1.getText().equals("")) && b1.getText().equals(b4.getText()) && b1.getText().equals(b7.getText())){
            if(b1.getText().equals(firstSymbol)){
                IWon = true;
            }
            return true;
        }

        if(!(b2.getText().equals("")) && b2.getText().equals(b5.getText()) &&  b2.getText().equals(b8.getText())){
            if(b2.getText().equals(firstSymbol)){
                IWon = true;
            }
            return true;
        }

        if(!(b3.getText().equals("")) && b3.getText().equals(b6.getText()) &&  b3.getText().equals(b9.getText())){
            if(b3.getText().equals(firstSymbol)){
                IWon = true;
            }
            return true;
        }
        return false;
    }

    public boolean CheckDiagonalWinning(){
        if(!(b1.getText().equals("")) && b1.getText().equals(b5.getText()) && b1.getText().equals(b9.getText())){
            if(b1.getText().equals(firstSymbol)){
                IWon = true;
            }
            return true;
        }
        
        if(!(b3.getText().equals("")) && b3.getText().equals(b5.getText()) && b3.getText().equals(b7.getText())){
            if(b3.getText().equals(firstSymbol)){
                IWon = true;
            }
            return true; 
        }
        return false;
    }

    public boolean HasWinner(){
        if(CheckHorizontalWinning() || CheckDiagonalWinning() || CheckVerticalWinning()){
            return true;
        }
        return false;
    }
        
    public void WinningScene(){        
        WinningSavedBase root = new WinningSavedBase();
        Scene scene = new Scene(root);
        stage = (Stage)b1.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
            
    public void LosingScene(){        
        LosingSavedBase root = new LosingSavedBase();
        Scene scene = new Scene(root);
        stage = (Stage)b1.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    public void DrawScene(){
        DrawBase root = new DrawBase();
        Scene scene = new Scene(root);
        stage = (Stage)getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    public void threadSleep(){
        try {
            th.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(LoadGameBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sceneHandler(){
        try{
            if(HasWinner() && IWon){
                WinningSavedBase root = new WinningSavedBase();
                changeScene(b1,root);
            }else if(HasWinner() && !IWon){
                LosingSavedBase root = new LosingSavedBase();
                changeScene(b1,root);
            }else{
                DrawBase root = new DrawBase();
                changeScene(b1,root);
            }
        }catch(IllegalStateException e){
            e.printStackTrace();
        }
    }
}
