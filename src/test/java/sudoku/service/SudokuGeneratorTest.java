package sudoku.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuGeneratorTest {

    SudokuGenerator generator = new SudokuGenerator();

    @Test
    void shouldGenerateValidSolution() {
        int[][] solution = generator.generateSolution();

        assertNotNull(solution);
        assertEquals(9, solution.length);
    }

    @Test
    void shouldGeneratePuzzleWithClues() {
        int[][] solution = generator.generateSolution();
        int[][] puzzle = generator.generatePuzzle(solution, 30);

        int count = 0;
        for (int[] row : puzzle)
            for (int cell : row)
                if (cell != 0) count++;

        assertEquals(30, count, 5); // tolerance
    }

    @Test
    void puzzleShouldDifferFromSolution() {
        int[][] solution = generator.generateSolution();
        int[][] puzzle = generator.generatePuzzle(solution, 30);

        assertFalse(java.util.Arrays.deepEquals(solution, puzzle));
    }
}