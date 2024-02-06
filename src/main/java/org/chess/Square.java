package org.chess;

import java.util.Objects;

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

    public Square(int row, int col) {
     if(row < 0 || col < 0)
         throw new IllegalArgumentException();

     this.row = row;
     this.col = col;
    }

    private void setCoordinates() {
        // logic to set the coordinates of the window with respect to each square
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return x == square.x && y == square.y && row == square.row && col == square.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, row, col);
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
