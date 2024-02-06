package org.chess.pieces;

import org.chess.Board;
import org.chess.Piece;
import org.chess.Square;
import org.chess.Team;

public class Bishop extends Piece {
    public Bishop(Board board, Square square, Team team) {
        super(board, square, team);
    }

    @Override
    public void move(Square square) {

    }

    public Bishop(Bishop b) {
        super(b);
    }
    @Override
    public Piece clonePiece() {
        return new Bishop(this);
    }

    @Override
    public void setTravelSquares() {

    }
}
