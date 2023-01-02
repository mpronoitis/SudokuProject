/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokuproject.player.model;

/**
 *
 * @author mpronoitis
 */
public class SudokuPlayerVeryHard extends SudokuPlayer{
    private static SudokuPlayerVeryHard instance;
    /**
     * Singleton Constructor
     * @param name: name of player
     */
    private SudokuPlayerVeryHard(String name){
        super(name,"very hard");
    }
    /**
     * Checks if instance of class already exists. If not, it creates a new one and returns it
     * @param name: name of player
     * @return instance: singleton instance of class
     */
    public static SudokuPlayerVeryHard getInstance(String name){
        if(instance!=null){
            return instance;
        }
        instance=new SudokuPlayerVeryHard(name);
        return instance;
    }
}
