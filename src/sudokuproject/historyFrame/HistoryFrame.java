package sudokuproject.historyFrame;

import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.*;
import sudokuproject.database.DBConnection;
/**
 * Singleton Class for Frame of player's history table
 * @author mpronoitis
 */
public class HistoryFrame extends JFrame{
    private JTable dataTable;
    private String[] columnNames={"Name","Level","Points","Time"};
    private ArrayList<String[]> dataArray;
    private String[][] data;
    private static HistoryFrame instance;
    /**
     * Singleton Constructor
     * @throws SQLException 
     */
    private HistoryFrame() throws SQLException{
        super();
        
        this.setTitle("History");
        this.setSize(600,300);
        
        DBConnection conn=DBConnection.getInstance();
        
        dataArray=conn.getPlayersInfo();
        data=new String[dataArray.size()][columnNames.length];
        for(int i=0;i<dataArray.size();i++){
            data[i]=dataArray.get(i);
            System.out.println(data[i][1]);
        }
        
        dataTable = new JTable(data,columnNames);
        
        JScrollPane scrollPane = new JScrollPane(dataTable);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(250, 250));
        
        this.add(scrollPane);
    }
    /**
     * Checks if instance of class already exists. If not, it creates a new one and returns it
     * @return instance: singleton instance of class HistoryFrame
     * @throws SQLException 
     */
    public static HistoryFrame getInstance() throws SQLException{
        if(instance!=null){
            return instance;
        }
        instance=new HistoryFrame();
        return instance;
    }
}
