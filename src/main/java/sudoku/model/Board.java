package sudoku.model;

public class Board {
    private final Cell[][] grid = new Cell[9][9];
    private final int[][] solution;

    public Board(int[][] puzzle, int[][] solution) {
        this.solution = solution;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j] = new Cell(puzzle[i][j], puzzle[i][j] != 0);
            }
        }
    }

    public Cell getCell(int r, int c) {
        return grid[r][c];
    }

    public int[][] getSolution() {
        return solution;
    }

    public boolean isComplete() {
        for (Cell[] row : grid) {
            for (Cell cell : row) {
                if (cell.isEmpty()) return false;
            }
        }
        return true;
    }
    
    public Board copy() {
        int[][] puzzleCopy = new int[9][9];
        int[][] solutionCopy = solution;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                puzzleCopy[i][j] = this.grid[i][j].getValue();
            }
        }

        return new Board(puzzleCopy, solutionCopy);
    }
}