package sudokuproject.gameFrame;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import sudokuproject.SudokuProject;
/**
 * Class of the Panel where the Numbers Button (1-9) are (Singleton Pattern)
 * @author mpronoitis
 */
public class NumBtnsPane extends JPanel{
    private int InputN;
    private JButton[] numbersBtns;
    private JButton checkBtn;
    private JButton solveBtn;
    private JButton undoBtn;
    private ArrayList<Integer> numbers;
    private String level;
    private static NumBtnsPane instance;
    private ArrayList<SelectNumListener> selectNumListener;
    private UndoListener undoListener;
    /**
     * Singleton Constructor
     */
    private NumBtnsPane(){
        this.level=SudokuProject.getLevel();
        this.InputN=SudokuProject.getInputN();
        
        numbersBtns=new JButton[this.InputN];
        numbers=new ArrayList<Integer>();
        for(int i=0;i<this.InputN;i++){
            numbers.add(i+1);
        }
        
        this.setLayout(new GridLayout(4,3));
        selectNumListener=new ArrayList<SelectNumListener>();
        for(int i=0;i<this.InputN;i++){
            numbersBtns[i]=new JButton(String.valueOf(numbers.get(i)));
            numbersBtns[i].setBackground(Color.yellow);
            
            selectNumListener.add(new SelectNumListener(numbers.get(i),this));
            numbersBtns[i].addMouseListener(selectNumListener.get(i));
            this.add(numbersBtns[i]);
        }
        solveBtn=new JButton("Solve");
        solveBtn.addActionListener(new SolveListener(solveBtn));
        
        undoBtn=new JButton("Undo");
        undoListener=UndoListener.getInstance(undoBtn);
        undoBtn.addMouseListener(undoListener);
        undoBtn.setEnabled(false);
        
        checkBtn=new JButton("Check");
        checkBtn.addActionListener(new CheckBtnListener());
        
        this.add(solveBtn);
        this.add(undoBtn);
        this.add(checkBtn);
    }
    /**
     * Checks if instance of class already exists. I fnot it creates a new one and returns it
     * @return instance: singleton instance of class
     */
    public static NumBtnsPane getInstance(){
        if(instance!=null){
            return instance;
        }
        instance=new NumBtnsPane();
        return instance;
    }
    /**
     * Getter
     * @return checkBtn: the check button 
     */
    public JButton getCheckBtn() {
        return checkBtn;
    }
    /**
     * Getter
     * @return numbersBtns: the numbers buttons (1-9)
     */
    public JButton[] getNumbersBtns() {
        return numbersBtns;
    }
    /**
     * Getter
     * @return undoBtn: the undo button 
     */
    public JButton getUndoBtn() {
        return undoBtn;
    }
    /**
     * Getter
     * @return selectNumListener: the select number listener 
     */
    public ArrayList<SelectNumListener> getSelectNumListener(){
        return selectNumListener;
    }
    /**
     * Sets all buttons to be enabled (true or false), except check button
     * @param enable: true or false, true if buttons are enabled
     */
    public void setAllEnabled(boolean enable){
        //this.checkBtn.setEnabled(enable);
        this.undoBtn.setEnabled(false);
        for(int i=0;i<this.InputN;i++){
            this.numbersBtns[i].setEnabled(enable);
        }
    }
}
