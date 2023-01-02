package sudokuproject.player.controller;

import sudokuproject.player.model.SudokuPlayer;
import sudokuproject.player.view.SudokuPlayerView;

/**
 * Class of Sudoku Player Controller (MVC Pattern)
 * @author mpronoitis
 */
//MVC Pattern
public class SudokuPlayerController {
    private SudokuPlayer model;
    private SudokuPlayerView view;
    /**
     * Constructor
     * @param model: the sudoku player to control
     * @param view:the sudoku player view 
     */
    public SudokuPlayerController(SudokuPlayer model,SudokuPlayerView view){
        this.model=model;
        this.view=view;
    }
    /**
     * Setter
     * @param name: name of sudoku player 
     */
    public void setSudokuPlayerName(String name){
        model.setName(name);
    }
    /**
     * Getter
     * @return the name of the player (model) 
     */
    public String getSudokuPlayerName(){
        return model.getName();
    }
    /**
     * Setter
     * @param level: the level of the player 
     */
    public void setSudokuPlayerLevel(String level){
        model.setDifficultyLevel(level);
    }
    /**
     * Getter
     * @return the level of the player (model) 
     */
    public String getSudokuPlayerLevel(){
        return model.getDifficultyLevel();
    }
    /**
     * Setter
     * @param points: the points of the player 
     */
    public void setSudokuPlayerPoints(int points){
        model.setPoints(points);
    }
    /**
     * Getter 
     * @return the points of the player (model) 
     */
    public int getSudokuPlayerPoints(){
        return model.getPoints();
    }
    /**
     * Updates the view of sudoku players
     */
    public void updateView(){
        view.printSudokuPlayerDetails(model.getName(),model.getDifficultyLevel(),model.getPoints(),model.getTime());
    }
    
}
