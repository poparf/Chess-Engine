package org.chess.gui;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    Color greenColor = new Color(118, 150, 86);
    Color yellowColor = new Color(238, 238, 210);

    private String selectedPiece = null;
    private int selectedRow = -1;
    private int selectedCol = -1;

    private HashMap<String, ChessPieceGUI> pieceGUIMap = new HashMap<String, ChessPieceGUI>();

    JPanel[][] chessSquares = new JPanel[8][8];
    //int windowWidth = ;
    //int windowHeight = ;
    public MainFrame() {
        this.setTitle("Chess");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // when hiting the X button it closes the app
        this.setResizable(false); // prevent this from being resized

        // JPanel == a gui component that functions as a container to hold other components

        GridLayout chessBoardLayout = new GridLayout(8,8);
        this.setLayout(chessBoardLayout);

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                chessSquares[row][col] = new JPanel();
                chessSquares[row][col].setPreferredSize(new Dimension(100, 100));

                // Alternate colors for the chessboard pattern
                if ((row + col) % 2 == 0) {
                    chessSquares[row][col].setBackground(greenColor);
                } else {
                    chessSquares[row][col].setBackground(yellowColor);
                }

                this.add(chessSquares[row][col]);
                final int finalRow = row;
                final int finalCol = col;
                chessSquares[row][col].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        handleSquareClick(finalRow, finalCol);
                    }
                });
            }
        }
        this.addPieces();


        this.setSize(600,600);
        //this.setExtendedState(Jthis.MAXIMIZED_BOTH); // sets the window to fullscreen
        // not really full screen more like a maximized window ( window fullscreen)
        this.setIconImage(new ImageIcon(getClass().getResource("/assets/images/whitePieces/Queen_white.png")).getImage());
        // Main.clas.getResource is a way to load images using the relative path

        this.setVisible(true); // makes the this visible
    }

    private void addPieces() {
        addPiecesByColor("Black", "/assets/images/blackPieces/Pawn_black.png", 1);
        addPiecesByColor("White", "/assets/images/whitePieces/Pawn_white.png", 6);

        addPiece("Black", "/assets/images/blackPieces/Rock_black.png", 0, 0, 8);
        addPiece("Black", "/assets/images/blackPieces/Knight_black.png", 0, 1, 9);
        addPiece("Black", "/assets/images/blackPieces/Bishop_black.png", 0, 2, 10);
        addPiece("Black", "/assets/images/blackPieces/King_black.png", 0, 3, 11);
        addPiece("Black", "/assets/images/blackPieces/Queen_black.png", 0, 4, 12);
        addPiece("Black", "/assets/images/blackPieces/Bishop_black.png", 0, 5, 13);
        addPiece("Black", "/assets/images/blackPieces/Knight_black.png", 0, 6, 14);
        addPiece("Black", "/assets/images/blackPieces/Rock_black.png", 0, 7, 15);

        addPiece("White", "/assets/images/whitePieces/Rock_white.png", 7, 0, 8);
        addPiece("White", "/assets/images/whitePieces/Knight_white.png", 7, 1, 9);
        addPiece("White", "/assets/images/whitePieces/Bishop_white.png", 7, 2, 10);
        addPiece("White", "/assets/images/whitePieces/King_white.png", 7, 3, 11);
        addPiece("White", "/assets/images/whitePieces/Queen_white.png", 7, 4, 12);
        addPiece("White", "/assets/images/whitePieces/Bishop_white.png", 7, 5, 13);
        addPiece("White", "/assets/images/whitePieces/Knight_white.png", 7, 6, 14);
        addPiece("White", "/assets/images/whitePieces/Rock_white.png", 7, 7, 15);
    }


    private void handleSquareClick(int row, int col) {
        if (selectedRow == -1 && selectedCol == -1) {
            // First click, save the position
            selectedRow = row;
            selectedCol = col;

            Component imageComponent = chessSquares[row][col].getComponent(0);
            for (Map.Entry<String, ChessPieceGUI> entry : this.pieceGUIMap.entrySet()) {
                if (entry.getValue().equals(imageComponent)) {
                    this.selectedPiece = entry.getKey();
                }
            }
        } else {
            // Second click, move the piece
            this.movePiece(selectedPiece,selectedRow, selectedCol, row, col);

            // Reset the selected position
            selectedRow = -1;
            selectedCol = -1;
        }
    }
    private void addPiecesByColor(String color, String imagePath, int row) {
        for (int i = 0; i < 8; i++) {
            String pieceKey = color + "_Pawn_" + (i + 1);
            this.pieceGUIMap.put(pieceKey, new ChessPieceGUI(imagePath));
            this.chessSquares[row][i].add(this.pieceGUIMap.get(pieceKey));
        }
    }

    private void addPiece(String color, String imagePath, int row, int col, int index) {
        String pieceKey = color + "_Piece_" + index;
        this.pieceGUIMap.put(pieceKey, new ChessPieceGUI(imagePath));
        this.chessSquares[row][col].add(this.pieceGUIMap.get(pieceKey));
    }

    public void movePiece(String pieceName, int fromRow, int fromCol, int toRow, int toCol) {

        ChessPieceGUI piece = this.pieceGUIMap.get(pieceName);
        // Remove the piece from the current position
        this.chessSquares[fromRow][fromCol].remove(piece);

        // Add the piece to the new position
        this.chessSquares[toRow][toCol].removeAll();
        this.chessSquares[toRow][toCol].add(piece);

        // Refresh the UI to reflect the changes
        this.revalidate();
        this.repaint();
    }
}
