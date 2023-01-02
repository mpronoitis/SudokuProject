package sudokuproject.player.view;
/**
 * Class of Sudoku Player View (MVC Pattern)
 * @author mpronoitis
 */
public class SudokuPlayerView {
    /**
     * Prints the Sudoku Players details
     * @param playerName: name of player
     * @param playerLevel: level of player
     * @param playerPoints: points of player
     * @param playerTimer: timer of player
     */
    public void printSudokuPlayerDetails(String playerName,String playerLevel,int playerPoints,String playerTimer){
        System.out.println("Player: ");
        System.out.println("Name: "+playerName);
        System.out.println("Level: "+playerLevel);
        System.out.println("Points: "+playerPoints);
        System.out.println("Timer: "+playerTimer);
    }
}
