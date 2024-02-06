package org.chess.pieces;

import org.chess.Board;
import org.chess.Piece;
import org.chess.Square;
import org.chess.Team;

import java.util.ArrayList;

public class Pawn extends Piece {



   public Pawn(Board board, Square square, Team team) {
      super(board, square, team);
      this.setTravelSquares();
      if(this.teamColor == Team.WHITE)
         this.pieceName = "White_Pawn_" + (this.square.getCol() + 1);
      else
         this.pieceName = "Black_Pawn_" + (this.square.getCol() + 1);
   }


   @Override
   public void move(Square newSquare) {
      // Check if the square is in the possible travel squares first

      if(!travelSquares.contains(newSquare))
         throw new IllegalArgumentException();

      this.board.update(this, newSquare);
      this.board.frame.movePiece(this.pieceName, square.getRow(), square.getCol(), newSquare.getRow(), newSquare.getCol());
      this.square = newSquare;
      this.setTravelSquares();
   }

   @Override
   public void setTravelSquares() {
      // This function should calculate and add in the travel squares the possibe squares
      // The pawn can move forward one square up or 2 if it is in the starting position
      // he can move left or right 1 square if it has a enemy
      // he can capture if an enemy pawn passed him with 2 squares ( el passante ) NOT CHECKED HERE
      this.travelSquares.clear();


      if(this.teamColor == Team.WHITE)
      {
         if(this.square.getRow() == this.board.getRows() - 2) {
            if(!this.board.isThereAPiece(this.square.getRow() - 1, this.square.getCol())) {
               this.travelSquares.add(new Square(this.board.getRows() - 3, this.square.getCol()));
               this.travelSquares.add(new Square(this.board.getRows() - 4, this.square.getCol()));
            }
         } else {
            // check if there s another piece there first
            if(!this.board.isThereAPiece(this.square.getRow() - 1, this.square.getCol()))
               this.travelSquares.add(new Square(this.square.getRow() - 1, this.square.getCol()));
         }
         // Checks if there is a piece that it can capture
         if(this.square.getCol() != 0 && this.square.getCol() != this.board.getColumns() - 1) {
            if(this.board.isThereAPiece(this.square.getRow() - 1, this.square.getCol() - 1)) {
               this.travelSquares.add(new Square(this.square.getRow() - 1, this.square.getCol() - 1));
            }

            if(this.board.isThereAPiece(this.square.getRow() - 1, this.square.getCol() + 1)) {
               this.travelSquares.add(new Square(this.square.getRow() - 1, this.square.getCol() + 1));
            }
         } else if(this.square.getCol() == 0) {
            if(this.board.isThereAPiece(this.square.getRow() - 1, this.square.getCol() + 1)) {
               this.travelSquares.add(new Square(this.square.getRow() - 1, this.square.getCol() + 1));
            }
         } else if(this.square.getCol() == this.board.getColumns() - 1) {
            if(this.board.isThereAPiece(this.square.getRow() - 1, this.square.getCol() - 1)) {
               this.travelSquares.add(new Square(this.square.getRow() - 1, this.square.getCol() - 1));
            }
         }

      }
      else if(this.teamColor == Team.BLACK)
      {
         if(this.square.getRow() == 1) {
            if(!this.board.isThereAPiece(this.square.getRow() + 1, this.square.getCol())) {
               this.travelSquares.add(new Square(2, this.square.getCol()));
               this.travelSquares.add(new Square(3, this.square.getCol()));
            }
         } else {
            if(!this.board.isThereAPiece(this.square.getRow() + 1, this.square.getCol()))
               this.travelSquares.add(new Square(this.square.getRow() + 1, this.square.getCol()));
         }

         if(this.square.getCol() != 0 && this.square.getCol() != this.board.getColumns() - 1) {
            if(this.board.isThereAPiece(this.square.getRow() + 1, this.square.getCol() - 1)) {
               this.travelSquares.add(new Square(this.square.getRow() + 1, this.square.getCol() - 1));
            }

            if(this.board.isThereAPiece(this.square.getRow() + 1, this.square.getCol() + 1)) {
               this.travelSquares.add(new Square(this.square.getRow() + 1, this.square.getCol() + 1));
            }
         } else if(this.square.getCol() == 0) {
            if(this.board.isThereAPiece(this.square.getRow() + 1, this.square.getCol() + 1)) {
               this.travelSquares.add(new Square(this.square.getRow() + 1, this.square.getCol() + 1));
            }
         } else if(this.square.getCol() == this.board.getColumns() - 1) {
            if (this.board.isThereAPiece(this.square.getRow() + 1, this.square.getCol() - 1)) {
               this.travelSquares.add(new Square(this.square.getRow() + 1, this.square.getCol() - 1));
            }
         }
      }
   }

   public Pawn(Pawn p) {
      super(p);
   }
   @Override
   public Piece clonePiece() {
      return new Pawn(this);
   }
}
