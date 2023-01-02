package sudokuproject.gameFrame;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import sudokuproject.SudokuProject;
/**
 * Class of the Frame where the game is (Singleton)
 * @author mpronoitis
 */
public class GameFrame extends JFrame{
    private static GameFrame instance;
    private String name;
    private String level;
    private TitlePane titlePane;
    private BtnPane btnPane;
    private InfoPane infoPane;
    private BoardPane boardPane;
    private NumBtnsPane numBtnsPane;
    /**
     * Singleton Constructor
     */
    private GameFrame(){
        super();
        this.name=SudokuProject.getName();
        this.level=SudokuProject.getLevel();
        
        this.setTitle("Sudoku");
        this.setSize(900,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.setLayout(new BorderLayout());
        
        titlePane=TitlePane.getInstance();
        this.add(titlePane,BorderLayout.NORTH);
        
        infoPane=new InfoPane();
        numBtnsPane=NumBtnsPane.getInstance();
        boardPane=BoardPane.getInstance();
        btnPane=BtnPane.getInstance();
        
        this.add(numBtnsPane,BorderLayout.EAST);
        this.add(infoPane,BorderLayout.WEST);
        this.add(boardPane,BorderLayout.CENTER);
        this.add(btnPane,BorderLayout.SOUTH);
    }
    /**
     * Checks if instance of class already exists. If not it creates a new one and return it
     * @return instance: singleton instance of class
     */
    public static GameFrame getInstance(){
        if(instance!=null){
            return instance;
        }
        instance=new GameFrame();
        return instance;
    }
}
