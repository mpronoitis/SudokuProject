package sudokuproject.gameFrame;

import java.awt.GridLayout;
import javax.swing.*;
import sudokuproject.SudokuProject;
/**
 * Class of Panel where the player's informations are displayed
 * @author mpronoitis
 */
public class InfoPane extends JPanel{
    private String name;
    private String level;
    private JLabel nameLabel;
    private JLabel levelLabel;
    /**
     * Constructor
     */
    public InfoPane(){
        this.name=SudokuProject.getName();
        this.level=SudokuProject.getLevel();
        
        this.setLayout(new GridLayout(2,1));
        
        nameLabel=new JLabel("Name: "+this.name);
        levelLabel=new JLabel("Difficulty level: "+this.level);
        
        this.add(nameLabel);
        this.add(levelLabel);
    }
}
