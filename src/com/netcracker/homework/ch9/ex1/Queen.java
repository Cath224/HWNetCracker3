package com.netcracker.homework.ch9.ex1;

import java.util.ArrayList;

public class Queen extends ChessPiece implements Move {
    private final String queenABC;
    private final String color;

    public Queen(String queenABC, String color) {
        this.queenABC = queenABC;
        this.color = color;
    }

    @Override
    public void putDefaultPositionDesk() {

        ArrayList<String> queenWhite = new ArrayList<>();
        ArrayList<String> queenBlack = new ArrayList<>();


        queenBlack.add("d8");
        queenWhite.add("d1");

        if ("black".equals(color)) {
            System.out.println("queenBlackDefaultPosition  : " + queenBlack);
        } else if ("white".equals(color)) {
            System.out.println("queenWhiteDefaultPosition  : " + queenWhite);
        }
    }

    @Override
    public void putPosition() {

        ChessPiece chess = new ChessPiece();
        chess.setPosition();


        String[] bishopArrayABC = (ChessPiece.getPosition()).split(" ");
        String[][] queenMatrixABC = Pawn.transformationMatrix(bishopArrayABC);



        int xQueen = 0;
        int yQueen = 0;
        for (int i = 0; i < queenMatrixABC.length; i++) {
            for (int j = 0; j < queenMatrixABC.length; j++) {
                if (queenMatrixABC[i][j].equals(queenABC)) {
                    xQueen = i;
                    yQueen = j;

                }
            }
        }
        canMoveTo(xQueen, yQueen, color);
    }

    public void canMoveTo(int xQueen, int yQueen, String color) {

        String[] queenArray = (queenPositionDesk(xQueen, yQueen, color).split(" "));
        String[][] queenMatrix = Pawn.transformationMatrix(queenArray);

        ArrayList<String> queenBlackMove = new ArrayList<>();
        ArrayList<String> queenWhiteMove = new ArrayList<>();

        if ("black".equals(color)) {
            if ( step(xQueen,yQueen,queenMatrix) ){
                queenBlackMove.add("Black queen steps");
            }
            if (killFigures(xQueen,yQueen,queenMatrix,'w')){
                queenBlackMove.add("Black queen kills");
            }
        }else if ("white".equals(color)) {

            if (step(xQueen, yQueen, queenMatrix)) {
                queenBlackMove.add("White queen steps");
            }
            if (killFigures(xQueen, yQueen, queenMatrix, 'b')) {
                queenBlackMove.add("White queen kills");
            }
        }


        System.out.print("operation : ");
        System.out.println(listAll(queenBlackMove, queenWhiteMove));
        System.out.println(queenPositionDesk(xQueen, yQueen, color));
    }


    private boolean step(int xQueen,int yQueen,String[][] queenMatrix){
        boolean stepExist = false;


        int xQueenFirstPosition = xQueen;
        int yQueenFirstPosition = yQueen;

        while  (xQueen+1  != 8 && yQueen+1  != 8 && queenMatrix[xQueen+1][yQueen+1 ].equals("+")){
            xQueen++;
            yQueen++;
            stepExist = true;
        }

        xQueen = xQueenFirstPosition ;
        yQueen = yQueenFirstPosition ;


        while  (xQueen+1  != 8 && yQueen-1 != -1 && queenMatrix[xQueen+1][yQueen-1 ].equals("+")){
            xQueen++;
            yQueen--;
            stepExist = true;

        }
        xQueen = xQueenFirstPosition ;
        yQueen = yQueenFirstPosition ;

        while  (xQueen-1 != -1 && yQueen-1 != -1 && queenMatrix[xQueen -1][yQueen-1 ].equals("+")){
            xQueen--;
            yQueen--;
            stepExist = true;

        }
        xQueen = xQueenFirstPosition ;
        yQueen = yQueenFirstPosition ;

        while  (xQueen-1 != -1 && yQueen +1 != 8 && queenMatrix[xQueen-1][yQueen+1 ].equals("+") ){
            xQueen--;
            yQueen++;
            stepExist = true;
        }
        xQueen = xQueenFirstPosition ;
        yQueen = yQueenFirstPosition ;

        while  (xQueen+1 != 8 && queenMatrix[xQueen+1][yQueen ].equals("+")){
            xQueen++;
            stepExist = true;
        }

        xQueen = xQueenFirstPosition ;
        yQueen = yQueenFirstPosition ;


        while  ( yQueen-1 != -1 && queenMatrix[xQueen][yQueen-1 ].equals("+")){
            yQueen--;
            stepExist = true;

        }
        xQueen = xQueenFirstPosition ;
        yQueen = yQueenFirstPosition ;

        while  (xQueen-1 != -1  && queenMatrix[xQueen -1][yQueen].equals("+")){
            xQueen--;
            stepExist = true;

        }

        xQueen = xQueenFirstPosition ;
        yQueen = yQueenFirstPosition ;

        while  ( yQueen+1 != 8 && queenMatrix[xQueen][yQueen+1 ].equals("+") ){
            yQueen++;
            stepExist = true;
        }
        return stepExist;
    }


    private boolean killFigures (int xQueen,int yQueen,String[][]  queenMatrix,char enemy) {
        boolean stepKill = false;

        int xQueenFirstPosition = xQueen;
        int yQueenFirstPosition = yQueen;

        while  (queenMatrix[xQueen][yQueen ].charAt(0) != enemy){
            xQueen++;
            yQueen++;
            if (xQueen  == 8 || yQueen  == 8){
                break;
            }else if (queenMatrix[xQueen][yQueen].charAt(0) == enemy){
                stepKill = true;
            }
        }
        xQueen = xQueenFirstPosition ;
        yQueen = yQueenFirstPosition ;

        while  (queenMatrix[xQueen][yQueen ].charAt(0) != enemy){
            xQueen++;
            yQueen--;
            if (xQueen  == 8 || yQueen == -1){
                break;
            }else if (queenMatrix[xQueen][yQueen ].charAt(0) == enemy){
                stepKill = true;
            }
        }
        xQueen = xQueenFirstPosition ;
        yQueen = yQueenFirstPosition ;

        while  (queenMatrix[xQueen][yQueen ].charAt(0) != enemy){
            xQueen--;
            yQueen--;
            if (xQueen == -1 || yQueen == -1){
                break;
            }else if (queenMatrix[xQueen][yQueen ].charAt(0) == enemy){
                stepKill = true;
            }
        }
        xQueen = xQueenFirstPosition ;
        yQueen = yQueenFirstPosition ;

        while  (queenMatrix[xQueen][yQueen ].charAt(0) != enemy){
            xQueen--;
            yQueen++;
            if (xQueen == -1 || yQueen == 8){
                break;
            }else if (queenMatrix[xQueen][yQueen ].charAt(0) == enemy){
                stepKill = true;
            }
        }
        xQueen = xQueenFirstPosition ;
        yQueen = yQueenFirstPosition ;

        while  (queenMatrix[xQueen][yQueen ].charAt(0) != enemy){
            xQueen++;
            if (xQueen  == 8 ){
                break;
            }else if (queenMatrix[xQueen][yQueen].charAt(0) == enemy){
                stepKill = true;
            }
        }
        xQueen = xQueenFirstPosition;

        while  (queenMatrix[xQueen][yQueen ].charAt(0) != enemy){
            yQueen--;
            if (yQueen == -1){
                break;
            }else if (queenMatrix[xQueen][yQueen ].charAt(0) == enemy){
                stepKill = true;
            }
        }
        yQueen = yQueenFirstPosition ;

        while  (queenMatrix[xQueen][yQueen ].charAt(0) != enemy){
            xQueen--;
            if (xQueen == -1){
                break;
            }else if (queenMatrix[xQueen][yQueen ].charAt(0) == enemy){
                stepKill = true;
            }
        }
        xQueen = xQueenFirstPosition;

        while  (queenMatrix[xQueen][yQueen].charAt(0) != enemy){
            yQueen++;
            if (yQueen == 8){
                break;
            }else if (queenMatrix[xQueen][yQueen].charAt(0) == enemy){
                stepKill = true;
            }
        }

        return stepKill;
    }


    public ArrayList<ArrayList> listAll(ArrayList<String> queenBlackMoves, ArrayList<String> queenWhiteMove) {
        ArrayList<ArrayList> queenAllMoves = new ArrayList<>();
        queenAllMoves.add(queenBlackMoves);
        queenAllMoves.add(queenWhiteMove);
        return queenAllMoves;
    }



    public  String queenPositionDesk(int xQueen, int yQueen, String color) {
        String board = "";
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (x == 1 && y == 5){
                    board += "wr ";
                }else if (x == xQueen && y == yQueen && "black".equals(color)) {
                    board += "bQ ";
                } else if (x == xQueen && y == yQueen && "white".equals(color)) {
                    board += "wQ ";
                } else {
                    board += "+ ";
                }
            }
            board += "\n";
        }
        return board;
    }

}