package sudokuproject.database;

import java.sql.*;
import java.util.ArrayList;
import sudokuproject.player.model.SudokuPlayer;
/**
 * Singleton class of Database Connection
 * @author mpronoitis
 */
//Singleton Pattern
public class DBConnection {
    private static DBConnection instance;
    private Connection myConn;
    private Statement stmt;
    private ResultSet results;
    private int columnsLen=4; //4 fields in database table (name,level,points,timer)
    //database name: java
    //table name: sudokuPlayers
    /**
     * Singleton Constructor
     * @throws SQLException 
     */
    private DBConnection() throws SQLException{
            this.myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");
            
            this.stmt=myConn.createStatement();
            ResultSet results=stmt.executeQuery("select * from sudokuPlayers");
            
            while(results.next()){
                System.out.println(results.getString("name"));
            }
    }
    /**
     * It checks if instance already exists, if not it creates one and returns it
     * @return instance: single instance of DBConnection
     * @throws SQLException 
     */
    public static DBConnection getInstance() throws SQLException{
        if(instance!=null){
            //System.out.println("Singleton");
            return instance;
        }
        instance=new DBConnection();
        return instance;
    }
    /**
     * Getter
     * @return myConn: connection to database
     */
    public Connection getMyConn() {
        return myConn;
    }
    /**
     * Method that inserts a player into the database
     * @param player: the player to insert into database
     * @throws SQLException 
     */
    public void insertPlayer(SudokuPlayer player) throws SQLException{
        if(nameExists(player.getName())){
            System.out.println("Player "+player.getName()+" already exists");
        }
        else{
            String query="insert into sudokuPlayers(name,level,points,timer) values('"+player.getName()+"','"+player.getDifficultyLevel()+"',"+player.getPoints()+",'"+player.getTime()+"')";
            this.stmt=myConn.createStatement();
            int x=stmt.executeUpdate(query);
            stmt.close();
        }
    }
    /**
     * It prints all the players that exist in database
     * @throws SQLException 
     */
    public void printPlayers() throws SQLException{
        System.out.println("\nPlayers History\n---------------");
        this.stmt=myConn.createStatement();
        results=stmt.executeQuery("select * from sudokuPlayers order by level");
        while(results.next()){
            System.out.println(results.getString("name")+" "+results.getString("level")+" "+results.getInt("points")+" "+results.getString("timer"));
        }
        results.close();
        this.stmt.close();
    }
    /**
     * It checks if the name, that the player inserted, already exists, so that there are no dublicates
     * @param name: the name, that the player inserted before the game starts
     * @return true or false: true if name already exists in database, else false
     * @throws SQLException 
     */
    public boolean nameExists(String name) throws SQLException{
        this.stmt=myConn.createStatement();
        results=stmt.executeQuery("select name from sudokuPlayers");
        while(results.next()){
            if(results.getString("name").equals(name)){
                return true;
            }
        }
        return false;
    }
    /**
     * It returns all the players in database as an arraylist 
     * @return players: all the players that exist in database
     * @throws SQLException 
     */
    public ArrayList<String[]> getPlayersInfo() throws SQLException{
        ArrayList<String[]> players=new ArrayList<String[]>();
        
        this.stmt=myConn.createStatement();
        results=stmt.executeQuery("select * from sudokuPlayers order by level asc");
        while(results.next()){
            String[] str=new String[columnsLen];
            str[0]=results.getString("name");
            str[1]=results.getString("level");
            str[2]=String.valueOf(results.getInt("points"));
            str[3]=results.getString("timer");
            players.add(str);
        }
        results.close();
        this.stmt.close();
        return players;
    }
}

