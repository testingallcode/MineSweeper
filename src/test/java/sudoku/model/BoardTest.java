package sudoku.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void shouldReturnFalse_whenBoardNotComplete() {
        int[][] puzzle = new int[9][9];
        int[][] solution = new int[9][9];

        Board board = new Board(puzzle, solution);

        assertFalse(board.isComplete());
    }

    @Test
    void shouldReturnTrue_whenBoardIsFullyFilled() {
        int[][] puzzle = new int[9][9];
        int[][] solution = new int[9][9];

        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                puzzle[i][j] = solution[i][j] = 1;

        Board board = new Board(puzzle, solution);

        assertTrue(board.isComplete());
    }

    
}