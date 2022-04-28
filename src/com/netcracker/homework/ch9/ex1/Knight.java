package com.netcracker.homework.ch9.ex1;

import java.util.ArrayList;

public class Knight extends ChessPiece implements Move {
    private final String knightABC;
    private final String color;

    public Knight(String knightABC, String color) {
        this.knightABC = knightABC;
        this.color = color;
    }

    @Override
    public void putDefaultPositionDesk() {

        ArrayList<String> knightWhite = new ArrayList<>();
        ArrayList<String> knightBlack = new ArrayList<>();


        knightBlack.add("b8");
        knightBlack.add("g8");
        knightWhite.add("b1");
        knightWhite.add("g1");

        if ("black".equals(color)) {
            System.out.println("knightBlackDefaultPosition  : " + knightBlack);
        } else if ("white".equals(color)) {
            System.out.println("knightWhiteDefaultPosition  : " + knightWhite);
        }
    }

    @Override
    public void putPosition() {

        ChessPiece chess = new ChessPiece();
        chess.setPosition();
        chess.setColorDesk();


        String[] knightArrayABC = (ChessPiece.getPosition()).split(" ");
        String[][] knightMatrixABC = Pawn.transformationMatrix(knightArrayABC);



        int xKnight = 0;
        int yKnight = 0;
        for (int i = 0; i < knightMatrixABC.length; i++) {
            for (int j = 0; j < knightMatrixABC.length; j++) {
                if (knightMatrixABC[i][j].equals(knightABC)) {
                    xKnight = i;
                    yKnight = j;

                }
            }
        }
        canMoveTo(xKnight, yKnight, color);
    }

    public void canMoveTo(int xKnight, int yKnight, String color) {

        String[] knightArray = (knightPositionDesk(xKnight, yKnight, color).split(" "));
        String[][] knightMatrix = Pawn.transformationMatrix(knightArray);

        ArrayList<String> knightBlackMove = new ArrayList<>();
        ArrayList<String> knightWhiteMove = new ArrayList<>();

        if ("black".equals(color)) {

            if ( step(xKnight,yKnight,knightMatrix) ){
                knightBlackMove.add("Black knight steps");
            }
            if (killFigures(xKnight,yKnight,knightMatrix,'w')){
                knightBlackMove.add("Black knight kills");
            }
        }else if ("white".equals(color)) {

            if (step(xKnight, yKnight, knightMatrix)) {
                knightBlackMove.add("White knight steps");
            }
            if (killFigures(xKnight, yKnight, knightMatrix, 'b')) {
                knightBlackMove.add("White knight kills");
            }
        }


        System.out.print("operation : ");
        System.out.println(listAll(knightBlackMove, knightWhiteMove));
        System.out.println(knightPositionDesk(xKnight, yKnight, color));
    }


    private boolean step(int xKnight,int yKnight,String[][] knightMatrix) {
        boolean stepExist = false;
        if (xKnight - 2 > 0) {
            if (yKnight + 1 < 8 && knightMatrix[xKnight - 2][yKnight + 1].equals("+")) {
                stepExist = true;
            }
            if (yKnight - 1 > 0 && knightMatrix[xKnight - 2][yKnight - 1].equals("+")) {
                stepExist = true;
            }
        }
        if (xKnight - 1 > 0) {
            if (yKnight + 2 < 8 && knightMatrix[xKnight - 1][yKnight + 2].equals("+")) {
                stepExist = true;
            }
            if (yKnight - 2 > 0 && knightMatrix[xKnight - 1][yKnight - 2].equals("+")) {
                stepExist = true;
            }
        }
        if (xKnight + 1 < 8) {
            if (yKnight + 2 < 8 && knightMatrix[xKnight + 1][yKnight + 2].equals("+")) {
                stepExist = true;
            }
            if (yKnight - 2 > 0 && knightMatrix[xKnight + 1][yKnight - 2].equals("+")) {
                stepExist = true;
            }
        }
        if (xKnight + 2 < 8) {
            if (yKnight + 2 < 8) {
                if (knightMatrix[xKnight + 2][yKnight + 2].equals("+")) {
                    stepExist = true;
                }
                if (yKnight - 2 > 0) {
                    if (knightMatrix[xKnight + 2][yKnight - 2].equals("+")) {
                        stepExist = true;
                    }
                }

            }
        }
        return stepExist;
    }
    private boolean killFigures (int xKnight,int yKnight,String[][] knightMatrix,char enemy) {
        boolean stepKill = false;
        if (xKnight - 2 > 0) {
            if (yKnight + 1 < 8 && knightMatrix[xKnight - 2][yKnight +1 ].charAt(0) == enemy) {
                stepKill =true;
            }
            if (yKnight - 1 > 0 && knightMatrix[xKnight - 2][yKnight - 1 ].charAt(0) == enemy) {
                stepKill =true;
            }
        }
        if (xKnight - 1 > 0) {
            if (yKnight + 2 < 8 &&  knightMatrix[xKnight -1][yKnight + 2 ].charAt(0) == enemy) {
                stepKill =true;
            }
            if (yKnight - 2 > 0 && knightMatrix[xKnight - 1][yKnight - 2 ].charAt(0) == enemy) {
                stepKill =true;
            }
        }
        if (xKnight + 1 < 8) {
            if (yKnight + 2 < 8 && knightMatrix[xKnight + 1][yKnight +2 ].charAt(0) == enemy) {
                stepKill =true;
            }
            if (yKnight - 2 > 0 && knightMatrix[xKnight + 1][yKnight - 2 ].charAt(0) == enemy ){
                stepKill =true;
            }
        }
        if (xKnight + 2 < 8) {
            if (yKnight + 2 < 8 && knightMatrix[xKnight + 2][yKnight + 2 ].charAt(0) == enemy){
                stepKill =true;
            }
            if (yKnight - 2 > 0 && knightMatrix[xKnight + 2][yKnight -2 ].charAt(0) == enemy ) {
                stepKill =true;
            }
        }
        return stepKill;
    }


    public ArrayList<ArrayList> listAll(ArrayList<String> knightBlackMoves, ArrayList<String> knightWhiteMove) {
        ArrayList<ArrayList> knightAllMoves = new ArrayList<>();
        knightAllMoves.add(knightBlackMoves);
        knightAllMoves.add(knightWhiteMove);
        return knightAllMoves;
    }



    public  String knightPositionDesk(int xKnight, int yKnight, String color) {
        String board = "";
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (x == 1 && y == 5){
                    board += "wr ";
                }else if (x == xKnight && y == yKnight && "black".equals(color)) {
                    board += "bk ";
                } else if (x == xKnight && y == yKnight && "white".equals(color)) {
                    board += "wk ";
                } else {
                    board += "+ ";
                }
            }
            board += "\n";
        }
        return board;
    }
}
