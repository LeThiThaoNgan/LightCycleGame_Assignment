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


        //Create frame of game, game title
        JFrame frame = new JFrame("Light Cycle");
        Grid grid = new Grid();

        //Setting up two light cycles
        LightCycle bike1 = new LightCycle(5, c1);
        LightCycle bike2 = new LightCycle(5, c2);


        //display names, scores and leaderboard on screen
        JLabel name = new JLabel("Name: " + p1 + " | " );
        JLabel name2= new JLabel("Name: " + p2 + " | " );

        final JLabel scoreDisplay = new JLabel("Score: " );
        final JLabel scoreDisplay2 = new JLabel("Score: ");
        LeaderBoard leaderBoard = new LeaderBoard();


        name.setForeground(Color.BLACK);
        name2.setForeground(Color.BLACK);


        name.setBackground(Color.WHITE);
        name2.setBackground(Color.WHITE);
        frame.setSize(600,800);

        ScoreBoard scoreBoard = new ScoreBoard();
        scoreBoard.add(name, BorderLayout.NORTH);


        scoreBoard.add(scoreDisplay, BorderLayout.SOUTH);

        scoreBoard.add(name2,BorderLayout.NORTH);
        scoreBoard.add(scoreDisplay2,BorderLayout.SOUTH);


        frame.add(scoreBoard, BorderLayout.NORTH);
        frame.add(leaderBoard, BorderLayout.WEST);


        //get random position of light cyclels in grid
        bike1.getRandomStart();
        bike2.getRandomStart();



        // frame-by-frame animation loop
        Timer timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bike1.move(grid.getSize(),bike2.getPoints()); //move car1
                bike2.move(grid.getSize(), bike1.getPoints()); //move bike2

                //display scores
                scoreDisplay.setText("Score: " + String.valueOf(bike1.getScore()) + "  ------  ");
                scoreDisplay2.setText("Score: " + String.valueOf(bike2.getScore()));


                //when car 1 dies
                if (!bike1.getAlive()) {

                    bike1.leaderBoard(); //save scores to leaderboard
                    bike2.leaderBoard();

                    //display winner
                    int selectedOption = JOptionPane.showConfirmDialog(frame, p2 + " won!" +
                            "\n Do you want to play again?");

                    //restart
                    if (selectedOption == JOptionPane.YES_OPTION) {
                        bike1.restart();
                        bike2.restart();

                        //close System
                    }
                    if (selectedOption == JOptionPane.NO_OPTION || selectedOption == JOptionPane.CANCEL_OPTION){
                        System.exit(0);
                    }
                }

                //if bike2 dies
                if (!bike2.getAlive()) {

                    bike1.leaderBoard();     //save scores to leaderboard
                    bike2.leaderBoard();

                    //display winner
                    int selectedOption = JOptionPane.showConfirmDialog(frame, p1 + " won!" +
                            "\n Do you want to play again?");

                    //restart
                    if (selectedOption == JOptionPane.YES_OPTION) {
                        bike1.restart();
                        bike2.restart();

                    }

                    //close system
                    if (selectedOption == JOptionPane.NO_OPTION || selectedOption == JOptionPane.CANCEL_OPTION){
                        System.exit(0);
                    }
                }

                //repaint for each frame per second
                grid.repaint();

            }
        });

        //start timer
        timer.start();




        //Setting up key interaction with light cycle for bike1
        grid.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                e.getKeyCode();
                if (e.getKeyCode() == KeyEvent.VK_W){
                    bike1.up();
                }
                if (e.getKeyCode() == KeyEvent.VK_S){
                    bike1.down();
                }
                if (e.getKeyCode() == KeyEvent.VK_A){
                    bike1.left();
                }
                if (e.getKeyCode() == KeyEvent.VK_D){
                    bike1.right();
                }

            }
        });

        //Setting up key interaction with light cycle for bike2
        grid.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                e.getKeyCode();
                if (e.getKeyCode() == KeyEvent.VK_UP){
                    bike2.up();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN){
                    bike2.down();
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT){
                    bike2.left();
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                    bike2.right();
                }

            }
        });




        //add grid to frame
        frame.add(grid, BorderLayout.CENTER);

        //add light cycles to grid
        grid.addLightCycle(bike1);
        grid.addLightCycle(bike2);

        //set frame's properties
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }
}


