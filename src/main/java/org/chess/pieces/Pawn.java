package org.chess.pieces;

import org.chess.Board;
import org.chess.Piece;
import org.chess.Square;
import org.chess.Team;

public class Pawn extends Piece {

   public Pawn(Board board, Square square, Team team) {
      super(board, square, team);
   }


   @Override
   public void move(Square square) {

   }


   public Pawn(Pawn p) {
      super(p);
   }
   @Override
   public Piece clonePiece() {
      return new Pawn(this);
   }
}
