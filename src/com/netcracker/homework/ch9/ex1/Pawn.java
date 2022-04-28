package com.netcracker.homework.ch9.ex1;

import java.util.ArrayList;

public class Pawn extends ChessPiece implements Move {
    private final String pawnABC;
    private final String color;

    public Pawn(String pawnABC, String color) {
        this.pawnABC = pawnABC;
        this.color = color;
    }
    @Override
    public void putDefaultPositionDesk() {

        ArrayList<String> pawnWhite = new ArrayList<>();
        ArrayList<String> pawnBlack = new ArrayList<>();


        String pawnWhiteDefaultPosition = "";
        String pawnBlackDefaultPosition = "";
        char sighABC = 'a';
        for (int j = 0; j < 8; j++) {
            pawnWhiteDefaultPosition = sighABC + "" + 2;
            pawnBlackDefaultPosition = sighABC + "" + 7;
            sighABC++;
            if (j == 7 && sighABC == 'h') {
                break;
            }

            pawnWhite.add(pawnWhiteDefaultPosition);
            pawnBlack.add(pawnBlackDefaultPosition);

        }
        if ("black".equals(color)) {
            System.out.println("pawnBlackDefaultPosition  : " + pawnBlack);
        } else if( "white".equals(color)){
            System.out.println("pawnWhiteDefaultPosition  : " + pawnWhite);
        }
    }

    @Override
    public void putPosition() {

        ChessPiece chess = new ChessPiece();
        chess.setPosition();


        String[] pawnArrayABC = (ChessPiece.getPosition()).split(" ");
        String[][] pawnMatrixABC = transformationMatrix(pawnArrayABC);

        int xPawn = 0;
        int yPawn = 0;
        for (int i = 0; i < pawnMatrixABC.length; i++) {
            for (int j = 0; j < pawnMatrixABC.length; j++) {
                if (pawnMatrixABC[i][j].equals(pawnABC)) {
                    xPawn = i;
                    yPawn = j;

                }
            }
        }
        canMoveTo(xPawn, yPawn, color);
    }

    public void canMoveTo(int xPawn,int yPawn,String color) {


        String[] pawnArray = (pawnPositionDesk(xPawn, yPawn, color).split(" "));
        String[][] pawnMatrix = transformationMatrix(pawnArray);

        ArrayList<String> pawnBlackMove = new ArrayList<>();
        ArrayList<String> pawnWhiteMove = new ArrayList<>();

        if ("black".equals(color)) {
            if (xPawn == 7) {
                pawnMatrix[xPawn][yPawn] = "bQ";
                pawnBlackMove.add("black pawn promoted to Queen");


            } else if (pawnMatrix[xPawn + 1][yPawn].equals("+")) {
                pawnBlackMove.add("black pawn steps forward");
                if (yPawn != 7) {
                    if (pawnMatrix[xPawn + 1][yPawn + 1].charAt(0) =='w') {
                        pawnBlackMove.add("black pawn kills the right figure");
                    }
                }
                if (yPawn != 0) {
                    if (pawnMatrix[xPawn + 1][yPawn - 1].charAt(0) =='w'){
                        pawnBlackMove.add("black pawn kills the left figure");
                    }
                }
            }

        }else if ( "white".equals(color)) {
            if (xPawn == 0) {
                pawnMatrix[xPawn][yPawn] = "wQ";
                pawnWhiteMove.add("white pawn promoted to Queen");

            } else if (pawnMatrix[xPawn - 1][yPawn].equals("+")) {
                pawnWhiteMove.add("white pawn steps forward");
                if (yPawn != 7) {
                    if (pawnMatrix[xPawn - 1][yPawn + 1].charAt(0) =='b') {
                        pawnWhiteMove.add("white pawn kills the right figure");
                    }
                }
                if (yPawn != 0) {
                    if (pawnMatrix[xPawn - 1][yPawn - 1].charAt(0) =='b') {
                        pawnWhiteMove.add("white pawn kills the left figure");
                    }
                }
            }
        }

        System.out.print("operation : " );
        System.out.println(listAll(pawnBlackMove,pawnWhiteMove));
        System.out.println(pawnPositionDesk(xPawn, yPawn, color));
    }

    public ArrayList<ArrayList> listAll(ArrayList<String> pawnBlackMoves,ArrayList<String> pawnWhiteMove){
        ArrayList<ArrayList> pawnAllMoves = new ArrayList<>();
        pawnAllMoves.add(pawnBlackMoves);
        pawnAllMoves.add(pawnWhiteMove);
        return pawnAllMoves;
    }


    public static String[][] transformationMatrix(String[] array){

        int count = 0;
        String[][] matrix = new String[8][8];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = array[count++];

            }
        }
        return matrix;
    }

    public  String pawnPositionDesk(int xPawn , int yPawn , String color){
        String board = "";
        for ( int x = 0; x<8; x++) {
            for (int y = 0; y < 8 ; y++) {
                if (x == 2 && y == 3){
                    board += "bk ";
                } else if (x == xPawn && y == yPawn &&  "white".equals(color)){
                    board += "wp ";
                }else if (x == xPawn && y == yPawn && "black".equals(color)){
                    board += "bp ";
                }else{
                    board += "+ ";
                }
            }
            board += "\n";
        }
        return board;
    }

}