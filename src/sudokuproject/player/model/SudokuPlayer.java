package sudokuproject.player.model;
/**
 * Class of Sudoku Player (Superclass) (MVC Pattern)
 * @author mpronoitis
 */
public class SudokuPlayer {
    private String name;
    private String difficultyLevel;
    private int points=0;
    private String time="00:00:00";
    /**
     * Constructor
     * @param name: name of player
     * @param difficultyLevel: level of difficulty of player
     */
    public SudokuPlayer(String name, String difficultyLevel){
        this.name=name;
        this.difficultyLevel=difficultyLevel;
    }
    /**
     * Getter
     * @return name: name of player 
     */
    public String getName() {
        return name;
    }
    /**
     * Getter
     * @return level: level od difficulty of player 
     */
    public String getDifficultyLevel() {
        return difficultyLevel;
    }
    /**
     * Getter
     * @return points: points of player 
     */
    public int getPoints() {
        return points;
    }
    /**
     * Getter
     * @return time: time of player 
     */
    public String getTime() {
        return time;
    }
    /**
     * Setter
     * @param name: name of player 
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Setter
     * @param difficultyLevel: level of difficulty of player 
     */
    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }
    /**
     * Setter
     * @param points: points of player
     */
    //Points=seconds that the game lasted
    public void setPoints(int points) {
        this.points = points;
    }
    /**
     * Setter
     * @param time: tm=ime of player 
     */
    public void setTime(String time) {
        this.time = time;
    }
}
