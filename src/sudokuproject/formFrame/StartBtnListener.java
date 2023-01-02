package sudokuproject.formFrame;

import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.*;
import javax.swing.*;
import sudokuproject.SudokuProject;
import sudokuproject.database.DBConnection;
import sudokuproject.gameFrame.GameFrame;
import sudokuproject.player.SudokuPlayerFactory;
/**
 * Listener of the start button
 * @author mpronoitis
 */
public class StartBtnListener implements ActionListener{
    private JTextArea textArea;
    private JComboBox comboBox;
    private static StartBtnListener instance;
    /**
     * Singleton Constructor
     * @param textArea
     * @param comboBox 
     */
    private StartBtnListener(JTextArea textArea,JComboBox comboBox){
        this.textArea=textArea;
        this.comboBox=comboBox;
    }
    /**
     * Method that checks if instance of class already exists. If not, it creates a new one and returns it
     * @param textArea: the area where the player inserts his/hers name
     * @param comboBox: the level of game the player chose
     * @return instance: the singleton instance of the class
     */
    public static StartBtnListener getInstance(JTextArea textArea,JComboBox comboBox){
        if(instance!=null){
            //System.out.println("Singleton");
            return instance;
        }
        instance=new StartBtnListener(textArea,comboBox);
        return instance;
    }
    /**
     * When the start button is pressed, it checks some things (name empty, name already exists etc.) and if everything is okay the player is created and the game starts
     * @param e: event that occurs and activates listener
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<String[]> dataArray;
        boolean found=false;
        
        if(textArea.getText().length()>0){
            DBConnection conn;
            try {
                conn = DBConnection.getInstance();
                dataArray=conn.getPlayersInfo();
                for(int i=0;i<dataArray.size();i++){
                    if(dataArray.get(i)[0].equals(textArea.getText())){
                        found=true;
                        JOptionPane.showMessageDialog(FormFrame.getInstance(),"Name already exists!","Warning",JOptionPane.WARNING_MESSAGE);
                        break;
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(StartBtnListener.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(found==false){
                SudokuProject.setName(textArea.getText());
                SudokuProject.setLevel(comboBox.getSelectedItem()+"");
                SudokuPlayerFactory.getInstance().getSudokuPlayer(textArea.getText(), comboBox.getSelectedItem()+"");
                FormFrame.getInstance().setVisible(false);
                GameFrame.getInstance().setVisible(true);
            }
        }
        else{
           JOptionPane.showMessageDialog(FormFrame.getInstance(),"Please insert name!","Warning",JOptionPane.WARNING_MESSAGE); 
        }
    }
}
