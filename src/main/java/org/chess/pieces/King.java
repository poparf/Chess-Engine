package org.chess.pieces;

import org.chess.Board;
import org.chess.Piece;
import org.chess.Square;
import org.chess.Team;

public class King extends Piece {
    public King(Board board, Square square, Team team) {
        super(board, square, team);
        this.value = 10;
    }


    /*The King may not move to a square:
        that is occupied by one of his own pieces,
        where it is checked by an enemy piece
        adjacent to the enemy King*/
    @Override
    public void move(Square newSquare) {
        Piece[][] content = this.board.getContent();

        // occupied by one of his own pieces
        if(content[newSquare.getRow()][newSquare.getCol()].getTeamColor() == this.teamColor) {
            throw new IllegalArgumentException();
        }

        // where it is checked by an enemy piece

    }

    public King(King k) {
        super(k);
    }

    @Override
    public Piece clonePiece() {
        return new King(this);
    }

    @Override
    public void setTravelSquares() {

    }
}
