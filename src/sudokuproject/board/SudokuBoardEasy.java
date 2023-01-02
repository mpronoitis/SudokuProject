package sudokuproject.board;

/**
 * Subclass of SudokuBoard for level easy
 * Patterns: Singleton
 * @author mpronoitis
 */
public class SudokuBoardEasy extends SudokuBoard{
    private static double hidden=1.0/3.0;
    private static SudokuBoardEasy instance;
    /**
     * Constructor
     */
    private SudokuBoardEasy(){
        super(hidden);
    }
    /**
     * Returns the instance of the Sudoku Board for level easy
     * @return instance: the sudoku board for level easy
     */
    public static SudokuBoardEasy getInstance(){
        if(instance!=null){
            //System.out.println("Singleton");
            return instance;
        }
        instance=new SudokuBoardEasy();
        return instance;
    }
}
