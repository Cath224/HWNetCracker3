package com.netcracker.homework.ch9.ex1;

import java.util.ArrayList;

public class King extends ChessPiece implements Move {
    private final String kingABC;
    private final String color;

    public King(String kingABC, String color) {
        this.kingABC = kingABC;
        this.color = color;
    }

    @Override
    public void putDefaultPositionDesk() {

        ArrayList<String> kingWhite = new ArrayList<>();
        ArrayList<String> kingBlack = new ArrayList<>();


        kingBlack.add("e8");

        kingWhite.add("e1");


        if ("black".equals(color)) {
            System.out.println("knightBlackDefaultPosition  : " + kingBlack);
        } else if ("white".equals(color)) {
            System.out.println("knightWhiteDefaultPosition  : " + kingWhite);
        }
    }

    @Override
    public void putPosition() {

        ChessPiece chess = new ChessPiece();
        chess.setPosition();
        chess.setColorDesk();


        String[] kingArrayABC = (ChessPiece.getPosition()).split(" ");
        String[][] kingMatrixABC = Pawn.transformationMatrix(kingArrayABC);



        int xKing = 0;
        int yKing = 0;
        for (int i = 0; i < kingMatrixABC.length; i++) {
            for (int j = 0; j < kingMatrixABC.length; j++) {
                if (kingMatrixABC[i][j].equals(kingABC)) {
                    xKing = i;
                    yKing = j;

                }
            }
        }
        canMoveTo(xKing, yKing, color);
    }

    public void canMoveTo(int xKing, int yKing, String color) {

        String[] kingArray = (kingPositionDesk(xKing, yKing, color).split(" "));
        String[][] kingMatrix = Pawn.transformationMatrix(kingArray);

        ArrayList<String> kingBlackMove = new ArrayList<>();
        ArrayList<String> kingWhiteMove = new ArrayList<>();

        if ("black".equals(color)) {

            if ( step(xKing,yKing,kingMatrix) ){
                kingBlackMove.add("Black knight steps");
            }
            if (killFigures(xKing,yKing,kingMatrix,'w')){
                kingBlackMove.add("Black knight kills");
            }
        }else if ("white".equals(color)) {

            if (step(xKing, yKing, kingMatrix)) {
                kingBlackMove.add("White knight steps");
            }
            if (killFigures(xKing, yKing, kingMatrix, 'b')) {
                kingBlackMove.add("White knight kills");
            }
        }


        System.out.print("operation : ");
        System.out.println(listAll(kingBlackMove, kingWhiteMove));
        System.out.println(kingPositionDesk(xKing, yKing, color));
    }


    private boolean step(int xKing,int yKing,String[][] kingMatrix) {
        boolean stepExist = false;

        if (xKing+1  != 8 && kingMatrix[xKing+1][yKing ].equals("+")){
            stepExist = true;
        }

        if ( yKing-1 != -1 && kingMatrix[xKing][yKing-1 ].equals("+")){
            stepExist = true;
        }


        if (xKing-1 != -1  && kingMatrix[xKing -1][yKing].equals("+")){
            stepExist = true;

        }

        if ( yKing+1 != 8 && kingMatrix[xKing][yKing+1 ].equals("+") ){
            stepExist = true;
        }

        return stepExist;
    }
    private boolean killFigures (int xKing, int yKing, String[][] kingMatrix, char enemy) {
        boolean stepKill = false;

        if (xKing+1  != 8 && kingMatrix[xKing+1][yKing ].charAt(0) == enemy){
            stepKill = true;
        }
        if ( yKing-1 != -1 && kingMatrix[xKing][yKing-1 ].charAt(0) == enemy){
            stepKill = true;
        }
        if (xKing-1 != -1  && kingMatrix[xKing -1][yKing].charAt(0) == enemy) {
            stepKill = true;
        }
        if ( yKing+1 != 8 && kingMatrix[xKing][yKing+1 ].charAt(0) == enemy ){
            stepKill = true;
        }

        return stepKill;
    }


    public ArrayList<ArrayList> listAll(ArrayList<String> kingBlackMoves, ArrayList<String> kingWhiteMove) {
        ArrayList<ArrayList> kingAllMoves = new ArrayList<>();
        kingAllMoves.add(kingBlackMoves);
        kingAllMoves.add(kingWhiteMove);
        return kingAllMoves;
    }



    public  String kingPositionDesk(int xKing, int yKing, String color) {
        String board = "";
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (x == 1 && y == 5){
                    board += "wQ ";
                }else if (x == xKing && y == yKing && "black".equals(color)) {
                    board += "bK ";
                } else if (x == xKing && y == yKing && "white".equals(color)) {
                    board += "wK ";
                } else {
                    board += "+ ";
                }
            }
            board += "\n";
        }
        return board;
    }

}