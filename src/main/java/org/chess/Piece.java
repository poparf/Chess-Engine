package org.chess;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Map;

public abstract class Piece {

    protected ArrayList<Square> travelSquares;
    protected Square square;
    protected byte value; // the value of the piece as a score
    protected Board board;
    protected Team teamColor;

    public Piece(Board board, Square square, Team teamColor) {
        this.board = board;
        this.square = square;
        this.teamColor = teamColor;
        this.travelSquares = new ArrayList<>();
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

    public ArrayList<Square> getTravelSquares() {
        return this.travelSquares;
    }

    abstract public void setTravelSquares();

}
