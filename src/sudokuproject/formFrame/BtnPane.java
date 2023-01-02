package sudokuproject.formFrame;

import java.awt.GridLayout;
import javax.swing.*;
/**
 * Class of the Button Pane, that contains buttons for help and history
 * @author mpronoitis
 */
public class BtnPane extends JPanel{
    private JButton helpBtn;
    private JButton historyBtn;
    /**
     * Constructor
     */
    public BtnPane(){
        this.setLayout(new GridLayout(1,2));
        
        helpBtn=new JButton("Help");
        historyBtn=new JButton("History");
        
        helpBtn.addActionListener(new HelpBtnListener());
        historyBtn.addActionListener(new HistoryBtnListener());
        
        this.add(helpBtn);
        this.add(historyBtn);
    }
}
