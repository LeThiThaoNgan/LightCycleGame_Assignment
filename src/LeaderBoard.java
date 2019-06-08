//import modules

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//Create a panel for the leaderboard
public class LeaderBoard extends JPanel
{
    JLabel heading = new JLabel("Leaderboard: \n"); //The leaderboard header
    JLabel savedscore = new JLabel(""); //The score saved in the leaderboard
    LightCycle lightCycle;                   //Calling class LightCycle

    //LeaderBoard constructor (designing the panel and labels)
    public LeaderBoard(){
        setPreferredSize(new Dimension(100,600));
        setBackground(Color.PINK);
        heading.setForeground(Color.WHITE);
        savedscore.setForeground(Color.WHITE);

        add(heading, BorderLayout.NORTH);

        //Opening the leaderboard file
        Path path = Paths.get("leaderboard.txt");
        InputStream input = null;
        try{
            input = Files.newInputStream(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String s = null;
            s = reader.readLine();
            savedscore.setText(s);
            add(savedscore, BorderLayout.CENTER);

            input.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}