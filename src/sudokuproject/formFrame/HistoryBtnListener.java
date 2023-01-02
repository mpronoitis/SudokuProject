package sudokuproject.formFrame;

import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.*;
import sudokuproject.historyFrame.HistoryFrame;
/**
 * Class of History Button Listener
 * @author mpronoitis
 */
public class HistoryBtnListener implements ActionListener{
    /**
     * When history button is pressed, the history frame pops up and contains all the previous players
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        HistoryFrame historyFrame = null;
        try {
            historyFrame = HistoryFrame.getInstance();
        } catch (SQLException ex) {
            Logger.getLogger(BtnPane.class.getName()).log(Level.SEVERE, null, ex);
        }
        historyFrame.setVisible(true);
    }
}
