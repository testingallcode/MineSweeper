package  sudoku.service;

import java.util.*;

public class SudokuGenerator {

    private static final int SIZE = 9;
    private static final int EMPTY = 0;

    public int[][] generateSolution() {
        int[][] board = new int[SIZE][SIZE];
        solve(board);
        return board;
    }

    public int[][] generatePuzzle(int[][] solution, int clues) {
        int[][] puzzle = copy(solution);

        int cellsToRemove = SIZE * SIZE - clues;
        Random rand = new Random();

        while (cellsToRemove > 0) {
            int r = rand.nextInt(SIZE);
            int c = rand.nextInt(SIZE);

            if (puzzle[r][c] != EMPTY) {
                puzzle[r][c] = EMPTY;
                cellsToRemove--;
            }
        }

        return puzzle;
    }



    private boolean solve(int[][] board) {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {

                if (board[r][c] == EMPTY) {

                    List<Integer> nums = shuffledNumbers();

                    for (int num : nums) {
                        if (isValid(board, r, c, num)) {
                            board[r][c] = num;

                            if (solve(board)) return true;

                            board[r][c] = EMPTY;
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(int[][] board, int row, int col, int num) {

        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        for (int r = sr; r < sr + 3; r++) {
            for (int c = sc; c < sc + 3; c++) {
                if (board[r][c] == num) return false;
            }
        }

        return true;
    }

    private List<Integer> shuffledNumbers() {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= 9; i++) nums.add(i);
        Collections.shuffle(nums);
        return nums;
    }

    private int[][] copy(int[][] original) {
        int[][] copy = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            System.arraycopy(original[i], 0, copy[i], 0, SIZE);
        }

        return copy;
    }
}