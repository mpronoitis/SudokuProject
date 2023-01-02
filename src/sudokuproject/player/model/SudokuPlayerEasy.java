package sudokuproject.player.model;

import sudokuproject.player.model.SudokuPlayer;

/**
 * Singleton class of sudoku player level easy (subclass of SudokuPlayer)
 * @author mpronoitis
 */
public class SudokuPlayerEasy extends SudokuPlayer{
    private static SudokuPlayerEasy instance; 
    /**
     * Singleton Constructor
     * @param name: name of player 
     */
    private SudokuPlayerEasy(String name){
        super(name,"easy");
    }
    /**
     * Checks if instance of class already exists. If not, it creates a new one and returns it
     * @param name: name of player
     * @return istance: singleton instance of class SudokuPlayerEasy
     */
    public static SudokuPlayerEasy getInstance(String name){
        if(instance!=null){
            return instance;
        }
        instance=new SudokuPlayerEasy(name);
        return instance;
    }
}

