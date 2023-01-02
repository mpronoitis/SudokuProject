package sudokuproject.gameFrame;

import java.awt.event.*;
import javax.swing.JButton;
import sudokuproject.SudokuProject;
import sudokuproject.board.*;
/**
 * Class listener of solve button
 * @author mpronoitis
 */
public class SolveListener implements ActionListener{
    private int[][] solvedMat;
    private JButton[][] solvedBoard;
    private String level;
    private JButton solveBtn;
    /**
     * Constructor
     * @param solveBtn: the solve button 
     */
    public SolveListener(JButton solveBtn){
        this.solveBtn=solveBtn;
        this.level=SudokuProject.getLevel();
        if(level.equals("easy")){
            solvedMat=SudokuBoardEasy.getInstance().getSolvedMat();
        }
        else if(level.equals("normal")){
            solvedMat=SudokuBoardNormal.getInstance().getSolvedMat();
        }
        else{
            solvedMat=SudokuBoardHard.getInstance().getSolvedMat();
        }
    }
    /**
     * When solve button is pressed, the sudoku board is solved
     * @param e: the event that occurs when the solve button is pressed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.update();
        //solveBtn.setEnabled(false);
        //NumBtnsPane.getInstance().getCheckBtn().setEnabled(false);
        
        solvedBoard=new JButton[SudokuProject.getN()][SudokuProject.getN()];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                //solvedBoard[i][j]=new JButton(Integer.toString(solvedMat[i][j]));
                solvedBoard[i][j]=new JButton();
                solvedBoard[i][j].setText(solvedMat[i][j]+"");
                BoardPane.getInstance().setSpecificBtnText(i,j,Integer.toString(solvedMat[i][j]));
                BoardPane.getInstance().getBoard().setSpecificPos(i,j,solvedMat[i][j]);
            }
        }
        NumBtnsPane.getInstance().setAllEnabled(false);
    }
    /**
     * Updates the solved matrix, in case the restart button is pressed
     */
    public void update(){
        if(level.equals("easy")){
            solvedMat=SudokuBoardEasy.getInstance().getSolvedMat();
        }
        else if(level.equals("normal")){
            solvedMat=SudokuBoardNormal.getInstance().getSolvedMat();
        }
        else{
            solvedMat=SudokuBoardHard.getInstance().getSolvedMat();
        }
    }
}
