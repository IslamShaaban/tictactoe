package tictactoe.Games.Multiplayer.Network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EventObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.DialogEvent;
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
import javafx.stage.WindowEvent;
import tictactoe.GameStatus.*;
import static tictactoe.GameStatus.DrawBase.changeScene;
import tictactoe.PlaysChoice.*;
import tictactoe.SignInUp.SignInBase;
import tictactoe.XODataBase.ox_database;

public class OnlineGame extends AnchorPane implements Runnable{

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
    private String playerName , opponentName, playerSymbol, opponentSymbol;
    protected ArrayList<Integer> Hoster;
    protected ArrayList<Integer> Connector;
    public static Socket PlayerSocket;
    private   Button[] buttons;
    protected DataOutputStream PlayerOutputSocket;
    protected DataInputStream PlayerInputSocket;
    private Stage stage;
    private boolean IWon;
    Thread th = new Thread(this);
    protected final Label Player1abel1;
    protected final Label Playerlabel2;
    protected final Label shape1;
    protected final Label shape2;
    protected final Label turn;

    public OnlineGame() {

        Hoster = new ArrayList<>();
        Connector = new ArrayList<>();
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
        turn = new Label();
        IWon = false;

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
        gridPane.setDisable(true);

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
        
        turn.setLayoutX(295.0);
        turn.setLayoutY(420.0);
        turn.setTextFill(javafx.scene.paint.Color.WHITE);
        turn.setFont(new Font(30.0));
        turn.setFont(new Font("System Bold", 30.0));
        turn.setText("Opponent Turn");
        
        Player1abel1.setText("You");
        Playerlabel2.setText("Opponent");

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
        getChildren().add(turn);
        playerSymbol = XOChoiceBase.symbol;

        if (XOChoiceBase.symbol.equals("X")) {
            playerSymbol = "X";
            opponentSymbol = "O";
        } else {
            playerSymbol = "O";
            opponentSymbol = "X";
        }
        playerName = SignInBase.userName;
        shape1.setText(playerSymbol);
        shape2.setText(opponentSymbol);
        try {
            if (HostConnectBase.host == 0) {
                PlayerSocket = new Socket(InetAddress.getLocalHost(), 5000);
                PlayerOutputSocket = new DataOutputStream(PlayerSocket.getOutputStream());
                PlayerOutputSocket.writeUTF(playerName);
            } else if (HostConnectBase.flag == true) {
                GameServer gameServer = new GameServer();
                HostConnectBase.flag = false;
                gridPane.setDisable(false);
                turn.setLayoutX(330.0);
                turn.setLayoutY(420.0);
                turn.setText("Your Turn");
                PlayerSocket = gameServer.socket;
                PlayerInputSocket = new DataInputStream(PlayerSocket.getInputStream());
                opponentName = PlayerInputSocket.readUTF();
            }
            PlayerInputSocket = new DataInputStream(PlayerSocket.getInputStream());
            PlayerOutputSocket = new DataOutputStream(PlayerSocket.getOutputStream());
        } catch (IOException | NullPointerException e) {
            showAlert();
        }

        b1.setOnAction((ActionEvent event) -> {
            buttonAction(b1,1,playerSymbol); 
        });

        b2.setOnAction((ActionEvent event) -> {
            buttonAction(b2,2,playerSymbol);
        });

        b3.setOnAction((ActionEvent event) -> {
            buttonAction(b3,3,playerSymbol); 
        });

        b4.setOnAction((ActionEvent event) -> {
            buttonAction(b4,4,playerSymbol); 
        });

        b5.setOnAction((ActionEvent event) -> {
            buttonAction(b5,5,playerSymbol); 
        });

        b6.setOnAction((ActionEvent event) -> {
            buttonAction(b6,6,playerSymbol);
        });

        b7.setOnAction((ActionEvent event) -> {
            buttonAction(b7,7,playerSymbol); 
        });

        b8.setOnAction((ActionEvent event) -> {
            buttonAction(b8,8,playerSymbol); 
        });

        b9.setOnAction((ActionEvent event) -> {
            buttonAction(b9,9,playerSymbol);
        });
               
        th.start();
    }

    public boolean CheckHorizontalWinning() {
        if (!(b1.getText().equals("")) && b1.getText().equals(b2.getText()) && b1.getText().equals(b3.getText())) {
            if (b1.getText().equals(playerSymbol)) {
                IWon = true;
            }
            return true;
        }

        if (!(b4.getText().equals("")) && b4.getText().equals(b5.getText()) && b4.getText().equals(b6.getText())) {
            if (b4.getText().equals(playerSymbol)) {
                IWon = true;
            }
            return true;
        }

        if (!(b7.getText().equals("")) && b7.getText().equals(b8.getText()) && b7.getText().equals(b9.getText())) {
            if (b7.getText().equals(playerSymbol)) {
                IWon = true;
            }
            return true;
        }

        return false;
    }

    public boolean CheckVerticalWinning() {
        if (!(b1.getText().equals("")) && b1.getText().equals(b4.getText()) && b1.getText().equals(b7.getText())) {
            if (b1.getText().equals(playerSymbol)) {
                IWon = true;
            }
            return true;
        }

        if (!(b2.getText().equals("")) && b2.getText().equals(b5.getText()) && b2.getText().equals(b8.getText())) {
            if (b2.getText().equals(playerSymbol)) {
                IWon = true;
            }
            return true;
        }

        if (!(b3.getText().equals("")) && b3.getText().equals(b6.getText()) && b3.getText().equals(b9.getText())) {
            if (b3.getText().equals(playerSymbol)) {
                IWon = true;
            }
            return true;
        }
        return false;
    }

    public boolean CheckDiagonalWinning() {
        if (!(b1.getText().equals("")) && b1.getText().equals(b5.getText()) && b1.getText().equals(b9.getText())) {
            if (b1.getText().equals(playerSymbol)) {
                IWon = true;
            }
            return true;
        }

        if (!(b3.getText().equals("")) && b3.getText().equals(b5.getText()) && b3.getText().equals(b7.getText())) {
            if (b3.getText().equals(playerSymbol)) {
                IWon = true;
            }
            return true;
        }
        return false;
    }

    public boolean HasWinner() {
        return CheckHorizontalWinning() || CheckDiagonalWinning() || CheckVerticalWinning();
    }

    public void WinningScene() {
        if(HostConnectBase.host==1){
            StoreDB();
        }
        WinningBase root = new WinningBase();
        Scene scene = new Scene(root);
        stage = (Stage) getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    public boolean isMovesLeft(){
        for(int i = 0; i < 9; i++){
            if(buttons[i].getText().equals("")){
                return true;
            }
        }
        return false;
    }
    
    public void LosingScene() {
        if(HostConnectBase.host==1){
            StoreDB();
        }
        LosingBase root = new LosingBase();
        Scene scene = new Scene(root);
        stage = (Stage) getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void DrawScene() {
        if(HostConnectBase.host==1){
            StoreDB();
        }
        DrawBase root = new DrawBase();
        Scene scene = new Scene(root);
        stage = (Stage) getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
//    public void close(){
//        try {
//            PlayerInputSocket.close();
//            PlayerOutputSocket.close();
//        } catch (IOException ex) {
//            Logger.getLogger(OnlineGame.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    @Override
    public void run() {

        while (true) {
            try {
                int btn_choiced = PlayerInputSocket.readInt();
                switch (btn_choiced) {
                    case 0:
                        buttonAction(b1,1,opponentSymbol);
                        break;

                    case 1:
                        buttonAction(b2,2,opponentSymbol);
                        break;

                    case 2:
                        buttonAction(b3,3,opponentSymbol);
                        break;

                    case 3:
                        buttonAction(b4,4,opponentSymbol);
                        break;

                    case 4:
                        buttonAction(b5,5,opponentSymbol);
                        break;

                    case 5:
                        buttonAction(b6,6,opponentSymbol); 
                        break;

                    case 6:
                        buttonAction(b7,7,opponentSymbol);
                        break;

                    case 7:
                        buttonAction(b8,8,opponentSymbol);
                        break;

                    case 8:
                        buttonAction(b9,9,opponentSymbol);
                        break;
                    case 9:
                        if(HasWinner() && IWon){
                            
                            WinningScene();
                        }else if(HasWinner() && !IWon){
                            
                            LosingScene(); 
                        }
                        break;
                    case 10:
                        DrawScene();
                        break;
                }
            } catch (IOException e) {
                showAlert();
                break;
            } catch (IllegalStateException e) {
                showAlert();
                break;
            }
        }
    }
    
    public void checkboard(){
        if(HasWinner() && IWon){
            Platform.runLater(() -> {
                WinningScene();
            });
        }else if(HasWinner() && !IWon){
            Platform.runLater(() -> {
                LosingScene();
            });
        }else if(!isMovesLeft()){
            Platform.runLater(() -> {
                DrawScene();
            });
        }
    }
    
    public void buttonAction(Button btn ,int i,String symbol){
        if(symbol.equals(playerSymbol)){
            try {
                PlayerOutputSocket.writeInt(i-1);
                PlayerOutputSocket.flush();
                btn.setStyle("-fx-text-fill: #0000ff;-fx-font-size: 3em");
                btn.setText(symbol);
                btn.setDisable(true);
                Hoster.add(i);
                gridPane.setDisable(true);
                turn.setLayoutX(295.0);
                turn.setLayoutY(420.0);
                turn.setText("Opponent Turn");
                checkboard();
            } catch (IOException e) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("player left :(");
                alert.setContentText("please try again later");
                alert.setOnCloseRequest((DialogEvent event) -> {
                    HostConnectBase root = new HostConnectBase();
                    changeScene(b1,root);
                });
                alert.showAndWait();
                e.printStackTrace();
            }
        }else{
            Platform.runLater(() -> {
                gridPane.setDisable(false);
                btn.setStyle("-fx-text-fill: #0000ff;-fx-font-size: 3em");
                btn.setText(symbol);
                btn.setDisable(true);
                Connector.add(i);
                turn.setLayoutX(330.0);
                turn.setLayoutY(420.0);
                turn.setText("Your Turn");
                checkboard();
            });
        }
    }

    public String HostSteps(){
        String hoster = Arrays.toString(Hoster.toArray()).replace("[", "").replace("]", "").replace(",", "").replace(" ", "");
        return hoster;
    }
   
    public String ConnectorSteps(){
        String connector = Arrays.toString(Connector.toArray()).replace("[", "").replace("]", "").replace(",", "").replace(" ", "");
        return connector;
    }

    private void StoreDB(){
        try {
            int game_id = ox_database.storePlayer1_name(playerName);
            ox_database.storePlayer2_name( opponentName,game_id);
            ox_database.storeSteps(playerName,playerSymbol ,HostSteps(), 1 ,game_id);
            ox_database.storeSteps(opponentName,opponentSymbol, ConnectorSteps(), 2,game_id);
        } catch (SQLException ex) {
            Logger.getLogger(OnlineGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showAlert(){
        Platform.runLater(()->{
            
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("server is down :(");
            alert.setContentText("please try again later");
            alert.setOnCloseRequest((DialogEvent event) -> {
                HostConnectBase root = new HostConnectBase();
                changeScene(b1,root);
            });
            alert.showAndWait();
        });
    }
}