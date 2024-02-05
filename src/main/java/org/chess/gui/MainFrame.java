package org.chess.gui;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MainFrame extends JFrame {

    //int windowWidth = ;
    //int windowHeight = ;
    public MainFrame() {

        /*ImageIcon image = new ImageIcon(getClass().getResource("/assets/images/whitePieces/Pawn_white.png"));

        Border border = BorderFactory.createDashedBorder(Color.green);

        JLabel label = new JLabel();
        label.setText("Start game");
        label.setBorder(border);


        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER); // set text left/center/right on imageicon
        label.setVerticalTextPosition(JLabel.TOP);
        label.setForeground(Color.lightGray);
        label.setFont(new Font("MV Boli", Font.PLAIN, 20));
        // label.setIconTextGap() // set the gap of text to image +/-
        label.setBackground(Color.black);
        label.setOpaque(true);
        // the label expands as much as it can


        // setBounds sets x,y position in the frame as well as dimensions
        label.setBounds(0,0,250,250);
*/

        // JPanel == a gui component that functions as a container to hold other components

        JPanel menuPanel = new JPanel();
        menuPanel.setBackground(Color.lightGray);
        menuPanel.setBounds(250,250,250,500);
        //menuPanel.setLayout(new );

        JPanel logoPanel = new JPanel();
        logoPanel.setBackground(Color.ORANGE);
        logoPanel.setBounds(100,100,500,140);

        this.setTitle("Chess");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // when hiting the X button it closes the app
        //this.setResizable(false); // prevent this from being resized

        this.setLayout(null);

        this.setSize(1080,720);
        //this.setExtendedState(Jthis.MAXIMIZED_BOTH); // sets the window to fullscreen
        // not really full screen more like a maximized window ( window fullscreen)
        this.setIconImage(new ImageIcon(getClass().getResource("/assets/images/whitePieces/Queen_white.png")).getImage());
        // Main.clas.getResource is a way to load images using the relative path

        this.setVisible(true); // makes the this visible

        // Setting a color for the background
        this.getContentPane().setBackground(Color.darkGray);

       // this.add(label);
        this.add(logoPanel);
        this.add(menuPanel);


    }

}
