package org.example;
import java.util.*;
import java.util.logging.*;
public class TicTacToe {
    Logger l = Logger.getLogger("com.api.jar");

    public int horizontalcheck(char[][] board, int row) {
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == 'X') {
                count1++;
            } else if (board[row][i] == 'O') {
                count2++;
            }
        }
        if (count1 == board.length || count2 == board.length) {
            return 1;
        } else {
            return 0;
        }
    }

    public int verticalcheck(char[][] board, int column) {
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i][column] == 'X') {
                count1++;
            } else if (board[i][column] == 'O') {
                count2++;
            }
        }
        if (count1 == board.length || count2 == board.length) {
            return 1;
        } else {
            return 0;
        }
    }

    public int rightDiagonal(char[][] board) {
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == 'X') {
                count1++;
            } else if (board[i][i] == 'O') {
                count2++;
            }
        }
        if (count1 == board.length || count2 == board.length) {
            return 1;
        } else {
            return 0;
        }
    }

    public int leftDiagnoal(char[][] board) {
        int count1 = 0;
        int count2 = 0;
        int j = board.length - 1;
        for (int i = 0; i < board.length; i++) {
            if (board[i][j] == 'X') {
                count1++;
            } else if (board[i][j] == 'O') {
                count2++;
            }
            j = j - 1;
        }
        if (count1 == board.length || count2 == board.length) {
            return 1;
        } else {
            return 0;
        }
    }

    public int setplayer(char[][] board, int row, int column, char p) {
        if (board[row][column] == 'X' || board[row][column] == 'O') {
            l.info("invalid row and column");
            return 0;
        } else if (p == 'X') {
            board[row][column] = 'X';
        } else if (p == 'O') {
            board[row][column] = 'O';
        }
        return 1;
    }
    public int winGame(char[][] board, int row, int column) {
        int hor = horizontalcheck(board, row);
        int ver = verticalcheck(board, column);
        if (row == column) {
            if (hor == 1 || ver == 1 || rightDiagonal(board) == 1 || leftDiagnoal(board) == 1) {
                return 1;
            }
            return 0;
        } else {
            if (hor == 1 || ver == 1 || leftDiagnoal(board) == 1) {
                return 1;
            }
            return 0;
        }
    }

    public char[][] assignBoard(int dimension) {
        char[][] board = new char[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                board[i][j] = '-';
            }
        }
        return board;

    }

    public void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                String z = board[i][j] + " ";
                l.info(z);
            }
            l.info("\n");
        }
    }

    public static void main(String[] args) {
        Logger l = Logger.getLogger("com.api.jar");
        Scanner sc = new Scanner(System.in);
        l.info("Enter the Dimension");
        TicTacToe obj = new TicTacToe();
        int dimension = sc.nextInt();
        char[][] board = obj.assignBoard(dimension);
        int count = 0;
        char p;
        boolean k=true;
        while (k) {
            if (count % 2 == 0) {
                l.info("player 1 turn");
                p = 'X';

            } else {
                l.info("player 2 turn");
                p = 'O';
            }
            boolean t = true;
            int row = 0;
            int col = 0;
            while (t) {
                l.info("Enter row");
                row = sc.nextInt();
                l.info("Enter col");
                col = sc.nextInt();
                t = false;
            }
            if(obj.setplayer(board, row, col, p)==0){
                break;
            }
            count++;
            obj.printBoard(board);
            if(obj.winGame(board, row, col) == 1) {
                if(p=='X'){
                    l.info("Player1 is win");
                }
                else{
                    l.info("player2 is win");
                }
                k=false;
            }
            if(count==dimension*dimension){
                l.info("Game is drawn");
                k=false;
            }
        }
    }
}