package org.chess;

public abstract class Piece {

    // [ [1,3], [4,5] ]
    // Linked list
    // fast delete and fast insertion
    // search can be sequential O(n)

    protected Square square;
    protected byte value; // the value of the piece as a score
    protected Board board;
    protected Team teamColor;

    public Piece(Board board, Square square, Team teamColor) {
        this.board = board;
        this.square = square;
        this.teamColor = teamColor;
    }
    public abstract void move(Square newSquare);
    public abstract Piece clonePiece();

    protected Piece(Piece p) {
        this.board = p.board;
        this.square = p.square;
        this.teamColor = p.teamColor;
        this.value = p.value;
    }

    public Square getSquare() {
        return square;
    }

    public byte getValue() {
        return value;
    }

    public Team getTeamColor() {
        return teamColor;
    }
}
