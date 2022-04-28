package com.netcracker.homework.ch9.ex1;

public class Main {
    public static void main(String[] args) {

        ChessPiece chess = new ChessPiece();
        System.out.println("Correct positioning of figures: \n"  + chess);

        chess.setPosition();
        System.out.println("\nA1B2C3 desk: \n" +chess.getPosition());
        chess.setColorDesk();
        System.out.println("\nColor desk: \n" +chess.getColorDesk());

        System.out.println("\n\tPawn\n");

        Move pawnBlack = new Pawn("g1","black");
        motion(pawnBlack);
        Move pawnWhite = new Pawn("c5","white");
        motion(pawnWhite);

        System.out.println("\n\tKnight\n");

        Move knightWhite = new Knight("d6", "white");
        motion(knightWhite);
        Move knightBlack = new Knight("d8", "black");
        motion(knightBlack);

        System.out.println("\n\tBishop\n");

        Move bishopBlack = new Bishop("b3", "black");
        motion(bishopBlack);
        Move bishopWhite = new Bishop("g6", "white");
        motion(bishopWhite);

        System.out.println("\n\tRook\n");

        Move rookBlack = new Rook("c7", "black");
        motion(rookBlack);
        Move rookWhite = new Rook("f4", "white");
        motion(rookWhite);

        System.out.println("\n\tQueen\n");

        Move queenBlack = new Queen("d5","black");
        motion(queenBlack);
        Move queenWhite = new Queen("f6","white");
        motion(queenWhite);

        System.out.println("\n\tKing\n");

        Move kingBlack = new King("d5","black");
        motion(kingBlack);
        Move kingWhite = new King("h8","white");
        motion(kingWhite);
    }

    public static void motion(Move figure){
        figure.putDefaultPositionDesk();
        figure.putPosition();
    }
}