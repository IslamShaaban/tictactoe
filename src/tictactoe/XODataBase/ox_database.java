package tictactoe.XODataBase;

import java.sql.* ; 
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ox_database {
    
    public static String password = "16496";
    static public int storePlayer1_name(String n) throws SQLException{
        int current_game =0;
        try{
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tictactoe","root",password);/* enter your root password */
            Statement stmt = con.createStatement() ;
            String insertestring = new String("INSERT INTO tictactoe.game(player1_name) values('"+n+"')");
            stmt.executeUpdate(insertestring);
            String selectGameId = new String("SELECt game_id FROM tictactoe.game" );
            ResultSet rs= stmt.executeQuery(selectGameId);
            while(rs.next()){
                if(current_game<rs.getInt(1)){
                      current_game=rs.getInt(1);
                }
            }
            stmt.close();
            con.close();
        }catch(SQLException ex)
        {
          ex.printStackTrace();
        }
       return current_game; 
    }
    
    static public void storeSteps(String name_player,String player_char ,String steps, int first ,int game_id) throws SQLException{
        try{
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection con = DriverManager.getConnection 
            ("jdbc:mysql://localhost:3306/tictactoe","root",password);/* enter your root password */
            Statement stmt = con.createStatement() ;
            String insertestring = new String("INSERT INTO tictactoe.steps(player_name,player_ch ,player_steps,first_player,game_id) values('"+name_player+"','"+player_char+"','"+steps+"','"+first+"','"+game_id+"')");
            stmt.executeUpdate(insertestring);
            stmt.close();
            con.close();
        }catch(SQLException ex){
          ex.printStackTrace();
        }
    }
     
    static public void storePlayer2_name(String n , int game_id) throws SQLException{
        try{
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection con = DriverManager.getConnection 
            ("jdbc:mysql://localhost:3306/tictactoe","root",password);/* enter your root password */
            Statement stmt = con.createStatement() ;
            String insertestring = new String("UPDATE tictactoe.game SET player2_name = '"+n+"'"+" WHERE game_id ='"+game_id+"'");
            stmt.executeUpdate(insertestring);
            stmt.close();
            con.close();
        }catch(SQLException ex)
        {
          ex.printStackTrace();
        }
    }
    
    static public void retrieveData(int game_id) throws SQLException{
        ResultSet rs = null;
        try{
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection con = DriverManager.getConnection 
            ("jdbc:mysql://localhost:3306/tictactoe","root",password);/* enter your root password */
            Statement stmt = con.createStatement() ;
            String insertestring = new String("SELECT player_name,player_ch,player_steps,first_player FROM tictactoe.steps WHERE game_id ='"+game_id+"'");
            rs= stmt.executeQuery(insertestring);
            while(rs.next()){
                String steps=new String(rs.getString(3));
            }
            stmt.close();
            con.close();
        }catch(SQLException ex){
          ex.printStackTrace();
        }
       
    }
    
    static public boolean checkfullName(String fullName) throws SQLException{
        ResultSet rs = null;
	boolean check=false;
        try{
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection con = DriverManager.getConnection 
        ("jdbc:mysql://localhost:3306/tictactoe","root",password);/* enter your root password */
        Statement stmt = con.createStatement() ;
        String insertestring = new String("SELECT player1_name,player2_name FROM tictactoe.game");
        rs= stmt.executeQuery(insertestring);
        while(rs.next()){
            if(fullName.equals(rs.getString(1)) ||fullName.equals(rs.getString(2))){
	       check=true;
            }
	}
        
        stmt.close();
        con.close();
        
        }catch(SQLException ex){
          ex.printStackTrace();
        }
        return  check;
    }
    
    public static ArrayList checkgameID(String fullName){
        
        ArrayList<Integer> ids=new ArrayList<>();   
      
        try {
            ResultSet rs = null;
            int i =0;
            System.out.println(fullName);
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tictactoe","root",password);
            Statement stmt = con.createStatement() ;
            String insertestring = new String("SELECT game_id FROM tictactoe.game WHERE player1_name ='"+fullName+"' or player2_name='"+fullName+"'");
            rs= stmt.executeQuery(insertestring);

            while(rs.next()){
                ids.add(rs.getInt(1));
            }
            System.out.println(ids);
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ox_database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ids ;
    }
}    

   

