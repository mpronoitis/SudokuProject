package sudokuproject.gameFrame;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import sudokuproject.SudokuProject;
import sudokuproject.board.*;
/**
 * Class of the Panel where the sudoku board is (Singleton Pattern)  
 * @author mpronoitis
 */
public class BoardPane extends JPanel{
    private int N;
    private String level;
    private SudokuBoard board;
    private JLabel[][] boardLabel;
    private JButton[][] boardBtns;
    private static BoardPane instance;
    private String select="none";
    private static final Color LIGHT_GREY = new Color(204,204,204);
    private ArrayList<PlaceNumListener> placeNumListener;
    /**
     * Singleton Constructor
     */
    private BoardPane(){
        this.N=SudokuProject.getN();
        this.level=SudokuProject.getLevel();
        this.setLayout((new GridLayout(this.N,this.N)));
        
            if(level.equals("easy")){
                board=SudokuBoardEasy.getInstance();
            }
            else if(level.equals("normal")){
                board=SudokuBoardNormal.getInstance();
            }
            else if(level.equals("hard")){
                board=SudokuBoardHard.getInstance();
            }
            else if(level.equals("very hard")){
                board=SudokuBoardVeryHard.getInstance();
            }
        
        boardLabel=new JLabel[this.N][this.N];
        boardBtns=new JButton[this.N][this.N];
        
        for(int i=0;i<this.N;i++){
            for(int j=0;j<this.N;j++){
                if(board.getMat()[i][j]!=0){
                    boardBtns[i][j]=new JButton(board.getMat()[i][j]+"");
                    boardBtns[i][j].setBackground(LIGHT_GREY);
                }
                else{
                    boardBtns[i][j]=new JButton("");
                    boardBtns[i][j].setBackground(Color.white);
                }
                this.add(boardBtns[i][j]);
            }
        }
    }
    /**
     * Method that checks if instance of class already exists. If not it creates a new one and returns it
     * @return 
     */
    public static BoardPane getInstance(){
        if(instance!=null){
            return instance;
        }
        instance=new BoardPane();
        return instance;
    }
    /**
     * It adds the Listener to the buttons, which places the numbers on board when pressed
     * @param num: the number to place on board 
     */
    public void addPlaceNumListener(int num){
        placeNumListener=new ArrayList<PlaceNumListener>();
        for(int i=0;i<this.N;i++){
            for(int j=0;j<this.N;j++){
                if(board.getMat()[i][j]==0){
                    int id=placeNumListener.size();
                    placeNumListener.add(new PlaceNumListener(id,i,j,num));
                    boardBtns[i][j].addMouseListener(placeNumListener.get(id));
                }
                this.add(boardBtns[i][j]);
            }
        }
    }
    /**
     * Getter 
     * @return placeNumListener: the listeners that place numbers on board 
     */
    public ArrayList<PlaceNumListener> getPlaceNumListener() {
        return placeNumListener;
    }
    /**
     * Getter
     * @return board: the board of the sudoku 
     */
    public SudokuBoard getBoard() {
        return board;
    }
    /**
     * Getter
     * @return boardLabel: the labels that are on sudoku board 
     */
    public JLabel[][] getBoardLabel() {
        return boardLabel;
    }
    /**
     * Getter
     * @return boardBtns: the buttons on sudoku board 
     */
    public JButton[][] getBoardBtns() {
        return boardBtns;
    }
    /**
     * Setter
     * @param board: the board of the sudoku  
     */
    public void setBoard(SudokuBoard board) {
        this.board = board;
    }
    /**
     * Setter
     * @param boardLabel: the labels that are on sudoku board 
     */
    public void setBoardLabel(JLabel[][] boardLabel) {
        this.boardLabel = boardLabel;
    }
    /**
     * Setter
     * @param boardBtns: the buttons on sudoku board
     */
    public void setBoardBtns(JButton[][] boardBtns) {
        this.boardBtns = boardBtns;
    }
    /**
     * Sets the text of a specific button on sudoku board
     * @param row: row of button on board
     * @param col: column of button on board
     * @param txt: text to set on button
     */
    public void setSpecificBtnText(int row,int col,String txt){
        this.boardBtns[row][col].setText(txt);
    }
    /**
     * Method that restarts the sudoku board 
     */
    public void restartBoard(){
        if(level.equals("easy")){
            board=SudokuBoardEasy.getInstance();
        }
        else if(level.equals("normal")){
            board=SudokuBoardNormal.getInstance();
        }
        else if(level.equals("hard")){
            board=SudokuBoardHard.getInstance();
        }
        board.restartBoard();
        
        for(int i=0;i<this.N;i++){
            for(int j=0;j<this.N;j++){
                if(board.getMat()[i][j]!=0){
                    boardBtns[i][j].setText(board.getMat()[i][j]+"");
                    boardBtns[i][j].setBackground(LIGHT_GREY);
                }
                else{
                    boardBtns[i][j].setText("");
                    boardBtns[i][j].setBackground(Color.white);
                }
            }
        }
    }
}
