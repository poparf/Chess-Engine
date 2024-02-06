package org.chess.gui;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MainFrame extends JFrame {

    //int windowWidth = ;
    //int windowHeight = ;
    public MainFrame() {
        this.setTitle("Chess");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // when hiting the X button it closes the app
        this.setResizable(false); // prevent this from being resized

        // JPanel == a gui component that functions as a container to hold other components

        GridLayout chessBoardLayout = new GridLayout(8,8);
        this.setLayout(chessBoardLayout);


        Color greenColor = new Color(118, 150, 86);
        Color yellowColor = new Color(238, 238, 210);

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                JPanel squarePanel = new JPanel();
                squarePanel.setPreferredSize(new Dimension(100, 100));

                // Alternate colors for the chessboard pattern
                if ((row + col) % 2 == 0) {
                    squarePanel.setBackground(greenColor);
                } else {
                    squarePanel.setBackground(yellowColor);
                }

                this.add(squarePanel);
            }
        }




        this.setSize(800,800);
        //this.setExtendedState(Jthis.MAXIMIZED_BOTH); // sets the window to fullscreen
        // not really full screen more like a maximized window ( window fullscreen)
        this.setIconImage(new ImageIcon(getClass().getResource("/assets/images/whitePieces/Queen_white.png")).getImage());
        // Main.clas.getResource is a way to load images using the relative path

        this.setVisible(true); // makes the this visible

      /*  // Setting a color for the background
        this.getContentPane().setBackground(Color.darkGray);

       // this.add(label);
        this.add(logoPanel);
        this.add(menuPanel);*/




    }

}
