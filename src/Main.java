import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;



public class Main  {



    public static void main(String[] args)  {

        ImageIcon icon = new ImageIcon("/Users/Jace/Downloads/Assignment2/Program/src/images/tron3.jpg");
        int input = JOptionPane.showConfirmDialog(null,
                "Play Light Cycle?", "Light Cycle Game", JOptionPane. YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon );
        if (input == JOptionPane.NO_OPTION ){
            System.exit(0);
        }

        String p1 = JOptionPane.showInputDialog("Enter 1st player name: ");

        Color c1 = JColorChooser.showDialog(null, "Choose a color for your Light Cycle", Color.RED);

        String p2 = JOptionPane.showInputDialog("Enter 2nd player name: ");

        Color c2 = JColorChooser.showDialog(null, "Choose a color for your Light Cycle", Color.RED);




