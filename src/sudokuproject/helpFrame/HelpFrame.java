package sudokuproject.helpFrame;

import java.awt.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;
/**
 * Singleton Class for Frame of Help text
 * @author mpronoitis
 */
public class HelpFrame extends JFrame{
    private JTextArea textArea;
    private String helpText;
    private static HelpFrame instance;
    /**
     * Singleton Constructor
     */
    private HelpFrame(){
        super();
        
        this.setTitle("Help");
        this.setSize(600,300);
        
        this.readHelpFile();
        textArea=new JTextArea(helpText);
        textArea.setFont(new Font("Serif", Font.ITALIC, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(250, 250));
        textArea.setEditable(false);
        
        this.add(scrollPane);
    }
    /**
     * Checks if instance of class already exists. If not, it creates a new one and return it
     * @return instance: singleton instance of class
     */
    public static HelpFrame getInstance(){
        if(instance!=null){
            return instance;
        }
        instance=new HelpFrame();
        return instance;
    }
    /**
     * Method that reads the file where the help text is 
     */
    public void readHelpFile(){
        helpText="";
        
        try {
            File helpFile= new File("help.txt");
            Scanner myReader = new Scanner(helpFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                //System.out.println(data);
                helpText+=data+"\n";
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
