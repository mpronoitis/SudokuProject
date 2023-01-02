package sudokuproject.formFrame;

import java.awt.event.*;
import sudokuproject.helpFrame.HelpFrame;
/**
 * Class of the Listener that activates when help button is pressed
 * @author mpronoitis
 */
public class HelpBtnListener implements ActionListener{
    /**
     * When the button help is pressed, the help frame pops up
     * @param e: the event that activated the listener (press)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        HelpFrame helpFrame=HelpFrame.getInstance();
        helpFrame.setVisible(true);
    }
}
