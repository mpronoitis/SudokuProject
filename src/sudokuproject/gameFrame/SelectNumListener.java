package sudokuproject.gameFrame;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.JButton;
import sudokuproject.SudokuProject;
/**
 * Class of listener when a number is selected from 1-9
 * @author mpronoitis
 */
public class SelectNumListener implements MouseListener{
    private int num;
    private NumBtnsPane numBtnsPane;
    private static final Color VERY_DARK_YELLOW = new Color(255,204,0);
    private static final Color LIGHT_YELLOW = new Color(255,255,153);
    private boolean selected=false;
    private String level;
    private int counter;
    private JButton myBtn;
    /**
     * Constructor
     * @param num: number of button
     * @param numBtnsPane: the panel where the numbers 1-9 are
     */
    public SelectNumListener(int num,NumBtnsPane numBtnsPane){
        this.counter=SudokuProject.getN();
        this.num=num;
        this.numBtnsPane=numBtnsPane;
        this.level=SudokuProject.getLevel();
        this.myBtn=numBtnsPane.getNumbersBtns()[num-1];
    }
    /**
     * Checks if number is selected (1-9)
     * @return true or false:if true then number is selected
     */
    public boolean isSelected() {
        return selected;
    }
    /**
     * Sets number's button as not selected
     */
    public void setSelectedFalse() {
        this.selected = false;
        
        for(JButton btn:numBtnsPane.getNumbersBtns()){
            btn.setBackground(Color.yellow);
        }
    }
    /**
     * Removes 1 from counter when number is placed and disables button
     */
    public void removeCounter(){
        this.counter--;
        if(this.counter==0){
            this.myBtn.setBackground(LIGHT_YELLOW);
            this.myBtn.setEnabled(false);
        }
    }
    /**
     * Adds 1 to counter and enables button
     */
    public void addCounter(){
        this.counter++;
        if(this.counter>0)
            this.myBtn.setEnabled(true);
    }
    /**
     * When button is clicked, make it darker and change status to selected
     * @param e 
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if(this.counter==0){
            this.myBtn.setEnabled(false);
        }
        else{
            /*set make all buttons yellow and then the one you selected darker*/
            this.setSelectedFalse();
            
            this.myBtn.setBackground(VERY_DARK_YELLOW);
            selected=true;

            BoardPane.getInstance().addPlaceNumListener(num);
        }
    }
    /**
     * Action that is performed when mouse is pressed
     * @param e 
     */
    @Override
    public void mousePressed(MouseEvent e) {
    }
    /**
     * Action that is performed when mouse is released
     * @param e 
     */
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    /**
     * Action that is performed when mouse is entered
     * @param e 
     */
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    /**
     * Action that is performed when mouse is exited
     * @param e 
     */
    @Override
    public void mouseExited(MouseEvent e) {
    }
}
