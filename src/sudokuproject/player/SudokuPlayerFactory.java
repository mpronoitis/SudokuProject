package sudokuproject.player;

import sudokuproject.player.model.SudokuPlayerNormal;
import sudokuproject.player.model.SudokuPlayerHard;
import sudokuproject.player.model.SudokuPlayerEasy;
import sudokuproject.player.model.SudokuPlayer;

/**
 * Class of Sudoku Player Factory (MVC Pattern)
 * @author mpronoitis
 */
public class SudokuPlayerFactory {
    private static SudokuPlayerFactory instance;
    /**
     * Singleton Constructor
     * @return instance: singleton instance of class
     */
    public static SudokuPlayerFactory getInstance(){
        if(instance!=null){
            return instance;
        }
        instance=new SudokuPlayerFactory();
        return instance;
    }
    /**
     * Getter
     * @param name: name of player
     * @param playerType: level of difficulty of player
     * @return 
     */
    public SudokuPlayer getSudokuPlayer(String name,String playerType){
        if(playerType==null){
            return null;
        }
        if(playerType.equalsIgnoreCase("EASY")){
            return SudokuPlayerEasy.getInstance(name);
        }
        else if(playerType.equalsIgnoreCase("NORMAL")){
            return SudokuPlayerNormal.getInstance(name);
        }
        else if(playerType.equalsIgnoreCase("HARD")){
            return SudokuPlayerHard.getInstance(name);
        }
        return null;
    }
}
