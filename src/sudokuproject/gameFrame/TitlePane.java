package sudokuproject.gameFrame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
/**
 * Singleton Class of Panel where the title is (Singleton Pattern)
 * @author mpronoitis
 */
public class TitlePane extends JPanel{
    private JLabel titleLabel;
    private JLabel timeLabel;
    private Timer timer;
    private int count=0;
    private int hours;
    private int minutes;
    private int seconds;
    private String totalTime;
    private static TitlePane instance;
    /**
     * Singleton Constructor
     */
    private TitlePane(){
        titleLabel=new JLabel("SUDOKU");
        timeLabel=new JLabel("...");
        
        timer=new Timer(1000,new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                if(count<100000){
                    hours=count/3600;
                    minutes=(count%3600)/60;
                    seconds=count%60;
                    totalTime=String.format("%02d:%02d:%02d",hours,minutes,seconds);
                    timeLabel.setText(totalTime);
                }
                else{
                    ((Timer)(e.getSource())).stop();
                }
            }
        });
        timer.setInitialDelay(0);
        timer.start();
        
        Border border=BorderFactory.createLineBorder(Color.BLACK);
        this.setBorder(border);
        
        this.setLayout(new GridLayout(2,1));
        this.add(titleLabel);
        titleLabel.setFont(new Font("Serif", Font.ITALIC, 30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        
        this.add(timeLabel);
        timeLabel.setFont(new Font("Serif", Font.ITALIC, 20));
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        timeLabel.setVerticalAlignment(JLabel.CENTER);
    }
    /**
     * Checks if class instance aready exists. If not, it creates a new one and returns it
     * @return instance: the singleton instance of class TitlePane
     */
    public static TitlePane getInstance(){
        if(instance!=null){
            return instance;
        }
        instance=new TitlePane();
        return instance;
    }
    /**
     * Getter
     * @return timer: the timer of the game 
     */
    public Timer getTimer() {
        return timer;
    }
    /**
     * Getter
     * @return totalTime: the total time 
     */
    public String getTotalTime() {
        return totalTime;
    }
    /**
     * Getter
     * @return timeLabel: the label where the time is 
     */
    public JLabel getTimeLabel() {
        return timeLabel;
    }
    /**
     * This method stops the timer
     */
    public void stopTimer(){
        timer.stop();
    }
}
