package sudokuproject.gameFrame;

import sudokuproject.player.model.SudokuPlayerNormal;
import sudokuproject.player.model.SudokuPlayerHard;
import sudokuproject.player.model.SudokuPlayerEasy;
import sudokuproject.player.model.SudokuPlayer;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;
import sudokuproject.SudokuProject;
import sudokuproject.board.*;
import sudokuproject.database.DBConnection;
import sudokuproject.formFrame.FormFrame;
import sudokuproject.player.*;
/**
 * Class of check button listener
 * @author mpronoitis
 */
public class CheckBtnListener implements ActionListener{
    private static BoardPane boardPane;
    private int minNum=1;
    private int maxNum=9;
    private int minPos=0;
    private int maxPos=8;
    private int num;
    private ArrayList<Integer> pos;
    private SudokuBoard board;
    private int N;
    private JButton[][] textArea;
    private String level;
    private int sqrtN=(int)Math.sqrt(this.N);
    private SudokuPlayer player;
    private String name;
    /**
     * Constructor
     */
    public CheckBtnListener(){
        this.level=SudokuProject.getLevel();
        this.name=SudokuProject.getName();
        this.N=SudokuProject.getN();
        
        boardPane=BoardPane.getInstance();
        textArea=boardPane.getBoardBtns();
        if(level.equals("easy"))
            board=SudokuBoardEasy.getInstance();
        else if(level.equals("normal"))
            board=SudokuBoardNormal.getInstance();
        else if(level.equals("hard"))
            board=SudokuBoardHard.getInstance();
    }
    /**
     * When the check button is pressed, the method checks if player won
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        if(win()){
            TitlePane.getInstance().stopTimer();
            //((JButton)e.getSource()).setEnabled(false);
            if(level.equals("easy"))
                player=SudokuPlayerEasy.getInstance(name);
            else if(level.equals("normal"))
                player=SudokuPlayerNormal.getInstance(name);
            else if(level.equals("hard"))
                player=SudokuPlayerHard.getInstance(name);
            
            String[] totalTime=(TitlePane.getInstance().getTotalTime()).split(":");
            int sec=Integer.valueOf(totalTime[2]);
            int min=Integer.valueOf(totalTime[1]);
            int hour=Integer.valueOf(totalTime[0]);
            int totalSec=sec+min*60+hour*360;
            
            player.setPoints(totalSec);
            player.setTime(TitlePane.getInstance().getTotalTime());
            
            try {
                DBConnection con=DBConnection.getInstance();
                con.insertPlayer(player);
            
                con.printPlayers();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.out.println("You win!!!");
            JOptionPane.showMessageDialog(FormFrame.getInstance(),"You won!!!","Game over",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        else{
            System.out.println("Keep playing");
        }
    }
    /**
     * Updates the sudoku board before checking
     */
    public void update(){
        this.boardPane=BoardPane.getInstance();
        this.textArea=boardPane.getBoardBtns();
        if(level.equals("easy"))
            this.board=SudokuBoardEasy.getInstance();
        else if(level.equals("normal"))
            this.board=SudokuBoardNormal.getInstance();
        else if(level.equals("hard"))
            this.board=SudokuBoardHard.getInstance();
    }
    /**
     * Method that checks if player won
     * @return true or false: true if won
     */
    public boolean win(){
        boolean win=true;
        boolean emptyCells=false;
        boolean wrongNums=false;
        String warning="";
        
        this.board.printSolvedSudoku();
        
        for(int i=0;i<this.N;i++){
            for(int j=0;j<this.N;j++){
                if(this.board.getMat()[i][j]==0)
                    emptyCells=true;
                if(this.board.getMat()[i][j]!=0 && this.board.getMat()[i][j]!=this.board.getSolvedMat()[i][j]){
                    wrongNums=true;
                }
            }
        }
        if(emptyCells==true){
            win=false;
            warning+="Still empty cells!";
        }
        if(wrongNums==true ){
            win=false;
            warning+="\nWrong inputs!";
        }
        if(win==false)            
            JOptionPane.showMessageDialog(FormFrame.getInstance(),warning,"Warning",JOptionPane.WARNING_MESSAGE);
        return win;
    }
    /**
     * Checks if num already exists on row, column or box (invalid position)
     * @param num: number to check
     * @param row: row the number is positioned
     * @param col: column the number is positioned
     * @return true or false: false if num doesn't exist (valid position)
     */
    public boolean numExists(int num,int row,int col){
        if(this.isInBox(row,col, num) || this.isInCol(col, num) || this.isInRow(row, num))
            return true;
        return false;
    }
    /**
     * Check each element of the row for num, if num is found return false
     * @param row: row to check
     * @param num: number to check
     * @return true or false: true if already exists in row
     */
    public boolean isInRow(int row, int num) {
        for(int i=0;i<this.N;i++){
            if(num==board.getMat()[row][i]){
                return true;
            }
        }
        return false;
    }
    /**
     * Check each element of the column for num, if num is found return true
     * @param col: col to check
     * @param num: number to check
     * @return true or false: true if already exists in column
     */
    public boolean isInCol(int col, int num) {

        for(int i=0;i<this.N;i++){
            if(num==board.getMat()[i][col]){
                return true;
            }
        }

        return false;
    }
    /**
     * Check each element of the box for num, if num is found return true
     * @param xPos: row of number's position
     * @param yPos: column of number's position
     * @param num: number to check
     * @return true or false: true if number already exists in box
     */
    public boolean isInBox(int xPos, int yPos, int num) {
        int[][] section = new int[sqrtN][sqrtN];
        section = getSection(xPos, yPos);

        for (int i = 0; i < this.sqrtN; i++) {
            for (int j = 0; j < this.sqrtN; j++) {
                if (section[i][j] == num)
                    return true;
            }
        }
        return false;
    }
    /**
     * Finds the 3x3 section that a specific position is in
     * @param xPos: row to check
     * @param yPos: column to check
     * @return section: the 3x3 section 
     */
    public int[][] getSection(int xPos, int yPos) {
        int[][] section = new int[this.sqrtN][this.sqrtN];
        int xIndex = this.sqrtN * (xPos / this.sqrtN);
        int yIndex = this.sqrtN * (yPos / this.sqrtN);

        for (int i = 0; i < this.sqrtN; i++) {
            for (int j = 0; j < this.sqrtN; j++) {
                section[i][j] = board.getMat()[xIndex + i][yIndex + j];
            }
        }
        return section;
    }
}
