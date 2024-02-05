package org.chess.pieces;

import org.chess.Board;
import org.chess.Piece;
import org.chess.Square;
import org.chess.Team;

public class Rock extends Piece {
    public Rock(Board board, Square square, Team team) {
        super(board, square, team);
    }

    @Override
    public void move(Square square) {

    }


    public Rock(Rock r) {
        super(r);
    }
    @Override
    public Piece clonePiece() {
        return new Rock(this);
    }
}
