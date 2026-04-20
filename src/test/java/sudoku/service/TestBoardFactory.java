package sudoku.service;

import sudoku.model.Board;

public class TestBoardFactory {

    public static Board createEmptyBoard() {
        int[][] p = new int[9][9];
        int[][] s = new int[9][9];
        return new Board(p, s);
    }

    public static Board createSolvedBoard() {
        int[][] s = new int[9][9];
        int[][] p = new int[9][9];

        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                p[i][j] = s[i][j] = (i * 3 + j % 9 + 1) % 9 + 1;

        return new Board(p, s);
    }

    public static Board createPrefilledBoard() {

        int[][] puzzle = new int[9][9];
        int[][] solution = new int[9][9];

        puzzle[0][0] = 5; 

        return new Board(puzzle, solution);
    }

    public static Board createPuzzleBoard() {
        return createEmptyBoard();
    }
}