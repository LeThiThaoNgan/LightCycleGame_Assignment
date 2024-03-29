//import modules
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;


//Create jpanel of grid
public class Grid extends JPanel {

    //list of light cycles in the grid
    private int i = 0;
    private ArrayList<LightCycle> lightCycles = new ArrayList<LightCycle>();

    private static final Font font = new Font("Arial",Font.BOLD, 26);


    //constructor
    Grid() {
        setFocusable(true); // is false by default...
        setPreferredSize(new Dimension(600,600));
        setBackground(Color.PINK);
        setBorder(BorderFactory.createLineBorder(Color.WHITE));
        setFocusable(true);

    }

    //add light cycles to grid
    void addLightCycle(LightCycle lightCycle) {
        lightCycles.add(lightCycle);
    }





    //paint graphics for grid and light cycle
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        for(LightCycle lightCycle : lightCycles) {
            lightCycle.draw(graphics);
        }

    }
}
