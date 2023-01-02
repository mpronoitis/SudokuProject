package sudokuproject.player.model;

import sudokuproject.player.model.SudokuPlayer;

/**
 * Singleton class of Sudoku Player Hard (subclass of SudokuPlayer)
 * @author mpronoitis
 */
public class SudokuPlayerHard extends SudokuPlayer{
    private static SudokuPlayerHard instance;
    /**
     * Singleton Constructor
     * @param name: name of player 
     */
    private SudokuPlayerHard(String name){
        super(name,"hard");
    }
    /**
     * Checks if instance of class already exists. If not, it creates a new one and returns it
     * @param name: name of player
     * @return instance: singleton instance of class
     */
    public static SudokuPlayerHard getInstance(String name){
        if(instance!=null){
            return instance;
        }
        instance=new SudokuPlayerHard(name);
        return instance;
    }
    
    
    
}
