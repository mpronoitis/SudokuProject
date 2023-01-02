package sudokuproject.board;
/**
 * Subclass of SudokuBoard for level hard
 * Patterns: Singleton
 * @author mpronoitis
 */
public class SudokuBoardHard extends SudokuBoard{
    private static double hidden=2.0/3.0;
    private static SudokuBoardHard instance;
    /**
     * Constructor
     */
    private SudokuBoardHard(){
        super(hidden);
    }
    /**
     * Returns the instance of the Sudoku Board for level hard
     * @return instance: the sudoku board for level hard
     */
    public static SudokuBoardHard getInstance(){
        if(instance!=null){
            //System.out.println("Singleton");
            return instance;
        }
        instance=new SudokuBoardHard();
        return instance;
    }
}
