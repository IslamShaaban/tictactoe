package tictactoe.Games.Multiplayer.Network;

import java.io.IOException;
import java.net.*;

public class GameServer {

    Socket socket;
    public GameServer(){
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            socket = serverSocket.accept();
            System.out.println("server is running");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}