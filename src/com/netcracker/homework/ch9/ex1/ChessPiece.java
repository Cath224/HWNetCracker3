package com.netcracker.homework.ch9.ex1;

public class ChessPiece {
    private  String[][] chessDesk = new String[8][8];
    private static String position;
    private static String colorDesk;



    ChessPiece() {
        this.position = "";
        this.colorDesk = "";
    }

    public static String getPosition() {
        return position;

    }


    public void setPosition() {

        for (int x = chessDesk.length - 1; x >= 0; x--) {
            char sighABC = 'a';
            for (int y = 0; y < chessDesk.length; y++) {

                chessDesk[x][y] = sighABC + "" + (x + 1);
                sighABC++;
                if (y == 7 && sighABC == 'h') {
                    break;
                }
                position += chessDesk[x][y] + " ";

            }
            position += "\n";
        }
    }

    public void setColorDesk() {

        for (int x = 0; x< chessDesk.length;x++) {
            for (int y = 0; y < chessDesk.length; y++) {
                if(x % 2==0) {
                    if (y % 2 == 0) {
                        chessDesk[x][y] ="w";
                    } else {
                        chessDesk[x][y]= "b";
                    }
                } else{
                    if (y % 2 == 0) {
                        chessDesk[x][y]= "b";
                    } else {
                        chessDesk[x][y]= "w";
                    }
                }
                colorDesk +=chessDesk[x][y] + " ";
            }
            colorDesk += "\n";
        }

    }

    public static String getColorDesk() {
        return colorDesk;
    }


    @Override
    public String toString() {
        String board = "";
        for (int x = chessDesk.length - 1; x >= 0; x--) {
            for (int y = 0; y < chessDesk.length; y++) {
                if (y == 0) {
                    board += (x + 1);
                }

                if (x == 1 || x == 6) {
                    board += "  p";
                } else if (x == 7 || x == 0) {
                    if (y == 0 || y == 7) {
                        board += "  r";
                    } else if (y == 1 || y == 6) {
                        board += "  k";
                    } else if (y == 2 || y == 5) {
                        board += "  b";
                    } else if (y == 3) {
                        board += "  Q";
                    } else if (y == 4) {
                        board += "  K";
                    }
                } else {
                    board += "  +";
                }
            }
            board += "\n";
            if (x == 0) {
                for (char k = 'A'; k <= 'H'; k++) {
                    board += "  " + k;
                }
            }
        }
        return board;
    }

}