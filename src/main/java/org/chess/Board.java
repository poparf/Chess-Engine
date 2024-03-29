package org.chess;

import org.chess.gui.MainFrame;
import org.chess.pieces.*;

public class Board {
    private final int rows = 8;
    private final int columns = 8;
    private Piece[][] content;// = new Piece[rows][columns];

    public MainFrame frame;

    Board() {
        this.content = new Piece[rows][columns];
        initBlackTeamTop();
        initWhiteTeamBottom();
        frame = new MainFrame(this);
    }



    private void initBlackTeamTop() {
        
        content[0][0] = new Rock(this,new Square(0,0,0,0),Team.BLACK);
        content[0][1] = new Knight(this,new Square(0,0,0,1),Team.BLACK);
        content[0][2] = new Bishop(this,new Square(0,0,0,2),Team.BLACK);
        content[0][3] = new Queen(this,new Square(0,0,0,3),Team.BLACK);
        content[0][4] = new King(this,new Square(0,0,0,4),Team.BLACK);
        content[0][5] = new Bishop(this,new Square(0,0,0,5),Team.BLACK);
        content[0][6] = new Knight(this,new Square(0,0,0,6),Team.BLACK);
        content[0][7] = new Rock(this,new Square(0,0,0,7),Team.BLACK);

        for (int i = 0; i < columns; i++) {
            content[1][i] = new Pawn(this,new Square(0,0,1,i), Team.BLACK);
        }
    }

    private void initWhiteTeamBottom() {
        content[rows - 1][0] = new Rock(this,new Square(0,0,rows - 1,0),Team.WHITE);
        content[rows - 1][1] = new Knight(this,new Square(0,0,rows - 1,1),Team.WHITE);
        content[rows - 1][2] = new Bishop(this,new Square(0,0,rows - 1,2),Team.WHITE);
        content[rows - 1][3] = new Queen(this,new Square(0,0,rows - 1, 3),Team.WHITE);
        content[rows - 1][4] = new King(this,new Square(0,0,rows - 1,4),Team.WHITE);
        content[rows - 1][5] = new Bishop(this,new Square(0,0,rows - 1,5),Team.WHITE);
        content[rows - 1][6] = new Knight(this,new Square(0,0,rows - 1, 6),Team.WHITE);
        content[rows - 1][7] = new Rock(this,new Square(0,0,rows - 1, 7),Team.WHITE);

        for (int i = 0; i < columns; i++) {
            content[rows - 2][i] = new Pawn(this,new Square(0,0,rows - 2,i), Team.WHITE);
        }
    }

    public Piece[][] getContent() {
        Piece[][] copiedContent = new Piece[rows][columns];

       for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(this.content[i][j] != null)
                    copiedContent[i][j] = this.content[i][j].clonePiece();
                else
                    copiedContent[i][j] = null;
            }
        }
        return copiedContent;
    }

    // To be deleted
    public void printBoard() {
        for (int i = 0; i < rows; i++) {
            System.out.println();
            for (int j = 0; j < columns; j++) {
                if(this.content[i][j] != null)
                    System.out.print(this.content[i][j].getClass().getName().substring(17) + " ");
                else {
                    System.out.print("null");
                }
            }

        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public boolean isThereAPiece(int row, int col) {
        return this.content[row][col] != null;
    }

    // Se face oare upcasting ?
    public void update(Piece piece, Square newSquare) {
        this.content[piece.getSquare().getRow()][piece.getSquare().getCol()] = null;
        this.content[newSquare.getRow()][newSquare.getCol()] = piece;
    }

    public void processMove(Square square, Square newSquare) {
        this.content[square.getRow()][square.getCol()].move(newSquare);
    }
}
