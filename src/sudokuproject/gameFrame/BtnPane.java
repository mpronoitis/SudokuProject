package sudokuproject.gameFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import sudokuproject.SudokuProject;
import sudokuproject.formFrame.*;
/**
 * Class of the Panel where the buttons are (help,history,restart,level) (Singleton Pattern)
 * @author mpronoitis
 */
public class BtnPane extends JPanel{
    private JButton helpBtn;
    private JButton historyBtn;
    private JButton restartBtn;
    private String level;
    private static BtnPane instance;
    /**
     * Singleton Constructor
     */
    private BtnPane(){
        this.level=SudokuProject.getLevel();
        
        this.setLayout(new GridLayout(1,4));
        this.setPreferredSize(new Dimension(50,50));
        helpBtn=new JButton("Help");
        historyBtn=new JButton("History");
        restartBtn=new JButton("Restart");
        restartBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                BoardPane.getInstance().restartBoard();
            }
        });
        
        helpBtn.addActionListener(new HelpBtnListener());
        historyBtn.addActionListener(new HistoryBtnListener());
        
        this.add(helpBtn);
        this.add(historyBtn);
        this.add(restartBtn);
    }
    /**
     * Checks if instance of class already exists. If not, it creates a new one and returns it
     * @return instance: singleton instance of class BtnPane
     */
    public static BtnPane getInstance(){
        if(instance!=null){
            return instance;
        }
        instance=new BtnPane();
        return instance;
    }
}
