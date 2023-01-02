package sudokuproject.gameFrame;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JButton;
import sudokuproject.SudokuProject;
/**
 * Class of listener that places numbers on board
 * @author mpronoitis
 */
public class PlaceNumListener implements MouseListener{
    private int id;
    private int row;
    private int col;
    private String level;
    private int num;
    private int N;
    private static ArrayList<JButton> undoBtns;
    private SelectNumListener selectListener;
    private JButton myBtn;
    /**
     * Constructor
     * @param id: the id of position on board
     * @param row: the row where the button is on board
     * @param col: the column where the button is on board 
     * @param num: number to place on board 
     */
    public PlaceNumListener(int id,int row,int col,int num){
        this.id=id;
        this.row=row;
        this.col=col;
        this.level=SudokuProject.getLevel();
        this.num=num;
        this.N=SudokuProject.getN();
        
        undoBtns=new ArrayList<JButton>();
    }
    /**
     * Getter
     * @return undoBtns: an array list where we keep all the numbers that where previously placed 
     */
    public static ArrayList<JButton> getUndoBtns() {
        return undoBtns;
    }
    /**
     * Setter
     * @param undoBtns: an array list where we keep all the numbers that where previously placed
     */
    public static void setUndoBtns(ArrayList<JButton> undoBtns) {
        PlaceNumListener.undoBtns = undoBtns;
    }
    /**
     * When mouse is clicked in board, place number on that position
     * @param e 
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        selectListener=NumBtnsPane.getInstance().getSelectNumListener().get(num-1);
        if(selectListener.isSelected()){
            System.out.println("You selected "+num+" "+row+" "+col);
            
            this.myBtn=BoardPane.getInstance().getBoardBtns()[this.row][this.col];
            this.myBtn.setText(num+"");
            
            BoardPane.getInstance().getBoard().setSpecificPos(this.row,this.col,num);
            
            //this.myBtn.setEnabled(false);

            selectListener.setSelectedFalse();
            selectListener.removeCounter();

            UndoListener.getInstance(NumBtnsPane.getInstance().getUndoBtn()).updateUndo("add",num,row,col);
        }
        else{
            System.out.println("Select a number first");
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
