package org.chess.pieces;

import org.chess.Board;
import org.chess.Piece;
import org.chess.Square;
import org.chess.Team;

public class Queen extends Piece {
    public Queen(Board board, Square square, Team team) {
        super(board, square, team);
    }

    @Override
    public void move(Square square) {

    }

    public Queen(Queen q) {
        super(q);
    }

    @Override
    public Piece clonePiece() {
        return new Queen(this);
    }

    @Override
    public void setTravelSquares() {

    }
}
