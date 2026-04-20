package sudoku.service;

import sudoku.model.Board;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    Validator validator = new Validator();

    @Test
    void shouldDetectRowViolation() {
        Board board = TestBoardFactory.createEmptyBoard();

        board.getCell(0, 0).setValue(5);
        board.getCell(0, 1).setValue(5);

        Optional<String> result = validator.validate(board);

        assertTrue(result.isPresent());
        assertTrue(result.get().contains("Row"));
    }

    @Test
    void shouldDetectColumnViolation() {
        Board board = TestBoardFactory.createEmptyBoard();

        board.getCell(0, 0).setValue(5);
        board.getCell(1, 0).setValue(5);

        Optional<String> result = validator.validate(board);

        assertTrue(result.isPresent());
        assertTrue(result.get().contains("Column"));
    }

    @Test
    void shouldDetectSubgridViolation() {
        Board board = TestBoardFactory.createEmptyBoard();

        board.getCell(0, 0).setValue(5);
        board.getCell(1, 1).setValue(5);

        Optional<String> result = validator.validate(board);

        assertTrue(result.isPresent());
        assertTrue(result.get().contains("3×3"));
    }

    @Test
    void shouldReturnEmpty_whenValid() {

        Board board = TestBoardFactory.createEmptyBoard();

        Optional<String> result = validator.validate(board);

        assertTrue(result.isEmpty());
    }
}