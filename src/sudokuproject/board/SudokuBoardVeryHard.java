/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokuproject.board;

/**
 *
 * @author mpronoitis
 */
public class SudokuBoardVeryHard extends SudokuBoard{
    private static double hidden=2.5/3.0;
    private static SudokuBoardVeryHard instance;
    /**
     * Constructor
     */
    private SudokuBoardVeryHard(){
        super(hidden);
    }
    /**
     * Returns the instance of the Sudoku Board for level easy
     * @return instance: the sudoku board for level easy
     */
    public static SudokuBoardVeryHard getInstance(){
        if(instance!=null){
            //System.out.println("Singleton");
            return instance;
        }
        instance=new SudokuBoardVeryHard();
        return instance;
    }
}
