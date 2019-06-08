import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScreen {
    private JFrame f;
    private JPanel p;
    private JButton b1;
    private JLabel lab;

    public StartScreen()
    {
        gui();
    }
    public void gui()
    {
        f = new JFrame("Light Cycle Game");
        f.setVisible(true);
        f.setSize(300,300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        p = new JPanel();
        p.setBackground(Color.BLUE);

        b1 = new JButton("Play");
        lab = new JLabel("Game");


        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();

            }
        });

        p.add(b1);
        p.add(lab);

        f.add(p);


    }


}
