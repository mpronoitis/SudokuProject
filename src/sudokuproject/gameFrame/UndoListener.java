package sudokuproject.gameFrame;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JButton;
import sudokuproject.SudokuProject;
/**
 * Singleton Class Listener of undo button (Singleton Pattern)
 * @author mpronoitis
 */
public class UndoListener implements MouseListener{
    private static UndoListener instance;
    private static ArrayList<Integer[]> undoNumArray;
    private String level;
    private JButton[][] myBtns;
    private JButton undoBtn;
    private static int size=0;
    /**
     * Singleton Constructor
     * @param undoBtn: the undo button 
     */
    private UndoListener(JButton undoBtn){
        this.undoBtn=undoBtn;
        this.level=SudokuProject.getLevel();
        this.undoNumArray=new ArrayList<Integer[]>();
        this.myBtns=BoardPane.getInstance().getBoardBtns();
    }
    /**
     * Checks if instance of class already exists. If not, it creates a new one and returns it
     * @param undoBtn: the undo button
     * @return instance: the instance of the class UndoListener
     */
    public static UndoListener getInstance(JButton undoBtn){
        if(instance!=null){
            return instance;
        }
        instance=new UndoListener(undoBtn);
        return instance;
    }
    /**
     * Updates the undo array 
     * @param choice: add or remove from undo array
     * @param num: number to add
     * @param row: row where the number is 
     * @param col: column where the number is
     */
    public void updateUndo(String choice,int num,int row,int col){
        System.out.println("Update");
        Integer[] data={num,row,col};
        int index=this.undoNumArray.size()-1;
        if(choice.equals("add")){
            size++;
            this.undoNumArray.add(data);
            for(Integer[] number:this.undoNumArray){
                System.out.println("Add "+number[0]+" "+number[1]+" "+number[2]);
            }
        }
        else{
            System.out.println("Removee");
            this.undoNumArray.remove(index);
            for(Integer[] myUndo:this.undoNumArray){
                System.out.println(myUndo[0]+" "+myUndo[1]+" "+myUndo[2]);
            }
        }
        
        if(size==0)
            undoBtn.setEnabled(false);
        else
            undoBtn.setEnabled(true);
    }
    /**
     * When button is clicked, remove from undo array
     * @param e: event that occurs when button is clicked 
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("size:"+size);
        
        if(size==0){
            undoBtn.setEnabled(false);
        }
        else{
            size=size-1;
            BoardPane.getInstance().getBoard().setSpecificPos(0, undoNumArray.get(size)[1], undoNumArray.get(size)[2]);
            BoardPane.getInstance().setSpecificBtnText(undoNumArray.get(size)[1], undoNumArray.get(size)[2], "");
            this.updateUndo("remove",-1,-1,-1);
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
