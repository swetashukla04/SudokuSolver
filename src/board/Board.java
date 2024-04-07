package board;

import java.util.*;

import triple.Triple;

public class Board {

    private int size;
     public int matrix[][];

    public Board(int size) {
        this.size=size;
        this.matrix = new int[size][size];
    }

    public int getSize() {
        return size;
        
    }

   

    public void printBoard() {
        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    public void setUpBoardConfig(int row, int col, int val) {
        matrix[row][col] = val;

    }

    public void setUpColumn(int row, List<Integer> col, List<Integer> val) {
        for (int i = 0; i < col.size(); i++) {
            this.matrix[row][col.get(i)] = val.get(i);
        }
    }

    public void setUpBoard(List<Triple> triple) {
        for (int i = 0; i < triple.size(); i++) {
            matrix[triple.get(i).getRow()][triple.get(i).getCol()] = triple.get(i).getVal();
        }
    }
}
