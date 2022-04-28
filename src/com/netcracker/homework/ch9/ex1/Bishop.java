package com.netcracker.homework.ch9.ex1;

import java.util.ArrayList;

public class Bishop extends ChessPiece implements Move {
    private final String bishopABC;
    private final String color;

    public Bishop(String bishopABC, String color) {
        this.bishopABC = bishopABC;
        this.color = color;
    }

    @Override
    public void putDefaultPositionDesk() {

        ArrayList<String> bishopWhite = new ArrayList<>();
        ArrayList<String> bishopBlack = new ArrayList<>();


        bishopBlack.add("c8");
        bishopBlack.add("f8");
        bishopWhite.add("c1");
        bishopWhite.add("f1");

        if ("black".equals(color)) {
            System.out.println("bishopBlackDefaultPosition  : " + bishopBlack);
        } else if ("white".equals(color)) {
            System.out.println("bishopWhiteDefaultPosition  : " + bishopWhite);
        }
    }

    @Override
    public void putPosition() {

        ChessPiece chess = new ChessPiece();
        chess.setPosition();


        String[] bishopArrayABC = (ChessPiece.getPosition()).split(" ");
        String[][] bishopMatrixABC = Pawn.transformationMatrix(bishopArrayABC);



        int xBishop = 0;
        int yBishop = 0;
        for (int i = 0; i < bishopMatrixABC.length; i++) {
            for (int j = 0; j < bishopMatrixABC.length; j++) {
                if (bishopMatrixABC[i][j].equals(bishopABC)) {
                    xBishop = i;
                    yBishop = j;

                }
            }
        }
        canMoveTo(xBishop, yBishop, color);
    }

    public void canMoveTo(int xBishop, int yBishop, String color) {

        String[] bishopArray = (bishopPositionDesk(xBishop, yBishop, color).split(" "));
        String[][] bishopMatrix = Pawn.transformationMatrix(bishopArray);

        ArrayList<String> bishopBlackMove = new ArrayList<>();
        ArrayList<String> bishopWhiteMove = new ArrayList<>();

        if ("black".equals(color)) {
            if ( step(xBishop,yBishop,bishopMatrix) ){
                bishopBlackMove.add("Black bishop steps");
            }
            if (killFigures(xBishop,yBishop,bishopMatrix,'w')){
                bishopBlackMove.add("Black bishop kills");
            }
        }else if ("white".equals(color)) {

            if (step(xBishop, yBishop, bishopMatrix)) {
                bishopBlackMove.add("White bishop steps");
            }
            if (killFigures(xBishop, yBishop, bishopMatrix, 'b')) {
                bishopBlackMove.add("White bishop kills");
            }
        }


        System.out.print("operation : ");
        System.out.println(listAll(bishopBlackMove, bishopWhiteMove));
        System.out.println(bishopPositionDesk(xBishop, yBishop, color));
    }


    private boolean step(int xBishop,int yBishop,String[][] bishopMatrix){
        boolean stepExist = false;


        int xBishopFirstPosition = xBishop;
        int yBishopFirstPosition = yBishop;

        while  (xBishop+1  != 8 && yBishop+1  != 8 && bishopMatrix[xBishop+1][yBishop+1 ].equals("+")){
            xBishop++;
            yBishop++;
            stepExist = true;
        }

        xBishop = xBishopFirstPosition ;
        yBishop = yBishopFirstPosition ;


        while  (xBishop+1  != 8 && yBishop-1 != -1 && bishopMatrix[xBishop+1][yBishop-1 ].equals("+")){
            xBishop++;
            yBishop--;
            stepExist = true;

        }
        xBishop = xBishopFirstPosition ;
        yBishop = yBishopFirstPosition ;

        while  (xBishop-1 != -1 && yBishop-1 != -1 && bishopMatrix[xBishop -1][yBishop-1 ].equals("+")){
            xBishop--;
            yBishop--;
            stepExist = true;

        }
        xBishop = xBishopFirstPosition ;
        yBishop = yBishopFirstPosition ;

        while  (xBishop-1 != -1 && yBishop +1 != 8 && bishopMatrix[xBishop-1][yBishop+1 ].equals("+") ){
            xBishop--;
            yBishop++;
            stepExist = true;
        }

        return stepExist;
    }


    private boolean killFigures (int xBishop,int yBishop,String[][]  bishopMatrix,char enemy) {
        boolean stepKill = false;

        int xBishopFirstPosition = xBishop;
        int yBishopFirstPosition = yBishop;

        while  (bishopMatrix[xBishop][yBishop ].charAt(0) != enemy){
            xBishop++;
            yBishop++;
            if (xBishop  == 8 || yBishop  == 8){
                break;
            }else if (bishopMatrix[xBishop][yBishop].charAt(0) == enemy){
                stepKill = true;
            }
        }
        xBishop = xBishopFirstPosition ;
        yBishop = yBishopFirstPosition ;

        while  (bishopMatrix[xBishop][yBishop ].charAt(0) != enemy){
            xBishop++;
            yBishop--;
            if (xBishop  == 8 || yBishop == -1){
                break;
            }else if (bishopMatrix[xBishop][yBishop ].charAt(0) == enemy){
                stepKill = true;
            }
        }
        xBishop = xBishopFirstPosition ;
        yBishop = yBishopFirstPosition ;

        while  (bishopMatrix[xBishop][yBishop ].charAt(0) != enemy){
            xBishop--;
            yBishop--;
            if (xBishop == -1 || yBishop == -1){
                break;
            }else if (bishopMatrix[xBishop][yBishop ].charAt(0) == enemy){
                stepKill = true;
            }
        }
        xBishop = xBishopFirstPosition ;
        yBishop = yBishopFirstPosition ;

        while  (bishopMatrix[xBishop][yBishop ].charAt(0) != enemy){
            xBishop--;
            yBishop++;
            if (xBishop == -1 || yBishop == 8){
                break;
            }else if (bishopMatrix[xBishop][yBishop ].charAt(0) == enemy){
                stepKill = true;
            }

        }

        return stepKill;
    }


    public ArrayList<ArrayList> listAll(ArrayList<String> bishopBlackMoves, ArrayList<String> bishopWhiteMove) {
        ArrayList<ArrayList> bishopAllMoves = new ArrayList<>();
        bishopAllMoves.add(bishopBlackMoves);
        bishopAllMoves.add(bishopWhiteMove);
        return bishopAllMoves;
    }



    public  String bishopPositionDesk(int xBishop, int yBishop, String color) {
        String board = "";
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (x == 1 && y == 5){
                    board += "wp ";
                }else if (x == xBishop && y == yBishop && "black".equals(color)) {
                    board += "bb ";
                } else if (x == xBishop && y == yBishop && "white".equals(color)) {
                    board += "wb ";
                } else {
                    board += "+ ";
                }
            }
            board += "\n";
        }
        return board;
    }

}