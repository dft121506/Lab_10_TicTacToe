import java.util.Scanner;

public class TicTacToe {
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static String board [][] = new String[ROWS][COLS];
    private static int moveCount;

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        boolean playAgain = true;

        //do while loop for play again
        do {
            moveCount = 0;
            String player = "X";
            clearBoard();
            int playRow;
            int playCol;

            do {
            //asks what row and column the player wants to play
            do {
                playRow = SafeInput.getRangedInt(in, "What row would you like to play", 1, 3);
                playCol = SafeInput.getRangedInt(in, "What column would you like to play", 1, 3);
            } while (!isValidMove(playRow - 1, playCol - 1));
            moveCount++;


            //switches the 1-3 to a 0-2 for the array indexes

            int row = playRow - 1;
            int col = playCol - 1;

            //adds the move to the board and adds 1 to the move count

            board[row][col] = player;

            display();


                //checks for win, tie, or nothing and changes the X to an O after every turn
                if(isRowWin(player) || isColWin(player) || isDiagonalWin(player)){
                    if (isWin(player)) {
                        System.out.println(player + " has won TicTacToe");
                        break;
                    }
                }
                player = player.equals("X") ? "O" : "X";
            }while (!isWin(player) && !isTie());

            playAgain = SafeInput.getYNConfirm(in, "Would you like to play again Yes or no");
        }while (playAgain);
    }


    //adds spaces to fill the array
    private static void clearBoard(){
        for (int row = 0; row < ROWS; row++){
            for (int col = 0; col < COLS; col++){
                board[row][col] = " ";
            }
        }
        moveCount = 0;
    }

    //displays the tictactoe symbol
    private static void display(){
        for (int row = 0; row < ROWS; row++){
            for (int col = 0; col < COLS; col++){
                System.out.print(board[row][col]);
                if (col != 2){
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (row < ROWS - 1) {
                System.out.println("---------");
            }
        }
    }

    //checks if move is a valid one
    private static boolean isValidMove(int row, int col){
        if (!board[row][col].equals(" ")){
            System.out.println("That is a wrong input");
        }

        return board[row][col].equalsIgnoreCase(" ");

    }

    //overall win
    private static boolean isWin(String player){
        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
    }

    //a win with the columns
    private static boolean isColWin(String player){
        for (int col = 0; col < COLS; col++){
            if (board[0][col].equalsIgnoreCase(player) && (board[1][col].equalsIgnoreCase(player) && board[2][col].equalsIgnoreCase(player)))
                return true;
        }
        return false;
    }

    //a win with the rows
    private static boolean isRowWin(String player){
        for (int row = 0; row < ROWS; row++){
            if (board[row][0].equalsIgnoreCase(player) && board[row][1].equalsIgnoreCase(player) && board[row][2].equalsIgnoreCase(player)){
                return true;
            }
        }
        return false;
    }

    //a win with the diagonals
    private static boolean isDiagonalWin(String player){
        if (board[0][0].equalsIgnoreCase(player) && board[1][1].equalsIgnoreCase(player) && board[2][2].equalsIgnoreCase(player)){
            return true;
        }
        if (board[0][2].equalsIgnoreCase(player) && board[1][1].equalsIgnoreCase(player) && board[2][0].equalsIgnoreCase(player)){
            return true;
        }
        return false;
    }

    //if the round is a tie
    private static boolean isTie(){
        int tieCount = 0;

        if (moveCount == 9){
            System.out.println("You have filled the board it is a tie");
            return true;
        }
        else if (moveCount >= 7){
            //checks the rows
            for (int row = 0; row < ROWS; row++) {
                boolean foundX = false;
                boolean foundO = false;
                for (int col = 0; col < COLS; col++){
                    if (board[row][col].equals("X")){
                        foundX = true;
                    }
                    if (board[row][col].equals("O")){
                        foundO = true;
                    }
                }
                if (foundX && foundO){
                    tieCount++;
                }
            }
            //checks the columns
            for (int col = 0; col < COLS; col++) {
                boolean foundX = false;
                boolean foundO = false;
                for (int row = 0; row < ROWS; row++){
                    if (board[row][col].equals("X")){
                        foundX = true;
                    }
                    if (board[row][col].equals("O")){
                        foundO = true;
                    }
                }
                if (foundX && foundO){
                    tieCount++;
                }
            }
            //checks the diagonal from top left to bottom right
            boolean diag1X = false;
            boolean  diag1O = false;
            for (int i = 0; i < ROWS; i++){
                if (board[i][i].equals("X")) {
                    diag1X = true;
                }
                if (board[i][i].equals("O")) {
                    diag1O = true;
                }
            }
            if (diag1X && diag1O){
                tieCount++;
            }
            //checks the diagonal from top right to bottom left
            boolean diag2X = false;
            boolean diag2O = false;
            for (int i = 0; i < ROWS; i++) {

                if (board[i][COLS - 1 - i].equals("X")){
                    diag2X = true;
                }
                if (board[i][COLS - 1 - i].equals("O")){
                    diag2O = true;
                }
            }
            if (diag2X && diag2O){
                tieCount++;
            }

            if (tieCount == 8){
                System.out.println("It was a tie. There will be no winner this round");
                return true;
            }
        }
        return false;
    }
}
