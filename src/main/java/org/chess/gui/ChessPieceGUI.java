package org.chess.gui;

import javax.swing.*;
import java.net.URL;

public class ChessPieceGUI extends JLabel {

    public ChessPieceGUI(String imagePath) {
        ImageIcon image = new ImageIcon(getClass().getResource(imagePath));
        this.setIcon(image);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
    }

    // You can add more methods here for animations, movement, etc.
}