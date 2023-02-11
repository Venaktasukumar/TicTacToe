package org.example;
import java.util.*;
import java.util.logging.*;
class TicTacToe{
    Logger l= Logger.getLogger("com.api.jar");
    public int horizontalcheck(char[][] board, int row){
        int count1=0;
        int count2=0;
        for(int i=0; i<board.length; i++){
            if(board[row][i]=='X'){
                count1++;
            }
            else if(board[row][i]=='O'){
                count2++;
            }
        }
        if(count1==board.length || count2==board.length){
            return 1;
        }
        else{
            return 0;
        }
    }
    public int verticalcheck(char[][] board, int column){
        int count1=0;
        int count2=0;
        for(int i=0; i<board.length; i++){
            if(board[i][column]=='X'){
                count1++;
            }
            else if(board[i][column]=='O'){
                count2++;
            }
        }
        if(count1==board.length || count2==board.length){
            return 1;
        }
        else{
            return 0;
        }
    }
    public int rightDiagonal(char[][] board){
        int count1=0;
        int count2=0;
        for(int i=0; i<board.length; i++){
            if(board[i][i]=='X'){
                count1++;
            }
            else if(board[i][i]=='O'){
                count2++;
            }
        }
        if(count1==board.length || count2==board.length){
            return 1;
        }
        else{
            return 0;
        }
    }
    public int leftDiagnoal(char[][] board){
        int count1=0;
        int count2=0;
        int j=2;
        for(int i=0; i<board.length; i++){
            if(board[i][j]=='X'){
                count1++;
            }
            else if(board[i][j]=='O'){
                count2++;
            }
            j=j-1;
        }
        if(count1==board.length || count2==board.length){
            return 1;
        }
        else{
            return 0;
        }
    }
    public int setplayer1(char[][] board,int row, int column){
        if(board[row][column]=='X' || board[row][column]=='O'){
            return 0;
        }
        board[row][column]='X';
        return 1;
    }
    public int setplayer2(char[][] board,int row, int column){
        if(board[row][column]=='X' || board[row][column]=='O'){
            return 0;
        }
        board[row][column]='O';
        return 1;
    }

    public int winGame(char[][] board,int row, int column){
        int hor=horizontalcheck(board,row);
        int ver=verticalcheck(board,column);
        if(row==1 && column==1){
            if(hor==1 || ver==1 || rightDiagonal(board)==1 || leftDiagnoal(board)==1){
                return 1;
            }
            return 0;
        }
        else if(row==column){
            if(hor==1 || ver==1 || rightDiagonal(board)==1){
                return 1;
            }
            return 0;
        }
        else{
            if(hor==1 || ver==1 || leftDiagnoal(board)==1){
                return 1;
            }
            return 0;
        }
    }
    public void printBoard(char[][] board){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                String z=board[i][j]+" ";
                l.info(z);
            }
            l.info("\n");
        }
    }
    public static void main(String[] args){
        Logger l= Logger.getLogger("com.api.jar");
        Scanner sc=new Scanner(System.in);
        l.info("Enter the Dimension");
        int dimension=sc.nextInt();
        char[][] board=new char[dimension][dimension];
        for(int i=0; i<dimension; i++){
            for(int j=0; j<dimension; j++){
                board[i][j]='-';
            }
        }
        TicTacToe obj=new TicTacToe();
        boolean t=true;
        int count=0;
        while(t){
            l.info("Player1");
            l.info("Enter row:");
            int row=sc.nextInt();
            l.info("Enter column:");
            int col=sc.nextInt();
            if(obj.setplayer1(board,row,col)==0){
                l.info("invalid row and column");
                System.exit(0);
            }
            count++;
            obj.printBoard(board);
            if(obj.winGame(board,row,col)==1){
                l.info("Player1 is win");
                System.exit(0);
            }
            if(count==(board.length*board.length)){
                l.info("game is drawn");
                System.exit(0);
            }
            l.info("Player2");
            l.info("Enter row:");
            int row1=sc.nextInt();
            l.info("Enter column:");
            int col1=sc.nextInt();
            if(obj.setplayer2(board,row1,col1)==0){
                l.info("invalid row and column");
                System.exit(0);
            }
            count++;
            obj.printBoard(board);
            if(obj.winGame(board,row1,col1)==1){
                l.info("Player2 is win");
                System.exit(0);
            }
            if(count==(board.length*board.length)){
                l.info("Game is Drawn");
                break;
            }
        }
        sc.close();
    }
}