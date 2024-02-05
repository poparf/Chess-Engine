package org.chess;

public class Square {
    // XY represents the coordinates of the place on window
    private int x;
    private int y;
    // Row / col the place inside the matrix
    private int row;
    private int col;

    // For king mechanic of check
    private boolean isAttackedByWhite = false;
    private boolean isAttackedByBlack = false;

    Square(int x, int y, int row, int col) {
        this.x = x;
        this.y = y;

        if(row < 0 || row > 7 || col < 0 || col > 7)
            throw new IllegalArgumentException();

        this.row = row;
        this.col = col;
    }

    Square(Square s) {
        this.x = s.x;
        this.y = s.y;
        this.row = s.row;
        this.col = s.col;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
