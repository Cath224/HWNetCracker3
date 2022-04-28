package com.netcracker.homework.ch9.ex1;

import java.util.ArrayList;

public class Rook extends ChessPiece implements Move {
    private final String rookABC;
    private final String color;

    public Rook(String rookABC, String color) {
        this.rookABC = rookABC;
        this.color = color;
    }

    @Override
    public void putDefaultPositionDesk() {

        ArrayList<String> rookWhite = new ArrayList<>();
        ArrayList<String> rookBlack = new ArrayList<>();


        rookBlack.add("a8");
        rookBlack.add("h8");
        rookWhite.add("a1");
        rookWhite.add("h1");

        if ("black".equals(color)) {
            System.out.println("rookBlackDefaultPosition  : " + rookBlack);
        } else if ("white".equals(color)) {
            System.out.println("rookWhiteDefaultPosition  : " + rookWhite);
        }
    }

    @Override
    public void putPosition() {

        ChessPiece chess = new ChessPiece();
        chess.setPosition();


        String[] rookArrayABC = (ChessPiece.getPosition()).split(" ");
        String[][] rookMatrixABC = Pawn.transformationMatrix(rookArrayABC);

        int xRook = 0;
        int yRook = 0;
        for (int i = 0; i < rookMatrixABC.length; i++) {
            for (int j = 0; j < rookMatrixABC.length; j++) {
                if (rookMatrixABC[i][j].equals(rookABC)) {
                    xRook = i;
                    yRook = j;

                }
            }
        }
        canMoveTo(xRook, yRook, color);
    }

    public void canMoveTo(int xRook, int yRook, String color) {

        String[] rookArray = (bishopPositionDesk(xRook, yRook, color).split(" "));
        String[][] rookMatrix = Pawn.transformationMatrix(rookArray);

        ArrayList<String> rookBlackMove = new ArrayList<>();
        ArrayList<String> rookWhiteMove = new ArrayList<>();

        if ("black".equals(color)) {
            if ( step(xRook,yRook,rookMatrix) ){
                rookBlackMove.add("Black bishop steps");
            }
            if (killFigures(xRook,yRook,rookMatrix,'w')){
                rookBlackMove.add("Black bishop kills");
            }
        }else if ("white".equals(color)) {

            if (step(xRook, yRook, rookMatrix)) {
                rookBlackMove.add("White bishop steps");
            }
            if (killFigures(xRook, yRook, rookMatrix, 'b')) {
                rookBlackMove.add("White bishop kills");
            }
        }


        System.out.print("operation : ");
        System.out.println(listAll(rookBlackMove, rookWhiteMove));
        System.out.println(bishopPositionDesk(xRook, yRook, color));
    }


    private boolean step(int xRook,int yRook,String[][] rookMatrix){
        boolean stepExist = false;


        int xRookFirstPosition = xRook;
        int yRookFirstPosition = yRook;

        while  (xRook+1  != 8 && rookMatrix[xRook+1][yRook ].equals("+")){
            xRook++;
            stepExist = true;
        }

        xRook = xRookFirstPosition ;
        yRook = yRookFirstPosition ;


        while  ( yRook-1 != -1 && rookMatrix[xRook][yRook-1 ].equals("+")){
            yRook--;
            stepExist = true;

        }
        xRook = xRookFirstPosition ;
        yRook = yRookFirstPosition ;

        while  (xRook-1 != -1  && rookMatrix[xRook -1][yRook].equals("+")){
            xRook--;
            stepExist = true;

        }
        xRook = xRookFirstPosition ;
        yRook = yRookFirstPosition ;

        while  ( yRook+1 != 8 && rookMatrix[xRook][yRook+1 ].equals("+") ){
            yRook++;
            stepExist = true;
        }

        return stepExist;
    }


    private boolean killFigures (int xRook,int yRook,String[][]  rookMatrix,char enemy) {
        boolean stepKill = false;

        int xRookFirstPosition = xRook;
        int yRookFirstPosition = yRook;

        while  (rookMatrix[xRook][yRook ].charAt(0) != enemy){
            xRook++;
            if (xRook  == 8 ){
                break;
            }else if (rookMatrix[xRook][yRook].charAt(0) == enemy){
                stepKill = true;
            }
        }
        xRook = xRookFirstPosition ;

        while  (rookMatrix[xRook][yRook ].charAt(0) != enemy){
            yRook--;
            if (yRook == -1){
                break;
            }else if (rookMatrix[xRook][yRook ].charAt(0) == enemy){
                stepKill = true;
            }
        }
        yRook = yRookFirstPosition ;

        while  (rookMatrix[xRook][yRook ].charAt(0) != enemy){
            xRook--;
            if (xRook == -1){
                break;
            }else if (rookMatrix[xRook][yRook ].charAt(0) == enemy){
                stepKill = true;
            }
        }
        xRook = xRookFirstPosition ;

        while  (rookMatrix[xRook][yRook ].charAt(0) != enemy){
            yRook++;
            if (yRook == 8){
                break;
            }else if (rookMatrix[xRook][yRook ].charAt(0) == enemy){
                stepKill = true;
            }

        }

        return stepKill;
    }


    public ArrayList<ArrayList> listAll(ArrayList<String> rookBlackMoves, ArrayList<String> rookWhiteMove) {
        ArrayList<ArrayList> rookAllMoves = new ArrayList<>();
        rookAllMoves.add(rookBlackMoves);
        rookAllMoves.add(rookWhiteMove);
        return rookAllMoves;
    }



    public  String bishopPositionDesk(int xRook, int yRook, String color) {
        String board = "";
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (x == 1 && y == 5){
                    board += "wb ";
                }else if (x == xRook && y == yRook && "black".equals(color)) {
                    board += "br ";
                } else if (x == xRook && y == yRook && "white".equals(color)) {
                    board += "wr ";
                } else {
                    board += "+ ";
                }
            }
            board += "\n";
        }
        return board;
    }

}