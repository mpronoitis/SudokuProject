package sudokuproject.board;
/**
 * Subclass of SudokuBoard for level normal
 * Patterns: Singleton
 * @author mpronoitis
 */
public class SudokuBoardNormal extends SudokuBoard{
    private static double hidden=1.0/2.0;
    private static SudokuBoardNormal instance;
    /**
     * Constructor
     */
    private SudokuBoardNormal(){
        super(hidden);
    }
    /**
     * Returns the instance of the Sudoku Board for level normal
     * @return instance: the sudoku board for level normal
     */
    public static SudokuBoardNormal getInstance(){
        if(instance!=null){
            //System.out.println("Singleton");
            return instance;
        }
        instance=new SudokuBoardNormal();
        return instance;
    }
}
