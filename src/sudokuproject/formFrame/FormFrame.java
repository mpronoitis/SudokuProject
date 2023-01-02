package sudokuproject.formFrame;

import java.awt.*;
import java.awt.GridLayout;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
/**
 * The class of the frame, where the form exists
 * @author mpronoitis
 */
public class FormFrame extends JFrame{
    private InputPane inputPane;
    private BtnPane btnPane;
    private JLabel titleLabel;
    private static FormFrame instance;
    /**
     * Singleton Constructor
     */
    private FormFrame(){
        super();
        
        this.setSize(900,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3,1));
        
        titleLabel=new JLabel("SUDOKU");
        titleLabel.setFont(new Font("Serif", Font.ITALIC, 30));
        titleLabel.setPreferredSize(new Dimension(150, 100));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        this.add(titleLabel);
        
        inputPane=new InputPane();
        btnPane=new BtnPane();
        
        this.add(inputPane);
        this.add(btnPane);
    }
    /**
     * Method that checks if instance of class already exists. If not, it creates one
     * @return instance: singleton instance of class FormFrame
     */
    public static FormFrame getInstance(){
        if(instance!=null){
            //System.out.println("Singleton");
            return instance;
        }
        instance=new FormFrame();
        return instance;
    }
}
