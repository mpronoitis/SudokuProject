package sudokuproject;

import java.sql.SQLException;
import sudokuproject.formFrame.FormFrame;

/**
 * The main Class, where the main method runs
 * @author mpronoitis
 */
public class SudokuProject {
    private static int N=9;
    private static int InputN=9;
    private static String name;
    private static String level;
    /**
     * The main method, where we create the Form Frame
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        FormFrame formFrame=FormFrame.getInstance();
        formFrame.setVisible(true);
    }
    /**
     * Returns the size of the Sudoku board
     * @return N: the size of the Sudoku board
     */
    public static int getN() {
        return N;
    }
    /**
     * Returns the valid input numbers
     * @return InputN: the size of the valid input numbers 
     */
    public static int getInputN() {
        return InputN;
    }
    /**
     * Returns the name of the player
     * @return name: the name of the player
     */
    public static String getName() {
        return name;
    }
    /**
     * Returns the level of the player
     * @return level: the level of the player
     */
    public static String getLevel() {
        return level;
    }
    /**
     * Sets the name of the Player
     * @param name: the name of the player
     */
    public static void setName(String name){
        SudokuProject.name=name;
    }
    /**
     * Sets the level that the player chose
     * @param level: level that the player chose
     */
    public static void setLevel(String level) {
        SudokuProject.level = level;
    }
}
