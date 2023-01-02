package sudokuproject.formFrame;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
/**
 * The pane where the player inserts his/hers information 
 * @author mpronoitis
 */
public class InputPane extends JPanel{
    private JButton startBtn;
    private JTextArea nameTxt;
    private JLabel nameLabel;
    private JLabel levelLabel;
    private JComboBox levelCombo;
    private String[] levels={"easy","normal","hard","very hard"};
    private JPanel dataPane;
    private StartBtnListener startBtnListener;
    /**
     * Constructor
     */
    public InputPane(){
        this.setLayout(new GridLayout(2,1));
        
        dataPane=new JPanel();
        dataPane.setLayout(new GridLayout(2,2));
        
        nameLabel=new JLabel("Name: ");
        nameTxt=new JTextArea();
        nameTxt.setBounds(10,30,200,200);
        dataPane.add(nameLabel);
        dataPane.add(nameTxt);
        
        levelLabel=new JLabel("Level: ");
        levelCombo = new JComboBox(levels);
        levelCombo.setSelectedIndex(0);
        dataPane.add(levelLabel);
        dataPane.add(levelCombo);
        
        this.add(dataPane);
        
        startBtn=new JButton("Start");
        startBtnListener=StartBtnListener.getInstance(nameTxt,levelCombo);
        startBtn.addActionListener(startBtnListener);
        this.add(startBtn);
    }
}
