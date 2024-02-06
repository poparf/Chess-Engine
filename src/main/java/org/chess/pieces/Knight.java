package org.chess.pieces;

import org.chess.Board;
import org.chess.Piece;
import org.chess.Square;
import org.chess.Team;

public class Knight extends Piece {

    public Knight(Board board, Square square, Team team) {
        super(board, square, team);
    }

    @Override
    public void move(Square newSquare) {

    }

    public Knight(Knight k) {
        super(k);
    }
    @Override
    public Piece clonePiece() {
        return new Knight(this);
    }

    @Override
    public void setTravelSquares() {

    }
}
