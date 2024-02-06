package org.chess;
import org.chess.gui.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Board mainBoard = new Board();
        //mainBoard.printBoard();

        Scanner scanner = new Scanner(System.in);

        while(true) {
            try {
                mainBoard.printBoard();
                System.out.println();
                System.out.println("Choose pawn first row: ");
                int row = scanner.nextInt();
                System.out.println("Choose pawn second col: ");
                int col = scanner.nextInt();

                if (!mainBoard.isThereAPiece(row, col))
                    continue;

                System.out.println("Choose where to move row first: ");
                int moveRow = scanner.nextInt();
                System.out.printf("Choose where to move col second: ");
                int moveCol = scanner.nextInt();


                mainBoard.processMove(new Square(row, col), new Square(moveRow, moveCol));
            } catch(Throwable t) {
                System.out.println(t.getMessage());
            }
        }




    }
}