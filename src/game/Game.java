package game;

import board.Board;
import player.Player;

public class Game {
    Board board;
    Player player;

    public Game(Board board, Player player) {
        this.board = board;
        this.player = player;
    }

    public void play() {
        // System.out.println("fghjkl");

        solveSudoku(0, 0);
        // System.out.println("dtfgyhuij");
    }

    public void solveSudoku(int row, int col) {
        // System.out.println("tfghjk");
        if(row==board.getSize())
        {
            System.out.println("Sudoku Solved!!");
                board.printBoard();
            return;
        }
        int nrow = 0;
        int ncol = 0;
        if (col == board.getSize() - 1) {
            nrow=row+1;
            ncol = 0;
        } else {
            nrow = row;
            ncol=col+1;

        }

        if (board.matrix[row][col] != 0) {
            solveSudoku(nrow, ncol);
        } else {
            for (int i = 1; i <= 9; i++)

            {
                if (validPosition(board.matrix, row, col, i)==true) {
                    board.matrix[row][col] = i;
                    solveSudoku(nrow, ncol);
                    board.matrix[row][col] = 0;
                }
            }

        }

    }

    private boolean validPosition(int[][] matrix, int row, int col, int val) {

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[row][i] == val) {
                return false;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][col] == val) {
                return false;
            }
        }

        int tempRow = row / 3 * 3;
        int tempcol = col / 3 * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[tempRow + i][tempcol + j] == val) {
                    return false;
                }
            }
        }
        return true;
    }

}
