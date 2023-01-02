package sudokuproject.player.model;

import sudokuproject.player.model.SudokuPlayer;

/**
 * Singleton Class of Sudoku Player Normal (subclass of SudokuPlayer)
 * @author mpronoitis
 */
public class SudokuPlayerNormal extends SudokuPlayer{
    private static SudokuPlayerNormal instance;
    /**
     * Singleton Constructor
     * @param name: name of player
     */
    private SudokuPlayerNormal(String name){
        super(name,"normal");
    }
    /**
     * Checks if instance of class already exists. If not, it creates a new one and returns it
     * @param name: name of player
     * @return instance: singleton instance of class
     */
    public static SudokuPlayerNormal getInstance(String name){
        if(instance!=null){
            return instance;
        }
        instance=new SudokuPlayerNormal(name);
        return instance;
    }
}

